package com.example.demo.dao;

import com.example.demo.entity.ScanRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface ScanRecordMapper {

    List<ScanRecord> getall(String id);

}
