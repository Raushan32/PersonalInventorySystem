/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personaliventorysystem.bean;

/**
 *
 * @author rkhjp
 */
public class IncomeBean {
    private int inc_id;
    private String inc_ac;
    private int userid;
    private int inc_catid;
    private double amount;
    private String transaction_date;
    private String receiveBy;
    private String remark;

    public IncomeBean() {
    }

    public IncomeBean(int inc_id, String inc_ac, int userid, int inc_catid, double amount, String transaction_date, String receiveBy, String remark) {
        this.inc_id = inc_id;
        this.inc_ac = inc_ac;
        this.userid = userid;
        this.inc_catid = inc_catid;
        this.amount = amount;
        this.transaction_date = transaction_date;
        this.receiveBy = receiveBy;
        this.remark = remark;
    }

    public int getInc_id() {
        return inc_id;
    }

    public String getInc_ac() {
        return inc_ac;
    }

    public int getUserid() {
        return userid;
    }

    public int getInc_catid() {
        return inc_catid;
    }

    public double getAmount() {
        return amount;
    }

    public String getTransaction_date() {
        return transaction_date;
    }

    public String getReceiveBy() {
        return receiveBy;
    }

    public String getRemark() {
        return remark;
    }

    public void setInc_id(int inc_id) {
        this.inc_id = inc_id;
    }

    public void setInc_ac(String inc_ac) {
        this.inc_ac = inc_ac;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public void setInc_catid(int inc_catid) {
        this.inc_catid = inc_catid;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setTransaction_date(String transaction_date) {
        this.transaction_date = transaction_date;
    }

    public void setReceiveBy(String receiveBy) {
        this.receiveBy = receiveBy;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    
}
