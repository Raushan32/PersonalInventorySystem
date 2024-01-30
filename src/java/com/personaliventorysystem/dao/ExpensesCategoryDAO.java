/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personaliventorysystem.dao;

import com.personaliventorysystem.bean.ExpensesBean;
import com.personaliventorysystem.bean.ExpensesCategoryBean;
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
public class ExpensesCategoryDAO {
    Connection conn;
    public int addExpcatid(ExpensesCategoryBean eb) throws ClassNotFoundException, SQLException{
    int r=0;
    conn=ConnectionPool.connectDB();
    String sql="insert into expenses_category(exp_catid,exp_catname,exp_catdetails,userid)values('"+eb.getExp_catid()+"','"+eb.getExp_catname()+"','"+eb.getExp_catdetails()+"','"+eb.getUserid()+"')";
    Statement stmt=conn.createStatement();
    r=stmt.executeUpdate(sql);
    return r ;   
    }
    public int  deleteExpCategory(int Exp_catid ) throws ClassNotFoundException, SQLException{
    conn=ConnectionPool.connectDB();
    String sql="delete from expenses_category where exp_catid='"+Exp_catid+"'";
    Statement stmt=conn.createStatement();
    int r=stmt.executeUpdate(sql);
    if(r>0){
        System.out.println("Deleted Succes");
    }else{
        System.out.println("Deleted Failed");
    }
    return r;
    }
    public int UpdateExpCategory(ExpensesCategoryBean eb) throws SQLException, ClassNotFoundException{
        
        conn=ConnectionPool.connectDB();
        String sql="update Expenses_category set exp_catname='"+eb.getExp_catname()+"',exp_catdetails='"+eb.getExp_catdetails()+"',userid='"+eb.getUserid()+"' where exp_catid='"+eb.getExp_catid()+"'";
        Statement stmt=conn.createStatement();
        int r=stmt.executeUpdate(sql);
        if(r>0){
            System.out.println("Updated Succes");
        }else{
            System.out.println("Updated failed");
        }
        return r;
    }
    public ArrayList<ExpensesCategoryBean>  FindAll() throws SQLException, ClassNotFoundException{
        conn=ConnectionPool.connectDB();
        ArrayList<ExpensesCategoryBean> al =new ArrayList();
        
        String sql="select * from expenses_category";
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        while(rs.next()){
//            System.out.println(""+rs.getInt(1)+"\t\t\t"+rs.getString(2)+"\t\t\t"+rs.getString(3)+"\t\t\t"+rs.getInt(4));
        ExpensesCategoryBean eb =new ExpensesCategoryBean();
        eb.setExp_catname(rs.getString("exp_catname"));
        eb.setExp_catdetails(rs.getString("exp_catdetails"));
        al.add(eb);
        
        }
        return al;
    }
    public int FindId(int exp_catid) throws SQLException{
        int r=0;
        String sql="select * from expenses_category where exp_catid='"+exp_catid+"'";
        Statement stmt=conn.createStatement();
        ResultSet rs =stmt.executeQuery(sql);
        while(rs.next()){
             System.out.println(""+rs.getInt(1)+"\t\t\t"+rs.getString(2)+"\t\t\t"+rs.getString(3)+"\t\t\t"+rs.getInt(4));
        }
        return r;
    }
    //public ArrayList findAll(int userid)
    //and same in income dao
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ExpensesCategoryBean eb =new ExpensesCategoryBean();
        //add Expenses_Category
//        eb.setExp_catname("Raushan Kumar");
//        eb.setExp_catdetails("CSE");
//        eb.setUserid(10);
        ExpensesCategoryDAO ed =new ExpensesCategoryDAO();
//        ed.addExpcatid(eb);

//deleteExpCategory
//ed.deleteExpCategory(4);
  
//find all
//ed.FindAll();

//find byId

//update
        eb.setExp_catid(1);
        eb.setExp_catname("Raushan");
        eb.setExp_catdetails("CSE");
        eb.setUserid(10);
        ed.UpdateExpCategory(eb);

    }
}
