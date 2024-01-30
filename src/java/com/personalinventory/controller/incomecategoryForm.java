/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personalinventory.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author rkhjp
 */
public class incomecategoryForm extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet incomecategoryForm</title>");    
            out.println("<link rel='stylesheet' type='text/css' href='IncomeCategory.css'>");
            out.println("</head>");
           
            out.println("<body class='body'>");
            out.println("<form action='incomecategory'> ");
             HttpSession session=request.getSession();
            
            int userid=(int) session.getAttribute("id");
            String name=(String)session.getAttribute("name");
            
           
            out.println("<div id='box1'>");
                out.println("<div id='box2'>");
                    out.println("<h1 class='personal'>Personal</h1>");
                    out.println("<h1 class='inventory'><font color='white'>Inventory</font> System</h1>");
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
                        out.println("<td>"+name+"</td>");
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
                            out.println("<td>Income &nbsp<font color='Gray'>Category</font>  </td>");
                        out.println("</tr>");
                    out.println("</table>");
                    out.println("<table id='table1'>");
                        out.println("<tr>");
                            out.println("<td id='text'>");
                                out.println("Category Name :");
                            out.println("</td>");
                            out.println("<td>");
                                out.println("<input type='text' name='cn'>");
                            out.println("</td>");
                        out.println("</tr>");
                        out.println("<tr>");
                            out.println("<td id='text'>");
                                out.println("Category Details :");
                            out.println("</td>");
                            out.println("<td>");
                                out.println("<input type='text' name='cd'>");
                            out.println("</td>");
                        out.println("</tr>");

                        out.println("<tr>");
                            out.println("<td><button>Add</button>&nbsp&nbsp&nbsp&nbsp<button>Cancle</button></td>");
                        out.println("</tr>");
                    out.println("</table>");
                    out.println("<br>");

                out.println("</div>");
            out.println("</div>");
        out.println("</form>");
//            out.println("<h1>Servlet incomecategoryForm at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        processRequest(request, response);
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
