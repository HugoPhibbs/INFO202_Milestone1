<%@page import="domain.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <header>
            <h1>Welcome to the Ski Master Store!</h1>
        </header>
        <a href="index.jsp">Home</a>
        <%
            Customer customer = (Customer) session.getAttribute("CURRENT-CUSTOMER");
            System.out.println(customer);
            if (customer == null) { %>
        <a href="sign-in.jsp">Sign In</a>
        <% } else {%>
        <a href = "view-products.jsp"> Browse Products</a>
        <form id = "sign-out-form" name = "sign-out" method = "POST">
            <button type = "submit">Sign out</button>
        </form>
        <% }%>

    </body>
</html>
