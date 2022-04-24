package com.example.demo.getToken;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AccessTokenTask {
    private Logger logger = LoggerFactory.getLogger(AccessTokenTask.class);

    @Autowired
    private GetToken getToken;
    @Value("${wx.gz.appid}")
    private String appid;
    @Value("${wx.gz.secret}")
    private String secret;

    /**
     * access_token 是小程序的全局唯一调用凭据
     * access_token 的有效期为 2 个小时，需要定时刷新 access_token，重复获取会导致之前一次获取的
     * access_token 失效
     * 延迟一秒执行
     */
    @Scheduled(initialDelay = 1000, fixedDelay = 7000*1000 )
    public void getTouTiaoAccessToken(){
        try {
            String token = getToken.getToken(appid, secret).getAccessToken();
            //将获取到的token放到内存
            WeixinToken.token = token;
            logger.info("获取到的微信accessToken为"+token);
        } catch (Exception e) {
            logger.error("获取微信adcessToken出错，信息如下");
            e.printStackTrace();
        }

    }

}
