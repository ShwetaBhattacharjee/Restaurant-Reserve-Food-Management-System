/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rfdbms_c2;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author rkana
 */
public class AdminController implements Initializable {
    @FXML
    private AnchorPane aOrderListAnc;
    @FXML
    private AnchorPane aPackageListAnc;
    @FXML
    private AnchorPane aItemListAnc;
    @FXML
    private AnchorPane aReservationLAnc;
    @FXML
    private AnchorPane aProfileAnc;
    @FXML
    private AnchorPane aEmployeeListAnc;
    @FXML
    private Button aPackageList;
    @FXML
    private Button aItemsLIst;
    @FXML
    private Button aLogout;
    @FXML
    private Button aEmployeeList;
    @FXML
    private Button aOrderList;
    @FXML
    private Button aProfile;
    @FXML
    private Button aReservationList;
    
    @FXML
    private TableColumn<Employee, Integer> Eid;
    @FXML
    private TableColumn<Employee, String> EName;
    @FXML
    private TableColumn<Employee, String> eUsername;
    @FXML
    private TableColumn<Employee, String> EPassword;
    @FXML
    private TableColumn<Employee, String> EPhone;
    @FXML
    private TableColumn<Employee, String> EEmail;
    @FXML
    private TableColumn<Employee, String> EAddress;
    @FXML
    private TableColumn<Employee, Integer> EAdminId;
    @FXML
    private TableView<Employee> eEmployeeList;
    @FXML
    private TextField aPackageSearchTextField;
    @FXML
    private TableView<Package> aPackageListTable;
    @FXML
    private TableColumn<Package, Integer> aP_id;
    @FXML
    private TableColumn<Package, String> aP_name;
    @FXML
    private TableColumn<Package, Integer> aP_price;
    @FXML
    private TableColumn<Package, String> aP_description;
    @FXML
    private TableColumn<Package, Integer> aP_status;
    @FXML
    private TextField aItemSearchTextField;
    @FXML
    private TableView<Item> aItemTable;
    @FXML
    private TableColumn<Item, Integer> aI_id;
    @FXML
    private TableColumn<Item, String> aI_name;
    @FXML
    private TableColumn<Item, Integer> aI_price;
    @FXML
    private TableColumn<Item, Integer> aI_quantity;
    @FXML
    private TableColumn<Item, Integer> aI_status;
    @FXML
    private Button aProfilePasswordChangeBtn;
    @FXML
    private Button aProfileUserNameChangeBtn;
    @FXML
    private TextField aprofilePassword;
    @FXML
    private TextField aprofileID;
    @FXML
    private TextField aprofileUsername;
    @FXML
    private TextField aprofileEmail;
    @FXML
    private TextField aprofileAddress;
    @FXML
    private TextField aprofilePhone;
    @FXML
    private TextField aprofileName;
    @FXML
    private TextField aEmployeeSearchTextField;
    @FXML
    private TextField arlSearch;
    @FXML
    private TableView<EReservation> aReservationInfo;
    @FXML
    private TableColumn<EReservation, Integer> arR_id;
    @FXML
    private TableColumn<EReservation, Integer> arNumofPeople;
    @FXML
    private TableColumn<EReservation, Integer> arT_id;
    @FXML
    private TableColumn<EReservation, Integer> arNumofTable;
    @FXML
    private TableColumn<EReservation, String> arReserveTime;
    @FXML
    private TableColumn<EReservation, String> arReserveDate;
    @FXML
    private TableColumn<EReservation, String> arTime;
    @FXML
    private TableColumn<EReservation, String> arDate;
    @FXML
    private TableView<Customer> aCustomerInfo;
    @FXML
    private TableColumn<Customer, Integer> arC_id;
    @FXML
    private TableColumn<Customer, String> arName;
    @FXML
    private TableColumn<Customer, String> arPhone;
    @FXML
    private TableColumn<Customer, String> arEmail;
    @FXML
    private TableColumn<Customer, String> arAddress;
    @FXML
    private TableView<Payment> aPaymentInfo;
    @FXML
    private TableColumn<Payment, Integer> arP_id;
    @FXML
    private TableColumn<Payment, Integer> arP_price;
    @FXML
    private TableColumn<Payment, String> arP_paymethod;
    @FXML
    private TableColumn<Payment, Integer> arP_paid;
    @FXML
    private TableColumn<Payment, Integer> arP_due;
    @FXML
    private TableColumn<Payment, String> arP_time;
    @FXML
    private TableColumn<Payment, String> arP_date;
    @FXML
    private TextField aeEmail;
    @FXML
    private TextField aePhone;
    @FXML
    private TextField aeName;
    @FXML
    private TextField aeUsername;
    @FXML
    private TextField aePassword;
    @FXML
    private TextField aeAddress;
    @FXML
    private Button aeOkBtn;
    @FXML
    private Button aeClearBtn;
    @FXML
    private Button aeDeleteBtn;
    @FXML
    private Button aeUpdateBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            initializeEmployee();
            initializePackage();
            initializeItem();
            initializeReservationList();
            initializeCustomer();
            initializePayment();
            
