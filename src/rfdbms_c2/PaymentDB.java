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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author rkana
 */
public class PaymentDB {
    
    public static ObservableList<Payment> getAllRecords() throws ClassNotFoundException, SQLException{
        String sql = "SELECT * FROM Reservation R INNER JOIN Payment PY ON (R.Pay_id=PY.Pay_id) INNER JOIN ReservationDetails RD ON (R.R_id=RD.R_id)";
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager
                    .getConnection("jdbc:sqlserver://localhost:1433;databaseName=RFDBMS;selectMethod=cursor", "sa", "123456");
            
            Statement statement = connection.createStatement();
            ResultSet rsSet = statement.executeQuery(sql);
            ObservableList<Payment> PaymentInfo = getPaymentObjects(rsSet);
            return PaymentInfo;
        }catch(SQLException e){
            System.out.println("Error occured while the records from DB"+e);
            e.printStackTrace();
            throw e;
        }
    }
    
    public static ObservableList<Payment> getPaymentObjects(ResultSet rsSet) throws ClassNotFoundException, SQLException{
        
        try{
            ObservableList<Payment> PaymentInfo = FXCollections.observableArrayList();
            
            while(rsSet.next()){
                Payment py = new Payment();
                py.setPaymentId(rsSet.getInt("Pay_id"));
                py.setTotalPrice(rsSet.getInt("Total_price"));
                py.setPaymentMethod(rsSet.getString("Method"));
                py.setPaymentPaid(rsSet.getInt("Paid"));
                py.setPaymentDue(rsSet.getInt("Due"));
                py.setPaymentDate(rsSet.getString("P_date"));
                py.setPaymentTime(rsSet.getString("P_time"));
                
                PaymentInfo.add(py);
            }
            return PaymentInfo;
        }catch(SQLException e){
            System.out.println("Error occured while the records from DB"+e);
            e.printStackTrace();
            throw e;
        }
    }
    
}
