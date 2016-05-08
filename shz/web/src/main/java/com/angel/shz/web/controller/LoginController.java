package com.angel.shz.web.controller;

import com.alibaba.fastjson.JSON;
import com.angel.common.util.Constants;
import com.angel.common.util.functionutil.loginfailtimescheck.FailCheckUtil;
import com.angel.common.util.sessionutil.SessionUtil;
import com.angel.shz.business.UserBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lijn on 2016/4/28.
 *
 * @author Lijn
 */
@Controller
@RequestMapping
public class LoginController {

    @Autowired
    UserBusiness userBusiness;

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST,produces = {"application/javascript","application/json"} )
    public Object login( HttpServletRequest request ){
        Map<String, Object> result = new HashMap<String, Object>();

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String timestamp = request.getParameter("timestamp");

        //检查用户
        boolean verifyresult = userBusiness.checkLogin(userName, password, timestamp);

        if ( verifyresult ){
            FailCheckUtil.getInstance().remove(userName);
            SessionUtil.storeMessage(request, Constants.SESSION_KEY_USER,userName);
            result.put("message", "登录成功");
            return JSON.toJSONString(result);
        } else {
            result.put("message", "登录失败");
            if(FailCheckUtil.getInstance().addFailTime(userName)){
                userBusiness.lockUser(userName);
                FailCheckUtil.getInstance().remove(userName);
            }
            return JSON.toJSONString(result);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/logout", method = RequestMethod.GET, produces = {"application/javascript","application/json"})
    public Object logout( HttpServletRequest request) {
        Map<String, Object> result = new HashMap<String, Object>();
        SessionUtil.removeMessage(request, Constants.SESSION_KEY_USER);
        result.put("message", "注销成功");
        return JSON.toJSONString(result);
    }
}
