package com.example.demo.entity;

import java.util.Date;

public class ScanRecordCount {

    private String id;//主键id

    private Integer expType;//扫描类型，1：CT，2：全景，3：侧位

    private Integer counts;//扫描总条数

    private Date endTime;//最后更新时间

    private String productSold;//所属已售产品


    public ScanRecordCount(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getExpType() {
        return expType;
    }

    public void setExpType(Integer expType) {
        this.expType = expType;
    }

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getProductSold() {
        return productSold;
    }

    public void setProductSold(String productSold) {
        this.productSold = productSold;
    }


    public String getExpTypeStr() {
        String expTypeStr = "";
        if(expType != null){
            if(expType == 1){
                expTypeStr = "CT";
            }
            if(expType == 2){
                expTypeStr = "全景";
            }
            if(expType == 3){
                expTypeStr = "侧位";
            }
            if(expType == 4){
                expTypeStr = "定位像";
            }
            if(expType == 5){
                expTypeStr = "TMJ";
            }
        }
        return expTypeStr;
    }

}
