package com.angel.common.util.securityutil;

/**
 * Created by Lijn on 2016/5/3.
 *
 * @author Lijn
 */
public class MD5Utiltest {

    public static void main(String[] args){
        String password = MD5Util.encrypt("namepassword1").toUpperCase();
        System.out.println(password);
    }
}
