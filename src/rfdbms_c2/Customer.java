
package rfdbms_c2;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Customer {
    
    private IntegerProperty c_id;
    private StringProperty name;
    private StringProperty phone;
    private StringProperty email;
    private StringProperty address;
    
    
    public Customer(){
        this.c_id = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty();
        this.phone = new SimpleStringProperty();
        this.email = new SimpleStringProperty();
        this.address = new SimpleStringProperty();
    }

    public IntegerProperty getC_id() {
        return c_id;
    }
    
     public int getCustomerId(){
        return c_id.get();
    }
    
    public void setCustomerId(int c_id){
        this.c_id.set(c_id);
    }

    public StringProperty getName() {
        return name;
    }

    public String getCustomerName(){
        return name.get();
    }
    
    public void setCustomerName(String name){
        this.name.set(name);
    }
    
    
    public StringProperty getPhone() {
        return phone;
    }
    
     public String getCustomerPhone(){
        return phone.get();
    }
    
    public void setCustomerPhone(String phone){
        this.phone.set(phone);
    }

    public StringProperty getEmail() {
        return email;
    }
    
    public String getCustomerEmail(){
        return email.get();
    }
    
    public void setCustomerEmail(String email){
        this.email.set(email);
    }

    public StringProperty getAddress() {
        return address;
    }
    
    public String getCustomerAddress(){
        return address.get();
    }
    
    public void setCustomerAddress(String address){
        this.address.set(address);
    }
    
}
