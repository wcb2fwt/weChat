package com.example.demo.dao;

import com.example.demo.entity.Pic;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface PicMapper {

    //保存图片信息
    int insertPic( Pic pic);

    //根据图片名称查询图片链接
    String picUrl(String picName);

    int updatePic(Pic pic);
}
