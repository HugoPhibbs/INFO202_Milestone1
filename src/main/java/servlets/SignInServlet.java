/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import dao.CustomerDAO;
import dao.DaoFactory;
import domain.Customer;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hugo
 */
@WebServlet(name = "SignInServlet", urlPatterns = {"/sign-in"})
public class SignInServlet extends HttpServlet {

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
        String username = request.getParameter("username-input");
        String password = request.getParameter("password-input");
        
        CustomerDAO dao = DaoFactory.getCustomerDAO();
        if (dao.matchCustomer(username, password)) {
            Customer customer = dao.searchByUsername(username);
            HttpSession session = request.getSession();
            session.setAttribute("CURRENT-CUSTOMER", customer);
        } 
        response.sendRedirect("index.jsp");
    }

}
