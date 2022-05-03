/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rfdbms_c2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rkana
 */
public class OrderDb {
    
    Connection conn;
    Statement st;
    
    public void orderInsertDB(){
        String sql="";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager
                    .getConnection("jdbc:sqlserver://localhost:1433;databaseName=RFDBMS;selectMethod=cursor", "sa", "123456");
            
            st = conn.prepareStatement(sql);
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                conn.close();
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(DbConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    
}
