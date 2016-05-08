package com.angel.shz.web.common;

import com.angel.common.util.Constants;
import com.angel.common.util.checkcodeutil.VerifyCodeUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Lijn on 2016/4/28.
 *
 * @author Lijn
 */
public class ControllerUtil {

    /** 生成验证码 image输出到响应报文
     * @param response
     *
     * @return
     * @throws IOException
     */
    public static String backVerifyImage(HttpServletResponse response) throws IOException {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        //返回验证码，图片输出到指定流中
        String verifyCode = VerifyCodeUtils.createVerifyCode(Constants.VERIFYCODE_SIZE, Constants.VERIFYCODE_WIDTH, Constants.VERIFYCODE_HEIGHT, response.getOutputStream());

        return verifyCode;
    }
}
