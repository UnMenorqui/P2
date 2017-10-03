<%-- 
    Document   : register
    Created on : 03-oct-2017, 11:24:49
    Author     : aleixabrieprat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="register" method="post">
            <div>
                <label for="name"> Name: </label>
                <input type="text" name="name" required/>                
            </div>
            
            <div>
                <label for="password"> Password: </label>
                <input type="password" name="password" required/>
            </div>
            
            <div>
                <label for="password"> Repeat Password: </label>
                <input type="password" name="password1" required/>
            </div>
           
            <div>
                <input type="submit" value="Submit">
            </div>
                
        </form>
    </body>
</html>
