/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connectDB;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author taiproduaxe
 */
public class testDatabase {
    public static void main(String[] args){
        
        Connection conn = Database.getConnection();
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            String query = "select * from phanxuong";
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                System.out.println(""+rs.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(testDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}