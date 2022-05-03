/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rfdbms_c2;

import java.awt.event.KeyEvent;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Window;
import javax.swing.JOptionPane;
import org.controlsfx.control.textfield.TextFields;


/**
 * FXML Controller class
 *
 * @author rkana
 */
public class EmployeeController implements Initializable {
    @FXML
    private Button eorderBtn;
    @FXML
    private Button eorderListBtn;
    @FXML
    private Button eitemsListBtn;
    @FXML
    private Button epackageListBtn;
    @FXML
    private Button ereservationBtn;
    @FXML
    private Button ereservationListBtn;
    @FXML
    private Button eprofileBtn;
    @FXML
    private Button elogoutBtn;
    @FXML
    private AnchorPane eprofileAnc;
    @FXML
    private TextField eprofileName;
    @FXML
    private TextField eprofilePhone;
    @FXML
    private TextField eprofileAddress;
    @FXML
    private TextField eprofileEmail;
    @FXML
    private TextField eprofileUsername;
    @FXML
    private TextField eprofileID;
    @FXML
    private TextField eprofilePassword;
    @FXML
    private AnchorPane ereservationListAnc;
    @FXML
    private AnchorPane ereservationAnc;
    @FXML
    private AnchorPane eitemsListAnc;
    @FXML
    private AnchorPane eorderListAnc;
    @FXML
    private AnchorPane eorderAnc;
    @FXML
    private AnchorPane epackageListAnc;
    @FXML
    private TableView<Package> ePackageList;
    @FXML
    private TableColumn<Package, Integer> P_id;
    @FXML
    private TableColumn<Package, String> PName;
    @FXML
    private TableColumn<Package, Integer> PPrice;
    @FXML
    private TableColumn<Package, String> PDescription;
    @FXML
    private TableColumn<Package, Integer> PStatus;
    @FXML
    private TableView<Item> eItemList;
    @FXML
    private TableColumn<Item, Integer> I_id;
    @FXML
    private TableColumn<Item, String> IName;
    @FXML
    private TableColumn<Item, Integer> IPrice;
    @FXML
    private TableColumn<Item, Integer> IQuantity;
    @FXML
    private TableColumn<Item, Integer> IStatus;
    @FXML
    private Button eOrderOkBtn;
    @FXML
    private ComboBox<String> eOrderPayCombo;
    @FXML
    private Button eOrderClearBtn;
    @FXML
    private TextField eOrderNameTextField;
    @FXML
    private TextField ePackageSearchTextField;
    @FXML
    private TextField eOrderPhoneTextField;
    @FXML
    private TextField eOrderOrderTextField;
    @FXML
    private TextField eOrderEmailTextField;
    @FXML
    private TextField eOrderAddressTextField;
    @FXML
    private Button eProfileUserNameChangeBtn;
    @FXML
    private TextField erName;
    @FXML
    private TextField erAddress;
    @FXML
    private TextField erPhone;
    @FXML
    private Button erOkBtn;
    @FXML
    private ComboBox<String> erPayMethod;
    @FXML
    private TextField erNumofPeople;
    @FXML
    private TextField erReservDate;
    @FXML
    private Button erClearBtn;
    @FXML
    private TextField erReservTime;
    @FXML
    private TextField erEmail;
    @FXML
    private TextField erTable;
    @FXML
    private TextField erPrice;
    @FXML
    private TextField erPaid;
    @FXML
    private TextField erSearch;
    @FXML
    private TableColumn<EReservation, Integer> erTReservId;
    @FXML
    private TableColumn<EReservation, String> erTName;
    @FXML
    private TableColumn<EReservation, String> erTPhone;
    @FXML
    private TableColumn<EReservation, Integer> erTNumofPeople;
    @FXML
    private TableColumn<EReservation, Integer> erTTableId;
    @FXML
    private TableColumn<EReservation, Integer> erTNUmofTable;
    @FXML
    private TableColumn<EReservation, String> erTReservTime;
    @FXML
    private TableColumn<EReservation, String> erTReservDate;
    @FXML
    private TableColumn<EReservation, String> erTTime;
    @FXML
    private TableColumn<EReservation, String> erTDate;
    @FXML
    private TableColumn<EReservation, Integer> erTTotalPay;
    @FXML
    private TableColumn<EReservation, Integer> erTPaid;
    @FXML
    private TableColumn<EReservation, Integer> erTDue;
    @FXML
    private TableColumn<EReservation, String> erTPayMethod;
    @FXML
    private TableView<EReservation> eReservTable;
    @FXML
    private TextField erlSearch;
    @FXML
    private TableView<EReservation> erlReserveTable;
    @FXML
    private TableView<Customer> erlCustomerTable;
    @FXML
    private TableView<Payment> erlPaymentTable;
    @FXML
    private TableColumn<EReservation, Integer> erlR_id;
    @FXML
    private TableColumn<EReservation, Integer> erlNumofPeople;
    @FXML
    private TableColumn<EReservation, Integer> erlT_id;
    @FXML
    private TableColumn<EReservation, Integer> erlNumofTable;
    @FXML
    private TableColumn<EReservation, String> erlReserveTime;
    @FXML
    private TableColumn<EReservation, String> erlReserveDate;
    @FXML
    private TableColumn<EReservation, String> erlRtime;
    @FXML
    private TableColumn<EReservation, String> erlRdate;
    
