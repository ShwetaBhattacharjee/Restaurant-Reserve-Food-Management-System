
package rfdbms_c2;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Package {
    //P_id ,Name, Price, Description, Status
    
    private IntegerProperty p_id;
    private StringProperty name;
    private IntegerProperty price;
    private StringProperty description;
    private IntegerProperty status;
    
    public Package(){
        this.p_id = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty();
        this.price = new SimpleIntegerProperty();
        this.description = new SimpleStringProperty();
        this.status = new SimpleIntegerProperty();
    }

    public IntegerProperty getP_id() {
        return p_id;
    }
    
    public int getPackageId(){
        return p_id.get();
    }
    public void setPackageId(int p_id){
        this.p_id.set(p_id);
    }
    

    public StringProperty getName() {
        return name;
    }
    
    public String getPackageName(){
        return name.get();
    }
    
    public void setPackageName(String name){
        this.name.set(name);
    }
    

    public IntegerProperty getPrice() {
        return price;
    }
    public int getPackagePrice(){
        return price.get();
    }
    public void setPackagePrice(int price){
        this.price.set(price);
    }
    

    public StringProperty getDescription() {
        return description;
    }
    
    public String getPackageDescription(){
        return description.get();
    }
    
    public void setPackageDescription(String description){
        this.description.set(description);
    }
    

    public IntegerProperty getStatus() {
        return status;
    }
    
    public int getPackageStatus(){
        return status.get();
    }
    
    public void setPackageStatus(int status){
        this.status.set(status);
    }

    
    
    
    
}
