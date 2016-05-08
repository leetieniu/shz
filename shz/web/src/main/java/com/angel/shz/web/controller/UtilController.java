package com.angel.shz.web.controller;

import com.angel.common.util.sessionutil.SessionUtil;
import com.angel.shz.web.common.ControllerUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Lijn on 2016/4/28.
 *
 * @author Lijn
 */
@Controller
@RequestMapping
public class UtilController {

    @ResponseBody
    @RequestMapping(value = "/checkcode/{type}/get", method = RequestMethod.GET, produces = {"application/javascript","application/json"})
    public void verifyCode( @PathVariable("type") String type, HttpServletRequest request,HttpServletResponse response) {
        try {
            //返回验证码，图片输出到指定流中
            String verifyCode = ControllerUtil.backVerifyImage(response);
            //验证码存入会话session
            SessionUtil.storeMessage(request,type,verifyCode);
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
