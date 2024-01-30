/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personaliventorysystem.dao;



import com.personaliventorysystem.bean.CashBookBean;
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
public class CashBookDAO {
      Connection conn;
    public int addid(CashBookBean bb) throws ClassNotFoundException, SQLException{
        int r=0;
        conn=ConnectionPool.connectDB();
        String sql="insert into cash_book(account,transation_date,amount,userid,operation)values('"+bb.getAccount()+"','"+bb.getTransaction_date()+"','"+bb.getAmount()+"','"+bb.getUserid()+"','"+bb.getOperation()+"')";
        Statement stmt=conn.createStatement();
        r=stmt.executeUpdate(sql);
        
        return r;
    }
    public ArrayList<CashBookBean> findAll() throws ClassNotFoundException, SQLException{
        conn=ConnectionPool.connectDB();
        ArrayList<CashBookBean> al =new ArrayList();
        String sql="select * from cash_book";
        Statement stmt=conn.createStatement();
        ResultSet rs =stmt.executeQuery(sql);
        while(rs.next()){
            //System.out.println(""+rs.getString(2)+"\t\t\t"+rs.getString(3)+"\t\t\t"+rs.getString(6)+"\t\t\t"+rs.getInt(1)+"\t\t\t"+rs.getInt(5)+"\t\t\t"+rs.getDouble(4));
            
            CashBookBean cb =new CashBookBean();
            cb.setAcid(rs.getInt("acid"));
            cb.setTransaction_date(rs.getString("transation_date"));
            cb.setAmount(rs.getDouble("amount"));
            cb.setOperation(rs.getString("operation"));
            al.add(cb);
        }
        return al;
    }
    public void findByID(int acid) throws ClassNotFoundException, SQLException{
        
        conn=ConnectionPool.connectDB();
        String sql="select * from cash_book where '"+acid+"'";
        Statement stmt=conn.createStatement();
        ResultSet rs= stmt.executeQuery(sql);
        while(rs.next()){
            System.out.println(""+rs.getInt(1)+"\t\t\t"+rs.getString(2)+"\t\t\t"+rs.getString(3)+"\t\t\t"+rs.getDouble(4)+"\t\t\t"+rs.getInt(5)+"\t\t\t"+rs.getString(6));
        }
    }
     public double  closingBalance(int userid) throws ClassNotFoundException, SQLException{
         conn=ConnectionPool.connectDB();
         double r =0;
         String sql="select(select sum(amount)as total_payment from cash_book where userid='"+userid+"' and operation='Receive')-(select sum(amount)as total_received from cash_book where userid='"+userid+"' and operation='pay')as closing_balance from dual";
         Statement stmt =conn.createStatement();
         ResultSet rs =stmt.executeQuery(sql);
//           int s=stmt.executeUpdate(sql);
           while(rs.next()){
               System.out.println(""+rs.getInt(sql));
           }
         return r;
     }
     public ArrayList<CashBookBean> findallDateWise(String sdate,String edate) throws ClassNotFoundException, SQLException{
     conn=ConnectionPool.connectDB();
     
        ArrayList<CashBookBean> al =new ArrayList(); 
        String sql="SELECT *FROM cash_book WHERE transation_date >='"+sdate+"' AND transation_date <= '"+edate+"' ";
      int r=0;
      Statement stmt=conn.createStatement();
      ResultSet rs=stmt.executeQuery(sql);
      while(rs.next()){
          CashBookBean cb =new CashBookBean();
//          bb.setUserid(rs.getInt("userid"));
          cb.setAcid(rs.getInt("acid"));
          cb.setAmount(rs.getDouble("amount"));
          cb.setTransaction_date(rs.getString("transation_date"));
          cb.setOperation(rs.getString("operation"));
          al.add(cb);
      }
      
      return al;
    }
    public void delete(int acid) throws ClassNotFoundException, SQLException{
        
        conn=ConnectionPool.connectDB();
        String sql="delete from cash_book where acid ='"+acid+"'";
        Statement stmt=conn.createStatement();
        int  r=stmt.executeUpdate(sql);
        if(r>0){
            System.out.println("Deleted Succes");
        }else{
            System.out.println("NOt Deleted");
        }
//        
   
    }
    public void Update(CashBookBean bb) throws ClassNotFoundException, SQLException{
        conn=ConnectionPool.connectDB();
         String sql="update cash_book set Account ='"+bb.getAccount()+"',transation_date='"+bb.getTransaction_date()+"',amount='"+bb.getAccount()+"',userid='"+bb.getUserid()+"',operation='"+bb.getOperation()+"' where acid='"+bb.getAcid()+"'";
    Statement stmt=conn.createStatement();
    int t=stmt.executeUpdate(sql);
    if(t>0){
        System.out.println("Updated sucess");
    }else{
        System.out.println("Updated failed");
    }
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        CashBookBean b =new CashBookBean();
//        b.setAcid(1);
//        b.setAccount("123456");
//        b.setAmount(25000);
//        b.setTransaction_date("2023-12-10");
//        b.setOperation("55");
//       b.setUserid(10);
//        
       CashBookDAO bd =new CashBookDAO();
//       int x=bd.addid(b);
//        if(x>0){
//         System.out.println("Data Insert Succesfully");
//     }else{
//         System.out.println("Data Not Insert ");
//     }
//    b.setAcid(1);
//        b.setAccount("123456");
//        b.setAmount(2500000);
//        b.setTransaction_date("null");
//        b.setOperation("null");
//        b.setUserid(5);
//        bd.Update(b);
//find all
//bd.findAll();

//update
//        b.setAcid(1);
//        b.setAccount("1234");
//        b.setAmount(25000);
//        b.setTransaction_date("2023-12-10");
//        b.setOperation("55");
//       b.setUserid(10);
//       bd.Update(b);
bd.closingBalance(3);
        

}}
