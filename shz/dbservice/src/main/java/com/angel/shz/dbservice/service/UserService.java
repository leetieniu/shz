package com.angel.shz.dbservice.service;

import com.angel.common.util.Constants;
import com.angel.shz.dbservice.mapper.UserMapper;
import com.angel.shz.dbservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Lijn on 2016/4/27.
 *
 * @author Lijn
 */
@Service
public class UserService {

    @Autowired
    UserMapper mapper;

    public  int addUser(User user){
        User user1 = mapper.selectByPrimaryKey(user.getLoginName());
        if(user1!=null){
            throw new RuntimeException("已存在同名用户");
        }
        return mapper.insert(user);
    }

    public User selectByLoginName(String loginName){
        return mapper.selectByPrimaryKey(loginName);
    }

    @Transactional
    public int updateWithLockByLoginName(String userName){
        User user = new User();
        user.setName(userName);
        user.setStatus(Constants.USER_STATUS_LOCK);
        mapper.selectforUpdateByPrimaryKey(userName);
        return mapper.updateByPrimaryKeySelective(user);
    }
}
