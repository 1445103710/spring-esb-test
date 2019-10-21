package com.yao.springboottest.util;

import lombok.extern.log4j.Log4j2;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author: yanggl
 * @Date: 2019/1/16 9:39
 * @Version: 1.0
 * @Description: TODO
 */
@Log4j2
public class MD5Util {

    /**
     * 对请求按照名称进行排序，并参数签名验证
     *
     * @param requestToken 需要校验的签名
     * @param params 参与计算的参数集合
     * @return
     */
    public static boolean verifySign(String requestToken, TreeMap<String, String> params) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        if (!sign(params).equals(requestToken)) {
            return false;
        }
        return true;
    }

//    /**
//     * 对字符串进行编码
//     * 次编码规则只适用于页面js的encodeURIComponent，不适用其他语言
//     *
//     * @param original 需要编码的字符串
//     * @return
//     */
//    private static String encodeString(String original) throws UnsupportedEncodingException {
//        String encoderString = URLEncoder.encode(original, "UTF-8");
//        encoderString.replaceAll("\\+", "%20");
//        encoderString.replaceAll("%7E", "~");
//        encoderString.replaceAll("%21", "!");
//        encoderString.replaceAll("%27", "'");
//        encoderString.replaceAll("%28", "(");
//        encoderString.replaceAll("%29", ")");
////        encoderString.replaceAll("\\*", "%2A");
//        return encoderString;
//    }

    /**
     * 连接参数值并做签名
     *
     * @param params
     * @return
     */
    public static String sign(TreeMap<String, String> params) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        StringBuilder paramValues = new StringBuilder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            paramValues.append(entry.getKey());
            paramValues.append(entry.getValue());
        }
        log.debug("待加密字符串：" + paramValues.toString());
        String value = md5(paramValues.toString());
        log.debug("md5加密后字符串：" + value);
        return value;
    }

    /**
     * md5加密
     *
     * @param originalString 需要加密的字符串
     * @return
     */
    private static String md5(String originalString) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        byte[] hash;
        hash = MessageDigest.getInstance("MD5").digest(originalString.getBytes("UTF-8"));
        StringBuilder hex = new StringBuilder(hash.length * 2);
        for (byte b : hash) {
            if ((b & 0xFF) < 0x10){
                hex.append("0");
            }
            hex.append(Integer.toHexString(b & 0xFF));
        }
        log.info("token：" + hex.toString());
        return hex.toString();
    }

    public static void main(String[] args){
        try {
//            {
//                "code": 0,
//                    "map": {
//                "appCode": "5004",
//                        "appSecret": "bhd4sGJQlFMqmCibhiKJOVPY855hNSPC",
//                        "timestamp": "1571279020470",
//                        "transId": "222"
//            },
//                "token": "dc759fbcad96a8d960b2208c710c5df8"
//            }
            TreeMap<String, String> paramTreeMap = new TreeMap<>();
            paramTreeMap.put("appCode", "5004");
            paramTreeMap.put("transId", "222");
            paramTreeMap.put("timestamp", "1571279020470");
            paramTreeMap.put("appSecret", "bhd4sGJQlFMqmCibhiKJOVPY855hNSPC");
            String sign = sign(paramTreeMap);
            System.out.println(sign);
        } catch (NoSuchAlgorithmException e) {
        } catch (UnsupportedEncodingException e) {
        }
    }
}