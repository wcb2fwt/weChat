package com.example.demo.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import com.example.demo.entity.WechatQRCode;
import com.example.demo.getToken.WeixinToken;
import com.example.demo.service.WxService;
import com.example.demo.service.WxServiceImpl;
import com.example.demo.weixinaes.MyX509TrustManager;

public class Program {


	public static void main(String[] args) throws Exception {
		String s = "1234_56789";
		String[] split = s.split("_");
		for(int i=0;i<split.length;i++){
			System.out.println(i);
			System.out.println(split[i]);
		}
	}
}
