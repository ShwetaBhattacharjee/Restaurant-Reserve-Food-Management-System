
package rfdbms_c2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class ItemDB {
    
    public static ObservableList<Item> getAllRecords() throws ClassNotFoundException, SQLException{
        String sql = "SELECT * FROM Items";
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager
                    .getConnection("jdbc:sqlserver://localhost:1433;databaseName=RFDBMS;selectMethod=cursor", "sa", "123456");
            
            Statement statement = connection.createStatement();
            ResultSet rsSet = statement.executeQuery(sql);
            ObservableList<Item> itemList = getItemObjects(rsSet);
            return itemList;
        }catch(SQLException e){
            System.out.println("Error occured while the records from DB"+e);
            e.printStackTrace();
            throw e;
        }
    }
    
    public static ObservableList<Item> getItemObjects(ResultSet rsSet) throws ClassNotFoundException, SQLException{
        
        try{
            ObservableList<Item> itemList = FXCollections.observableArrayList();
            
            //I_id, Name, Price, Quantity, Status
            while(rsSet.next()){
                Item it = new Item();
                it.setItemId(rsSet.getInt("I_id"));
                it.setItemName(rsSet.getString("Name"));
                it.setItemPrice(rsSet.getInt("Price"));
                it.setItemQuantity(rsSet.getInt("Quantity"));
                it.setItemStatus(rsSet.getInt("Status"));
                
                itemList.add(it);
            }
            return itemList;
        }catch(SQLException e){
            System.out.println("Error occured while the records from DB"+e);
            e.printStackTrace();
            throw e;
        }
    }
    
}
