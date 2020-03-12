package com.yao.handle.util;

import lombok.extern.log4j.Log4j2;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 标题:
 * 描述:序列化工具类
 * 公司: www.tydic.com
 * @author wuheng
 * @date 2018/9/24 17:44
 */
@Log4j2
public class SerializeUtils {
    /** 反序列化
     *
     * @param bytes
     * @return */
    public static Object deserialize(byte[] bytes) {

        Object result = null;

        if (isEmpty(bytes)) {
            return null;
        }

        try {
            ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(byteStream);
                try {
                    result = objectInputStream.readObject();
                }
                catch (ClassNotFoundException ex) {
                    throw new Exception("Failed to deserialize object type", ex);
                }
            }
            catch (Throwable ex) {
                throw new Exception("Failed to deserialize", ex);
            }
        }
        catch (Exception e) {
            log.error("Failed to deserialize", e);
        }
        return result;
    }

    public static boolean isEmpty(byte[] data) {
        return (data == null || data.length == 0);
    }

    /** 序列化
     *
     * @param object
     * @return */
    public static byte[] serialize(Object object) {

        byte[] result = null;

        if (object == null) {
            return new byte[0];
        }
        try {
            ByteArrayOutputStream byteStream = new ByteArrayOutputStream(128);
            try {
                if (!(object instanceof Serializable)) {
                    throw new IllegalArgumentException(SerializeUtils.class.getSimpleName() + " requires a Serializable payload " + "but received an object of type [" + object.getClass().getName()
                            + "]");
                }
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteStream);
                objectOutputStream.writeObject(object);
                objectOutputStream.flush();
                result = byteStream.toByteArray();
            }
            catch (Throwable ex) {
                throw new Exception("Failed to serialize", ex);
            }
        }
        catch (Exception ex) {
            log.error("Failed to serialize", ex);
        }
        return result;
    }

}
