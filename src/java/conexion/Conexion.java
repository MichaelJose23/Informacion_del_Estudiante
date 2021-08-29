/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;



/**
 *
 * @author Michael Castro
 */
public class Conexion {
    static String bd="Estudiante";
    static String user="root";
    static String pass="12345";
    static String url="jdbc:mysql://localhost:3306/"+bd;
    Connection conn=null;
    
    public Conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection(url, user, pass);
            if(conn!=null){
                System.out.println("Exito en la conexion");
            }
        } catch (Exception e) {
            System.out.println("Error" +e);
        }
        
        
    }
  
    public Connection conectar(){
        return conn;
        
    
    }
    public void desconectar() throws Exception{
      conn.close();
    }
    
}

