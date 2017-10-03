package register;

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


@WebServlet(urlPatterns = {"/register"})

public class register extends HttpServlet{
    
    
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
        HttpSession sesion = request.getSession();
        response.setContentType("text/html;charset=UTF-8");
        //PrintWriter out = response.getWriter();
                       
        Connection connection = null;
        try                        
        {            
          // load the sqlite-JDBC driver using the current class loader
          Class.forName("org.sqlite.JDBC");   
          //java.util.Date d = new java.util.Date();
          //out.println("La fecha actual es " + d);             
          
          // create a database connection
          //connection = DriverManager.getConnection("jdbc:sqlite:F:\\AD\\Pràctica 2\\BD\\exemple.db");
          connection = DriverManager.getConnection("jdbc:sqlite:/Users/aleixabrieprat/Documents/FIB/7e quadrimestre/ad/lab/practica 2/p2.db"); //Mac Aleix
          Statement statement = connection.createStatement();
          statement.setQueryTimeout(30);  // set timeout to 30 sec.
                    
          statement.executeUpdate("create table if not exists usuarios (id_usuario string primary key, password string)");
          statement.executeUpdate("create table if not exists vuelos (id_vuelo integer primary key, companyia string, origen string, hora_salida string, destino string, hora_llegada string)");
          statement.executeUpdate("create table if not exists hoteles (id_hotel integer primary key, nom_hotel string, cadena string,numb_hab integer,calle string, numero integer,codigo_postal string,ciudad string,provincia string,pais string)");
          
          String username = request.getParameter("name");
          String password = request.getParameter("password");
          String passwd = request.getParameter("password1");
          
          if (password.equals(passwd)) {
             ResultSet rs = statement.executeQuery("select * from usuarios where id_usuario ='"+username+"'");
             
             if (!rs.next() && sesion.getAttribute("usuario") == null) {
                 statement.executeUpdate("insert into usuarios values('"+username+"','"+password+"')");
                 response.sendRedirect("login.jsp");
             }
             else {
                 response.sendRedirect("error.jsp");
             }
          }
          else {
              response.sendRedirect("error.jsp");
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
