package buscarhotel;


import buscarhotel.hotel;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns = {"/buscarvuelo"})

public class buscarhotel extends HttpServlet { 
    
    
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
            throws ServletException, IOException, SQLException, ClassNotFoundException {
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
          //connection = DriverManager.getConnection("jdbc:sqlite:/Users/Toni/Documents/Universitat/AD/LAB/P2/p2.db"); //Mac Toni
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
          
          ResultSet rs; 
          if (id_hotel.equals("")) {
              if (nombrehotel.equals("")) {
                  if (cadenahotelera.equals("")) {
                      if (calle.equals("")) {
                          if (numero.equals("")) {
                              if (codigopostal.equals("")) {
                                  if (ciudad.equals("")) {
                                      if (provincia.equals("")) {
                                          if (pais.equals("")) {
                                              if (num_habitaciones.equals("")) {
                                                  rs = statement.executeQuery("Select * from hoteles"); //Buscar todo (parametros todos vacíos)
                                              }
                                              else {
                                                  rs = statement.executeQuery("Select * from vuelos where numb_hab='"+num_habitaciones+"'"); //Buscar solo por destino
                                              }
                                          }
                                          else {
                                              if (num_habitaciones.equals("")) {
                                                  rs = statement.executeQuery("Select * from hoteles where pais='"+pais+"'"); //Buscar todo (parametros todos vacíos)
                                              }
                                              else {
                                                  rs = statement.executeQuery("Select * from hoteles where pais='"+pais+"' and numb_hab='"+num_habitaciones+"'"); //Buscar todo (parametros todos vacíos)
                                              }
                                          }
                                      }
                                      else {
                                          if (pais.equals("")) {
                                              if (num_habitaciones.equals("")) {
                                                  rs = statement.executeQuery("Select * from hoteles where provincia='"+provincia+"'"); //Buscar todo (parametros todos vacíos)
                                              }
                                              else {
                                                  rs = statement.executeQuery("Select * from hoteles where provincia='"+provincia+"' and numb_hab='"+num_habitaciones+"'"); //Buscar todo (parametros todos vacíos)
                                              }
                                          }
                                          else {
                                              if (num_habitaciones.equals("")) {
                                                  rs = statement.executeQuery("Select * from hoteles where provincia='"+provincia+"' and pais='"+pais+"'"); //Buscar todo (parametros todos vacíos)
                                              }
                                              else {
                                                  rs = statement.executeQuery("Select * from hoteles where provincia='"+provincia+"' pais='"+pais+"' and numb_hab='"+num_habitaciones+"'"); //Buscar todo (parametros todos vacíos)
                                              }
                                              
                                          }
                                      }
                                  }
                                  else {
                                      if (provincia.equals("")) {
                                          if (pais.equals("")) {
                                              if (num_habitaciones.equals("")) {
                                                  rs = statement.executeQuery("Select * from hoteles where ciudad='"+ciudad+"'");
                                              }
                                              else {
                                                  rs = statement.executeQuery("Select * from hoteles where ciudad='"+ciudad+"' and numb_hab='"+num_habitaciones+"'");
                                              }
                                          }
                                          else {
                                              if (num_habitaciones.equals("")) {
                                                  rs = statement.executeQuery("Select * from hoteles where ciudad='"+ciudad+"' and pais='"+pais+"'");
                                              }
                                              else {
                                                  rs = statement.executeQuery("Select * from hoteles where ciudad='"+ciudad+"' and pais='"+pais+"' and numb_hab='"+num_habitaciones+"'");
                                              }
                                          }
                                      }
                                      else {
                                          if (pais.equals("")) {
                                              if (num_habitaciones.equals("")) {
                                                  rs = statement.executeQuery("Select * from hoteles where ciudad='"+ciudad+"' and provincia='"+provincia+"'");
                                              }
                                              else {
                                                  rs = statement.executeQuery("Select * from hoteles where ciudad='"+ciudad+"' and provincia='"+provincia+"' and numb_hab='"+num_habitaciones+"'");
                                              }
                                          }
                                          else {
                                              if (num_habitaciones.equals("")) {
                                                  rs = statement.executeQuery("Select * from hoteles where ciudad='"+ciudad+"' and provincia='"+provincia+"' and numb_hab='"+pais+"'");
                                              }
                                              else {
                                                  rs = statement.executeQuery("Select * from hoteles where ciudad='"+ciudad+"' and provincia='"+provincia+"' and numb_hab='"+pais+"' and numb_hab='"+num_habitaciones+"'");
                                              }
                                          }
                                      }
                                          
                                  }
                                  
                              }
                              else {
                                  if (ciudad.equals("")) {
                                      if (provincia.equals("")) {
                                          if (pais.equals("")) {
                                              if (num_habitaciones.equals("")) {
                                                  rs = statement.executeQuery("Select * from hoteles where codigo_postal='"+codigopostal+"'");
                                              }
                                              else {
                                                  rs = statement.executeQuery("Select * from hoteles where codigo_postal='"+codigopostal+"' and numb_hab='"+num_habitaciones+"'");
                                              }
                                          }
                                          
                                          else {
                                              if (num_habitaciones.equals("")) {
                                                  rs = statement.executeQuery("Select * from hoteles where codigo_postal='"+codigopostal+"' and pais='"+pais+"'");
                                              }
                                              else {
                                                  rs = statement.executeQuery("Select * from hoteles where codigo_postal='"+codigopostal+"' and pais='"+pais+"' and numb_hab='"+num_habitaciones+"'");
                                              }
                                          }
                                      }
                                      else {
                                          if (pais.equals("")) {
                                              if (num_habitaciones.equals("")) {
                                                  rs = statement.executeQuery("Select * from hoteles where codigo_postal='"+codigopostal+"' and provincia='"+provincia+"'");
                                              }
                                              else {
                                                  rs = statement.executeQuery("Select * from hoteles where codigo_postal='"+codigopostal+"' and provincia='"+provincia+"' and numb_hab='"+num_habitaciones+"'");
                                              }
                                          }
                                          else {
                                              if (num_habitaciones.equals("")) {
                                                  rs = statement.executeQuery("Select * from hoteles where codigo_postal='"+codigopostal+"' and provincia='"+provincia+"' and pais='"+pais+"'");
                                              }
                                              else {
                                                  rs = statement.executeQuery("Select * from hoteles where codigo_postal='"+codigopostal+"' and provincia='"+provincia+"' and pais='"+pais+"' and numb_hab='"+num_habitaciones+"'");
                                              }
                                          }
                                      }
                                  }
                              }
                          }
                          else {
                              if (codigopostal.equals("")) {
                                  if (ciudad.equals("")) {
                                      if (provincia.equals("")) {
                                          if (pais.equals("")) {
                                              if (num_habitaciones.equals("")) {
                                                  rs = statement.executeQuery("Select * from hoteles where numero='"+numero+"'");
                                              }
                                              else {
                                                  rs = statement.executeQuery("Select * from hoteles where numero='"+numero+"' and numb_hab='"+num_habitaciones+"'");
                                              }
                                          }
                                          else {
                                              if (num_habitaciones.equals("")) {
                                                  rs = statement.executeQuery("Select * from hoteles where numero='"+numero+"' and pais='"+pais+"'");
                                              }
                                              else {
                                                  rs = statement.executeQuery("Select * from hoteles where numero='"+numero+"' and pais='"+pais+"' and numb_hab='"+num_habitaciones+"'");
                                              }
                                          }
                                      }
                                      else {
                                          if (pais.equals("")) {
                                              if (num_habitaciones.equals("")) {
                                                  rs = statement.executeQuery("Select * from hoteles where numero='"+numero+"' and provincia='"+provincia+"'");
                                              }
                                              else {
                                                  rs = statement.executeQuery("Select * from hoteles where numero='"+numero+"' and provincia='"+provincia+"' and numb_hab='"+num_habitaciones+"'");
                                              }
                                          }
                                          else {
                                              if (num_habitaciones.equals("")) {
                                                  rs = statement.executeQuery("Select * from hoteles where numero='"+numero+"' and provincia='"+provincia+"' and pais='"+pais+"'");
                                              }
                                              else {
                                                  rs = statement.executeQuery("Select * from hoteles where numero='"+numero+"' and provincia='"+provincia+"' and pais='"+pais+" and numb_hab='"+num_habitaciones+"'");
                                              }
                                          }
                                      }
                                  }
                                  else {
                                      if (provincia.equals("")) {
                                          if (pais.equals("")) {
                                              if (num_habitaciones.equals("")) {
                                                  rs = statement.executeQuery("Select * from hoteles where numero='"+numero+"' and ciudad='"+ciudad+"'");
                                              }
                                              else {
                                                  rs = statement.executeQuery("Select * from hoteles where numero='"+numero+"' and ciudad='"+ciudad+"' numb_hab='"+num_habitaciones+"'");
                                              }
                                          }
                                          else {
                                              if (num_habitaciones.equals("")) {
                                                  rs = statement.executeQuery("Select * from hoteles where numero='"+numero+"' and ciudad='"+ciudad+"' andpais='"+pais+"'");
                                              }
                                          }
                                      }
                                      else {
                                          if (pais.equals("")) {
                                              if (num_habitaciones.equals("")) {
                                                  rs = statement.executeQuery("Select * from hoteles where numero='"+numero+"' and ciudad='"+ciudad+"' and provincia='"+provincia+"'");
                                              }
                                              else {
                                                  rs = statement.executeQuery("Select * from hoteles where numero='"+numero+"' and ciudad='"+ciudad+"' provincia='"+provincia+"' and numb_hab='"+num_habitaciones+"'");
                                              }
                                          }
                                          else {
                                              if (num_habitaciones.equals("")) {
                                                  rs = statement.executeQuery("Select * from hoteles where numero='"+numero+"' and ciudad='"+ciudad+"' provincia='"+provincia+"' and pais='"+pais+"'");
                                              }
                                              else {
                                                  rs = statement.executeQuery("Select * from hoteles where numero='"+numero+"' and ciudad='"+ciudad+"' provincia='"+provincia+"' and pais='"+pais+"' and numb_hab='"+num_habitaciones+"'");
                                              }
                                          }
                                      }
                                  }
                              }
                              else {
                                  if (ciudad.equals("")) {
                                      if (provincia.equals("")) {
                                          if (pais.equals("")) {
                                              if (num_habitaciones.equals("")) {
                                                  rs = statement.executeQuery("Select * from hoteles where numero='"+numero+"' and codigo_postal='"+codigopostal+"'");
                                              }
                                          }
                                          else {
                                              if (num_habitaciones.equals("")) {
                                                  rs = statement.executeQuery("Select * from hoteles where numero='"+numero+"' and codigo_postal='"+codigopostal+"' and pais='"+pais+"'");
                                              }
                                              else {
                                                  rs = statement.executeQuery("Select * from hoteles where numero='"+numero+"' and codigo_postal='"+codigopostal+"' and pais='"+pais+"' and numb_hab='"+num_habitaciones+"'");
                                              }
                                          }
                                      }
                                      else {
                                          if (pais.equals("")) {
                                              if (num_habitaciones.equals("")) {
                                                  rs = statement.executeQuery("Select * from hoteles where numero='"+numero+"' and codigo_postal='"+codigopostal+"' and provincia='"+provincia+"'");
                                              }
                                              else {
                                                  rs = statement.executeQuery("Select * from hoteles where numero='"+numero+"' and codigo_postal='"+codigopostal+"' and provincia='"+provincia+"' and numb_hab='"+num_habitaciones+"'");
                                              }
                                          }
                                          else {
                                              if (num_habitaciones.equals("")) {
                                                  rs = statement.executeQuery("Select * from hoteles where numero='"+numero+"' and codigo_postal='"+codigopostal+"' and provincia='"+provincia+"' and pais='"+pais+"'");
                                              }
                                              else {
                                                  rs = statement.executeQuery("Select * from hoteles where numero='"+numero+"' and codigo_postal='"+codigopostal+"' and provincia='"+provincia+"' and pais='"+pais+"' and numb_hab='"+num_habitaciones+"'");
                                              }
                                          }
                                      }
                                  }
                                  else {
                                      if (provincia.equals("")) {
                                          if (pais.equals("")) {
                                              if (num_habitaciones.equals("")) {
                                                  rs = statement.executeQuery("Select * from hoteles where numero='"+numero+"' and codigo_postal='"+codigopostal+"' and provincia='"+provincia+"' and ciudad='"+ciudad+"'");
                                              }
                                          }
                                          else {
                                              if (num_habitaciones.equals("")) {
                                                  rs = statement.executeQuery("Select * from hoteles where numero='"+numero+"' and codigo_postal='"+codigopostal+"' and provincia='"+provincia+"' and ciudad='"+ciudad+"' and pais='"+pais+"'");
                                              }
                                              else {
                                                  rs = statement.executeQuery("Select * from hoteles where numero='"+numero+"' and codigo_postal='"+codigopostal+"' and provincia='"+provincia+"' and ciudad='"+ciudad+"' and pais='"+pais+"' and numb_hab='"+num_habitaciones+"'");
                                              }
                                          }
                                      }
                                  }
                              }
                          }
                      }
                      else {
                          if (numero.equals("")) {
                            if (codigopostal.equals("")) {
                                if (ciudad.equals("")) {
                                    if (provincia.equals("")) {
                                        if (pais.equals("")) {
                                            if (num_habitaciones.equals("")) {
                                                rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"'");
                                            }
                                            else {
                                                rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and numb_hab='"+num_habitaciones+"'");
                                            }
                                        }
                                        else {
                                            if (num_habitaciones.equals("")) {
                                                rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and pais='"+pais+"'");
                                            }
                                            else {
                                                rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and pais='"+pais+"' and numb_hab='"+num_habitaciones+"'");
                                            }
                                        }
                                    }
                                    else {
                                        if (pais.equals("")) {
                                            if (num_habitaciones.equals("")) {
                                                rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and provincia='"+provincia+"'");
                                            }
                                            else {
                                                rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and provincia='"+provincia+"' and numb_hab='"+num_habitaciones+"'");
                                            }
                                        }
                                        else {
                                            if (num_habitaciones.equals("")) {
                                                rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and provincia='"+provincia+"' and pais='"+pais+"'");
                                            }
                                            else {
                                                rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and provincia='"+provincia+"' and pais='"+pais+"' and numb_hab='"+num_habitaciones+"'");
                                            }
                                        }
                                    }
                                }
                                else {
                                    if (provincia.equals("")) {
                                        if (pais.equals("")) {
                                            if (num_habitaciones.equals("")) {
                                                rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and ciudad='"+ciudad+"'");
                                            }
                                            else {
                                                rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and ciudad='"+ciudad+"' and numb_hab='"+num_habitaciones+"'");
                                            }
                                        }
                                        else {
                                            if (num_habitaciones.equals("")) {
                                                rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and ciudad='"+ciudad+"' pais='"+pais+"'");
                                            }
                                            else {
                                                rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and ciudad='"+ciudad+"' pais='"+pais+"' and numb_hab='"+num_habitaciones+"'");
                                            }
                                        }
                                    }
                                    else {
                                        if (pais.equals("")) {
                                            if (num_habitaciones.equals("")) {
                                                rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and ciudad='"+ciudad+"' provincia='"+provincia+"'");
                                            }
                                            else {
                                                rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and ciudad='"+ciudad+"' provincia='"+provincia+"' and numb_hab='"+num_habitaciones+"'");
                                            }
                                        }
                                        else {
                                            if (num_habitaciones.equals("")) {
                                                rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and ciudad='"+ciudad+"' provincia='"+provincia+"' and pais='"+pais+"'");
                                            }
                                            else {
                                                rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and ciudad='"+ciudad+"' provincia='"+provincia+"' and pais='"+pais+"' and numb_hab='"+num_habitaciones+"'");
                                            }
                                        }
                                    }
                                }
                            }
                            else {
                                if (ciudad.equals("")) {
                                    if (provincia.equals("")) {
                                        if (pais.equals("")) {
                                            if (num_habitaciones.equals("")) {
                                                rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and codigo_postal='"+codigopostal+"'");
                                            }
                                            else {
                                                rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and codigo_postal='"+codigopostal+"' and numb_hab='"+num_habitaciones+"'");
                                            }
                                        }
                                        else {
                                            if (num_habitaciones.equals("")) {
                                                rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and codigo_postal='"+codigopostal+"' and pais='"+pais+"'");
                                            }
                                            else {
                                                rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and codigo_postal='"+codigopostal+"' and pais='"+pais+"' and numb_hab='"+num_habitaciones+"'");
                                            }
                                        }
                                    }
                                    else {
                                        if (pais.equals("")) {
                                            if (num_habitaciones.equals("")) {
                                                rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and codigo_postal='"+codigopostal+"' and provincia='"+provincia+"'");
                                            }
                                            else {
                                                rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and codigo_postal='"+codigopostal+"' and provincia='"+provincia+"' and numb_hab='"+num_habitaciones+"'");
                                            }
                                        }
                                        else {
                                            if (num_habitaciones.equals("")) {
                                                rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and codigo_postal='"+codigopostal+"' and provincia='"+provincia+"' and pais='"+pais+"'");
                                            }
                                            else {
                                                rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and codigo_postal='"+codigopostal+"' and provincia='"+provincia+"' and pais='"+pais+"' and numb_hab='"+num_habitaciones+"'");
                                            }
                                        }
                                    }
                                }
                                else {
                                    if (provincia.equals("")) {
                                        if (pais.equals("")) {
                                            if (num_habitaciones.equals("")) {
                                                rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and codigo_postal='"+codigopostal+"' and ciudad='"+ciudad+"'");
                                            }
                                            else {
                                                rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and codigo_postal='"+codigopostal+"' and ciudad='"+ciudad+"' and numb_hab='"+num_habitaciones+"'");
                                            }
                                        }
                                        else {
                                            if (num_habitaciones.equals("")) {
                                                rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and codigo_postal='"+codigopostal+"' and ciudad='"+ciudad+"' and pais='"+pais+"'");
                                            }
                                            else {
                                                rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and codigo_postal='"+codigopostal+"' and ciudad='"+ciudad+"' and pais='"+pais+"' and numb_hab='"+num_habitaciones+"'");
                                            }
                                        }
                                    }
                                    else {
                                        if (pais.equals("")) {
                                            if (num_habitaciones.equals("")) {
                                                rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and codigo_postal='"+codigopostal+"' and ciudad='"+ciudad+"' and provincia='"+provincia+"'");
                                            }
                                            else {
                                                rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and codigo_postal='"+codigopostal+"' and ciudad='"+ciudad+"' and provincia='"+provincia+"' and numb_hab='"+num_habitaciones+"'");
                                            }
                                        }
                                        else {
                                            if (num_habitaciones.equals("")) {
                                                rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and codigo_postal='"+codigopostal+"' and ciudad='"+ciudad+"' and provincia='"+provincia+"' and pais='"+pais+"'");
                                            }
                                            else {
                                                rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and codigo_postal='"+codigopostal+"' and ciudad='"+ciudad+"' and provincia='"+provincia+"' and pais='"+pais+"' and numb_hab='"+num_habitaciones+"'");
                                            }
                                        }
                                    }
                                }
                            }
                          }
                          else {
                              if (codigopostal.equals("")) {
                                  if (ciudad.equals("")) {
                                      if (provincia.equals("")) {
                                          if (pais.equals("")) {
                                              if (num_habitaciones.equals("")) {
                                                  rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and numero='"+numero+"'");
                                              }
                                              else {
                                                  rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and numero='"+numero+"' and numb_hab='"+num_habitaciones+"'");
                                              }
                                          }
                                          else {
                                              if (num_habitaciones.equals("")) {
                                                  rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and numero='"+numero+"' and pais='"+pais+"'");
                                              }
                                              else {
                                                  rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and numero='"+numero+"' and pais='"+pais+"' and numb_hab='"+num_habitaciones+"'");
                                              }
                                              
                                          }
                                      }
                                      else {
                                          if (ciudad.equals("")) {
                                              if (provincia.equals("")) {
                                                  if (pais.equals("")) {
                                                      if (num_habitaciones.equals("")) {
                                                          rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and numero='"+numero+"' and codigopostal='"+codigopostal+"'");
                                                      }
                                                      else {
                                                          rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and numero='"+numero+"' and codigopostal='"+codigopostal+"' and numb_hab='"+num_habitaciones+"'");
                                                      }
                                                  }
                                                  else {
                                                      if (num_habitaciones.equals("")) {
                                                          rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and numero='"+numero+"' and codigopostal='"+codigopostal+"' and pais='"+pais+"'");
                                                      }
                                                      else {
                                                          rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and numero='"+numero+"' and codigopostal='"+codigopostal+"' and pais='"+pais+"' and numb_hab='"+num_habitaciones+"'");
                                                      }
                                                  }
                                              }
                                              else {
                                                  if (pais.equals("")) {
                                                      if (num_habitaciones.equals("")) {
                                                          rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and numero='"+numero+"' and codigopostal='"+codigopostal+"' and provincia='"+provincia+"'");
                                                      }
                                                      else {
                                                          rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and numero='"+numero+"' and codigopostal='"+codigopostal+"' and provincia='"+provincia+"' and numb_hab='"+num_habitaciones+"'");
                                                      }
                                                  }
                                                  else {
                                                      if (num_habitaciones.equals("")) {
                                                          rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and numero='"+numero+"' and codigopostal='"+codigopostal+"' and provincia='"+provincia+"' and pais='"+pais+"'");
                                                      }
                                                      else {
                                                          rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and numero='"+numero+"' and codigopostal='"+codigopostal+"' and provincia='"+provincia+"' and pais='"+pais+"' and numb_hab='"+num_habitaciones+"'");
                                                      }
                                                  }
                                              }
                                          }
                                      }
                                  }
                                  else {
                                      if (provincia.equals("")) {
                                          if (pais.equals("")) {
                                              if (num_habitaciones.equals("")) {
                                                  rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and numero='"+numero+"' and codigopostal='"+codigopostal+"' and ciudad='"+ciudad+"'");
                                              }
                                              else {
                                                  rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and numero='"+numero+"' and codigopostal='"+codigopostal+"' and ciudad='"+ciudad+"' and numb_hab='"+num_habitaciones+"'");
                                              }
                                          }
                                          else {
                                              if (num_habitaciones.equals("")) {
                                                  rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and numero='"+numero+"' and codigopostal='"+codigopostal+"' and ciudad='"+ciudad+"' and pais='"+pais+"'");
                                              }
                                              else {
                                                  rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and numero='"+numero+"' and codigopostal='"+codigopostal+"' and ciudad='"+ciudad+"' and pais='"+pais+"' and numb_hab='"+num_habitaciones+"'");
                                              }
                                          }
                                      }
                                      else {
                                          if (pais.equals("")) {
                                              if (num_habitaciones.equals("")) {
                                                  rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and numero='"+numero+"' and codigopostal='"+codigopostal+"' and ciudad='"+ciudad+"' and provincia='"+provincia+"'");
                                              }
                                              else {
                                                  rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and numero='"+numero+"' and codigopostal='"+codigopostal+"' and ciudad='"+ciudad+"' and provincia='"+provincia+"' and numb_hab='"+num_habitaciones+"'");
                                              }
                                          }
                                          else {
                                              if (num_habitaciones.equals("")) {
                                                  rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and numero='"+numero+"' and codigopostal='"+codigopostal+"' and ciudad='"+ciudad+"' and provincia='"+provincia+"' and pais='"+pais+"'");
                                              }
                                              else {
                                                  rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and numero='"+numero+"' and codigopostal='"+codigopostal+"' and ciudad='"+ciudad+"' and provincia='"+provincia+"' and pais='"+pais+"' and numb_hab='"+num_habitaciones+"'");
                                              }
                                          }
                                      }
                                  }
                              }
                              else {
                                  if (ciudad.equals("")) {
                                      if (provincia.equals("")) {
                                          if (pais.equals("")) {
                                              if (num_habitaciones.equals("")) {
                                                  rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and numero='"+numero+"' and codigo_postal='"+codigopostal+"'");
                                              }
                                              else {
                                                  rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and numero='"+numero+"' and codigo_postal='"+codigopostal+"' and numb_hab='"+num_habitaciones+"'");
                                              }
                                          }
                                          else {
                                              if (num_habitaciones.equals("")) {
                                                  rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and numero='"+numero+"' and codigo_postal='"+codigopostal+"' and pais='"+pais+"'");
                                              }
                                              else {
                                                  rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and numero='"+numero+"' and codigo_postal='"+codigopostal+"' and pais='"+pais+"' and numb_hab='"+num_habitaciones+"'");
                                              }
                                          }
                                      }
                                      else {
                                          if (pais.equals("")) {
                                              if (num_habitaciones.equals("")) {
                                                  rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and numero='"+numero+"' and codigo_postal='"+codigopostal+"' and provincia='"+provincia+"'");
                                              }
                                              else {
                                                  rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and numero='"+numero+"' and codigo_postal='"+codigopostal+"' and provincia='"+provincia+"' and numb_hab='"+num_habitaciones+"'");
                                              }
                                          }
                                          else {
                                              if (num_habitaciones.equals("")) {
                                                  rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and numero='"+numero+"' and codigo_postal='"+codigopostal+"' and provincia='"+provincia+"' and pais='"+pais+"'");
                                              }
                                              else {
                                                  rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and numero='"+numero+"' and codigo_postal='"+codigopostal+"' and provincia='"+provincia+"' and pais='"+pais+"' and numb_hab='"+num_habitaciones+"'");
                                              }
                                          }
                                      }
                                  }
                                  else {
                                      if (provincia.equals("")) {
                                          if (pais.equals("")) {
                                              if (num_habitaciones.equals("")) {
                                                  rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and numero='"+numero+"' and codigo_postal='"+codigopostal+"' and ciudad='"+ciudad+"'");
                                              }
                                              
                                              else {
                                                  rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and numero='"+numero+"' and codigo_postal='"+codigopostal+"' and ciudad='"+ciudad+"' and numb_hab='"+num_habitaciones+"'");
                                              }
                                          }
                                          else {
                                              if (num_habitaciones.equals("")) {
                                                  rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and numero='"+numero+"' and codigo_postal='"+codigopostal+"' and ciudad='"+ciudad+"' and pais='"+pais+"'");
                                              }
                                              else {
                                                  rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and numero='"+numero+"' and codigo_postal='"+codigopostal+"' and ciudad='"+ciudad+"' and pais='"+pais+"' and numb_hab='"+num_habitaciones+"'");
                                              }
                                          }
                                      }
                                      else {
                                          if (pais.equals("")) {
                                              if (num_habitaciones.equals("")) {
                                                  rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and numero='"+numero+"' and codigo_postal='"+codigopostal+"' and ciudad='"+ciudad+"' and provincia='"+provincia+"'");
                                              }
                                              else {
                                                  rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and numero='"+numero+"' and codigo_postal='"+codigopostal+"' and ciudad='"+ciudad+"' and provincia='"+provincia+"' and numb_hab='"+num_habitaciones+"'");
                                              }
                                          }
                                          else {
                                              if (num_habitaciones.equals("")) {
                                                  rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and numero='"+numero+"' and codigo_postal='"+codigopostal+"' and ciudad='"+ciudad+"' and provincia='"+provincia+"' and pais='"+pais+"'");
                                              }
                                              else {
                                                  rs = statement.executeQuery("Select * from hoteles where calle='"+calle+"' and numero='"+numero+"' and codigo_postal='"+codigopostal+"' and ciudad='"+ciudad+"' and provincia='"+provincia+"' and pais='"+pais+"' and numb_hab='"+num_habitaciones+"'");
                                              }
                                          }
                                      }
                                  }
                              }
                          }
                      }
                  }
                  else {
                      if (calle.equals("")) {
                          if (numero.equals("")) {
                              if (codigopostal.equals("")) {
                                  if (ciudad.equals("")) {
                                      if (provincia.equals("")) {
                                          if (pais.equals("")) {
                                              if (num_habitaciones.equals("")) {
                                                  rs = statement.executeQuery("Select * from hoteles where cadena='"+cadenahotelera+"'");
                                              }
                                              else {
                                                  rs = statement.executeQuery("Select * from hoteles where cadena='"+cadenahotelera+"' and numb_hab='"+num_habitaciones+"'");
                                              }
                                          }
                                          else {
                                              if (num_habitaciones.equals("")) {
                                                  
                                              }
                                          }
                                      }
                                  }
                              }
                          }
                      }
                  }
              }
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
        try {
            processRequestPOST(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(buscarhotel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(buscarhotel.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequestPOST(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(buscarhotel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(buscarhotel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
