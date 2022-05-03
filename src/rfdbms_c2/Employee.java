
package rfdbms_c2;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Employee {
    
    private IntegerProperty e_id;
    private StringProperty name;
    private StringProperty username;
    private StringProperty password;
    private StringProperty phone;
    private StringProperty email;
    private StringProperty address;
    private IntegerProperty a_id;
    
    public Employee(){
        this.e_id = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty();
        this.username = new SimpleStringProperty();
        this.password = new SimpleStringProperty();
        this.phone = new SimpleStringProperty();
        this.email = new SimpleStringProperty();
        this.address = new SimpleStringProperty();
        this.a_id = new SimpleIntegerProperty();
    }

    public IntegerProperty getE_id() {
        return e_id;
    }
    
    public int getEmployeeId(){
        return e_id.get();
    }
    
    public void setEmployeeId(int e_id){
        this.e_id.set(e_id);
    }
    

    public StringProperty getName() {
        return name;
    }
    
    public String getEmployeeName(){
        return name.get();
    }
    
    public void setEmployeeName(String name){
        this.name.set(name);
    }
    

    public StringProperty getUsername() {
        return username;
    }
    
    public String getEmployeeUsername(){
        return username.get();
    }
    
    public void setEmployeeUsername(String username){
        this.username.set(username);
    }
    

    public StringProperty getPassword() {
        return password;
    }
    
    public String getEmployeePassword(){
        return password.get();
    }
    
    public void setEmployeePassword(String password){
        this.password.set(password);
    }
    

    public StringProperty getPhone() {
        return phone;
    }
    
    public String getEmployeePhone(){
        return phone.get();
    }
    
    public void setEmployeePhone(String phone){
        this.phone.set(phone);
    }
    

    public StringProperty getEmail() {
        return email;
    }
    
    public String getEmployeeEmail(){
        return email.get();
    }
    
    public void setEmployeeEmail(String email){
        this.email.set(email);
    }
    

    public StringProperty getAddress() {
        return address;
    }
    
    public String getEmployeeAddress(){
        return address.get();
    }
    
    public void setEmployeeAddress(String address){
        this.address.set(address);
    }
    

    public IntegerProperty getA_id() {
        return a_id;
    }
    
    public int getEmployeeA_id(){
        return a_id.get();
    }
    
    public void setEmployeeA_id(int a_id){
        this.a_id.set(a_id);
    }
    
    
    
    
}
