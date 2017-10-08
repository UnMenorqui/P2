package buscarvuelo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/buscarvuelo"})

public class buscarvuelo extends HttpServlet { 
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
          connection = DriverManager.getConnection("jdbc:sqlite:/Users/aleixabrieprat/Documents/FIB/7e quadrimestre/ad/lab/practica 2/p2.db"); //Mac Aleix
          Statement statement = connection.createStatement();
          statement.setQueryTimeout(30);  // set timeout to 30 sec.
          
          
          String numerovuelo = request.getParameter("numero");
          String compania = request.getParameter("compañia");
          String origen = request.getParameter("origen");
          String destino = request.getParameter("destino");
          
          System.out.println("numero de vuelo="+numerovuelo);
          System.out.println("companyia="+compania);
          System.out.println("origen="+origen);
          System.out.println("destino="+destino);
          
          
          /*
          ResultSet rs; 
          if (numerovuelo.equals("null")) {
              if (compania.equals("null")) {
                  if (origen.equals("null")) {
                      if (destino.equals("null")) {
                         rs = statement.executeQuery("Select * from vuelos");
                      }
                      else {rs = statement.executeQuery("Select * from vuelos where destino='"+destino+"'");} 
                  }
                  else {
                      if (destino.equals("null")) {rs = statement.executeQuery("Select * from vuelos where origen='"+origen+"'");}
                      else {rs = statement.executeQuery("Select * from vuelos where destino='"+destino+"' and origen='"+origen+"'");}
                  }
              }
              else {
                  if (origen.equals("null")) {
                      if (destino.equals("null")) {rs = statement.executeQuery("Select * from vuelos where companyia='"+compania+"'"); }
                      else {rs = statement.executeQuery("Select * from vuelos where companyia='"+compania+"' and destino='"+destino+"'");}
                  }
                  else {
                      if (destino.equals("null")) {rs = statement.executeQuery("Select * from vuelos where companyia='"+compania+"' and origen='"+origen+"'");}
                      else {rs = statement.executeQuery("Select * from vuelos where companyia='"+compania+"' and destino='"+destino+"' and origen='"+origen+"'");}
                  }
              }
          }
          else {
              if (compania.equals("null")) {
                  if (origen.equals("null")) {
                      if (destino.equals("null")) {rs = statement.executeQuery("Select * from vuelos where id_vuelo='"+numerovuelo+"'");}
                      else {rs = statement.executeQuery("Select * from vuelos where id_vuelo='"+numerovuelo+" and destino='"+destino+"'");} 
                  }
                  else {
                      if (destino.equals("null")) {rs = statement.executeQuery("Select * from vuelos where id_vuelo='"+numerovuelo+" and origen='"+origen+"'");}
                      else {rs = statement.executeQuery("Select * from vuelos where id_vuelo='"+numerovuelo+" and destino='"+destino+"' and origen='"+origen+"'");}
                  }
              }
              else {
                  if (origen.equals("null")) {
                      if (destino.equals("null")) {rs = statement.executeQuery("Select * from vuelos id_vuelo='"+numerovuelo+" and where companyia='"+compania+"'"); }
                      else {rs = statement.executeQuery("Select * from vuelos id_vuelo='"+numerovuelo+" and where companyia='"+compania+"' and destino='"+destino+"'");}
                  }
                  else {
                      if (destino.equals("null")) {rs = statement.executeQuery("Select * from vuelos where id_vuelo='"+numerovuelo+" and companyia='"+compania+"' and origen='"+origen+"'");}
                      else {rs = statement.executeQuery("Select * from vuelos where id_vuelo='"+numerovuelo+" and companyia='"+compania+"' and destino='"+destino+"' and origen='"+origen+"'");}
                  }
              }
              
          }
          if (!rs.next()) {
              String mensaje = "There is no flight with these characteristics.";
              response.sendRedirect("error.jsp?error=" + mensaje);
          } else {
              
          }
          */
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
