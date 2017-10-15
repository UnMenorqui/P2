<%@page import="java.util.ArrayList"%>
<%@page import="buscarvuelo.vuelo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Flight</title>
        
        <link rel="stylesheet" href="css/style.css" type="text/css">
        <link rel="stylesheet" href="css/tabla.css" type="text/css">
        <link rel="stylesheet" href="css/menu.css" type="text/css">
        
    </head>
    <body>
        <form action="buscarvuelo" method="post">
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
                        <a href="altahotel.jsp">Register Hotel</a>
                        <a href="buscarhotel.jsp">Search Hotel</a>
                    </div> 
                </li>
                <li><a href="">Log Out</a></li>
            </ul>
            
            <div class="container">
                <div class="login-box">
                    <div class="box-header">
                        <h2>Search Flight</h2>
                    </div>
                    <label for="numerovuelo"> Flight number: </label>
                    <br/>
                    <input type="text" name="numero"/>
                    <br/>
                    <label for="compañia"> Company </label>
                    <br/>
                    <input type="text" name="compania"/>
                    <br/>
                    <label for="origen"> Origin </label>
                    <br/>
                    <input type="text" name="origen"/>
                    <br/>
                    <label for="destino"> Destination </label>
                    <br/>
                    <input type="text" name="destino"/>
                    <br/>
                    <button type="submit">Search Flight</button>
                    <br/>
                </div>    
        </form>
        <% 
            try {
                HttpSession sesion = request.getSession(false);
                ArrayList<vuelo> lista = (ArrayList)sesion.getAttribute("vuelos");
                vuelo vuelo = lista.get(0); //throws an exception if empty 
        %>
        <table id="customers">
            <tr>
                <th><strong>Flight Number</strong></th>
                <th><strong>Company</strong></th>
                <th><strong>Origin</strong></th>
                <th><strong>Departure Time</strong></th>
                <th><strong>Destination</strong></th>
                <th><strong>Arrival Time</strong></th>
         
            </tr> 
        <%for (int i=0; i<lista.size(); ++i) {%>
                <tr>
                    <td><%=lista.get(i).getIdvuelo()%></td>
                    <td><%=lista.get(i).getCompania()%></td>
                    <td><%=lista.get(i).getOrigen()%></td>
                    <td><%=lista.get(i).getHoraSalida()%></td>
                    <td><%=lista.get(i).getDestino()%></td>
                    <td><%=lista.get(i).getHoraLlegada()%></td> 
                </tr>
          <%}    
            }catch(NullPointerException e){} %>
        </table>
    </body>
</html>