            employeeTableRow();
            
        } catch (Exception ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    

    @FXML
    private void ehandleButtonAction(ActionEvent event) {
        
        if(event.getSource() == aEmployeeList){
            
            aEmployeeListAnc.toFront();
            
        }else if(event.getSource() == aOrderList){
            
            aOrderListAnc.toFront();
            
        }else if(event.getSource() == aReservationList){
            
            aReservationLAnc.toFront();
            
        }else if(event.getSource() == aPackageList){
            
            aPackageListAnc.toFront();
            
        }else if(event.getSource() == aItemsLIst){
            
            aItemListAnc.toFront();
            
        }else if(event.getSource() == aProfile){
            
            aProfileAnc.toFront();
            
        }else if(event.getSource() == aLogout){
            
            Platform.exit();
            
        }
        
    }
    
    
    /////////////////////////////// Initializing table /////////////////////////
    
    private void initializeEmployee() throws Exception{
        Eid.setCellValueFactory(cellData -> cellData.getValue().getE_id().asObject());
        EName.setCellValueFactory(cellData -> cellData.getValue().getName());
        eUsername.setCellValueFactory(cellData -> cellData.getValue().getUsername());
        EPassword.setCellValueFactory(cellData -> cellData.getValue().getPassword());
        EPhone.setCellValueFactory(cellData -> cellData.getValue().getPhone());
        EEmail.setCellValueFactory(cellData -> cellData.getValue().getEmail());
        EAddress.setCellValueFactory(cellData -> cellData.getValue().getAddress());
        EAdminId.setCellValueFactory(cellData -> cellData.getValue().getA_id().asObject());
        
        ObservableList<Employee> employeeList = EmployeeDB.getAllRecords();
        populateEmployeeTable(employeeList);
    }
    
    private void populateEmployeeTable(ObservableList<Employee> employeeList){
        
        eEmployeeList.setItems(employeeList);
        
    }
    
    
    private void initializePackage() throws Exception{
        aP_id.setCellValueFactory(cellData -> cellData.getValue().getP_id().asObject());
        aP_name.setCellValueFactory(cellData -> cellData.getValue().getName());
        aP_price.setCellValueFactory(cellData -> cellData.getValue().getPrice().asObject());
        aP_description.setCellValueFactory(cellData -> cellData.getValue().getDescription());
        aP_status.setCellValueFactory(cellData -> cellData.getValue().getStatus().asObject());
        ObservableList<Package> packageList = PackageDB.getAllRecords();
        populatePackageTable(packageList);
    }
    
    private void populatePackageTable(ObservableList<Package> packageList){
        
        aPackageListTable.setItems(packageList);
        
    }
    
    
    private void initializeItem() throws Exception{
        aI_id.setCellValueFactory(cellData -> cellData.getValue().getI_id().asObject());
        aI_name.setCellValueFactory(cellData -> cellData.getValue().getIName());
        aI_price.setCellValueFactory(cellData -> cellData.getValue().getIPrice().asObject());
        aI_quantity.setCellValueFactory(cellData -> cellData.getValue().getIQuantity().asObject());
        aI_status.setCellValueFactory(cellData -> cellData.getValue().getIStatus().asObject());
        
        ObservableList<Item> itemList = ItemDB.getAllRecords();
        populateItemTable(itemList);
    }
    
    private void populateItemTable(ObservableList<Item> itemList){
        
        aItemTable.setItems(itemList);
        
    }
    
    private void initializeReservationList() throws Exception{
        arR_id.setCellValueFactory(cellData -> cellData.getValue().getReserv_id().asObject());
        arNumofPeople.setCellValueFactory(cellData -> cellData.getValue().getNumofPeope().asObject());
        arT_id.setCellValueFactory(cellData -> cellData.getValue().getTable_id().asObject());
        arNumofTable.setCellValueFactory(cellData -> cellData.getValue().getNumofTable().asObject());
        arReserveTime.setCellValueFactory(cellData -> cellData.getValue().getReservTime());
        arReserveDate.setCellValueFactory(cellData -> cellData.getValue().getReservDate());
        arTime.setCellValueFactory(cellData -> cellData.getValue().getTime());
        arDate.setCellValueFactory(cellData -> cellData.getValue().getDate());
        
        ObservableList<EReservation> elReservationList = EReservationDB.getAllRecordsRL();
        populateEReservationListTable(elReservationList);
    }
    
    private void populateEReservationListTable(ObservableList<EReservation> elReservationList){
        
        aReservationInfo.setItems(elReservationList);
        
    }
    
    
    private void initializeCustomer() throws Exception{
        arC_id.setCellValueFactory(cellData -> cellData.getValue().getC_id().asObject());
        arName.setCellValueFactory(cellData -> cellData.getValue().getName());
        arPhone.setCellValueFactory(cellData -> cellData.getValue().getPhone());
        arEmail.setCellValueFactory(cellData -> cellData.getValue().getEmail());
        arAddress.setCellValueFactory(cellData -> cellData.getValue().getAddress());
        
        String sql = "SELECT * FROM Reservation R INNER JOIN Customer C ON (R.C_id=C.C_id) INNER JOIN ReservationDetails RD ON (R.R_id=RD.R_id)";
        
        ObservableList<Customer> CustomerInfo = CustomerDB.getAllRecords(sql);
        populateCustomerTable(CustomerInfo);
    }
    
    private void populateCustomerTable(ObservableList<Customer> CustomerInfo){
        
        aCustomerInfo.setItems(CustomerInfo);
        
    }
    
    
    private void initializePayment() throws Exception{
        arP_id.setCellValueFactory(cellData -> cellData.getValue().getP_id().asObject());
        arP_price.setCellValueFactory(cellData -> cellData.getValue().getTotal_price().asObject());
        arP_paymethod.setCellValueFactory(cellData -> cellData.getValue().getMethod());
        arP_paid.setCellValueFactory(cellData -> cellData.getValue().getPaid().asObject());
        arP_due.setCellValueFactory(cellData -> cellData.getValue().getDue().asObject());
        arP_time.setCellValueFactory(cellData -> cellData.getValue().getP_date());
        arP_date.setCellValueFactory(cellData -> cellData.getValue().getP_time());
        
        
        ObservableList<Payment> paymentList = PaymentDB.getAllRecords();
        populatePaymentTable(paymentList);
    }
    
    private void populatePaymentTable(ObservableList<Payment> PaymentInfo){
        
        aPaymentInfo.setItems(PaymentInfo);
        
    }
    
    
    //////////////////////////// Filtering ////////////////////////////////////

    @FXML
    private void aPackageSearch(KeyEvent event) {
        
        ObservableList<Package> packageList = null;
        try {
            packageList = PackageDB.getAllRecords();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        FilteredList<Package> filterPackage = new FilteredList(packageList, e-> true);
        
        aPackageSearchTextField.textProperty().addListener((observable, oldValue, newValue) -> {
        
            filterPackage.setPredicate((Predicate<? super Package>) (Package std) ->{
                
                if(newValue == null || newValue.isEmpty()){
                    return true;
                }
                
                String typetext = newValue.toLowerCase();
                
                if(String.valueOf(std.getPackageId()).indexOf(typetext) != -1){
                    return true;
                }
                else if(std.getPackageName().toLowerCase().indexOf(typetext) != -1){
                    return true;
                }
                else if(String.valueOf(std.getPackagePrice()).indexOf(typetext) != -1){
                    return true;
                }
                else if(std.getPackageDescription().toLowerCase().indexOf(typetext) != -1){
                    return true;
                }
                else if(String.valueOf(std.getPackageStatus()).indexOf(typetext) != -1){
                    return true;
                }
                
                return false;
                
            });
            
            SortedList<Package> sortedPacList = new SortedList<>(filterPackage);
            sortedPacList.comparatorProperty().bind(aPackageListTable.comparatorProperty());
            aPackageListTable.setItems(sortedPacList);
        
        });
        
        
    }

    @FXML
    private void aItemsSearch(KeyEvent event) {
        
        ObservableList<Item> itemList = null;
        try {
            itemList = ItemDB.getAllRecords();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        FilteredList<Item> filterItem = new FilteredList(itemList, f-> true);
        
        aItemSearchTextField.textProperty().addListener((observable, oldValue, newValue) -> {
        
            filterItem.setPredicate((Predicate<? super Item>) (Item std) ->{
                
                if(newValue == null || newValue.isEmpty()){
                    return true;
                }
                
                String typetext = newValue.toLowerCase();
                
                if(String.valueOf(std.getItemId()).indexOf(typetext) != -1){
                    return true;
                }
                else if(std.getItemName().toLowerCase().indexOf(typetext) != -1){
                    return true;
                }
                else if(String.valueOf(std.getItemPrice()).indexOf(typetext) != -1){
                    return true;
                }
                else if(String.valueOf(std.getItemQuantity()).indexOf(typetext) != -1){
                    return true;
                }
                else if(String.valueOf(std.getItemStatus()).indexOf(typetext) != -1){
                    return true;
                }
                
                return false;
                
            });
            
            SortedList<Item> sortedPacList = new SortedList<>(filterItem);
            sortedPacList.comparatorProperty().bind(aItemTable.comparatorProperty());
            aItemTable.setItems(sortedPacList);
        
        });
        
        
    }

    @FXML
    private void aEmployeeSearch(KeyEvent event) {
        
        
        ObservableList<Employee> itemList = null;
        try {
            itemList = EmployeeDB.getAllRecords();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        FilteredList<Employee> filterItem = new FilteredList(itemList, f-> true);
        
        aEmployeeSearchTextField.textProperty().addListener((observable, oldValue, newValue) -> {
        
            filterItem.setPredicate((Predicate<? super Employee>) (Employee std) ->{
                
                if(newValue == null || newValue.isEmpty()){
                    return true;
                }
                
                String typetext = newValue.toLowerCase();
                
                if(String.valueOf(std.getEmployeeId()).indexOf(typetext) != -1){
                    return true;
                }
                else if(std.getEmployeeName().toLowerCase().indexOf(typetext) != -1){
                    return true;
                }
                else if(std.getEmployeeUsername().toLowerCase().indexOf(typetext) != -1){
                    return true;
                }
                else if(std.getEmployeePassword().toLowerCase().indexOf(typetext) != -1){
                    return true;
                }
                else if(std.getEmployeePhone().toLowerCase().indexOf(typetext) != -1){
                    return true;
                }
                else if(std.getEmployeeEmail().toLowerCase().indexOf(typetext) != -1){
                    return true;
                }
                else if(std.getEmployeeAddress().toLowerCase().indexOf(typetext) != -1){
                    return true;
                }
                else if(String.valueOf(std.getEmployeeA_id()).indexOf(typetext) != -1){
                    return true;
                }
                
                return false;
                
            });
            
            SortedList<Employee> sortedPacList = new SortedList<>(filterItem);
            sortedPacList.comparatorProperty().bind(eEmployeeList.comparatorProperty());
            eEmployeeList.setItems(sortedPacList);
        
        });
        
    }

    @FXML
    private void aReservationListSearch(KeyEvent event) {
        
        ObservableList<EReservation> itemList = null;
        try {
            itemList = EReservationDB.getAllRecordsRL();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        FilteredList<EReservation> filterItem = new FilteredList(itemList, f-> true);
        
        arlSearch.textProperty().addListener((observable, oldValue, newValue) -> {
        
            filterItem.setPredicate((Predicate<? super EReservation>) (EReservation std) ->{
                
                if(newValue == null || newValue.isEmpty()){
                    return true;
                }
                
                String typetext = newValue.toLowerCase();
                
                if(String.valueOf(std.getRid()).indexOf(typetext) != -1){
                    return true;
                }
                else if(String.valueOf(std.getRNumofPeope()).indexOf(typetext) != -1){
                    return true;
                }
                else if(String.valueOf(std.getRTable_id()).indexOf(typetext) != -1){
                    return true;
                }
                else if(String.valueOf(std.getRNumofTable()).indexOf(typetext) != -1){
                    return true;
                }
                else if(std.getRReservTime().toLowerCase().indexOf(typetext) != -1){
                    return true;
                }
                else if(std.getRReservDate().toLowerCase().indexOf(typetext) != -1){
                    return true;
                }
                else if(std.getRTime().toLowerCase().indexOf(typetext) != -1){
                    return true;
                }
                else if(std.getRDate().toLowerCase().indexOf(typetext) != -1){
                    return true;
                }
                
                return false;
                
            });
            
            SortedList<EReservation> sortedPacList = new SortedList<>(filterItem);
            sortedPacList.comparatorProperty().bind(aReservationInfo.comparatorProperty());
            aReservationInfo.setItems(sortedPacList);
        
        });
        
        
    }

    
    
    //////////////////////// Employee button work //////////////////////////////
    
    @FXML
    private void aeOk(ActionEvent event) {
        
        String name, username, password, phone, email, address;
        int a_id;
        
        name = aeName.getText();
        username = aeUsername.getText();
        password = aePassword.getText();
        phone = aePhone.getText();
        phone = phone.replaceAll("\\s", "");
        email = aeEmail.getText();
        address = aeAddress.getText();
        
        a_id = Integer.valueOf(aprofileID.getText());
        
        if(name.isEmpty() || username.isEmpty() || password.isEmpty() || phone.isEmpty() || email.isEmpty() || address.isEmpty()){
            Alert alt = new Alert(Alert.AlertType.WARNING);
            alt.setTitle("WARNING");
            alt.setContentText("Please fill all the fields");
            alt.showAndWait();
        }
        else{
            EmployeeDB edb = new EmployeeDB();
            edb.employeeInsert(name, username, password, phone, email, address, a_id);
            try {
                initializeEmployee();
            } catch (Exception ex) {
                Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
            aeName.clear();
            aeUsername.clear();
            aePassword.clear();
            aePhone.clear();
            aeEmail.clear();
            aeAddress.clear();
            
        }
        
    }

    @FXML
    private void aeClear(ActionEvent event) {
        
        aeName.clear();
        aeUsername.clear();
        aePassword.clear();
        aePhone.clear();
        aeEmail.clear();
        aeAddress.clear();
    }

    @FXML
    private void aeDelete(ActionEvent event) {
        
        String username, password;
        
        username = aeUsername.getText();
        password = aePassword.getText();
        
        String sqd = "DELETE FROM Employee WHERE UserName = '"+username+"' AND Password = '"+password+"'";
        
        DbConnect dbc = new DbConnect();
        dbc.executeQuery(sqd);
        
        try {
            initializeEmployee();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        aeName.clear();
        aeUsername.clear();
        aePassword.clear();
        aePhone.clear();
        aeEmail.clear();
        aeAddress.clear();
        
    }

    @FXML
    private void aeUpdate(ActionEvent event) {
        
        String name, username, password, phone, email, address;
        
        name = aeName.getText();
        username = aeUsername.getText();
        password = aePassword.getText();
        phone = aePhone.getText();
        phone = phone.replaceAll("\\s", "");
        email = aeEmail.getText();
        address = aeAddress.getText();
        
        
        String sqd = "UPDATE Employee SET Name='"+name+"',UserName='"+username+"',Password='"+password+"',Phone='"+phone+"',Email='"+email+"',Address='"+address+"' WHERE UserName = '"+username+"' AND Password = '"+password+"'";
        
        DbConnect dbc = new DbConnect();
        dbc.executeQuery(sqd);
        
        try {
            initializeEmployee();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        aeName.clear();
        aeUsername.clear();
        aePassword.clear();
        aePhone.clear();
        aeEmail.clear();
        aeAddress.clear();
        
        
    }
    
    
    ///////////////////////////// Profile setup ////////////////////////////////
    
    public void profileSet(String username, String password){
        
        String query = "SELECT * FROM Admin WHERE UserName = '"+username+"'";
        ResultSet rs;
        
        EmployeeDB edb = new EmployeeDB();
        rs = edb.getProfile(query);
        
        try {
            rs.next();
            aprofileID.setText(String.valueOf(rs.getInt("A_id")));
            aprofileName.setText(rs.getString("Name"));
            aprofilePhone.setText(rs.getString("Phone"));
            aprofileEmail.setText(rs.getString("Email"));
            aprofileAddress.setText(rs.getString("Address"));
            
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        aprofileUsername.setText(username);
        aprofilePassword.setText(password);
        
    }
    
    
    /////////////////////////////// Profile button  ////////////////////////////
    

    @FXML
    private void aProfilePChangeBtn(ActionEvent event) {
        
        String password = aprofilePassword.getText();
        int e_id = Integer.valueOf(aprofileID.getText());
        String sqlu = "UPDATE Employee SET Password= '"+password+"' WHERE E_id = '"+e_id+"'";
        
        DbConnect dbc = new DbConnect();
        dbc.executeQuery(sqlu);
        
    }

    @FXML
    private void aProfileUChangeBtn(ActionEvent event) {
        
        String username = aprofileUsername.getText();
        int e_id = Integer.valueOf(aprofileID.getText());
        String sqlu = "UPDATE Employee SET UserName= '"+username+"' WHERE E_id = '"+e_id+"'";
        
        DbConnect dbc = new DbConnect();
        dbc.executeQuery(sqlu);
        
    }
    
    
    
    private void employeeTableRow(){
        
        eEmployeeList.setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override
            public void handle (MouseEvent event){
                
                aeName.setText(eEmployeeList.getSelectionModel().getSelectedItem().getEmployeeName());
                aeUsername.setText(eEmployeeList.getSelectionModel().getSelectedItem().getEmployeeUsername());
                aePassword.setText(eEmployeeList.getSelectionModel().getSelectedItem().getEmployeePassword());
                aePhone.setText(eEmployeeList.getSelectionModel().getSelectedItem().getEmployeePhone());
                aeEmail.setText(eEmployeeList.getSelectionModel().getSelectedItem().getEmployeeEmail());
                aeAddress.setText(eEmployeeList.getSelectionModel().getSelectedItem().getEmployeeAddress());
                
            }
        });
        
    }

    
    
    
}
