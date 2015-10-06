/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vikar
 */
public class KoneksiMySql {
    private static Connection koneksi;
    private static final String user = "inventori";
    private static final String password = "program";
    private static final String url = "jdbc:mysql://localhost:3306/appinventori";
    
    public static Connection getKoneksi() {
        if(koneksi == null) {
            try {
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                koneksi = DriverManager.getConnection(url, user, password);
            } catch (SQLException ex) {
                Logger.getLogger(KoneksiMySql.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return koneksi;
    }
    
}
