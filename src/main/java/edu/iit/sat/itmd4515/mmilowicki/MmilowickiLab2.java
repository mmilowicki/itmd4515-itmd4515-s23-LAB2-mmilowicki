/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package edu.iit.sat.itmd4515.mmilowicki;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maciej
 */
public class MmilowickiLab2 {

    public static void main(String[] args) {
     
        String username = "itmd4515";
        String password = "itmd4515";
        String url = "jdbc:mysql://localhost:3306/northwind?zeroDateTimeBehavior=CONVERT_TO_NULL";
        String query = "select * from customer where contactName = ?";
        
        ResultSet rs;
                
        try (Connection con = DriverManager.getConnection(url, username, password);
            PreparedStatement ps = con.prepareStatement(query);) {
            
            //rs = st.executeQuery(query);
              ps.setString(1, "Bansal");
              rs = ps.executeQuery();
            
            while(rs.next()) {
                System.out.println(rs.getString("city"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MmilowickiLab2.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }    
}
