package com.angel.shz.web.controller;

import com.alibaba.fastjson.JSON;
import com.angel.common.util.Constants;
import com.angel.common.util.sessionutil.SessionUtil;
import com.angel.shz.business.UserBusiness;
import com.angel.shz.dbservice.model.User;
import com.angel.shz.web.common.ControllerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lijn on 2016/4/28.
 *
 * @author Lijn
 */
@Controller
@RequestMapping
public class UserController {

    @Autowired
    UserBusiness userBusiness;

    /** 注册
     * @param request request
     * @param response response
     *
     * @return 注册结果
     */
    @ResponseBody
    @RequestMapping(value = "/regist", method = RequestMethod.POST,produces = {"application/javascript","application/json"} )
    public Object registUser( HttpServletRequest request,HttpServletResponse response ){
        Map<String, Object> result = new HashMap<String, Object>();

       /* Map<String, Object> userInfo = new HashMap<String, Object>();                           //TODO getuserInfo from web
        String userName = "1234";
        String password = "2344";*/
        String code = "1244";
        User user = new User();

        //检查检查校验码
        if( !SessionUtil.verifyMessage(request,Constants.SESSION_KEY_VERIFYCODE_USERREGISTER,code)){
            try {
                //返回验证码，图片输出到指定流中
                String verifyCode = ControllerUtil.backVerifyImage( response);
                //验证码存入会话session
                SessionUtil.storeMessage(request,Constants.SESSION_KEY_VERIFYCODE_USERREGISTER,verifyCode);
                return null;
            }catch (IOException ioe){
                ioe.printStackTrace();
            }
        }

        userBusiness.addUser(user);                     //TODO 储存用户信息
        result.put("message","SUCCESS");
       return JSON.toJSONString(result);
    }


}
