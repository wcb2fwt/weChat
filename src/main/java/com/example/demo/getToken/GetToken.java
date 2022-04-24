package com.example.demo.getToken;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.WechatQRCode;
import com.example.demo.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class GetToken {
    private Logger logger = LoggerFactory.getLogger(GetToken.class);
    public WechatQRCode getToken(String appid, String appSecrect) {

        WechatQRCode wechatQRCode = null;

        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appid
                + "&secret=" + appSecrect;

        JSONObject jsonObject = CommonUtil.httpsRequest(url, "GET", null);

        if (jsonObject != null) {

            try {
                wechatQRCode = new WechatQRCode();

                wechatQRCode.setAccessToken(jsonObject.getString("access_token"));

                wechatQRCode.setExpiresIn(jsonObject.getInteger("expires_in"));
            } catch (Exception e) {
                wechatQRCode = null;
                e.printStackTrace();
                logger.error("系统出错了！");
            }
        } else {
            wechatQRCode = null;
            // 获取token失败
            logger.error("jsonObject为空，获取token失败");
        }
        return wechatQRCode;

    }

}
