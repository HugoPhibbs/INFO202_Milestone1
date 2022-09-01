<%-- 
    Document   : create-account
    Created on : 16/08/2022, 4:46:54 pm
    Author     : Hugo
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <link href = "./css/style.css" rel="stylesheet">
        <title>Create Account</title>
    </head>
    <body>
        <header>
            <h1>Create an Account</h1>
        </header>

        <jsp:include page = "nav.jsp"></jsp:include>


            
        <%
            String validation = (String) session.getAttribute("validation");
            validation = validation != null ? validation : "";
        %>

        <form id = "create-account-form" action ="create-account" method = "POST">
            <h3>Account Details</h3>
            <div>
                <label for="username-input">Username:</label>
                <input name = "username" id="username-input" type="text" required = "required">
            </div>

            <div>
                <label for="firstname-input">First name:</label>
                <input name="firstName" id="firstname-input" type="text">
            </div>

            <div>
                <label for="lastname-input">Last name:</label>
                <input name="lastName" id="lastname-input" type="text">
            </div>

            <div>
                <label for="email-input">Email:</label>
                <input name="email" id="email-input" type="text">
            </div>

            <div>
                <label for="address-input">Address:</label>
                <input name = "address" id="address-input" type="text">
            </div>

            <div>
                <label for="password-input">Password:</label>
                <input name = "password" id="password-input" type="text" required = "required">
            </div>

            <button type = "submit" >Create account!</button>
        </form>

        <p class = "validation"><%=validation%></p>
    </body>
</html>
