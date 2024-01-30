/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personaliventorysystem.dao;

import com.personaliventorysystem.bean.BankBookBean;
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
public class BankBookDAO {

   
//select(select sum(amount)as total_payment from bank_book where userid=1 and operation='receive')
//-(select sum(amount)as total_received from bank_book where userid=1 and operation='pay')as closing_balance from dual;
//also add this in cashbook dao
    Connection conn;
    public int addid(BankBookBean bb) throws ClassNotFoundException, SQLException{
        int r=0;
        conn=ConnectionPool.connectDB();
        String sql="insert into bank_book(account,transaction_date,amount,userid,operation)values('"+bb.getAccount()+"','"+bb.getTransaction_date()+"','"+bb.getAmount()+"','"+bb.getUserid()+"','"+bb.getOperation()+"')";
        Statement stmt=conn.createStatement();
        r=stmt.executeUpdate(sql);
        
        return r;
    }
    public ArrayList<BankBookBean> findAll() throws ClassNotFoundException, SQLException{
        conn=ConnectionPool.connectDB();
        ArrayList<BankBookBean> al =new ArrayList();
        String sql="select * from bank_book";
        Statement stmt=conn.createStatement();
        ResultSet rs =stmt.executeQuery(sql);
        
        //for closing balance show in bank_book
//        BankBookDAO bd =new BankBookDAO();
//         bd.closingBalance(userid);
        
        while(rs.next()){
//            System.out.println(""+rs.getString(2)+"\t\t\t"+rs.getString(3)+"\t\t\t"+rs.getString(6)+"\t\t\t"+rs.getInt(1)+"\t\t\t"+rs.getInt(5)+"\t\t\t"+rs.getDouble(4));
            BankBookBean bb =new BankBookBean();
            bb.setAcid(rs.getInt("acid"));
            bb.setTransaction_date(rs.getString("transaction_date"));
            bb.setAmount(rs.getDouble("amount"));
            bb.setOperation(rs.getString("operation"));
//            bb.setUserid(rs.getInt("userid"));
           
            al.add(bb);
            
        }
        return al;
    }
    public void findByID(int acid) throws ClassNotFoundException, SQLException{
        
        conn=ConnectionPool.connectDB();
        String sql="select * from bank_book where '"+acid+"'";
        Statement stmt=conn.createStatement();
        ResultSet rs= stmt.executeQuery(sql);
        while(rs.next()){
            System.out.println(""+rs.getInt(1)+"\t\t\t"+rs.getString(2)+"\t\t\t"+rs.getString(3)+"\t\t\t"+rs.getDouble(4)+"\t\t\t"+rs.getInt(5)+"\t\t\t"+rs.getString(6));
        }
    }
//      public ArrayList<BankBookBean> findallDateWise(String sdate,String edate,int userId) 
    public ArrayList<BankBookBean> findallDateWise(String sdate,String edate) throws ClassNotFoundException, SQLException{
     conn=ConnectionPool.connectDB();
     
        ArrayList<BankBookBean> al =new ArrayList(); 
        String sql="SELECT *FROM bank_book WHERE transaction_date >='"+sdate+"' AND transaction_date <= '"+edate+"' ";
      int r=0;
      Statement stmt=conn.createStatement();
      ResultSet rs=stmt.executeQuery(sql);
      while(rs.next()){
          BankBookBean bb =new BankBookBean();
//          bb.setUserid(rs.getInt("userid"));
          bb.setAcid(rs.getInt("acid"));
          bb.setAmount(rs.getDouble("amount"));
          bb.setTransaction_date(rs.getString("transaction_date"));
          bb.setOperation(rs.getString("operation"));
          al.add(bb);
      }
      
      return al;
    }
     public double  closingBalance(int userid) throws ClassNotFoundException, SQLException{
         conn=ConnectionPool.connectDB();
         double r =0;
         String sql="select(select sum(amount)as total_payment from bank_book where userid='"+userid+"' and operation='Receive')-(select sum(amount)as total_received from bank_book where userid='"+userid+"' and operation='pay')as closing_balance from dual";
         Statement stmt =conn.createStatement();
         ResultSet rs =stmt.executeQuery(sql);
//           int s=stmt.executeUpdate(sql);
           while(rs.next()){
               System.out.println(""+rs.getInt(sql));
           }
         return r;
     }
    
    public void delete(int acid) throws ClassNotFoundException, SQLException{
        
        conn=ConnectionPool.connectDB();
        String sql="delete from bank_book where acid ='"+acid+"'";
        Statement stmt=conn.createStatement();
        int  r=stmt.executeUpdate(sql);
        if(r>0){
            System.out.println("Deleted Succes");
        }else{
            System.out.println("NOt Deleted");
        }
//        
   
    }
    public void Update(BankBookBean bb) throws ClassNotFoundException, SQLException{
        conn=ConnectionPool.connectDB();
          String sql="update bank_book set Account ='"+bb.getAccount()+"',transaction_date='"+bb.getTransaction_date()+"',amount='"+bb.getAccount()+"',userid='"+bb.getUserid()+"',operation='"+bb.getOperation()+"' where acid='"+bb.getAcid()+"'";
    Statement stmt =conn.createStatement();
    int r=stmt.executeUpdate(sql);
    if(r>0){
        System.out.println("Updated Succes");
    }else{
        System.out.println("Upated Failed");
    }
    
    
    
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        BankBookBean b =new BankBookBean();
//        b.setAcid(1);
//        b.setAccount("123456");
//        b.setAmount(25000);
//        b.setTransaction_date("2023-12-10");
//        b.setOperation("pay");
//       b.setUserid(3);
//        
        BankBookDAO bd =new BankBookDAO();
//       int x=bd.addid(b);
//        if(x>0){
//         System.out.println("Data Insert Succesfully");
//     }else{
//         System.out.println("Data Not Insert ");
//     }

//find all
   // BankBookDAO bd =new BankBookDAO();
//    bd.findAll();

//finbyid
//bd.findByID(1);

//deleteid
//bd.delete(1);

//update
// b.setAcid(1);
//        b.setAccount("123456");
//        b.setAmount(2500);
//        b.setTransaction_date("2023-12-10");
//        b.setOperation("null");
//       b.setUserid(10);
//       bd.Update(b);

//bd.findallDateWise("2016-12-14", "2023-12-10");

//closing balance

bd.closingBalance(3);
    }
}
