<%-- 
    Document   : nav.jsp
    Created on : 31/08/2022, 1:55:12 pm
    Author     : Hugo
--%>

<%@page import="domain.Customer"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<html>
    <body>
        <a href="index.jsp">Home</a>
        <%
            Customer customer = (Customer) session.getAttribute("CURRENT-CUSTOMER");
            if (customer == null) { %>
        <a href="sign-in.jsp">Sign In</a>
        <% } else {%>
        <a href = "view-products.jsp"> Browse Products</a>
        <form id = "sign-out-form" action = "sign-out" method = "GET">
            <button type = "submit">Sign out</button>
        </form>
        <h2>Hi <%= customer.getUsername() %></h2>
        <% }%>
    </body>
</html>
