/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rfdbms_c2;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author rkana
 */
public class LoginController implements Initializable {
    @FXML
    private AnchorPane login_admin_anc;
    @FXML
    private Pane login_admin_pane;
    @FXML
    private PasswordField admin_pass;
    @FXML
    private Button admin_back;
    @FXML
    private TextField admin_user;
    @FXML
    private Button admin_login;
    @FXML
    private AnchorPane login_stuff_anc;
    @FXML
    private Pane login_stuff_pane;
    @FXML
    private TextField stuff_user;
    @FXML
    private Label login_as;
    @FXML
    private PasswordField stuff_pass;
    @FXML
    private Button stuff_login;
    @FXML
    private Button stuff_back;
    @FXML
    private AnchorPane login_as_anc;
    @FXML
    private Pane login_as_pane;
    @FXML
    private Button admin_login_btn;
    @FXML
    private Button stuff_login_btn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
             
        if(event.getSource() == admin_login_btn){
            
            login_admin_anc.toFront();
            
        }else if(event.getSource() == stuff_login_btn){
            
            login_stuff_anc.toFront();
            
        }else if(event.getSource() == admin_back){
            
            login_as_anc.toFront();
            
        }else if(event.getSource() == stuff_back){
            
            login_as_anc.toFront();
            
        }else if(event.getSource() == admin_login){
            String admin_username = admin_user.getText();
            String admin_password = admin_pass.getText();
            admin_user.clear();
            admin_pass.clear();
            
            ResultSet resultSet;
            DbConnect DbC = new DbConnect();
            String query="SELECT * FROM Admin WHERE UserName='"+admin_username+"'";
            
            try {
                resultSet = DbC.readDatabase(query);
                resultSet.next();
                if(resultSet.getString("UserName").equalsIgnoreCase(admin_username) && resultSet.getString("Password").equalsIgnoreCase(admin_password)){
                    System.out.println("LOGIN SUCCESSFUL");

                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Admin.fxml"));
                        Parent root1 = (Parent) fxmlLoader.load();
                        
                        AdminController ec = fxmlLoader.getController();
                        ec.profileSet(admin_username, admin_password);
                        
                        Stage stage = new Stage();
                        stage.setTitle("ADMIN");
                        stage.setScene(new Scene(root1));
                        stage.show();

                    } catch (Exception e) {
                        System.out.println(e);
                        Alert alt = new Alert(Alert.AlertType.WARNING);
                        alt.setTitle("Warning");
                        alt.setContentText("Something went wrong.");
                        alt.showAndWait();
                    }
                    
                }else{
                    System.out.println("LOGIN UNSUCCESSFUL");

                    Alert alt = new Alert(Alert.AlertType.WARNING);
                    alt.setTitle("Warning");
                    alt.setContentText("Wrong username and password");
                    alt.showAndWait();
                }
            } catch (SQLException ex) {
                
                //Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                Alert alt = new Alert (Alert.AlertType.ERROR);
                alt.setTitle("Error");
                alt.setContentText("Database is not responding");
                alt.showAndWait();
            }
           
            
        }else if(event.getSource() == stuff_login){
            String stuff_username = stuff_user.getText();
            String stuff_password = stuff_pass.getText();
            stuff_user.clear();
            stuff_pass.clear();
            
            ResultSet resultSet;
            DbConnect DbC = new DbConnect();
            String query="SELECT * FROM Employee WHERE UserName='"+stuff_username+"'";
            
            try {
                resultSet = DbC.readDatabase(query);
                resultSet.next();
                if(resultSet.getString("UserName").equalsIgnoreCase(stuff_username) && resultSet.getString("Password").equalsIgnoreCase(stuff_password)){
                    System.out.println("LOGIN SUCCESSFUL");
                    

                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Employee.fxml"));
                        Parent root1 = (Parent) fxmlLoader.load();
                        
                        EmployeeController ec = fxmlLoader.getController();
                        ec.profileSet(stuff_username, stuff_password);
                        
                        Stage stage = new Stage();
                        stage.setTitle("STUFF");
                        stage.setScene(new Scene(root1));
                        stage.show();

                    } catch (Exception e) {
                        System.out.println(e);
                        Alert alt = new Alert(Alert.AlertType.WARNING);
                        alt.setTitle("Warning");
                        alt.setContentText("Couldn't load fxml file");
                        alt.showAndWait();
                    }
                    
                }else{
                    System.out.println("LOGIN UNSUCCESSFUL");

                    Alert alt = new Alert(Alert.AlertType.WARNING);
                    alt.setTitle("Warning");
                    alt.setContentText("Wrong username and password");
                    alt.showAndWait();
                }
            } catch (SQLException ex) {
                System.out.println(ex);
                
                //Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                /*Alert alt = new Alert (Alert.AlertType.ERROR);
                alt.setTitle("Error");
                alt.setContentText("Database is not responding");
                alt.showAndWait();*/
            }
           
        }
        
    }
    
}
