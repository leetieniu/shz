package com.angel.common.util.checkcodeutil;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Lijn on 2016/4/27.
 *
 * @author Lijn
 */
public class VerifyCodeUtilTest {
    public static void main(String[] args) {
        int w = 200, h = 80;
        File dir = new File("D:/快盘/myworkspace/common/util/src/test/resources/checkcode");
        if(!dir.exists()) {
            dir.mkdirs();
        }
        try {
            for (int i = 0; i < 5; i++) {
                String verifyCode = VerifyCodeUtils.generateVerifyCode(4, null);
                File file = new File(dir, verifyCode + ".jpg");
                file.createNewFile();
                FileOutputStream fos = new FileOutputStream(file);
                BufferedImage image = VerifyCodeUtils.dogetImage(w, h, verifyCode);
                ImageIO.write(image, "jpg", fos);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
