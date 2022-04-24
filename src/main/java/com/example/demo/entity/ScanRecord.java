package com.example.demo.entity;

import java.util.Date;

public class ScanRecord {


    private String id;//主键id

    private Integer expType;//扫描类型，1：CT，2：全景，3：侧位

    private Integer patientType;//患者类型

    private Integer startTicks;//开机后多久开始扫描

    private Integer tubeTemp;//球管温度

    private Integer totalTicks;//扫描时长

    private Date startTime;//扫描开始时间

    private Date endTime;//扫描结束时间

    private String productSold;//所属已售产品


    public ScanRecord(){

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

    public Integer getPatientType() {
        return patientType;
    }

    public void setPatientType(Integer patientType) {
        this.patientType = patientType;
    }

    public Integer getStartTicks() {
        return startTicks;
    }

    public void setStartTicks(Integer startTicks) {
        this.startTicks = startTicks;
    }

    public Integer getTotalTicks() {
        return totalTicks;
    }

    public void setTotalTicks(Integer totalTicks) {
        this.totalTicks = totalTicks;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
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

    public Integer getTubeTemp() {
        return tubeTemp;
    }

    public void setTubeTemp(Integer tubeTemp) {
        this.tubeTemp = tubeTemp;
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

    @Override
    public String toString() {
        return "ScanRecord{" +
                "id='" + id + '\'' +
                ", expType=" + expType +
                ", patientType=" + patientType +
                ", startTicks=" + startTicks +
                ", tubeTemp=" + tubeTemp +
                ", totalTicks=" + totalTicks +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", productSold='" + productSold + '\'' +
                '}';
    }
}
