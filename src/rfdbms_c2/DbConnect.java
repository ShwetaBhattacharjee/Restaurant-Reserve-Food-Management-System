/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rfdbms_c2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;

/**
 *
 * @author rkana
 */
public class DbConnect {
    
    Connection connection;
    Statement statement;
    ResultSet resultSet;
    
    public ResultSet readDatabase(String query){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager
                    .getConnection("jdbc:sqlserver://localhost:1433;databaseName=RFDBMS;selectMethod=cursor", "sa", "123456");
            
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            return resultSet;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList getArrayData(String query, String columnName){
        ArrayList datalist = new ArrayList();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager
                    .getConnection("jdbc:sqlserver://localhost:1433;databaseName=RFDBMS;selectMethod=cursor", "sa", "123456");
            
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                String name = resultSet.getString(columnName);
                datalist.add(name);
            }
            return datalist;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    public void executeQuery(String query){
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager
                    .getConnection("jdbc:sqlserver://localhost:1433;databaseName=RFDBMS;selectMethod=cursor", "sa", "123456");
            
            Statement statement = connection.createStatement();
            statement.executeQuery(query);
            
        } catch (Exception e) {
            Alert alt = new Alert (Alert.AlertType.CONFIRMATION);
            alt.setTitle("CONFIRMATION");
            alt.setContentText("Action Successfull");
            alt.showAndWait();
            System.out.println(e);
        }
    }
    
    
    
}
