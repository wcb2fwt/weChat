package com.example.demo.dao;

import com.example.demo.entity.ScanRecord;
import com.example.demo.entity.ScanRecordCount;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface ScanRecordCountMapper {

    void add(ScanRecordCount sc);

}
