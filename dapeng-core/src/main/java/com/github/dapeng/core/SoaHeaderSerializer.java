package com.github.dapeng.core;

import com.github.dapeng.core.helper.IPUtils;
import com.github.dapeng.org.apache.thrift.TException;
import com.github.dapeng.org.apache.thrift.protocol.*;

import java.util.Optional;

import static com.github.dapeng.core.helper.DapengUtil.longToHexStr;

/**
 * Created by tangliu on 2016/1/11.
 * SoaHeader序列化和反序列化
 */
public class SoaHeaderSerializer implements BeanSerializer<SoaHeader> {

    /**
     * 反序列化
     *
     * @throws TException
     */
    @Override
    public SoaHeader read(TProtocol iprot) throws TException {
        SoaHeader bean = new SoaHeader();
        TField schemeField;
        iprot.readStructBegin();
        while (true) {
            schemeField = iprot.readFieldBegin();
            if (schemeField.type == TType.STOP) {
                break;
            }
            switch (schemeField.id) {
                case 1:
                    if (schemeField.type == TType.STRING) {
                        bean.setServiceName(iprot.readString());
                    } else {
                        TProtocolUtil.skip(iprot, schemeField.type);
                    }
                    break;
                case 2:
                    if (schemeField.type == TType.STRING) {
                        bean.setMethodName(iprot.readString());
                    } else {
                        TProtocolUtil.skip(iprot, schemeField.type);
                    }
                    break;
                case 3:
                    if (schemeField.type == TType.STRING) {
                        bean.setVersionName(iprot.readString());
                    } else {
                        TProtocolUtil.skip(iprot, schemeField.type);
                    }
                    break;
                case 4:
                    if (schemeField.type == TType.STRING) {
                        bean.setCallerMid(Optional.of(iprot.readString()));
                    } else {
                        TProtocolUtil.skip(iprot, schemeField.type);
                    }
                    break;
                case 5:
                    if (schemeField.type == TType.STRING) {
                        bean.setCallerIp(iprot.readString());
                    } else if (schemeField.type == TType.I32) {
                        bean.setCallerIp(IPUtils.transferIp(iprot.readI32()));
                    } else {
                        TProtocolUtil.skip(iprot, schemeField.type);
                    }
                    break;
                case 6:
                    if (schemeField.type == TType.I32) {
                        bean.setCallerPort(Optional.of(iprot.readI32()));
                    } else {
                        TProtocolUtil.skip(iprot, schemeField.type);
                    }
                    break;
                case 7:
                    if (schemeField.type == TType.STRING) {
                        bean.setSessionTid(Optional.of(iprot.readString()));
                    } else if (schemeField.type == TType.I64) {
                        bean.setSessionTid(Optional.of(longToHexStr(iprot.readI64())));
                    } else {
                        TProtocolUtil.skip(iprot, schemeField.type);
                    }
                    break;
                case 8:
                    if (schemeField.type == TType.STRING) {
                        bean.setUserIp(Optional.of(iprot.readString()));
                    } else if (schemeField.type == TType.I32) {
                        bean.setUserIp(Optional.of(IPUtils.transferIp(iprot.readI32())));
                    } else {
                        TProtocolUtil.skip(iprot, schemeField.type);
                    }
                    break;
                case 9:
                    if (schemeField.type == TType.STRING) {
                        bean.setCallerTid(Optional.of(iprot.readString()));
                    } else if (schemeField.type == TType.I64) {
                        bean.setCallerTid(Optional.of(longToHexStr(iprot.readI64())));
                    }  else {
                        TProtocolUtil.skip(iprot, schemeField.type);
                    }
                    break;
                case 10:
                    if (schemeField.type == TType.I32) {
                        bean.setTimeout(Optional.of(iprot.readI32()));
                    } else {
                        TProtocolUtil.skip(iprot, schemeField.type);
                    }
                    break;
                case 11:
                    if (schemeField.type == TType.STRING) {
                        bean.setRespCode(iprot.readString());
                    } else {
                        TProtocolUtil.skip(iprot, schemeField.type);
                    }
                    break;
                case 12:
                    if (schemeField.type == TType.STRING) {
                        bean.setRespMessage(iprot.readString());
                    } else {
                        TProtocolUtil.skip(iprot, schemeField.type);
                    }
                    break;
                case 13:
                    if (schemeField.type == TType.STRING) {
                        bean.setCalleeTid(iprot.readString());
                    } else if (schemeField.type == TType.I64) {
                        bean.setCalleeTid(longToHexStr(iprot.readI64()));
                    } else {
                        TProtocolUtil.skip(iprot, schemeField.type);
                    }
                    break;
                case 14:
                    if (schemeField.type == TType.STRING) {
                        bean.setCalleeIp(Optional.of(iprot.readString()));
                    } else if (schemeField.type == TType.I32) {
                        bean.setCalleeIp(Optional.of(IPUtils.transferIp(iprot.readI32())));
                    } else {
                        TProtocolUtil.skip(iprot, schemeField.type);
                    }
                    break;
                case 15:
                    if (schemeField.type == TType.I32) {
                        bean.setOperatorId(Optional.of(iprot.readI32()));
                    } else {
                        TProtocolUtil.skip(iprot, schemeField.type);
                    }
                    break;
                case 16:
                    if (schemeField.type == TType.I32) {
                        bean.setCalleePort(Optional.of(iprot.readI32()));
                    } else {
                        TProtocolUtil.skip(iprot, schemeField.type);
                    }
                    break;
                case 17:
                    if (schemeField.type == TType.I64) {
                        bean.setUserId(Optional.of(iprot.readI64()));
                    } else {
                        TProtocolUtil.skip(iprot, schemeField.type);
                    }
                    break;
                case 18:
                    if (schemeField.type == TType.STRING) {
                        bean.setCalleeMid(iprot.readString());
                    } else {
                        TProtocolUtil.skip(iprot, schemeField.type);
                    }
                    break;
                case 19:
                    if (schemeField.type == TType.I32) {
                        bean.setTransactionId(iprot.readI32());
                    } else {
                        TProtocolUtil.skip(iprot, schemeField.type);
                    }
                    break;
                case 20:
                    if (schemeField.type == TType.I32) {
                        bean.setTransactionSequence(iprot.readI32());
                    } else {
                        TProtocolUtil.skip(iprot, schemeField.type);
                    }
                    break;
                case 21:
                    if (schemeField.type == TType.I32) {
                        bean.setCalleeTime1(iprot.readI32());
                    } else {
                        TProtocolUtil.skip(iprot, schemeField.type);
                    }
                    break;
                case 22:
                    if (schemeField.type == TType.I32) {
                        bean.setCalleeTime2(iprot.readI32());
                    } else {
                        TProtocolUtil.skip(iprot, schemeField.type);
                    }
                    break;
                case 23:
                    if (schemeField.type == TType.STRING) {
                        bean.setOperatorName(Optional.of(iprot.readString()));
                    } else {
                        TProtocolUtil.skip(iprot, schemeField.type);
                    }
                    break;
                case 24:
                    if (schemeField.type == TType.I32) {
                        bean.setCustomerId(Optional.of(iprot.readI32()));
                    } else {
                        TProtocolUtil.skip(iprot, schemeField.type);
                    }
                    break;
                case 25:
                    if (schemeField.type == TType.STRING) {
                        bean.setCustomerName(Optional.of(iprot.readString()));
                    } else {
                        TProtocolUtil.skip(iprot, schemeField.type);
                    }
                    break;
                case 26:
                    if (schemeField.type == TType.STRING) {
                        bean.setSessionId(Optional.of(iprot.readString()));
                    } else {
                        TProtocolUtil.skip(iprot, schemeField.type);
                    }
                    break;
                case 27:
                    if (schemeField.type == TType.STRING) {
                        bean.setCallerFrom(Optional.of(iprot.readString()));
                    }else {
                        TProtocolUtil.skip(iprot, schemeField.type);
                    }
                    break;
                case 28:
                    if (schemeField.type == com.github.dapeng.org.apache.thrift.protocol.TType.MAP) {
                        com.github.dapeng.org.apache.thrift.protocol.TMap _map0 = iprot.readMapBegin();
                        java.util.Map<String, String> elem0 = new java.util.HashMap<>(_map0.size);
                        for (int _i0 = 0; _i0 < _map0.size; ++_i0) {
                            String elem1 = iprot.readString();
                            String elem2 = iprot.readString();
                            elem0.put(elem1, elem2);
                        }
                        iprot.readMapEnd();
                        bean.setCookies(elem0);
                    } else {
                        com.github.dapeng.org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                    }
                    break;
                default:
                    TProtocolUtil.skip(iprot, schemeField.type);
            }
            iprot.readFieldEnd();
        }
        iprot.readStructEnd();
        return bean;
    }


