<%-- 
    Document   : login
    Created on : 26-sep-2017, 16:14:46
    Author     : Toni
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="login" method="post">
            <div>
                <label for="name"> Name: </label>
                <input type="text" name="name" />                
            </div>
            
            <div>
                <label for="password"> Password </label>
                <input type="password" name="password"/>
            </div>
            
            <div>
                <input type="submit" value="Submit">
            </div>
                
        </form>
    </body>
</html>
