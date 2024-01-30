/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personaliventorysystem.dao;

import com.personaliventorysystem.bean.ExpensesBean;
import com.personaliventorysystem.utility.ConnectionPool;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author rkhjp
 */
public class ExpensesDAO {
    Connection conn;
    public int addExpenses(ExpensesBean eb) throws ClassNotFoundException, SQLException{
        conn=ConnectionPool.connectDB();
        String sql="insert into expenses (exp_ac,userid,exp_catid,amount,transaction_date,payby,remark )values('"+eb.getExp_ac()+"','"+eb.getUserid()+"','"+eb.getExp_catid()+"','"+eb.getAmount()+"','"+eb.getTransaction_date()+"','"+eb.getPayby()+"','"+eb.getRemark()+"')";
    Statement stmt=conn.createStatement();
    int r=stmt.executeUpdate(sql);
    if(r>0){
        System.out.println("Inserted Succesfully");
    }else{
        System.out.println("Inserting Fail");
    }
return r;
    }
    public ArrayList<ExpensesBean> findAll() throws ClassNotFoundException, SQLException{
        conn=ConnectionPool.connectDB();
        ArrayList<ExpensesBean> al =new ArrayList();
        String sql="select * from expenses";
        Statement stmt=conn.createStatement();
        ResultSet rs =stmt.executeQuery(sql);
        while(rs.next()){
            //System.out.println(""+rs.getInt(1)+"\t\t\t"+rs.getString(2)+"\t\t\t"+rs.getInt(3)+"\t\t\t"+rs.getInt(4)+"\t\t\t"+rs.getDouble(5)+"\t\t\t"+rs.getString(6)+"\t\t\t"+rs.getString(7)+"\t\t\t"+rs.getString(8));
            ExpensesBean eb =new ExpensesBean();
            eb.setExp_ac(rs.getString("exp_ac"));
            eb.setExp_catid(rs.getInt("exp_catid"));
            eb.setPayby(rs.getString("payby"));
            eb.setRemark(rs.getString("remark"));
            eb.setTransaction_date(rs.getString("transaction_date"));
            eb.setExp_id(rs.getInt("exp_id"));
            eb.setAmount(rs.getInt("amount"));
            
            al.add(eb);
        }
        return al;
    }
    public int deleted(int exp_id) throws ClassNotFoundException, SQLException{
        int r=0;
        conn=ConnectionPool.connectDB();
        String sql="delete from expenses where exp_id='"+exp_id+"'";
        Statement stmt =conn.createStatement();
        r=stmt.executeUpdate(sql);
        if(r>0){
            System.out.println("Deleted Succes");
        }else{
            System.out.println("Deleted Failed");
        }
        return r;
    }
    public int findById(int exp_id) throws ClassNotFoundException, SQLException{
        int r=0;
        conn=ConnectionPool.connectDB();
        String sql="select * from expenses where exp_id='"+exp_id+"'";
        Statement stmt=conn.createStatement();
        ResultSet rs =stmt.executeQuery(sql);
        while(rs.next()){
            System.out.println(""+rs.getInt(1)+"\t\t\t"+rs.getString(2)+"\t\t\t"+rs.getInt(3)+"\t\t\t"+rs.getInt(4)+"\t\t\t"+rs.getDouble(5)+"\t\t\t"+rs.getString(6)+"\t\t\t"+rs.getString(7)+"\t\t\t"+rs.getString(8));
        }
        return r;
    }
    public void update(ExpensesBean eb) throws ClassNotFoundException, SQLException{
        conn=ConnectionPool.connectDB();
        String sql="update Expenses set exp_ac='"+eb.getExp_ac()+"',userid='"+eb.getUserid()+"',exp_catid='"+eb.getExp_catid()+"',amount='"+eb.getAmount()+"',transaction_date='"+eb.getTransaction_date()+"',payby='"+eb.getPayby()+"',remark='"+eb.getRemark()+"' where exp_id='"+eb.getExp_id()+"'";
        Statement stmt=conn.createStatement();
        int r=stmt.executeUpdate(sql);
        if(r>0){
            System.out.println("Updated Succes"); 
        }else{
            System.out.println("Updated Failed");
        }
    }
    //public ArrayList findAll(int userid)
    //public ArrayList findallDateWise(String sdate.edate,int userid)
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ExpensesBean eb=new ExpensesBean();
//        eb.setAmount(2000);
//        eb.setExp_ac("554");
//        eb.setExp_catid(10);
//        eb.setPayby("paytm");
//        eb.setRemark("good");
//        eb.setTransaction_date("2023-12-20");
//        eb.setUserid(3);
        ExpensesDAO ed =new ExpensesDAO();
        //ed.addExpenses(eb);
        //find all
//        ed.findAll();

//deleted


//ed.deleted(3)

//findbyid
//ed.findById(1);

//update 
//    eb.setExp_id(1);
//         eb.setAmount(20000);
//        eb.setExp_ac("55");
//        eb.setExp_catid(10);
//        eb.setPayby("phonepay");
//        eb.setRemark("Very good");
//        eb.setTransaction_date("2023-05-20");
//        eb.setUserid(4);
//        
//        ed.update(eb);
    }
}
