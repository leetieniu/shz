package com.angel.shz.business;

import com.angel.common.util.Constants;
import com.angel.common.util.securityutil.MD5Util;
import com.angel.shz.dbservice.model.User;
import com.angel.shz.dbservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Lijn on 2016/5/3.
 *
 * @author Lijn
 */
@Service
public class UserBusiness {

    @Autowired
    UserService userService;

    /**
     * 验证用户登录
     * @param userName 登录名
     * @param password 密码字段
     * @param timestamp 前端发送的时间
     *
     * @return 是否验证通过
     */
    public boolean checkLogin(String userName, String password, String timestamp){
        boolean result = false;
        User user = userService.selectByLoginName(userName);
        if ( user != null && Constants.USER_STATUS_NORMAL.equals(user.getStatus()) ){
            String verifypassword = MD5Util.encrypt(user.getLoginPassword() + timestamp);
            if(password.equals(verifypassword)){
                result = true;
            }
        }
        return result;
    }

    /**
     * 锁定用户
     * @param userName 用户名称
     */
    public void lockUser(String userName) {
        userService.updateWithLockByLoginName(userName);
    }

    public boolean addUser(User user){
        return userService.addUser(user)==1;
    }
}
