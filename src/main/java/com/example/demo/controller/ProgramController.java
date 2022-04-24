package com.example.demo.controller;

import com.example.demo.entity.InMsgEntity;
import com.example.demo.entity.OutMsgEntity;
import com.example.demo.getToken.WeixinToken;
import com.example.demo.service.WxService;
import com.example.demo.weixinaes.AesException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

@Controller
public class ProgramController {
    private static Logger log = LoggerFactory.getLogger(ProgramController.class);
    @Resource
    private WxService wxService;


    @RequestMapping(value = "/weChat",method = RequestMethod.GET)
    @ResponseBody
    public String validate( String signature, String timestamp, String nonce, String echostr) throws AesException {
        System.out.println(signature+"&"+timestamp+"&"+nonce+"&"+echostr);

//        if (signature!=null && WXPublicUtils.verifyUrl(signature,timestamp,nonce,echostr)){
//            return echostr;
//        }

        return null;
    }

    @RequestMapping(value = "/weChat",method = RequestMethod.POST,produces = { "application/xml;charset=UTF-8" })
    @ResponseBody
    public OutMsgEntity handleMessage(@RequestBody InMsgEntity msg) {

        System.out.println("handleMessage");
        System.out.println("msg"+msg);
        OutMsgEntity out = new OutMsgEntity();
        out.setToUserName(msg.getFromUserName());
        out.setFromUserName(msg.getToUserName());
        String msgType = msg.getMsgType();
        String event = msg.getEvent();
        out.setMsgType(msgType);
        out.setCreateTime(new Date().getTime());
        if ("text".equals(msgType)){
            out.setContent(msg.getContent());
        }else if ("image".equals(msgType)){
            out.setMediaId(new String[]{msg.getMediaId()});
        }else if ("event".equals(msgType)){
            if ("subscribe".equals(event)){
                String eventkey = msg.getEventKey();
                String split = eventkey.substring(8);
                out.setMediaId(new String[]{split});
                out.setMsgType("image");
                log.info("用户关注：{}");
            }else if ("SCAN".equals(event)){
                out.setMediaId(new String[]{msg.getEventKey()});
                out.setMsgType("image");
                log.info("用户扫码：{}");
            }
        }
        System.out.println("out"+out);
        return out;
    }

    /**
     * 获取二维码参数
     * @return
     */
    @GetMapping("/getQrCode")
    @ResponseBody
    public Object getQrCode(){
        return wxService.getQrCode("1");
    }





}
