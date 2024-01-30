/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personaliventorysystem.dao;

import com.personaliventorysystem.bean.UsersBean;
import com.personaliventorysystem.utility.ConnectionPool;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rkhjp
 */
public class UsersDAO {
     Connection conn=null;
    public int registerUSer(UsersBean ub) throws ClassNotFoundException, SQLException{
        int r=0;
    conn=ConnectionPool.connectDB();
        //step3
        String sql="insert into users(username,password,name,address,mobile,email)values('"+ub.getUsername()+"','"+ub.getPassword()+"','"+ub.getName()+"','"+ub.getAddress()+"','"+ub.getMobile()+"','"+ub.getEmail()+"')";
        try{
            Statement stmt=conn.createStatement();
            //step4 call executeUpdate method;
            r=stmt.executeUpdate(sql);
            //step 5 close the connection
            conn.close();
        }catch(SQLException ex){
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE,null,ex);  
        }
         if(r>0){
            System.out.println("Registration success");
        }else{
            System.out.println("Registration Failed");
        }
        return r;
    }
    public int loginCheck(String username,String password) throws ClassNotFoundException, SQLException{
        int id=0;
        conn=ConnectionPool.connectDB();
        String sql="select name,userid  from users where username ='"+username+"' and password ='"+password+"'";
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        if(rs.next()){
            String name=rs.getString("name");
            int userid=rs.getInt("userid");
            System.out.println(name);
            System.out.println(userid);
            System.out.println("Login Success");
        }
        return id;
    }
    public ArrayList<UsersBean> viewUser(String username,String password) throws ClassNotFoundException, SQLException{
        
        conn=ConnectionPool.connectDB();
        ArrayList<UsersBean> ub=new ArrayList();
        String sql="select name,username,password,mobile,email,address from users where username='"+username+"' and password='"+password+"'";
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        while(rs.next()){
            UsersBean b=new UsersBean ();
            b.setName(rs.getString("name"));
            b.setUsername(rs.getString("username"));
            b.setPassword(rs.getString("password"));
            b.setMobile(rs.getString("mobile"));
            b.setEmail(rs.getString("email"));
            b.setAddress(rs.getString("address"));
            ub.add(b);
//            System.out.println(""+rs.getString("name")+"\t\t\t"+rs.getString("username")+"\t\t\t"+rs.getString("password")+"\t\t\t"+rs.getString("mobile")+"\t\t\t"+rs.getString("email")+"\t\t\t"+rs.getString("address"));
        }
        return ub;
    }
    public ArrayList<UsersBean> view(String username,String password) throws ClassNotFoundException, SQLException{
        conn=ConnectionPool.connectDB();
         ArrayList<UsersBean> ub=new ArrayList();
        String sql="select name , userid from users where username='"+username+"' and password='"+password+"'";
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        while(rs.next()){
//            System.out.println(""+rs.getString("name")+"\t\t\t"+rs.getInt("userid"));
         UsersBean b=new UsersBean ();
            b.setName(rs.getString("name"));
            b.setUserid(rs.getInt("userid"));
            ub.add(b);
        }
        return ub;
    }
    public int updateUser(UsersBean ub) throws ClassNotFoundException, SQLException{
        conn=ConnectionPool.connectDB();
        int r=0;
        String sql="update Users set name='"+ub.getName()+"',username='"+ub.getUsername()+"' ,password='"+ub.getPassword()+"' ,address='"+ub.getAddress()+"' ,mobile='"+ub.getMobile()+"',email='"+ub.getEmail()+"' where userid='"+ub.getUserid()+"'";
        Statement stmt=conn.createStatement();
         r=stmt.executeUpdate(sql);
//        if(r>0){
//            System.out.println("User Updated Sucess");
//        }else{
//            System.out.println("User Updatation Failed");
//        }
        conn.close();
        return r;
    }
    public int deleteUser(int userid) throws ClassNotFoundException, SQLException{
        conn=ConnectionPool.connectDB();
       int q=0;
        String sql="delete from Users where userid='"+userid+"' ";
        Statement stmt=conn.createStatement();
        int r=stmt.executeUpdate(sql);
        if(r>0){
            System.out.println("Deleted Success");
        }else{
            System.out.println("Deleted Failed");
        }
        return q;
    }
    //public int checkAvailablity(String username)
    //public int checkAvailability(String username,String password)
    //public UsersBean authenticate(String username,String password)
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        UsersBean ub=new UsersBean();
//        ub.setUsername("R123");
//        ub.setPassword("123");
        UsersDAO ud =new UsersDAO();
//        ud.loginCheck("R123", "123");
        ud.view("R123", "123");
        
//        ub.setUserid(10);
//        ub.setAddress("mp");
//        ub.setEmail("ishan@");
//        ub.setMobile("123458");
//        ub.setName("ish");
//        ud.updateUser(ub);
//            ud.deleteUser(10);

//    ud.viewUser("R123", "123");
//    ub.getName();
//    ub.getPassword();
//    ub.getMobile();
//    ub.getUsername();
//    ub.getEmail();
//    ub.getAddress();
        
    }
}
