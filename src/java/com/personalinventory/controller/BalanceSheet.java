/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personalinventory.controller;

import com.personaliventorysystem.bean.ExpensesBean;
import com.personaliventorysystem.bean.IncomeBean;
import com.personaliventorysystem.dao.ExpensesDAO;
import com.personaliventorysystem.dao.IncomeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author rkhjp
 */
public class BalanceSheet extends HttpServlet {

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
            out.println("<title>Servlet BalanceSheet</title>");

            out.println("<link rel='stylesheet' type='text/css' href='style.css'>");

            out.println("</head>");
            out.println("<body class='body'>");
            
            HttpSession session=request.getSession();
            
            int userid=(int) session.getAttribute("id");
            String name=(String)session.getAttribute("name");
            
            
             String sdate=request.getParameter("sdate");
            String edate=request.getParameter("edate");
            
            out.println("<div id='box1'>");
            out.println("<div id='box2'>");
            out.println("<h1 class='personal'>Personal</h1>");
            out.println("<h1 class='inventory'>Inventory System</h1>");
            out.println("</div>");
            out.println("<div id='box3'>");

            out.println("<table id='href'>");
            
            out.println("<tr>");
           out.println("<td><a href='#'>Home</a>&nbsp&nbsp");
                            out.println("<a href='viewuser'>Profile </a>&nbsp&nbsp");
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
            out.println("<td>Master</td>");
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
                        out.println("<td><a href='BalanceSheetForm'>Bank Book</a></td>");
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
            out.println("<td>Balance<font color='Gray'>Sheet</font>  </td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("<table>");
            out.println("<tr id='date'><td>DateFrom &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp TO</td>");
            out.println("</table>");
            out.println("<table>");
            out.println("<tr><td><input type='text' name='sdate'>&nbsp&nbsp<input type='text' name='edate'> <button>Show</button></tr>");
            out.println("</table>");
            out.println("<div id='display'>");
           
             IncomeDAO id =new IncomeDAO();
              ArrayList<IncomeBean> al =id.findAll();
              
            out.println("<table id='sheet' >");
            out.println("<tr id='menu'>");
            out.println("<td>Incomes</td><td>Amount</td>");
            out.println("</tr>");
         
            
            
            for(IncomeBean cb : al){
                out.println("<tr id='text'>");
                out.println("<td>"+cb.getInc_ac()+"</td>");
                out.println("<td>"+cb.getAmount()+"</td>");
                out.println("</tr>");
            }
                //Total Amount
               out.println("<tr id='menu'><td>Total</td><td></td></tr>");
            
               out.println("</table>");
            
            out.println("<table id='sheet1'>");
            out.println("<tr id='menu'>");
            out.println("<td> Expenses</td><td>Amount</td>");
            out.println("</tr>");
    
            
            ExpensesDAO ed=new ExpensesDAO();
               ArrayList<ExpensesBean> a =ed.findAll();
            
               
               for(ExpensesBean eb :a){
                   
                 out.println("<tr id='text'>"); 
                out.println("<td>"+eb.getExp_ac()+"</td>");
                out.println("<td>"+eb.getAmount()+"</td>");
                out.println("</tr>");
               }
                    //Total Amount
                       out.println("<tr id='menu'><td>Total</td><td></td></tr>");
           
                       out.println("</table>");
          
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");

            out.println("<h1>Servlet BalanceSheet at " + request.getContextPath() + "</h1>");
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
            Logger.getLogger(BalanceSheet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BalanceSheet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(BalanceSheet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BalanceSheet.class.getName()).log(Level.SEVERE, null, ex);
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