    @FXML
    private TableColumn<Customer, Integer> erlC_id;
    @FXML
    private TableColumn<Customer, String> erlC_name;
    @FXML
    private TableColumn<Customer, String> erlC_phone;
    @FXML
    private TableColumn<Customer, String> erlC_email;
    @FXML
    private TableColumn<Customer, String> erlC_address;
    
    @FXML
    private TableColumn<Payment, Integer> erlPay_id;
    @FXML
    private TableColumn<Payment, Integer> erlTotalPrice;
    @FXML
    private TableColumn<Payment, String> erlPaymethod;
    @FXML
    private TableColumn<Payment, Integer> erlTotalPaid;
    @FXML
    private TableColumn<Payment, Integer> erlTotalDue;
    @FXML
    private TableColumn<Payment, String> erlP_time;
    @FXML
    private TableColumn<Payment, String> erlP_date;
    @FXML
    private TextField eItemListSearch;
    @FXML
    private Button eProfilePasswordChangeBtn;
    

    /**
     * Initializes the controller class.
     */
    
    /////
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ObservableList<String> paymentMethodList = FXCollections.observableArrayList("Cash", "Card", "Bkash", "Nagad", "NexusPay", "Rocket");
        eOrderPayCombo.setItems(paymentMethodList);
        erPayMethod.setItems(paymentMethodList);
        
