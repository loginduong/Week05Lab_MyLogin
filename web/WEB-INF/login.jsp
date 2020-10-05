<%-- 
    Document   : login
    Created on : Oct 5, 2020, 10:05:39 AM
    Author     : 760483
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="login" method="post">
            <label>
                Username:<input type="text" name="username" value="${usernameInput}">
            </label><br/>
            <label>
                Password:<input type="password" name="password" value="${passwordInput}">
            </label><br/>
            <input type="submit" value="Log in">
        </form>
    <c:if test = "${invalid}">
        <span>
            Invalid username/password.
        </span>
    </c:if>
    <c:if test = "${logout}">
        <span>
            Successfully logged out.
        </span>
    </c:if>
    </body>
</html>
