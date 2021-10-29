/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class Conexion {

//    private final String base = "registro";
//    private final String usuario = "root";
//    private final String contraseña = null;
//    private final String url = "jbdc:mysql://localhost:3306/" + base;
    private Connection con = null;

    public static Connection getConexion() throws ClassNotFoundException, SQLException {

        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/registro", "root", "informatica");
            System.out.println("Conexión realizada");
            return c;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw e;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;

        }

    }

//    public Connection getConexion() {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/registro", "root", "null");
//            System.out.println("conexion realizada");
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return con;
//
//    }
}