    /**
     * 序列化
     */
    @Override
    public void write(SoaHeader bean, TProtocol oprot) throws TException {

        //validate(bean);
        oprot.writeStructBegin(new TStruct("soaheader"));

        if (null != bean.getServiceName()) {
            oprot.writeFieldBegin(new TField("serviceName", TType.STRING, (short) 1));
            oprot.writeString(bean.getServiceName());
            oprot.writeFieldEnd();
        }
        if (null != bean.getMethodName()) {
            oprot.writeFieldBegin(new TField("methodName", TType.STRING, (short) 2));
            oprot.writeString(bean.getMethodName());
            oprot.writeFieldEnd();
        }
        if (null != bean.getVersionName()) {
            oprot.writeFieldBegin(new TField("versionName", TType.STRING, (short) 3));
            oprot.writeString(bean.getVersionName());
            oprot.writeFieldEnd();
        }
        if (bean.getCallerMid().isPresent()) {
            oprot.writeFieldBegin(new TField("callerMid", TType.STRING, (short) 4));
            oprot.writeString(bean.getCallerMid().get());
            oprot.writeFieldEnd();
        }
        if (bean.getCallerIp().isPresent()) {
            oprot.writeFieldBegin(new TField("callerIp", TType.STRING, (short) 5));
            oprot.writeString(bean.getCallerIp().get());
            oprot.writeFieldEnd();
        }
        if (bean.getCallerPort().isPresent()) {
            oprot.writeFieldBegin(new TField("callerPort", TType.I32, (short) 6));
            oprot.writeI32(bean.getCallerPort().get());
            oprot.writeFieldEnd();
        }
        if (bean.getSessionTid().isPresent()) {
            oprot.writeFieldBegin(new TField("sessionTid", TType.STRING, (short) 7));
            oprot.writeString(bean.getSessionTid().get());
            oprot.writeFieldEnd();
        }
        if (bean.getUserIp().isPresent()) {
            oprot.writeFieldBegin(new TField("userIp", TType.STRING, (short) 8));
            oprot.writeString(bean.getUserIp().get());
            oprot.writeFieldEnd();
        }
        if (bean.getCallerTid().isPresent()) {
            oprot.writeFieldBegin(new TField("callerTid", TType.STRING, (short) 9));
            oprot.writeString(bean.getCallerTid().get());
            oprot.writeFieldEnd();
        }
        if (bean.getTimeout().isPresent()) {
            oprot.writeFieldBegin(new TField("timeout", TType.I32, (short) 10));
            oprot.writeI32(bean.getTimeout().get());
            oprot.writeFieldEnd();
        }
        if (bean.getRespCode().isPresent()) {
            oprot.writeFieldBegin(new TField("respCode", TType.STRING, (short) 11));
            oprot.writeString(bean.getRespCode().get());
            oprot.writeFieldEnd();
        }
        if (bean.getRespMessage().isPresent()) {
            oprot.writeFieldBegin(new TField("respMessage", TType.STRING, (short) 12));
            oprot.writeString(bean.getRespMessage().get());
            oprot.writeFieldEnd();
        }
        if (bean.getCalleeTid().isPresent()) {
            oprot.writeFieldBegin(new TField("calleeTid", TType.STRING, (short) 13));
            oprot.writeString(bean.getCalleeTid().get());
            oprot.writeFieldEnd();
        }
        if (bean.getCalleeIp().isPresent()) {
            oprot.writeFieldBegin(new TField("calleeIp", TType.STRING, (short) 14));
            oprot.writeString(bean.getCalleeIp().get());
            oprot.writeFieldEnd();
        }
        if (bean.getOperatorId().isPresent()) {
            oprot.writeFieldBegin(new TField("operatorId", TType.I32, (short) 15));
            oprot.writeI32(bean.getOperatorId().get());
            oprot.writeFieldEnd();
        }
        if (bean.getCalleePort().isPresent()) {
            oprot.writeFieldBegin(new TField("calleePort", TType.I32, (short) 16));
            oprot.writeI32(bean.getCalleePort().get());
            oprot.writeFieldEnd();
        }
        if (bean.getUserId().isPresent()) {
            oprot.writeFieldBegin(new TField("userId", TType.I64, (short) 17));
            oprot.writeI64(bean.getUserId().get());
            oprot.writeFieldEnd();
        }
        if (bean.getCalleeMid().isPresent()) {
            oprot.writeFieldBegin(new TField("calleeMid", TType.STRING, (short) 18));
            oprot.writeString(bean.getCalleeMid().get());
            oprot.writeFieldEnd();
        }
        if (bean.getTransactionId().isPresent()) {
            oprot.writeFieldBegin(new TField("transactionId", TType.I32, (short) 19));
            oprot.writeI32(bean.getTransactionId().get());
            oprot.writeFieldEnd();
        }
        if (bean.getTransactionSequence().isPresent()) {
            oprot.writeFieldBegin(new TField("transactionSequence", TType.I32, (short) 20));
            oprot.writeI32(bean.getTransactionSequence().get());
            oprot.writeFieldEnd();
        }
        if (bean.getCalleeTime1().isPresent()) {
            oprot.writeFieldBegin(new TField("calleeTime1", TType.I32, (short) 21));
            oprot.writeI32(bean.getCalleeTime1().get());
            oprot.writeFieldEnd();
        }

        if (bean.getCalleeTime2().isPresent()) {
            oprot.writeFieldBegin(new TField("calleeTime2", TType.I32, (short) 22));
            oprot.writeI32(bean.getCalleeTime2().get());
            oprot.writeFieldEnd();
        }

        if(bean.getOperatorName().isPresent()){
            oprot.writeFieldBegin(new TField("operatorName", TType.STRING, (short) 23));
            oprot.writeString(bean.getOperatorName().get());
            oprot.writeFieldEnd();
        }

        if (bean.getCustomerId().isPresent()) {
            oprot.writeFieldBegin(new TField("customerId", TType.I32, (short) 24));
            oprot.writeI32(bean.getCustomerId().get());
            oprot.writeFieldEnd();
        }

        if(bean.getCustomerName().isPresent()){
            oprot.writeFieldBegin(new TField("customerName", TType.STRING, (short) 25));
            oprot.writeString(bean.getCustomerName().get());
            oprot.writeFieldEnd();
        }

        if(bean.getSessionId().isPresent()){
            oprot.writeFieldBegin(new TField("sessionId", TType.STRING, (short) 26));
            oprot.writeString(bean.getSessionId().get());
            oprot.writeFieldEnd();
        }

        if(bean.getCallerFrom().isPresent()){
            oprot.writeFieldBegin(new TField("callerFrom", TType.STRING, (short) 27));
            oprot.writeString(bean.getCallerFrom().get());
            oprot.writeFieldEnd();
        }

        oprot.writeFieldBegin(new com.github.dapeng.org.apache.thrift.protocol.TField("cookies", com.github.dapeng.org.apache.thrift.protocol.TType.MAP, (short) 23));
        java.util.Map<String, String> attachments = bean.getCookies();
        oprot.writeMapBegin(new com.github.dapeng.org.apache.thrift.protocol.TMap(TType.STRING, TType.STRING, attachments.size()));
        for (java.util.Map.Entry<String, String> attachment : attachments.entrySet()) {

            String key = attachment.getKey();
            String value = attachment.getValue();
            oprot.writeString(key);
            oprot.writeString(value);
        }
        oprot.writeMapEnd();
        oprot.writeFieldEnd();

        oprot.writeFieldStop();
        oprot.writeStructEnd();

        //oprot.getTransport().flush();
    }

    /**
     * SoaHeader验证
     */
    @Override
    public void validate(SoaHeader bean) throws TException {
        if (bean.getServiceName() == null) {
            throw new SoaException(SoaCode.NotNull, "serviceName字段不允许为空");
        }
        if (bean.getMethodName() == null) {
            throw new SoaException(SoaCode.NotNull, "methodName字段不允许为空");
        }
        if (bean.getVersionName() == null) {
            throw new SoaException(SoaCode.NotNull, "versionName字段不允许为空");
        }
    }

    @Override
    public String toString(SoaHeader bean) {
        return bean == null ? "null" : bean.toString();
    }

}
