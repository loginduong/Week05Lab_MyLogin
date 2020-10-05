<%-- 
    Document   : home
    Created on : Oct 5, 2020, 10:06:27 AM
    Author     : 760483
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h1>Home Page</h1>
        <p>
            Hello ${user["username"]}.
        </p>
        <a href="login?logout">Log out</a>
    </body>
</html>
