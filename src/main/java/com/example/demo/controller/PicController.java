package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Pic;
import com.example.demo.service.PicServiceImpl;
import com.example.demo.service.WxServiceImpl;
import com.example.demo.util.CommonUtil;
import com.example.demo.util.CommunityUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

@Controller
@RequestMapping("/pic")
public class PicController {

    @Value("${server.servlet.context-path}")
    private String contextPath;
    @Value("${community.path.upload}")
    private String uploadPath;
    @Value("${community.path.domain}")
    private String domain;

    @Resource
    private PicServiceImpl picServiceImpl;
    @Resource
    private WxServiceImpl wxService;

    @RequestMapping(path = "/index",method = RequestMethod.GET)
    public String wcv(){
        return "index";
    }

    private static void inputStreamToFile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static File multipartFileToFile(MultipartFile file) throws Exception {

        File toFile = null;
        if (file.equals("") || file.getSize() <= 0) {
            file = null;
        } else {
            InputStream ins = null;
            ins = file.getInputStream();
            toFile = new File(file.getOriginalFilename());
            inputStreamToFile(ins, toFile);
            ins.close();
        }
        return toFile;
    }

    //上传文件
    @RequestMapping(path = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public String uploadHeader(@RequestParam("file") MultipartFile file) {
        if (file == null) {
            return "您还没有选择图片！";
        }
        JSONObject image = null;
        try {
            File file1 = multipartFileToFile(file);
            image = CommonUtil.UploadMeida("image", file1);
            if(file1.exists()){
                file1.delete();
            }
        } catch (Exception e) {
            throw new RuntimeException("上传文件到素材中心失败！",e);
        }
        Map<String, Object> map = new HashMap<>();
        if (image != null){
           map = wxService.getQrCode(image.getString("media_id"));
        }else {
            return "上传文件到素材中心失败";
        }
        String url = "Error generating QR code!";
        if (null!=map.get("ticket")&&map.get("ticket")!=""){
            url = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket="+map.get("ticket");
        }
        return url;
    }


    @RequestMapping(path = "/url/{filename}",method = RequestMethod.GET)
    @ResponseBody
    public String getPicUrl(@PathVariable("filename") String filename){

        System.out.println(filename.length());
        if (filename == null && filename.length() == 0){
            return null;
        }
        //判断是否多张图片
        if (filename.contains(",")){
            String[] split = filename.split(",");
            ArrayList<String> as = new ArrayList<String>();
            for(int i=0; i<split.length; i++){
                String s = picServiceImpl.selectUrl(split[i]);
                as.add(s);
            }
            return String.valueOf(as);
        }
        //查询是否有这个图片
        String s = picServiceImpl.selectUrl(filename);
        return s;
    }


    //获取图片
    //向浏览器响应图片
    @RequestMapping(path = "/header/{filename}",method = RequestMethod.GET)
    public void getHeader(@PathVariable("filename") String filename, HttpServletResponse response){

        //服务器存放路径
        filename = uploadPath + "/" + filename;
        //文件的后缀
        String suffix = filename.substring(filename.lastIndexOf("."));
        //响应图片
        response.setContentType("image/"+suffix);
        try (
                //获取字节流，图片是二进制的，文件的输出流
                OutputStream os = response.getOutputStream();
                //创建文件的输入流
                FileInputStream fis = new FileInputStream(filename);
        ){
            //声明一个缓冲区
            byte[] buffer = new byte[1024];
            int b = 0;
            while ((b = fis.read(buffer)) != -1){
                os.write(buffer,0,b);
            }
        } catch (IOException e) {
            //LOGGER.error("读取头像失败："+e.getMessage());
            System.out.println("获取图片失败");
        }
    }
}
