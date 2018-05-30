package com.github.dapeng.common;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * zk 服务信息
 *
 * @author huyj
 * @Created 2018/5/25 14:46
 */
public class ZkServiceInfo {

    private String serviceName;
    private String versionName;
    private String host;
    private int port;
    private Status status = Status.CREATED;
    private AtomicInteger activeCount;

    public ZkServiceInfo(String serviceName, String host, Integer port, String versionName) {
        this.serviceName = serviceName;
        this.host = host;
        this.port = port;
        this.versionName = versionName;
        this.activeCount = new AtomicInteger(0);
    }

    public ZkServiceInfo(String serviceName) {
        this.serviceName = serviceName;
        this.activeCount = new AtomicInteger(0);
    }


    /**********setter getter*********************/

    public String getServiceName() {
        return serviceName;
    }

    public String getVersionName() {
        return versionName;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public AtomicInteger getActiveCount() {
        return activeCount;
    }

    public void setActiveCount(AtomicInteger activeCount) {
        this.activeCount = activeCount;
    }

    public int increaseActiveCount() {
        return activeCount.incrementAndGet();
    }


    public String getZkServiceInfo() {
        return serviceName + ":" + versionName + "[" + host + ":" + port + "]";
    }

    /**********Status  enum**********/
    public enum Status {
        CREATED, ACTIVE, CANCELED
    }

    @Override
    public String toString() {
        return "ZkServiceInfo{" +
                "serviceName='" + serviceName + '\'' +
                ", versionName='" + versionName + '\'' +
                ", host='" + host + '\'' +
                ", port=" + port +
                '}';
    }
}
