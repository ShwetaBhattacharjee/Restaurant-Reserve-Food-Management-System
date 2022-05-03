
package rfdbms_c2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class PackageDB {
    
    public static ObservableList<Package> getAllRecords() throws ClassNotFoundException, SQLException{
        String sql = "SELECT * FROM Package";
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager
                    .getConnection("jdbc:sqlserver://localhost:1433;databaseName=RFDBMS;selectMethod=cursor", "sa", "123456");
            
            Statement statement = connection.createStatement();
            ResultSet rsSet = statement.executeQuery(sql);
            ObservableList<Package> packageList = getPackageObjects(rsSet);
            return packageList;
        }catch(SQLException e){
            System.out.println("Error occured while the records from DB"+e);
            e.printStackTrace();
            throw e;
        }
    }
    
    public static ObservableList<Package> getPackageObjects(ResultSet rsSet) throws ClassNotFoundException, SQLException{
        
        try{
            ObservableList<Package> packageList = FXCollections.observableArrayList();
            
            while(rsSet.next()){
                Package pk = new Package();
                pk.setPackageId(rsSet.getInt("P_id"));
                pk.setPackageName(rsSet.getString("Name"));
                pk.setPackagePrice(rsSet.getInt("Price"));
                pk.setPackageDescription(rsSet.getString("Description"));
                pk.setPackageStatus(rsSet.getInt("Status"));
                
                packageList.add(pk);
            }
            return packageList;
        }catch(SQLException e){
            System.out.println("Error occured while the records from DB"+e);
            e.printStackTrace();
            throw e;
        }
    }
}
//P_id ,Name, Price, Description, Status