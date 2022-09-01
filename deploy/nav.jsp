<%-- 
    Document   : nav.jsp
    Created on : 31/08/2022, 1:55:12 pm
    Author     : Hugo
--%>

<%@page import="domain.Customer"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<html>
    <head>
        <link rel= "stylesheet" href = "./css/style.css" >  
    </head>
    <body>
        <div class="nav-div"> 

            <div class = "nav-links-div">
                <a href="index.jsp"><button>Home </button></a>
                <%
                    Customer customer = (Customer) session.getAttribute("CURRENT-CUSTOMER");
                    if (customer == null) { %>
                    <a href="sign-in.jsp"><button>Sign in</button></a>
                <% } else {%>
                <a href = "view-products.jsp"><button>View Products</button></a>
                <form id = "sign-out-form" action = "sign-out" method = "GET">
                    <button type = "submit">Sign out</button>
                </form>
                <% }%>
            </div>
                
            <% if (customer != null) { %>
            <h2>Hi <%= customer.getUsername() %></h2>
            <% }%>
        </div>
    </body>
</html> 
