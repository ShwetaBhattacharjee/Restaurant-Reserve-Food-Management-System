
package rfdbms_c2;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Item {
    //I_id, Name, Price, Quantity, Status
    
    private IntegerProperty i_id;
    private StringProperty name;
    private IntegerProperty price;
    private IntegerProperty quantity;
    private IntegerProperty status;
    
    public Item(){
        this.i_id = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty();
        this.price = new SimpleIntegerProperty();
        this.quantity = new SimpleIntegerProperty();
        this.status = new SimpleIntegerProperty();
    }

    public IntegerProperty getI_id() {
        return i_id;
    }
    
    public int getItemId(){
        return i_id.get();
    }
    
    public void setItemId(int i_id){
        this.i_id.set(i_id);
    }
    

    public StringProperty getIName() {
        return name;
    }
    
    public String getItemName(){
        return name.get();
    }
    
    public void setItemName(String name){
        this.name.set(name);
    }
    

    public IntegerProperty getIPrice() {
        return price;
    }
    
    public int getItemPrice(){
        return price.get();
    }
    
    public void setItemPrice(int price){
        this.price.set(price);
    }
    

    public IntegerProperty getIQuantity() {
        return quantity;
    }
    
    public int getItemQuantity(){
        return quantity.get();
    }
    
    public void setItemQuantity(int quantity){
        this.quantity.set(quantity);
    }
    

    public IntegerProperty getIStatus() {
        return status;
    }
    
    public int getItemStatus(){
        return status.get();
    }
    
    public void setItemStatus(int status){
        this.status.set(status);
    }
    
    
}
