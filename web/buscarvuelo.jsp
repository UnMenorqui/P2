<%@page import="java.util.ArrayList"%>
<%@page import="buscarvuelo.vuelo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Buscar Vuelo</title>
    </head>
    <body>
        <form action="buscarvuelo" method="post">
            <div>
                <label for="numerovuelo"> Numero de vuelo: </label>
                <input type="text" name="numero"/>                
            </div>
            
            <div>
                <label for="compañia"> Compañia: </label>
                <input type="text" name="compania"/>
            </div>
            
            <div>
                <label for="origen"> Origen: </label>
                <input type="text" name="origen"/>
            </div>
            
            <div>
                <label for="password"> Destino: </label>
                <input type="text" name="destino"/>
            </div>
            
            <div>
                <input type="submit" value="Search">
            </div>   
        </form>
        <% 
            try {
                ArrayList<vuelo> lista = (ArrayList)request.getAttribute("vuelos");
                vuelo vuelo = lista.get(0); //throws an exception if empty 
        %>
        <table width = 100%>
            <tr bgcolor="e7e7e7">
                <td><strong>Numero Vuelo</strong></td>
                <td><strong>Compañia</strong></td>
                <td><strong>Origen</strong></td>
                <td><strong>Hora Salida</strong></td>
                <td><strong>Destino</strong></td>
                <td><strong>Hora Llegada</strong></td>
         
            </tr> 
        <%
            for (int i=0; i<lista.size(); ++i) {
                %>
                <tr>
                    <td><%=lista.get(i).getIdvuelo()%></td>
                    <td><%=lista.get(i).getCompania()%></td>
                    <td><%=lista.get(i).getOrigen()%></td>
                    <td><%=lista.get(i).getHoraSalida()%></td>
                    <td><%=lista.get(i).getDestino()%></td>
                    <td><%=lista.get(i).getHoraLlegada()%></td> 
                </tr>
                <% ++i;          
            }    
            }catch(NullPointerException e){
                %><FONT>There are no current flights to display. </FONT><%

            } %>
        </table>
    </body>
</html>
