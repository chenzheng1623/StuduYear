package com.nwnu.cz.myapplication.modle;

/**
 * Created by cz on 2016/3/21.
 *  "FE_CU_NAME":"大学英语B级Ⅰ", 课程名称
 "FE_CU_YEAR":"2012秋季",  修读学期
 "FE_CU_CREDIT":"4",     学分
 "FE_SR_USUAL1":98,   平时
 "FE_SR_FINAL":71,    期末
 "FE_SR_TOTAL":"82",  总评
 "FE_SR_CORDE":"82",  最终
 "FE_SR_FLAG":"正考",  成绩类型
 "FE_CU_TYPE":"必修",  课程类型
 "FE_TP_CODE":"84000201",  课程编码
 "FE_CU_ID":258015}   课序号
 */
public class Gradge {


    private String FE_CU_NAME;
    private String FE_CU_YEAR;
    private String FE_CU_CREDIT;
    private String FE_SR_USUAL1;
    private String FE_SR_FINAL;
    private String FE_SR_TOTAL;
    private String FE_SR_CORDE;
    private String FE_SR_FLAG;

    @Override
    public String toString() {
        return "Gradge{" +
                "FE_CU_NAME='" + FE_CU_NAME + '\'' +
                ", FE_CU_YEAR='" + FE_CU_YEAR + '\'' +
                ", FE_CU_CREDIT='" + FE_CU_CREDIT + '\'' +
                ", FE_SR_USUAL1='" + FE_SR_USUAL1 + '\'' +
                ", FE_SR_FINAL='" + FE_SR_FINAL + '\'' +
                ", FE_SR_TOTAL='" + FE_SR_TOTAL + '\'' +
                ", FE_SR_CORDE='" + FE_SR_CORDE + '\'' +
                ", FE_SR_FLAG='" + FE_SR_FLAG + '\'' +
                ", FE_CU_TYPE='" + FE_CU_TYPE + '\'' +
                ", FE_TP_CODE='" + FE_TP_CODE + '\'' +
                ", FE_CU_ID='" + FE_CU_ID + '\'' +
                '}';
    }

    private String FE_CU_TYPE;
    private String FE_TP_CODE;
    private String FE_CU_ID;

    public String getFE_CU_YEAR() {
        return FE_CU_YEAR;
    }

    public void setFE_CU_YEAR(String FE_CU_YEAR) {
        this.FE_CU_YEAR = FE_CU_YEAR;
    }

    public String getFE_CU_CREDIT() {
        return FE_CU_CREDIT;
    }

    public void setFE_CU_CREDIT(String FE_CU_CREDIT) {
        this.FE_CU_CREDIT = FE_CU_CREDIT;
    }

    public String getFE_SR_USUAL1() {
        return FE_SR_USUAL1;
    }

    public void setFE_SR_USUAL1(String FE_SR_USUAL1) {
        this.FE_SR_USUAL1 = FE_SR_USUAL1;
    }

    public String getFE_SR_FINAL() {
        return FE_SR_FINAL;
    }

    public void setFE_SR_FINAL(String FE_SR_FINAL) {
        this.FE_SR_FINAL = FE_SR_FINAL;
    }

    public String getFE_SR_TOTAL() {
        return FE_SR_TOTAL;
    }

    public void setFE_SR_TOTAL(String FE_SR_TOTAL) {
        this.FE_SR_TOTAL = FE_SR_TOTAL;
    }

    public String getFE_SR_CORDE() {
        return FE_SR_CORDE;
    }

    public void setFE_SR_CORDE(String FE_SR_CORDE) {
        this.FE_SR_CORDE = FE_SR_CORDE;
    }

    public String getFE_SR_FLAG() {
        return FE_SR_FLAG;
    }

    public void setFE_SR_FLAG(String FE_SR_FLAG) {
        this.FE_SR_FLAG = FE_SR_FLAG;
    }

    public String getFE_CU_TYPE() {
        return FE_CU_TYPE;
    }

    public void setFE_CU_TYPE(String FE_CU_TYPE) {
        this.FE_CU_TYPE = FE_CU_TYPE;
    }

    public String getFE_TP_CODE() {
        return FE_TP_CODE;
    }

    public void setFE_TP_CODE(String FE_TP_CODE) {
        this.FE_TP_CODE = FE_TP_CODE;
    }

    public String getFE_CU_ID() {
        return FE_CU_ID;
    }

    public void setFE_CU_ID(String FE_CU_ID) {
        this.FE_CU_ID = FE_CU_ID;
    }

    public String getFE_CU_NAME() {

        return FE_CU_NAME;
    }

    public void setFE_CU_NAME(String FE_CU_NAME) {
        this.FE_CU_NAME = FE_CU_NAME;
    }
}
