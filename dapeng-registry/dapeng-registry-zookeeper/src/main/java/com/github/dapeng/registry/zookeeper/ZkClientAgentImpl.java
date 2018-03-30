package com.github.dapeng.registry.zookeeper;


import com.github.dapeng.core.InvocationContext;
import com.github.dapeng.core.InvocationContextImpl;
import com.github.dapeng.registry.*;

import com.github.dapeng.route.Route;
import com.github.dapeng.route.RouteExecutor;
import com.github.dapeng.util.SoaSystemEnvProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author lihuimin
 * @date 2017/12/24
 */
public class ZkClientAgentImpl implements ZkClientAgent {

    private static final Logger LOGGER = LoggerFactory.getLogger(ZkClientAgentImpl.class);
    /**
     * 是否使用 灰度 zk
     */
    private final boolean usingFallbackZk = SoaSystemEnvProperties.SOA_ZOOKEEPER_FALLBACK_ISCONFIG;

    private ClientZk masterZk, fallbackZk;

    public ZkClientAgentImpl() {
        start();
    }

    @Override
    public void start() {

        masterZk = new ClientZk(SoaSystemEnvProperties.SOA_ZOOKEEPER_HOST);
        masterZk.init();

        if (SoaSystemEnvProperties.SOA_ZOOKEEPER_FALLBACK_ISCONFIG) {
            fallbackZk = new ClientZk(SoaSystemEnvProperties.SOA_ZOOKEEPER_FALLBACK_HOST);
            fallbackZk.init();
        }
    }

    //todo 优雅退出的时候, 需要调用这个
    @Override
    public void stop() {
        if (masterZk != null) {
            masterZk.destroy();
        }

        if (fallbackZk != null) {
            fallbackZk.destroy();
        }

    }

    @Override
    public void cancnelSyncService(String serviceName, Map<String, ZkServiceInfo> zkInfos) {
        //fixme should remove the debug log
        LOGGER.info("cancnelSyncService-before:[" + serviceName + ", zkInfo:" + zkInfos.get(serviceName));
        zkInfos.remove(serviceName);
        LOGGER.info("cancnelSyncService-after:[" + serviceName + ", zkInfo:" + zkInfos.get(serviceName));
    }

    // todo ZkServiceInfo 添加一个标志位, 标志是否取消监听
    @Override
    public void syncService(String serviceName, Map<String, ZkServiceInfo> zkInfos) {
        ZkServiceInfo zkInfo = zkInfos.get(serviceName);
        if (zkInfo == null) {
            LOGGER.info(getClass().getSimpleName() + "::syncService[serviceName:" + serviceName + "]:zkInfo not found, now sync with zk");
            zkInfo = masterZk.syncServiceZkInfo(serviceName, zkInfos);
            if (zkInfo == null && usingFallbackZk) {
                zkInfo = fallbackZk.syncServiceZkInfo(serviceName, zkInfos);
            }
        }

        //使用路由规则，过滤可用服务器
        InvocationContext context = InvocationContextImpl.Factory.getCurrentInstance();
        List<Route> routes = usingFallbackZk ? fallbackZk.getRoutes() : masterZk.getRoutes();
        List<RuntimeInstance> runtimeList = new ArrayList<>();

        if (zkInfo != null && zkInfo.getRuntimeInstances() != null) {
            for (RuntimeInstance instance : zkInfo.getRuntimeInstances()) {
                try {
                    InetAddress inetAddress = InetAddress.getByName(instance.ip);
                    if (RouteExecutor.isServerMatched(context, routes, inetAddress)) {
                        runtimeList.add(instance);
                    }
                } catch (UnknownHostException e) {
                    LOGGER.error(e.getMessage(), e);
                }
            }
            zkInfo.setRuntimeInstances(runtimeList);
            zkInfos.put(serviceName, zkInfo);
            LOGGER.info(getClass().getSimpleName() + "::syncService[serviceName:" + serviceName + "]:zkInfo succeed");
        } else {
            LOGGER.info(getClass().getSimpleName() + "::syncService[serviceName:" + serviceName + "]:zkInfo failed");
        }
    }


    @Override
    public ZkConfigInfo getConfig(boolean usingFallback, String serviceKey) {

        return masterZk.getConfigData(serviceKey);

    }
}
