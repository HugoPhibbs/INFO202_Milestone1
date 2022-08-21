/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import dao.CustomerDAO;
import dao.JdbiDaoFactory;
import domain.Customer;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet for creating an account
 * 
 * @author Hugo
 */
@WebServlet(name = "CreateAccountServlet", urlPatterns = {"/create-account"})
public class CreateAccountServlet extends HttpServlet {

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
        // TODO what is the difference between response and request?
        // TODO does request care if the inputs are inside divs?
        String userName = request.getParameter("username");
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String password = request.getParameter("password");
        
        // CustomerDAO dao = new CustomerCollectionsDAO();
        CustomerDAO dao = JdbiDaoFactory.getCustomerDAO();
        Customer customer = new Customer(userName, firstName, lastName, address, email);
        customer.setPassword(password);
        
        dao.saveCustomer(customer);
       
        response.sendRedirect("index.jsp");
    }
    
}
