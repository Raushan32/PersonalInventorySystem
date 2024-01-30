package com.personaliventorysystem.dao;

import com.personaliventorysystem.bean.IncomeCategoryBean;
import com.personaliventorysystem.utility.ConnectionPool;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rkhjp
 */
public class IncomeCategoryDAO {
    Connection conn;
    public int add(IncomeCategoryBean ib) throws ClassNotFoundException, SQLException{
        int r=0;
        conn=ConnectionPool.connectDB();
        String sql="insert into income_category(inc_catname,inc_catdetails,userid)values('"+ib.getInc_catname()+"','"+ib.getInc_catdetails()+"','"+ib.getUserid()+"')";
        Statement stmt=conn.createStatement();
         r=stmt.executeUpdate(sql);
        if(r>0){
            System.out.println("Inserted Success");
        }else{
            System.out.println("Insterting Failed");
        }
        return r;
    }
    public int findId(int inc_catid) throws ClassNotFoundException, SQLException{
        int r=0;
        conn=ConnectionPool.connectDB();
        String sql="select * from income_category where inc_catid='"+inc_catid+"'";
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        while(rs.next()){
            System.out.println(""+rs.getInt(1)+"\t\t\t"+rs.getString(2)+"\t\t\t"+rs.getString(3)+"\t\t\t"+rs.getInt(4));
        }
        return r;
    }
    public ArrayList<IncomeCategoryBean> findAll() throws ClassNotFoundException, SQLException{
        conn=ConnectionPool.connectDB();
        
        String sql="select * from income_category";
        ArrayList<IncomeCategoryBean> al =new ArrayList();
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        while(rs.next()){
            //System.out.println(""+rs.getInt(1)+"\t\t\t"+rs.getString(2)+"\t\t\t"+rs.getString(3)+"\t\t\t"+rs.getInt(4)); 
        IncomeCategoryBean ib =new IncomeCategoryBean();
        ib.setInc_catdetails(rs.getString("cn"));
        ib.setInc_catname(rs.getString("cn"));
        al.add(ib);
        }
        return al;
    }
    public int delete(int inc_catid) throws ClassNotFoundException, SQLException{
        int r=0;
        conn=ConnectionPool.connectDB();
        String sql="delete from income_category where inc_catid='"+inc_catid+"'";
        Statement stmt=conn.createStatement();
        r=stmt.executeUpdate(sql);
        if(r>0){
            System.out.println("Deleted Succes");
        }else{
            System.out.println("Deleted Failed");
        }
        return r;
    }
    public void update(IncomeCategoryBean ib) throws ClassNotFoundException, SQLException{
        conn=ConnectionPool.connectDB();
        String sql="update income_category set inc_catname='"+ib.getInc_catname()+"',inc_catdetails='"+ib.getInc_catdetails()+"',userid='"+ib.getUserid()+"' where inc_catid='"+ib.getInc_catid()+"'";
        Statement stmt=conn.createStatement();
        int r=stmt.executeUpdate(sql);
        if(r>0){
            System.out.println("Updated Success");
        }else{
            System.out.println("Updating Failed");
        }
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        IncomeCategoryBean ib =new IncomeCategoryBean();
       // ib.setInc_catname("Ankit");
       // ib.setInc_catdetails("salesman");
       // ib.setUserid(10);
        IncomeCategoryDAO id =new IncomeCategoryDAO();
       // id.add(ib);
   
 //findbyid
 //id.findId(1);
 
 //findAll
 //id.findAll();
 
 //delete
 //id.delete(3);
 
 //update
 
 ib.setInc_catid(4);
 ib.setInc_catname("Ankit");
 ib.setInc_catdetails("sales");
 ib.setUserid(5);
 
 id.update(ib);
    }
}
