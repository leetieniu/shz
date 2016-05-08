package com.angel.common.util.loginfailtimescheck;


import com.angel.common.util.functionutil.loginfailtimescheck.FailCheckUtil;

import java.util.Date;
import java.util.Random;

/**
 * Created by Lijn on 2016/4/8.
 * 通过循环队列处理指定时间内验证失败3次就锁住用户
 * @author Lijn
 */
public class FailCheckUtilTest {

    public static void main(String[] args){
        String name = "Mr li";
        boolean locked = false;
        while(true){
            if(locked){
                System.out.println(name + " is locked;break");
                break;
            }

            Random rd = new Random();
            boolean passed = rd.nextBoolean();          //登陆验证是否通过

            if(passed){
                System.out.println(name + " 验证通过,失败次数清空  " + new Date());
                FailCheckUtil.getInstance(3, 1).remove(name);
            }else{                                                                  //如果未通过
                System.out.println(name + " 验证失败,次数+1  " + new Date());
                if(FailCheckUtil.getInstance().addFailTime(name)){    //如果连续短时间内失败n次则锁住用户    ；$1与$2应保持原子操作
                    System.out.println(name + " 锁定  " + new Date());
                    FailCheckUtilTest.lock(name);               //$1
                    locked = true;
                    FailCheckUtil.getInstance().remove(name);         //$2
                }
            }
            try {
                Thread.sleep(1000*rd.nextInt(10));    //等待多久进行下一次登陆验证
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void lock(String name){
        System.out.println(name + " locked  "+ new Date());
    }
}
