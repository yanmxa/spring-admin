package com.nood.hrm.util;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class MD5Util {
    private static final String SALT = "wuqian";
//    private static String encode(String password) {
//        password = password + SALT;
////        password = password;
//        MessageDigest md5 = null;
//        try {
//            md5 = MessageDigest.getInstance("MD5");
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        char[] charArray = password.toCharArray();
//        byte[] byteArray = new byte[charArray.length];
//
//        for (int i = 0; i < charArray.length; i++)
//            byteArray[i] = (byte) charArray[i];
//        byte[] md5Bytes = md5.digest(byteArray);
//        StringBuffer hexValue = new StringBuffer();
//        for (int i = 0; i < md5Bytes.length; i++) {
//            int val = ((int) md5Bytes[i]) & 0xff;
//            if (val < 16) {
//                hexValue.append("0");
//            }
//            hexValue.append(Integer.toHexString(val));
//        }
//        return hexValue.toString();
//    }

    public static String md5b64(String text) {
        MessageDigest digest;
        String ans = "";
        try {
            digest = MessageDigest.getInstance("MD5");
            byte[] buf = digest.digest(text.getBytes());
            ans = toHex(buf);
            BASE64Encoder base64Encoder = new BASE64Encoder();
            ans = base64Encoder.encode(buf);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return ans;
    }

    public static String toHex(byte[] bytes) {
        String ans = "";
        for (int i = 0; i < bytes.length; i++) {
            int temp = bytes[i];
            if (temp < 0) temp += 256;
            if (temp < 16) ans += "0";
            ans += Integer.toHexString(temp);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(md5b64("111111"));

        Map<Integer, Integer> index2Numeric = new HashMap<>();


        if ( index2Numeric.get("1") == 1) {


        }
    }
}