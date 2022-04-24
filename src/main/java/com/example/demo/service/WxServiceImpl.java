package com.example.demo.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.getToken.WeixinToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class WxServiceImpl implements WxService{

    Logger logger = LoggerFactory.getLogger(WxServiceImpl.class);

    @Resource
    private RestTemplate restTemplate;

    @Override
    public String getAccessToken() {
        logger.info("获取token"+WeixinToken.token);
        return WeixinToken.token;
    }

    @Override
    public Map<String, Object> getQrCode(String id) {
        //获取临时二维码
        String url = String.format("https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=%s",getAccessToken());
//        ResponseEntity<String> result = restTemplate.postForEntity(url, "{\"expire_seconds\": 1800, \"action_name\": \"QR_SCENE\", \"action_info\": {\"scene\": {\"scene_id\": "+id+"}}}", String.class);
        ResponseEntity<String> result = restTemplate.postForEntity(url, "{\"expire_seconds\": 2592000, \"action_name\": \"QR_STR_SCENE\", \"action_info\": {\"scene\": {\"scene_str\": \""+id+"\"}}}", String.class);
        logger.info("二维码:{}",result.getBody());
        System.out.println("{\"expire_seconds\": 2592000, \"action_name\": \"QR_STR_SCENE\", \"action_info\": {\"scene\": {\"scene_str\": \""+id+"\"}}}");
        logger.info("meadId"+id);
        JSONObject jsonObject = JSON.parseObject(result.getBody());
        Map<String,Object> map=new HashMap<>();
        map.put("ticket",jsonObject.getString("ticket"));
        map.put("url",jsonObject.getString("url"));
        return map;
    }
}
