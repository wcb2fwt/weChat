package com.example.demo.service;

import com.example.demo.dao.PicMapper;
import com.example.demo.entity.Pic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PicServiceImpl{

    @Autowired(required = false)
    private PicMapper picMapper;


    public int insertPic(Pic pic) {
        return picMapper.insertPic(pic);
    }

    public String selectUrl(String picName) {
        return picMapper.picUrl(picName);
    }

    public int updatePic(Pic pic) {
        return picMapper.updatePic(pic);
    }
}
