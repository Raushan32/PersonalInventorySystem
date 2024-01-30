/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personalinventory.controller;

import com.personaliventorysystem.bean.UsersBean;
import com.personaliventorysystem.dao.UsersDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author rkhjp
 */
public class viewuser extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet viewuser</title>");   
            out.println("<link rel='stylesheet' type='text/css' href='style.css'>");
            out.println("</head>");
               out.println("<body class='body'>");
//      
            HttpSession hs = request.getSession();

        String username = (String) hs.getAttribute("name");

        String password = (String) hs.getAttribute("pass");

        // this is for fetch userid and name
        
          
            
           
            out.println("<div id='box1'>");
            out.println("<div id='box2'>");
            out.println("<h1 class='personal'>Personal</h1>");
            out.println("<h1 class='inventory'><font color='white'>Inventory</font> System</h1>");
            out.println("</div>");
            out.println("<div id='box3'>");

            out.println("<table id='href'>");
            
            out.println("<tr>");
            out.println("<td><a href='#'>Home</a>&nbsp&nbsp");
                            out.println("<a href='#'>Profile </a>&nbsp&nbsp");
                            out.println("<a href='updateprofileForm'>Update Profile</a>&nbsp&nbsp");
                            out.println("<a href='login.html'>Logout</a>");
                        out.println("</td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("</div>");
            out.println("</div>");
            out.println("<div id='box4'>");
            out.println("<div id='box5'>");
            out.println("<table id='mast'>");
            out.println("<tr>");
//            out.println("<td>Master</td>");
                       
                    

//            out.println("<td>"+b.getName()+"</td>");
            out.println("</tr>");
            out.println("</table>");
            
            out.println("<table id='master'>");
            out.println("<tr>");
                        out.println("<td><a href='expensescategoryform'>Expenses Category</a></td>");
                    out.println("</tr>");
                    out.println("<tr>");
                        out.println("<td><a href='incomecategoryForm'>Income Category</a></td>");
                    out.println("</tr>");
                    out.println("<tr>");
                        out.println("<td><a href='AddExpensesForm'>Expenses </a></td>");
                    out.println("</tr>");
                    out.println("<tr>");
                        out.println("<td><a href='addIncomeForm'>Income</a></td>");
                    out.println("</tr>");
                    out.println("<tr>");
                        out.println("<td><a href='CashbookFrom'>Cash Book</a></td>");
                    out.println("</tr>");
                    out.println("<tr>");
                        out.println("<td><a href='BankBookForm'>Bank Book</a></td>");
                    out.println("</tr>");
                    out.println("<tr>");
                        out.println("<td><a href='DayBookForm'>Day Book</a></td>");
                    out.println("</tr>");
                    out.println("<tr>");
                        out.println("<td><a href='BalanceSheetForm'>Balance Sheet</a></td>");
                    out.println("</tr>");
            out.println("</table>");

            out.println("</div>");
            out.println("<div id='box6'>");
            out.println("<table id='BalanceSheet'>");
            out.println("<tr>");
            out.println("<td>User&nbsp<font color='Gray'> Profile</font>  </td>");
            out.println("</tr>");

            out.println("</table>");
            out.println("<table id='table1'>");

            
//            int id =(int)hs.getAttribute("id");
             UsersDAO ud = new UsersDAO();
            ArrayList<UsersBean> al = ud.viewUser(username, password);

                for(UsersBean b:al){
            
           
                out.println("<tr>");
                out.println("<td id ='text'>Name : </td>"); 
                out.println("<td id ='text'>"+b.getName()+"</td>"); 
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td id ='text'>Username : </td>");
                out.println("<td id ='text'>"+b.getUsername()+"</td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td id ='text'>Password : </td>");
                out.println("<td id ='text'>"+b.getPassword()+"</td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td id ='text'>Mobile : </td>");
                out.println("<td id ='text'>"+b.getMobile()+"</td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td id ='text'>Email : </td>");
                out.println("<td id ='text'>"+b.getEmail()+"</td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td id ='text'>Address: </td>");
                out.println("<td id ='text'>"+b.getAddress()+"</td>");
                out.println("</tr>");
           
                
                
                out.println("</table>");
                }
                
                UsersDAO q = new UsersDAO();
            ArrayList<UsersBean> a = q.view(username, password);

                for(UsersBean d:a){
                
//                q.view(username, password);
              
                int id =d.getUserid();
                String name =d.getName();
                HttpSession session =request.getSession();
                session.setAttribute("id", id);
                session.setAttribute("name", name);
                }
                
                
                

            out.println("</div>");
            out.println("</div>");
           
            out.println("<h1>Servlet viewuser at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(viewuser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(viewuser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(viewuser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(viewuser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
