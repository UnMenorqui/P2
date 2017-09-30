<%-- 
    Document   : menu
    Created on : 26-sep-2017, 16:14:51
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
        <h1>Bienvenido a tu puto menu.</h1>
        <h2> Bienvenido ${sessionScope.usuario}</h2>
        <div>
             <a href="login.jsp"> Alta Vuelo </a>
        </div>
        <div>
             <a href="login.jsp"> Alta Hotel </a>
        </div>
        <div>
             <a href="login.jsp"> Busca Vuelo </a>
        </div>
        <div>
             <a href="login.jsp"> Busca Hotel </a>
        </div>
        
        <div>
            <input type="submit" value="Log-out">
        </div>
    </body>
</html>
