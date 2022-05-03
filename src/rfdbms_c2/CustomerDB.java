
package rfdbms_c2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class CustomerDB {
    
    public static ObservableList<Customer> getAllRecords(String sql) throws ClassNotFoundException, SQLException{
        
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager
                    .getConnection("jdbc:sqlserver://localhost:1433;databaseName=RFDBMS;selectMethod=cursor", "sa", "123456");
            
            Statement statement = connection.createStatement();
            ResultSet rsSet = statement.executeQuery(sql);
            ObservableList<Customer> CustomerInfo = getCustomerObjects(rsSet);
            return CustomerInfo;
        }catch(SQLException e){
            System.out.println("Error occured while the records from DB"+e);
            e.printStackTrace();
            throw e;
        }
    }
    
    public static ObservableList<Customer> getCustomerObjects(ResultSet rsSet) throws ClassNotFoundException, SQLException{
        
        try{
            ObservableList<Customer> CustomerInfo = FXCollections.observableArrayList();
            
            while(rsSet.next()){
                Customer cu = new Customer();
                cu.setCustomerId(rsSet.getInt("C_id"));
                cu.setCustomerName(rsSet.getString("Name"));
                cu.setCustomerPhone(rsSet.getString("Phone"));
                cu.setCustomerEmail(rsSet.getString("Email"));
                cu.setCustomerAddress(rsSet.getString("Address"));
                CustomerInfo.add(cu);
            }
            return CustomerInfo;
        }catch(SQLException e){
            System.out.println("Error occured while the records from DB"+e);
            e.printStackTrace();
            throw e;
        }
    }
    
}
