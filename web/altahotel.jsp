<%-- 
    Document   : altahotel
    Created on : 12-oct-2017, 14:02:44
    Author     : Toni
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta Hotel</title>
    </head>
    <body>
        <form action="altahotel" method="post">
            <div>
                <label for="id_hotel"> Identificador de hotel: </label>
                <input type="text" name="id_hotel" required/>                
            </div>
            
            <div>
                <label for="nombrehotel"> Nombre de hotel: </label>
                <input type="text" name="nombrehotel" required/>                
            </div>
            
            <div>
                <label for="cadenahotelera"> Cadena hotelera: </label>
                <input type="text" name="cadenahotelera" required/>
            </div>
            
            <div>
                <label for="calle"> Calle: </label>
                <input type="text" name="calle" required/>
            </div>
            
            <div>
                <label for="calle"> Numero: </label>
                <input type="text" name="numero" required/>
            </div>
            
            <div>
                <label for="codigopostal"> Codigo Postal: </label>
                <input type="text" name="codigopostal" required/>
            </div>
            
            <div>
                <label for="ciudad"> Ciudad: </label>
                <input type="text" name="ciudad" required/>
            </div>
            
            <div>
                <label for="provincia"> Provincia: </label>
                <input type="text" name="provincia" required/>
            </div>
            
            <div>
                <label for="pais"> Pais: </label>
                <input type="text" name="pais" required/>
            </div>
            
            <div>
                <label for="numerohabitaciones"> Numero de habitaciones: </label>
                <input type="text" name="numerohabitaciones" required/>
            </div>
            
            <div>
                <input type="submit" value="Submit">
            </div>
                
        </form>
    </body>
</html>
