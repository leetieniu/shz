package com.angel.common.util.securityutil;

import java.security.MessageDigest;

/**
 * Created by Lijn on 2015/6/15.
 *
 */
public class MD5Util {
    public static String encrypt(String expressly) {
        String ciphertext = null;

        try {
            byte[] e = expressly.getBytes("utf-8");
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(e);
            byte[] resultByteArray = md5.digest();
            ciphertext = ToHex(resultByteArray);
        } catch (Exception var5) {
            var5.printStackTrace();
        }
        return ciphertext;
    }


    private static String ToHex(byte[] byteArray) {
        StringBuilder buffer = new StringBuilder();
        byte[] arr$ = byteArray;
        int len$ = byteArray.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            byte b = arr$[i$];
            int value = b & 255;
            if(value < 16) {
                buffer.append("0");
            }
            buffer.append(Integer.toHexString(value));
        }

        return buffer.toString();
    }



}
