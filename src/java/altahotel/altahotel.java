package altahotel;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns = {"/altahotel"})

public class altahotel extends HttpServlet { 
    
    private HttpSession sesion;
   /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequestPOST(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //PrintWriter out = response.getWriter();
                       
        Connection connection = null;
        try                        
        {            
          // load the sqlite-JDBC driver using the current class loader
          Class.forName("org.sqlite.JDBC");   
              
          
          // create a database connection
          //connection = DriverManager.getConnection("jdbc:sqlite:F:\\AD\\Pràctica 2\\BD\\exemple.db");
          //connection = DriverManager.getConnection("jdbc:sqlite:/Users/aleixabrieprat/Documents/FIB/7e quadrimestre/ad/lab/practica 2/p2.db"); //Mac Aleix
          connection = DriverManager.getConnection("jdbc:sqlite:/Users/Toni/Documents/Universitat/AD/LAB/P2/p2.db");
          Statement statement = connection.createStatement();
          statement.setQueryTimeout(30);  // set timeout to 30 sec.
          
          String id_hotel = request.getParameter("id_hotel");
          String nombrehotel = request.getParameter("nombrehotel");
          String cadenahotelera = request.getParameter("cadenahotelera");
          String calle = request.getParameter("calle");
          String numero = request.getParameter("numero");
          String codigopostal = request.getParameter("codigopostal");
          String ciudad = request.getParameter("ciudad");
          String provincia = request.getParameter("provincia");
          String pais = request.getParameter("pais");
          String num_habitaciones = request.getParameter("numerohabitaciones");
          
          
          /** Comparar Horas llegada/salida
          
          LocalTime llegada = LocalTime.parse(horallegada);
          LocalTime salida = LocalTime.parse(horasalida);
          
          if (salida.compareTo(llegada) > 0) {
              response.sendRedirect("error.jsp");
          }
          **/
          
          ResultSet rs = statement.executeQuery("select * from hoteles where id_hotel ='"+id_hotel+"'");
          
          if (rs.next()) {
              sesion = request.getSession(false);
              sesion.setAttribute("error", "5");
              response.sendRedirect("error.jsp");
          } else {
              statement.executeUpdate("insert into hoteles values('"+id_hotel+"','"+nombrehotel+"','"+calle+"','"+numero+"','"+codigopostal+"','"+ciudad+"','"+provincia+"','"+pais+"')");
              response.sendRedirect("menu.jsp");
          }
        } 
        catch(SQLException | ClassNotFoundException e)
        {
          System.err.println(e.getMessage());
        }   
        finally
        {
          try
          {
            if(connection != null)
              connection.close();
          }
          catch(SQLException e)
          {
            // connection close failed.
            System.err.println(e.getMessage());
          }
        }       
    } 
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequestPOST(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequestPOST(request, response);
    }

}
