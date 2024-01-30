/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personalinventory.controller;

import com.personaliventorysystem.bean.ExpensesBean;
import com.personaliventorysystem.dao.ExpensesDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
public class AddExpenses extends HttpServlet {

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
            out.println("<title>Servlet AddExpenses</title>");            
            out.println("</head>");
            out.println("<body>");
            
            HttpSession session=request.getSession();
            
            int userid=(int) session.getAttribute("id");
            String name=(String)session.getAttribute("name");
            
            String cat=request.getParameter("cat");
            
//            if(cat=="Shopping"){
//             int exp_catid= 10;
//            }else if(cat=="Rent"){
//                int exp_catid= 20;
//            }else if(cat=="Rent"){
//               int exp_catid=30;
//            }else if(cat=="Other Expenses"){
//                int exp_catid=30;
//            }
//            int exp=exp_catid;
            String exp_ac=request.getParameter("ex");
//            String exp_catid=request.getParameter("cat");
  int exp_catid=Integer.parseInt(request.getParameter("cat"));
            double amount=Double.parseDouble(request.getParameter("am"));
            String transaction_date=request.getParameter("date");
            String payBy=request.getParameter("pay");
            String Remark=request.getParameter("remark");
//            int userid=Integer.parseInt(request.getParameter("userid"));
//            int exp_catid=
            ExpensesBean eb =new ExpensesBean();
            
            eb.setAmount(amount);
            eb.setExp_ac(exp_ac);
            eb.setExp_catid(exp_catid);
            eb.setTransaction_date(transaction_date);
            eb.setPayby(payBy);
            eb.setRemark(Remark);
            eb.setUserid(userid);
            
            ExpensesDAO ed =new ExpensesDAO();
            int r=ed.addExpenses(eb);
            if(r>0){
                 response.sendRedirect("AddExpensesForm");
            out.println("<h1><font color='green'>Expenses Added success</font></h1>");
            }else{
//                 response.sendRedirect("AddExpensesForm");
                out.println("<h1><font color='red'>Expenses Added Failed</font></h1>");
            }
            
            out.println("<h1>Servlet AddExpenses at " + request.getContextPath() + "</h1>");
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
            Logger.getLogger(AddExpenses.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddExpenses.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AddExpenses.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddExpenses.class.getName()).log(Level.SEVERE, null, ex);
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
