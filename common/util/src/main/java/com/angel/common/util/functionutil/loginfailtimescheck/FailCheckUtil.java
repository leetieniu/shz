package com.angel.common.util.functionutil.loginfailtimescheck;

import com.angel.common.data.structure.queue.IQueue;
import com.angel.common.data.structure.queue.circlequeue.ArrayCircleQueue;

import java.util.Calendar;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Lijn on 2016/3/31.
 * 检查密码出错次数
 * @author Lijn
 */
public class FailCheckUtil {
    private  ConcurrentHashMap<String ,IQueue<Calendar>> userMap;
    private  int times = 3;     //次数
    private  int time = 10;      //时间段-minute

    private static FailCheckUtil instance;

    /**
     * @param times 次数
     * @param time  时间段(分钟)
     *
     * @return
     */
    public static FailCheckUtil getInstance(final int times,final int time){
        if( instance == null ){
            synchronized (FailCheckUtil.class) {
                if(instance == null){
                    instance = new FailCheckUtil();
                    instance.times = times;
                    instance.time = time;
                    instance.userMap = new ConcurrentHashMap<>();
                }
            }
        }
        return instance;
    }


    public static FailCheckUtil getInstance(){
        if( instance == null ){
            synchronized (FailCheckUtil.class) {
                if(instance == null){
                    instance = new FailCheckUtil();
                    instance.userMap = new ConcurrentHashMap<>();
                }
            }
        }
        return instance;
    }

    /**
     * 添加用户登录失败次数
     * @param userId 用户Id
     * @return 如果次数满 @times 次，这锁定用户（true）
     */
    public  boolean addFailTime(String userId){
        if(userId == null){
            throw new RuntimeException("非法用户");
        }
        boolean locked = false;
        userMap.putIfAbsent(userId,new ArrayCircleQueue<Calendar>());
        IQueue<Calendar> failtimes = userMap.get(userId);
        synchronized (failtimes){
            Calendar oldCalendar = Calendar.getInstance();
            oldCalendar.add(Calendar.MINUTE, 0 - time);
            while(true){
                if(failtimes.isEmpty()){
                    break;
                }
                Calendar tempCalendar = failtimes.takequeue();
                if(tempCalendar.before(oldCalendar)){
                    failtimes.dequeue();
                }else{
                    break;
                }
            }
            failtimes.enqueue(Calendar.getInstance());
            if(failtimes.getCurrentSize()>=times){
                locked =  true;
            }
        }
        return locked;
    }

    /**
     * 移除某用户所有失败次数
     * @invoke 1用户登录成功，2用户登录失败times次锁定用户
     * @param userId
     */
    public void remove(String userId){
        if(userId == null){
            throw new RuntimeException("非法用户");
        }
        userMap.remove(userId);
    }
}
