/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import dao.CustomerDAO;
import dao.DaoExceptionMapper;
import dao.DaoFactory;
import dao.JdbiDaoFactory;
import domain.Customer;
import java.io.IOException;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import net.sf.oval.exception.ConstraintsViolatedException;

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
        String username = request.getParameter("username");
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String password = request.getParameter("password");

        CustomerDAO dao = DaoFactory.getCustomerDAO();
        HttpSession session = request.getSession();
        if (dao.searchByUsername(username) != null) {
            session.setAttribute("validation", "Account with username already exists!");
            response.sendRedirect("create-account.jsp");
        } else {
            Customer customer = new Customer(username, firstName, lastName, address, email);
            session.setAttribute("validation", "");
            customer.setPassword(password);
            try {
                new Validator().assertValid(customer);
                dao.saveCustomer(customer);
            } catch (ConstraintsViolatedException cve) {
                // Server side checking if for some reason html form requirements fail
                ConstraintViolation[] violations = cve.getConstraintViolations();
                String msg = "Please fix the following input problems:";

                msg += "<ul>";
                for (ConstraintViolation cv : violations) {
                    msg += "<li>" + cv.getMessage() + "</li>";
                }
                msg += "</ul>";

                request.getSession().setAttribute("validation", msg);
                response.sendRedirect("create-account.jsp");
            } catch (Exception ex) {
                String msg = new DaoExceptionMapper().messageFromException(ex);
                request.getSession().setAttribute("validation", msg);
            } finally {
                response.sendRedirect("index.jsp");
            }
        }
    }
    
    

}
