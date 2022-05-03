
package rfdbms_c2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;




public class EmployeeDB {
    
    public static ObservableList<Employee> getAllRecords() throws ClassNotFoundException, SQLException{
        String sql = "SELECT * FROM Employee";
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager
                    .getConnection("jdbc:sqlserver://localhost:1433;databaseName=RFDBMS;selectMethod=cursor", "sa", "123456");
            
            Statement statement = connection.createStatement();
            ResultSet rsSet = statement.executeQuery(sql);
            ObservableList<Employee> employeeList = getEmployeeObjects(rsSet);
            return employeeList;
        }catch(SQLException e){
            System.out.println("Error occured while the records from DB"+e);
            e.printStackTrace();
            throw e;
        }
    }
    
    public static ObservableList<Employee> getEmployeeObjects(ResultSet rsSet) throws ClassNotFoundException, SQLException{
        
        try{
            ObservableList<Employee> employeeList = FXCollections.observableArrayList();
            
            while(rsSet.next()){
                Employee em = new Employee();
                em.setEmployeeId(rsSet.getInt("E_id"));
                em.setEmployeeName(rsSet.getString("Name"));
                em.setEmployeeUsername(rsSet.getString("UserName"));
                em.setEmployeePassword(rsSet.getString("Password"));
                em.setEmployeePhone(rsSet.getString("Phone"));
                em.setEmployeeEmail(rsSet.getString("Email"));
                em.setEmployeeAddress(rsSet.getString("Address"));
                em.setEmployeeA_id(rsSet.getInt("A_id"));
                
                employeeList.add(em);
            }
            return employeeList;
        }catch(SQLException e){
            System.out.println("Error occured while the records from DB"+e);
            e.printStackTrace();
            throw e;
        }
    }
    
    
    public ResultSet getProfile(String query){
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager
                    .getConnection("jdbc:sqlserver://localhost:1433;databaseName=RFDBMS;selectMethod=cursor", "sa", "123456");
            
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            return resultSet;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    public void employeeInsert(String name, String username, String password, String phone, String email, String address, int a_id){
        
        int rowC;
        String sqlC = "SELECT * FROM Customer WHERE Name LIKE '"+name+"' AND Phone LIKE '"+phone+"'";
        rowC = checkNumRow(sqlC);
        
        if (rowC == 0) {

            String sql = "INSERT INTO Employee(Name,UserName,Password,Phone,Email,Address,A_id) VALUES(?, ?, ?, ?, ?, ?, ?)";
            int i1 = 0;
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection connection = DriverManager
                        .getConnection("jdbc:sqlserver://localhost:1433;databaseName=RFDBMS;selectMethod=cursor", "sa", "123456");

                PreparedStatement stC = connection.prepareStatement(sql);
                stC.setString(1, name);
                stC.setString(2, username);
                stC.setString(3, password);
                stC.setString(4, phone);
                stC.setString(5, email);
                stC.setString(6, address);
                stC.setInt(7, a_id);

                i1 = stC.executeUpdate();

                if (i1 == 1) {
                    Alert alt = new Alert(Alert.AlertType.CONFIRMATION);
                    alt.setTitle("CONFIRMATION");
                    alt.setContentText("Data insert successful");
                    alt.showAndWait();
                }

            } catch (Exception e) {
                System.out.println("Error occured while insert into customer" + e);

            }

        } else {
            
            Alert alt = new Alert(Alert.AlertType.WARNING);
            alt.setTitle("WARNING");
            alt.setContentText("User already exits");
            alt.showAndWait();

        }
        
    }
    
    public int checkNumRow(String sql){
        int row = 0; 
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager
                    .getConnection("jdbc:sqlserver://localhost:1433;databaseName=RFDBMS;selectMethod=cursor", "sa", "123456");
            
            Statement statement = connection.createStatement();
            ResultSet rsSet = statement.executeQuery(sql);
            while (rsSet.next()) {
                row++;
            }
            return row;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }
    
    
    
}
