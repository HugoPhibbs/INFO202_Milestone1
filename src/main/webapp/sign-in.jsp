<%-- 
    Document   : sign-in
    Created on : 16/08/2022, 4:48:15 pm
    Author     : Hugo
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>
        <header>
            <h1>Sign in</h1>
        </header>


        <div>
            <h3>Account Details</h3>
            <form id="create-account-form">
                <div>
                    <label for="username-input">Username:</label>
                    <input id="username-input" type="text">
                </div>

                <div>
                    <label for="password-input">Password:</label>
                    <input id="password-input" type="text">
                </div>

                <button>Sign In!</button>
            </form>

            <div>
                <p>
                    If you don't have an account you can <a href="create-account.jsp">create one!</a>
                </p>
            </div>
        </div>
    </body>
</html>
