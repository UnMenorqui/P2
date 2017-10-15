<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu</title>
        
        <link rel="stylesheet" type="text/css" href="css/menu.css" />
    </head>
    <body>
        <ul>
            <li><a href="menu.jsp">Home</a></li>
            <li class="dropdown">
                <a href="#">Flights</a>
                <div class="dropdown-content">
                    <a href="altavuelo.jsp">Register Flight</a>
                    <a href="buscarvuelo.jsp">Search Flight</a>
                </div> 
            </li>
            
           <li class="dropdown">
                <a href="#">Hotels</a>
                <div class="dropdown-content">
                    <a href="altavuelo.jsp">Register Hotel</a>
                    <a href="buscarvuelo.jsp">Search Hotel</a>
                </div> 
            </li>
            <li><a href="">Log Out</a></li>
        </ul>
    </body>
</html>
