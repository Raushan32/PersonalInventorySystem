/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personaliventorysystem.dao;

import com.personaliventorysystem.bean.IncomeBean;
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
public class IncomeDAO {
    Connection conn;
    public int add(IncomeBean ib) throws ClassNotFoundException, SQLException{
       int r=0;
       conn=ConnectionPool.connectDB();
       String sql="insert into incomes(inc_ac,userid,inc_catid,amount,transation_date,receiveBy,remark)values('"+ib.getInc_ac()+"','"+ib.getUserid()+"','"+ib.getInc_catid()+"','"+ib.getAmount()+"','"+ib.getTransaction_date()+"','"+ib.getReceiveBy()+"','"+ib.getRemark()+"')";
       Statement stmt=conn.createStatement();
       r=stmt.executeUpdate(sql);
       if(r>0){
           System.out.println("Inserted Success");
       }else{
           System.out.println("Inserting Failed");
       }
       return r;
    }
    public ArrayList<IncomeBean> findAll() throws ClassNotFoundException, SQLException{
        conn=ConnectionPool.connectDB();
        ArrayList<IncomeBean> al =new ArrayList();
        
        String sql="select * from incomes";
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        while(rs.next()){
//            System.out.println(""+rs.getInt(1)+"\t\t\t"+rs.getString(2)+"\t\t\t"+rs.getInt(3)+"\t\t\t"+rs.getInt(4)+"\t\t\t"+rs.getDouble(5)+"\t\t\t"+rs.getString(6)+"\t\t\t"+rs.getString(7)+"\t\t\t"+rs.getString(8));
        IncomeBean ib =new IncomeBean();
        ib.setInc_ac(rs.getString("inc_ac"));
        ib.setInc_catid(rs.getInt("inc_catid"));
        ib.setInc_id(rs.getInt("inc_id"));
        ib.setReceiveBy(rs.getString("receiveBy"));
        ib.setRemark(rs.getString("remark"));
        ib.setTransaction_date(rs.getString("transation_date"));
        ib.setAmount(rs.getInt("amount"));
        
        al.add(ib);
        }
        return al;
    }
    public void findById(int inc_id) throws ClassNotFoundException, SQLException{
        //int r=0;
        conn=ConnectionPool.connectDB();
        String sql="select * from incomes where inc_id='"+inc_id+"'";
        Statement stmt=conn.createStatement();
         ResultSet rs=stmt.executeQuery(sql);
        while(rs.next()){
            System.out.println(""+rs.getInt(1)+"\t\t\t"+rs.getString(2)+"\t\t\t"+rs.getInt(3)+"\t\t\t"+rs.getInt(4)+"\t\t\t"+rs.getDouble(5)+"\t\t\t"+rs.getString(6)+"\t\t\t"+rs.getString(7)+"\t\t\t"+rs.getString(8));
        }
        
    }
    public void delete(int inc_id) throws ClassNotFoundException, SQLException{
        conn=ConnectionPool.connectDB();
        String sql="delete from incomes where inc_id='"+inc_id+"'";
        Statement stmt=conn.createStatement();
        int r=stmt.executeUpdate(sql);
        if(r>0){
            System.out.println("Deleted Succes");
        }else{
            System.out.println("Deleting Failed");
        }
    }
    public void update(IncomeBean ib) throws ClassNotFoundException, SQLException{
        conn=ConnectionPool.connectDB();
        String sql="update Incomes set inc_ac ='"+ib.getInc_ac()+"',userid ='"+ib.getUserid()+"',inc_catid ='"+ib.getInc_catid()+"',amount = '"+ib.getAmount()+"',transation_date ='"+ib.getTransaction_date()+"',receiveBy ='"+ib.getReceiveBy()+"',remark ='"+ib.getRemark()+"' where inc_id='"+ib.getInc_id()+"'";
        Statement stmt=conn.createStatement();
        int r=stmt.executeUpdate(sql);
        if(r>0){
            System.out.println("Upate Succes");
        }else{
            System.out.println("Updating Failed");
        }
        
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        IncomeBean ib =new IncomeBean();
        //ib.setInc_id(1);
//        ib.setInc_ac("check");
//        ib.setUserid(8);
//        ib.setInc_catid(10);
//        ib.setAmount(2000.00);
//        ib.setTransaction_date("2022-11-20");
//        ib.setReceiveBy("Ankit");
//        ib.setRemark("Good");
        
        IncomeDAO id =new IncomeDAO();
       // id.add(ib);
     
       //find all
       //id.findAll();
         
    //findById
    //id.findById(1);
    
    //delete
    //id.delete(3);
    
    //upadte
    ib.setInc_id(4);
    ib.setInc_ac("checking");
        ib.setUserid(18);
        ib.setInc_catid(1);
        ib.setAmount(200000.00);
        ib.setTransaction_date("2023-11-20");
        ib.setReceiveBy("Ankit mandal");
        ib.setRemark("Very Good");
        
        id.update(ib);
        
    }
    
}
