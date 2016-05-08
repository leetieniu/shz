package com.angel.common.util.sessionutil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Lijn on 2016/4/26.
 *
 * @author Lijn
 */
public class SessionUtil {


    /**
     * 向session中存储信息
     * @param servletRequest request
     * @param key key
     * @param value value
     * @param <T> T
     */
    public static  <T> void storeMessage(HttpServletRequest servletRequest,String key,T value){
        HttpSession session = servletRequest.getSession();
        session.setAttribute(key,value);
    }

    /**
     * 从seession中取信息
     * @param servletRequest servletRequest
     * @param key key
     * @param t T.class
     * @param <T> T
     *
     * @return 信息
     */
    public static <T> T getMessage(HttpServletRequest servletRequest,String key,Class<T> t){
        HttpSession session = servletRequest.getSession();
        Object value =  session.getAttribute(key);
        if( value == null){
            throw new RuntimeException("NO " + key + " Information");
        }
        return t.cast(value);
    }

    /**
     * 从session中移除信息
     * @param servletRequest servletRequest
     * @param key key
     */
    public static  void removeMessage(HttpServletRequest servletRequest,String key){
        HttpSession session = servletRequest.getSession();
        session.removeAttribute(key);
    }

    /**
     * 查询session中是否包含指定key
     * @param servletRequest servletRequest
     * @param key key
     *
     * @return true(包含),false(不含)
     */
    public static  boolean containsMessage(HttpServletRequest servletRequest,String key){
        HttpSession session = servletRequest.getSession();
        return session.getAttribute(key)!=null;
    }

    /**
     * 校验session中某key的value与指定value是否相等
     * @param servletRequest servletRequest
     * @param key  key
     * @param value value
     *
     * @return true(相等),false(不等)
     */
    public static boolean verifyMessage(HttpServletRequest servletRequest,String key,Object value){
        if( value == null ){
            return false;
        }
        HttpSession session = servletRequest.getSession();
        return value.equals(session.getAttribute(key));
    }

}
