
package rfdbms_c2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javax.swing.JOptionPane;


public class EReservationDB {
    
    public static ObservableList<EReservation> getAllRecords() throws ClassNotFoundException, SQLException{
        String sql = "SELECT * FROM Reservation R INNER JOIN Customer C ON (R.C_id=C.C_id) INNER JOIN Payment P ON (R.Pay_id=P.Pay_id) INNER JOIN ReservationDetails RD ON (R.R_id=RD.R_id) INNER JOIN ReservationTable RT ON (R.R_id=RT.R_id)";
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager
                    .getConnection("jdbc:sqlserver://localhost:1433;databaseName=RFDBMS;selectMethod=cursor", "sa", "123456");
            
            Statement statement = connection.createStatement();
            ResultSet rsSet = statement.executeQuery(sql);
            ObservableList<EReservation> eReservationList = getEReservationObjects(rsSet);
            return eReservationList;
        }catch(SQLException e){
            System.out.println("Error occured while the records from DB"+e);
            e.printStackTrace();
            throw e;
        }
    }
    
    public static ObservableList<EReservation> getEReservationObjects(ResultSet rsSet) throws ClassNotFoundException, SQLException{
        
        try{
            ObservableList<EReservation> eReservationList = FXCollections.observableArrayList();
            
            while(rsSet.next()){
                EReservation em = new EReservation();
                em.setRid(rsSet.getInt("r_id"));
                em.setRName(rsSet.getString("Name"));
                em.setRPhone(rsSet.getString("Phone"));
                em.setRNumofPeope(rsSet.getInt("Num_of_People"));
                em.setRTable_id(rsSet.getInt("T_id"));
                em.setRNumofTable(rsSet.getInt("Num_of_Table"));
                em.setRReservDate(rsSet.getString("ReservDate"));
                em.setRReservTime(rsSet.getString("ReservTime"));
                em.setRTime(rsSet.getString("R_time"));
                em.setRDate(rsSet.getString("R_date"));
                em.setRTotalPrice(rsSet.getInt("Total_price"));
                em.setRPaid(rsSet.getInt("Paid"));
                em.setRDue(rsSet.getInt("Due"));
                em.setRPayMethod(rsSet.getString("Method"));
                
                eReservationList.add(em);
            }
            return eReservationList;
        }catch(SQLException e){
            System.out.println("Error occured while the records from DB"+e);
            e.printStackTrace();
            throw e;
        }
    }
    
    public static ObservableList<EReservation> getAllRecordsRL() throws ClassNotFoundException, SQLException{
        String sql = "SELECT * FROM Reservation R INNER JOIN ReservationDetails RD ON (R.R_id=RD.R_id) INNER JOIN ReservationTable RT ON (R.R_id=RT.R_id)";
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager
                    .getConnection("jdbc:sqlserver://localhost:1433;databaseName=RFDBMS;selectMethod=cursor", "sa", "123456");
            
            Statement statement = connection.createStatement();
            ResultSet rsSet = statement.executeQuery(sql);
            ObservableList<EReservation> eReservationList = getReservationListObjects(rsSet);
            return eReservationList;
        }catch(SQLException e){
            System.out.println("Error occured while the records from DB"+e);
            e.printStackTrace();
            throw e;
        }
    }
    
    public static ObservableList<EReservation> getReservationListObjects(ResultSet rsSet) throws ClassNotFoundException, SQLException{
        
        try{
            ObservableList<EReservation> eReservationList = FXCollections.observableArrayList();
            
            while(rsSet.next()){
                EReservation em = new EReservation();
                em.setRid(rsSet.getInt("r_id"));
                em.setRNumofPeope(rsSet.getInt("Num_of_People"));
                em.setRTable_id(rsSet.getInt("T_id"));
                em.setRNumofTable(rsSet.getInt("Num_of_Table"));
                em.setRReservDate(rsSet.getString("ReservDate"));
                em.setRReservTime(rsSet.getString("ReservTime"));
                em.setRTime(rsSet.getString("R_time"));
                em.setRDate(rsSet.getString("R_date"));
                
                eReservationList.add(em);
            }
            return eReservationList;
        }catch(SQLException e){
            System.out.println("Error occured while the records from DB"+e);
            e.printStackTrace();
            throw e;
        }
    }
    
    
    
    public void insertEReservation(String name, String phone, String address, String email, int numofPeople, int table, String rDate, String rTime, int price, int paid, String payMethod, int em_id) throws ClassNotFoundException, SQLException{
        
        //name,phone,address,email,numofPeople,table,rDate,rTime,price,paid,payMethod
        int iC,iP,iR,iRD,iRT, c_id,pay_id,reserv_id, rowC,numofTable=1;
        String sqlC = "SELECT * FROM Customer WHERE Name LIKE '%"+name+"%' AND Phone LIKE '"+phone+"%'";
        rowC = checkNumRow(sqlC);
        if(rowC == 0){
            iC = customerInsert(name, phone, address, email);
            String sql1 = "SELECT * FROM Customer WHERE Name LIKE '%"+name+"%' AND Phone LIKE '"+phone+"%'";
            DbConnect dbc = new DbConnect();
            ResultSet rs = dbc.readDatabase(sql1);
            rs.next();
            c_id = rs.getInt("C_id");
            
        }else{
            DbConnect dbc = new DbConnect();
            ResultSet rs = dbc.readDatabase(sqlC);
            rs.next();
            c_id = rs.getInt("C_id");
            iC = 1;
        }
        
        iP = paymentInsert(price, paid, payMethod);
        pay_id = getPaymentId(price, paid, payMethod);
        iR = reservationInsert(c_id, em_id, pay_id);
        reserv_id = getReservationId(c_id, em_id, pay_id);
        iRD = reservationDetailsInsert(reserv_id, numofPeople, rDate, rTime, numofTable);
        iRT = reservationTableInsert(reserv_id, table);
        
        if(iC==1 && iP==1 && iR==1 && iRD==1 && iRT==1){
            Alert alt = new Alert(Alert.AlertType.CONFIRMATION);
            alt.setTitle("Confirmed");
            alt.setContentText("Reservation Successfull");
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
    
    private int customerInsert(String name, String phone, String address, String email){
        
        String sql = "INSERT INTO Customer(Name,Phone,Email,Address) VALUES(?, ?, ?, ?)";
        int i1=0;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager
                    .getConnection("jdbc:sqlserver://localhost:1433;databaseName=RFDBMS;selectMethod=cursor", "sa", "123456");
            
            PreparedStatement stC = connection.prepareStatement(sql);
            stC.setString(1, name);
            stC.setString(2, phone);
            stC.setString(3, email);
            stC.setString(4, address);
            
            i1 = stC.executeUpdate();
            
            
            if(i1 == 1){
                //JOptionPane.showMessageDialog(null,"Insert Unsuccessful");
                return i1;
            }
            
            
        }catch(Exception e){
            System.out.println("Error occured while insert into customer"+e);
        }
        return i1;
    }
    
    private int paymentInsert(int price, int paid, String payMethod){
        int due = price - paid;
        String sql = "INSERT INTO Payment (Total_price, Method, Paid, Due) VALUES(?, ?, ?, ?)";
        int i1=0;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager
                    .getConnection("jdbc:sqlserver://localhost:1433;databaseName=RFDBMS;selectMethod=cursor", "sa", "123456");
            
            PreparedStatement stC = connection.prepareStatement(sql);
            stC.setInt(1, price);
            stC.setString(2, payMethod);
            stC.setInt(3, paid);
            stC.setInt(4, due);
            
            i1 = stC.executeUpdate();
            if(i1 == 1){
                return i1;
            }
            
            
        }catch(Exception e){
            System.out.println("Error occured while insert into customer");
        }
        return i1;
    }
    
    private int reservationInsert(int c_id, int em_id, int pay_id){
        
        String sql = "INSERT INTO Reservation (C_id, Pay_id, E_id) VALUES(?, ?, ?)";
        int i1=0;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager
                    .getConnection("jdbc:sqlserver://localhost:1433;databaseName=RFDBMS;selectMethod=cursor", "sa", "123456");
            
            PreparedStatement stC = connection.prepareStatement(sql);
            stC.setInt(1, c_id);
            stC.setInt(2, pay_id);
            stC.setInt(3, em_id);
            
            i1 = stC.executeUpdate();
            if(i1 == 1){
                return i1;
            }
            
            
        }catch(Exception e){
            System.out.println("Error occured while insert into customer");
        }
        return i1;
    }
    
    public int getPaymentId(int price, int paid, String payMethod){
        int pay_id = 0;
        
        String sql1 = "SELECT * FROM Payment WHERE Total_price = '"+price+"' AND Method = '"+payMethod+"' AND Paid = '"+paid+"'";
        DbConnect dbc = new DbConnect();
        ResultSet rs = dbc.readDatabase(sql1);
        try {
            rs.next();
            pay_id = rs.getInt("Pay_id");
            return pay_id;
            
        } catch (Exception ex) {
            System.out.println("Couldn't get payment id");
        }
        
        return pay_id;
    }
    
    public int getReservationId(int c_id, int em_id, int pay_id){
        int reserv_id = 0;
        
        String sql1 = "SELECT * FROM Reservation WHERE C_id = '"+c_id+"' AND Pay_id = '"+pay_id+"' AND E_id = '"+em_id+"'";
        DbConnect dbc = new DbConnect();
        ResultSet rs = dbc.readDatabase(sql1);
        try {
            rs.next();
            reserv_id = rs.getInt("R_id");
            return reserv_id;
            
        } catch (Exception ex) {
            System.out.println("Couldn't get Reservation id");
        }
        return reserv_id;
        
    }
    
    private int reservationDetailsInsert(int reserve_id, int numofPeople, String rDate, String rTime, int numofTable){
        
        String sql = "INSERT INTO ReservationDetails (R_id, Num_of_People, ReservDate, ReservTime, Num_of_Table) VALUES(?, ?, ?, ?, ?)";
        int i1=0;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager
                    .getConnection("jdbc:sqlserver://localhost:1433;databaseName=RFDBMS;selectMethod=cursor", "sa", "123456");
            
            PreparedStatement stC = connection.prepareStatement(sql);
            stC.setInt(1, reserve_id);
            stC.setInt(2, numofPeople);
            stC.setString(3, rDate);
            stC.setString(4, rTime);
            stC.setInt(5, numofTable);
            
            i1 = stC.executeUpdate();
            if(i1 == 1){
                return i1;
            }
            
        }catch(Exception e){
            System.out.println("Error occured while insert into reservationDetails");
        }
        return i1;
    }
    
    private int reservationTableInsert(int reserv_id, int table){
        
        String sql = "INSERT INTO ReservationTable (R_id, T_id) VALUES (?, ?)";
        int i1=0;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager
                    .getConnection("jdbc:sqlserver://localhost:1433;databaseName=RFDBMS;selectMethod=cursor", "sa", "123456");
            
            PreparedStatement stC = connection.prepareStatement(sql);
            stC.setInt(1, reserv_id);
            stC.setInt(2, table);
            
            i1 = stC.executeUpdate();
            if(i1 == 1){
                return i1;
            }
            
            
        }catch(Exception e){
            System.out.println("Error occured while insert into reservationTable");
        }
        return i1;
    }
    
    
    
    
}
