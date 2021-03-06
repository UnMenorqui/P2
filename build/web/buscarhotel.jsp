<%@page import="java.util.ArrayList"%>
<%@page import="buscarhotel.hotel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Hotel</title>
        
        <link rel="stylesheet" href="css/style.css" type="text/css">
        <link rel="stylesheet" href="css/tabla.css" type="text/css">
        <link rel="stylesheet" href="css/menu.css" type="text/css">
        
    </head>
    <body>
        <form action="buscarhotel" method="post">
            <ul>
                <li><a href="menu.jsp">Home</a></li>
                <li class="dropdown">
                    <a href="#">Hotels</a>
                    <div class="dropdown-content">
                        <a href="altavuelo.jsp">Register Flight</a>
                        <a href="buscarvuelo.jsp">Search Flight</a>
                    </div> 
                </li>
            
                <li class="dropdown">
                    <a href="#">Hotels</a>
                    <div class="dropdown-content">
                        <a href="altahotel.jsp">Register Hotel</a>
                        <a href="buscarhotel.jsp">Search Hotel</a>
                    </div> 
                </li>
                <li><a href="">Log Out</a></li>
            </ul>
            
            <div class="container">
                <div class="login-box">
                    <div class="box-header">
                        <h2>Search Hotel</h2>
                    </div>
                    <label for="nombrehotel"> Hotel name </label>
                    <br/>
                    <input type="text" name="nombrehotel"/>
                    <br/>
                    <label for="cadenahotelera"> Hotels Chain </label>
                    <br/>
                    <input type="text" name="cadenahotelera"/>
                    <br/>
                    <label for="ciudad"> Hotel City </label>
                    <br/>
                    <input type="text" name="ciudad"/>
                    <br/>
                    <button type="submit">Search Hotel</button>
                    <br/>
                </div>    
        </form>
        <% 
            try {
                HttpSession sesion = request.getSession(false);
                ArrayList<hotel> lista = (ArrayList)sesion.getAttribute("hoteles");
                hotel hotel = lista.get(0); //throws an exception if empty 
        %>
        <table id="customers">
            <tr>
                <th><strong>Hotel ID</strong></th>
                <th><strong>Hotel Name</strong></th>
                <th><strong>Hotel Chain</strong></th>
                <th><strong>Nº Rooms</strong></th>
                <th><strong>Street</strong></th>
                <th><strong>Number</strong></th>
                <th><strong>Postal Code</strong></th>
                <th><strong>City</strong></th>
                <th><strong>Province</strong></th>
                <th><strong>Country</strong></th>
         
            </tr> 
        <%for (int i=0; i<lista.size(); ++i) {%>
                <tr>
                    <td><%=lista.get(i).getIdhotel()%></td>
                    <td><%=lista.get(i).getNombrehotel()%></td>
                    <td><%=lista.get(i).getCadenaHotelera()%></td>
                    <td><%=lista.get(i).getNum_Habitaciones()%></td>
                    <td><%=lista.get(i).getCalle()%></td>
                    <td><%=lista.get(i).getNumero()%></td>
                    <td><%=lista.get(i).getCodigoPostal()%></td>
                    <td><%=lista.get(i).getCiudad()%></td>
                    <td><%=lista.get(i).getProvincia()%></td>
                    <td><%=lista.get(i).getPais()%></td>
                    
                </tr>
          <%}    
            }catch(NullPointerException e){} %>
        </table>
    </body>
</html>