        try {
            // TODO
            initializePackage();
            initializeItem();
            initializeEReservation();
            initializeReservationList();
            initializeCustomer();
            initializePayment();
            
            eOrderNameTextFieldSug();
            eOrderPhoneTextFieldSug();
            eOrderEmailTextFieldSug();
            eOrderAddressTextFieldSug();
            erNameTextFieldSug();
            erPhoneTextFieldSug();
            erEmailTextFieldSug();
            erAddressTextFieldSug();
            erTableTextFieldSug();
            
        } catch (Exception ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
    @FXML
    private void ehandleButtonAction(ActionEvent event) {
        if(event.getSource() == eorderBtn){
            
            eorderAnc.toFront();
            
        }else if(event.getSource() == eorderListBtn){
            
            eorderListAnc.toFront();
            
        }else if(event.getSource() == epackageListBtn){
            
            epackageListAnc.toFront();
            
        }else if(event.getSource() == eitemsListBtn){
            
            eitemsListAnc.toFront();
            
        }else if(event.getSource() == ereservationBtn){
            
            ereservationAnc.toFront();
            
        }else if(event.getSource() == ereservationListBtn){
            
            ereservationListAnc.toFront();
            
        }else if(event.getSource() == eprofileBtn){
            
            eprofileAnc.toFront();
            
        }else if(event.getSource() == elogoutBtn){
            
            Platform.exit();
        }
    }
    
    
    private void initializePackage() throws Exception{
        P_id.setCellValueFactory(cellData -> cellData.getValue().getP_id().asObject());
        PName.setCellValueFactory(cellData -> cellData.getValue().getName());
        PPrice.setCellValueFactory(cellData -> cellData.getValue().getPrice().asObject());
        PDescription.setCellValueFactory(cellData -> cellData.getValue().getDescription());
        PStatus.setCellValueFactory(cellData -> cellData.getValue().getStatus().asObject());
        ObservableList<Package> packageList = PackageDB.getAllRecords();
        populatePackageTable(packageList);
    }
    
    private void populatePackageTable(ObservableList<Package> packageList){
        
        ePackageList.setItems(packageList);
        
    }
    
    
    private void initializeItem() throws Exception{
        I_id.setCellValueFactory(cellData -> cellData.getValue().getI_id().asObject());
        IName.setCellValueFactory(cellData -> cellData.getValue().getIName());
        IPrice.setCellValueFactory(cellData -> cellData.getValue().getIPrice().asObject());
        IQuantity.setCellValueFactory(cellData -> cellData.getValue().getIQuantity().asObject());
        IStatus.setCellValueFactory(cellData -> cellData.getValue().getIStatus().asObject());
        
        ObservableList<Item> itemList = ItemDB.getAllRecords();
        populateItemTable(itemList);
    }
    
    private void populateItemTable(ObservableList<Item> itemList){
        
        eItemList.setItems(itemList);
        
    }
    
    
    private void initializeEReservation() throws Exception{
        erTReservId.setCellValueFactory(cellData -> cellData.getValue().getReserv_id().asObject());
        erTName.setCellValueFactory(cellData -> cellData.getValue().getName());
        erTPhone.setCellValueFactory(cellData -> cellData.getValue().getPhone());
        erTNumofPeople.setCellValueFactory(cellData -> cellData.getValue().getNumofPeope().asObject());
        erTTableId.setCellValueFactory(cellData -> cellData.getValue().getTable_id().asObject());
        erTNUmofTable.setCellValueFactory(cellData -> cellData.getValue().getNumofTable().asObject());
        erTReservTime.setCellValueFactory(cellData -> cellData.getValue().getReservTime());
        erTReservDate.setCellValueFactory(cellData -> cellData.getValue().getReservDate());
        erTTime.setCellValueFactory(cellData -> cellData.getValue().getTime());
        erTDate.setCellValueFactory(cellData -> cellData.getValue().getDate());
        erTTotalPay.setCellValueFactory(cellData -> cellData.getValue().getTotalPrice().asObject());
        erTPaid.setCellValueFactory(cellData -> cellData.getValue().getPaid().asObject());
        erTDue.setCellValueFactory(cellData -> cellData.getValue().getDue().asObject());
        erTPayMethod.setCellValueFactory(cellData -> cellData.getValue().getPayMethod());
        
        ObservableList<EReservation> eReservationList = EReservationDB.getAllRecords();
        populateEReservationTable(eReservationList);
    }
    
    private void populateEReservationTable(ObservableList<EReservation> eReservationList){
        
        eReservTable.setItems(eReservationList);
        
    }
    
    private void initializeReservationList() throws Exception{
        erlR_id.setCellValueFactory(cellData -> cellData.getValue().getReserv_id().asObject());
        erlNumofPeople.setCellValueFactory(cellData -> cellData.getValue().getNumofPeope().asObject());
        erlT_id.setCellValueFactory(cellData -> cellData.getValue().getTable_id().asObject());
        erlNumofTable.setCellValueFactory(cellData -> cellData.getValue().getNumofTable().asObject());
        erlReserveTime.setCellValueFactory(cellData -> cellData.getValue().getReservTime());
        erlReserveDate.setCellValueFactory(cellData -> cellData.getValue().getReservDate());
        erlRtime.setCellValueFactory(cellData -> cellData.getValue().getTime());
        erlRdate.setCellValueFactory(cellData -> cellData.getValue().getDate());
        
        ObservableList<EReservation> elReservationList = EReservationDB.getAllRecordsRL();
        populateEReservationListTable(elReservationList);
    }
    
    private void populateEReservationListTable(ObservableList<EReservation> elReservationList){
        
        erlReserveTable.setItems(elReservationList);
        
    }
    
    
    private void initializeCustomer() throws Exception{
        erlC_id.setCellValueFactory(cellData -> cellData.getValue().getC_id().asObject());
        erlC_name.setCellValueFactory(cellData -> cellData.getValue().getName());
        erlC_phone.setCellValueFactory(cellData -> cellData.getValue().getPhone());
        erlC_email.setCellValueFactory(cellData -> cellData.getValue().getEmail());
        erlC_address.setCellValueFactory(cellData -> cellData.getValue().getAddress());
        
        String sql = "SELECT * FROM Reservation R INNER JOIN Customer C ON (R.C_id=C.C_id) INNER JOIN ReservationDetails RD ON (R.R_id=RD.R_id)";
        
        ObservableList<Customer> CustomerInfo = CustomerDB.getAllRecords(sql);
        populateCustomerTable(CustomerInfo);
    }
    
    private void populateCustomerTable(ObservableList<Customer> CustomerInfo){
        
        erlCustomerTable.setItems(CustomerInfo);
        
    }
    
    
    private void initializePayment() throws Exception{
        erlPay_id.setCellValueFactory(cellData -> cellData.getValue().getP_id().asObject());
        erlTotalPrice.setCellValueFactory(cellData -> cellData.getValue().getTotal_price().asObject());
        erlPaymethod.setCellValueFactory(cellData -> cellData.getValue().getMethod());
        erlTotalPaid.setCellValueFactory(cellData -> cellData.getValue().getPaid().asObject());
        erlTotalDue.setCellValueFactory(cellData -> cellData.getValue().getDue().asObject());
        erlP_time.setCellValueFactory(cellData -> cellData.getValue().getP_date());
        erlP_date.setCellValueFactory(cellData -> cellData.getValue().getP_time());
        
        
        ObservableList<Payment> paymentList = PaymentDB.getAllRecords();
        populatePaymentTable(paymentList);
    }
    
    private void populatePaymentTable(ObservableList<Payment> PaymentInfo){
        
        erlPaymentTable.setItems(PaymentInfo);
        
    }
    
    
    
    //********************** Textfield sug *****************************//
    
    private void eOrderNameTextFieldSug(){
        /*DbConnect db = new DbConnect();
        ArrayList datalist = new ArrayList();
        
        String sql = "SELECT * FROM Customer";
        String columnName = "Name";
        
        datalist = db.getArrayData(sql, columnName);
        
        TextFields.bindAutoCompletion(eOrderNameTextField, datalist);*/
        TextfieldSug ts = new TextfieldSug();
        ts.customerNameTextFieldSug(eOrderNameTextField);
    }
    
    private void eOrderPhoneTextFieldSug(){
        TextfieldSug ts = new TextfieldSug();
        ts.customerPhoneTextFieldSug(eOrderPhoneTextField);
    }
    
    private void eOrderEmailTextFieldSug(){
        TextfieldSug ts = new TextfieldSug();
        ts.customerEmailTextFieldSug(eOrderEmailTextField);
    }
    
    private void eOrderAddressTextFieldSug(){
        TextfieldSug ts = new TextfieldSug();
        ts.customerAddressTextFieldSug(eOrderAddressTextField);        
    }
    
    private void erNameTextFieldSug(){
        TextfieldSug ts = new TextfieldSug();
        ts.customerNameTextFieldSug(erName);
    }
    
    private void erPhoneTextFieldSug(){
        TextfieldSug ts = new TextfieldSug();
        ts.customerPhoneTextFieldSug(erPhone);
    }
    
    private void erEmailTextFieldSug(){
        TextfieldSug ts = new TextfieldSug();
        ts.customerEmailTextFieldSug(erEmail);
    }
    
    private void erAddressTextFieldSug(){
        TextfieldSug ts = new TextfieldSug();
        ts.customerAddressTextFieldSug(erAddress);
    }
    
    private void erTableTextFieldSug(){
        TextfieldSug ts = new TextfieldSug();
        ts.TableIDTextfieldSug(erTable);
    }
    
    
    //////////////////////// Filtering ////////////////////////////////////
    
    @FXML
    private void ePackageSearch(javafx.scene.input.KeyEvent event) {
        
        ObservableList<Package> packageList = null;
        try {
            packageList = PackageDB.getAllRecords();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        FilteredList<Package> filterPackage = new FilteredList(packageList, e-> true);
        
        ePackageSearchTextField.textProperty().addListener((observable, oldValue, newValue) -> {
        
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
            sortedPacList.comparatorProperty().bind(ePackageList.comparatorProperty());
            ePackageList.setItems(sortedPacList);
        
        });
        
    }
    
    @FXML
    private void eReservationListSearch(javafx.scene.input.KeyEvent event) {
        
        ObservableList<EReservation> itemList = null;
        try {
            itemList = EReservationDB.getAllRecordsRL();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        FilteredList<EReservation> filterItem = new FilteredList(itemList, f-> true);
        
        erlSearch.textProperty().addListener((observable, oldValue, newValue) -> {
        
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
            sortedPacList.comparatorProperty().bind(erlReserveTable.comparatorProperty());
            erlReserveTable.setItems(sortedPacList);
        
        });
        
    }
    
    @FXML
    private void eItemSearch(javafx.scene.input.KeyEvent event) {
        
        ObservableList<Item> itemList = null;
        try {
            itemList = ItemDB.getAllRecords();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        FilteredList<Item> filterItem = new FilteredList(itemList, f-> true);
        
        eItemListSearch.textProperty().addListener((observable, oldValue, newValue) -> {
        
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
            sortedPacList.comparatorProperty().bind(eItemList.comparatorProperty());
            eItemList.setItems(sortedPacList);
        
        });
        
    }
    
    @FXML
    private void erSearch(javafx.scene.input.KeyEvent event) {
        
        ObservableList<EReservation> itemList = null;
        try {
            itemList = EReservationDB.getAllRecords();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        FilteredList<EReservation> filterItem = new FilteredList(itemList, f-> true);
        
        erSearch.textProperty().addListener((observable, oldValue, newValue) -> {
        
            filterItem.setPredicate((Predicate<? super EReservation>) (EReservation std) ->{
                
                if(newValue == null || newValue.isEmpty()){
                    return true;
                }
                
                String typetext = newValue.toLowerCase();
                
                if(String.valueOf(std.getRid()).indexOf(typetext) != -1){
                    return true;
                }
                else if(std.getRName().toLowerCase().indexOf(typetext) != -1){
                    return true;
                }
                else if(std.getRPhone().toLowerCase().indexOf(typetext) != -1){
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
                else if(String.valueOf(std.getRTotalPrice()).indexOf(typetext) != -1){
                    return true;
                }
                else if(String.valueOf(std.getRPaid()).indexOf(typetext) != -1){
                    return true;
                }
                else if(String.valueOf(std.getRDue()).indexOf(typetext) != -1){
                    return true;
                }
                else if(std.getRPayMethod().toLowerCase().indexOf(typetext) != -1){
                    return true;
                }
                
                return false;
                
            });
            
            SortedList<EReservation> sortedPacList = new SortedList<>(filterItem);
            sortedPacList.comparatorProperty().bind(eReservTable.comparatorProperty());
            eReservTable.setItems(sortedPacList);
        
        });
        
        
    }
    
    
    
    

    //////////////////////////// Order ok button /////////////////////////
    @FXML
    private void eOkOrder(ActionEvent event) {
        int order=0 ;
        String name, phone, email =" ", address=" ", payMethod="Cash";
        name = eOrderNameTextField.getText();
        phone = eOrderPhoneTextField.getText();
        phone = phone.replaceAll("\\s", "");
        email = eOrderEmailTextField.getText();
        address = eOrderAddressTextField.getText();
        
        payMethod = eOrderPayCombo.getValue();
        
        order = Integer.valueOf(eOrderOrderTextField.getText());
        
        if(name.isEmpty()){
            Alert alt = new Alert (Alert.AlertType.ERROR);
            alt.setTitle("Error");
            alt.setContentText("Please fill the Name");
            alt.showAndWait();
            
        }
        if(phone.isEmpty()){
            Alert alt = new Alert (Alert.AlertType.ERROR);
            alt.setTitle("Error");
            alt.setContentText("Please fill the Phone Number");
            alt.showAndWait();
        }
        if(order == 0){
            Alert alt = new Alert (Alert.AlertType.ERROR);
            alt.setTitle("Error");
            alt.setContentText("Please fill the order");
            alt.showAndWait();
        }
        else{
            System.out.println(name+" "+phone+" "+email+" "+address+" "+order+" "+payMethod);
            
            
            
            eOrderNameTextField.clear();
            eOrderOrderTextField.clear();
            eOrderPhoneTextField.clear();
            eOrderEmailTextField.clear();
            eOrderAddressTextField.clear();
        }
        
    }

    @FXML
    private void eClearOrder(ActionEvent event) {
        
        eOrderNameTextField.clear();
        eOrderOrderTextField.clear();
        eOrderPhoneTextField.clear();
        eOrderEmailTextField.clear();
        eOrderAddressTextField.clear();
        
    }
    
    
    
    //****************************** profile *********************************//
    
    public void profileSet(String username, String password){
        
        String query = "SELECT * FROM Employee WHERE UserName = '"+username+"'";
        ResultSet rs;
        
        EmployeeDB edb = new EmployeeDB();
        rs = edb.getProfile(query);
        
        try {
            rs.next();
            eprofileID.setText(String.valueOf(rs.getInt("E_id")));
            eprofileName.setText(rs.getString("Name"));
            eprofilePhone.setText(rs.getString("Phone"));
            eprofileEmail.setText(rs.getString("Email"));
            eprofileAddress.setText(rs.getString("Address"));
            
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        eprofileUsername.setText(username);
        eprofilePassword.setText(password);
        
    }

    
    ////////////////////////// Profile Button //////////////////////////////////
    
    @FXML
    private void eProfileUChange(ActionEvent event) {
        String username = eprofileUsername.getText();
        int e_id = Integer.valueOf(eprofileID.getText());
        String sqlu = "UPDATE Employee SET UserName= '"+username+"' WHERE E_id = '"+e_id+"'";
        
        DbConnect dbc = new DbConnect();
        dbc.executeQuery(sqlu);
        
    }
    
    @FXML
    private void ePasswordChange(ActionEvent event) {
        
        String password = eprofilePassword.getText();
        int e_id = Integer.valueOf(eprofileID.getText());
        String sqlu = "UPDATE Employee SET Password= '"+password+"' WHERE E_id = '"+e_id+"'";
        
        DbConnect dbc = new DbConnect();
        dbc.executeQuery(sqlu);
        
    }
    
    
    
    

    //////////////////////////// Reservation ok button /////////////////////////
    @FXML
    private void eReservationOk(ActionEvent event) throws SQLException {
        
        String name, phone, address, email,  rDate, rTime, payMethod;
        int numofPeople, table, price, paid;
        
        name = erName.getText();
        phone = erPhone.getText();
        phone = phone.replaceAll("\\s", "");
        address = erAddress.getText();
        email = erEmail.getText();
        numofPeople = Integer.valueOf(erNumofPeople.getText());
        table = Integer.valueOf(erTable.getText());
        rDate = erReservDate.getText();
        rTime = erReservTime.getText();
        price = Integer.valueOf(erPrice.getText());
        paid = Integer.valueOf(erPaid.getText());
        
        payMethod = erPayMethod.getValue();
        int em_id = Integer.valueOf(eprofileID.getText());
        
        if(name.isEmpty() || phone.isEmpty() || email.isEmpty() || address.isEmpty() || rDate.isEmpty() || rTime.isEmpty() || payMethod.isEmpty()){
            Alert alt = new Alert(Alert.AlertType.WARNING);
            alt.setTitle("Warning");
            alt.setContentText("Please fill all the field");
            alt.showAndWait();
            return;
        }
        if(numofPeople == 0 || table== 0 || price== 0 || paid == 0){
            Alert alt = new Alert(Alert.AlertType.WARNING);
            alt.setTitle("Warning");
            alt.setContentText("Please fill all the field");
            alt.showAndWait();
        }
        else{
            
            EReservationDB er = new EReservationDB();
            try {
                er.insertEReservation(name, phone, address, email, numofPeople, table, rDate, rTime, price, paid, payMethod, em_id);
                initializeEReservation();
                
            } catch (Exception ex) {
                //Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"Insert Unsuccessful");
            }
            
            
            System.out.println(name+" "+phone+" "+address+" "+email+" "+numofPeople+" "+table+" "+rDate+" "+rTime+" "+price+" "+paid+" "+payMethod);
            System.out.println(em_id);
            erName.clear();
            erPhone.clear();
            erAddress.clear();
            erEmail.clear();
            erNumofPeople.clear();
            erTable.clear();
            erReservDate.clear();
            erReservTime.clear();
            erPrice.clear();
            erPaid.clear();
        }
        
    }

    @FXML
    private void eReservationClear(ActionEvent event) {
        erName.clear();
        erPhone.clear();
        erAddress.clear();
        erEmail.clear();
        erNumofPeople.clear();
        erTable.clear();
        erReservDate.clear();
        erReservTime.clear();
        erPrice.clear();
        erPaid.clear();
        
    }

    

    

    

    
    
    
}
