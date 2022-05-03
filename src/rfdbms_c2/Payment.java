/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rfdbms_c2;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author rkana
 */
public class Payment {
    
    private IntegerProperty p_id;
    private IntegerProperty total_price;
    private StringProperty method;
    private IntegerProperty paid;
    private IntegerProperty  due;
    private StringProperty p_date;
    private StringProperty  p_time;

 
    public Payment(){
        this.p_id = new SimpleIntegerProperty();
        this.total_price = new SimpleIntegerProperty();
        this.method = new SimpleStringProperty();
        this.paid = new SimpleIntegerProperty();
        this.due = new SimpleIntegerProperty();
        this.p_date = new SimpleStringProperty();
        this.p_time = new SimpleStringProperty();
    }

    public IntegerProperty getP_id() {
        return p_id;
    }
     public int getPaymentId(){
        return p_id.get();
    }
    
    public void setPaymentId(int p_id){
        this.p_id.set(p_id);
    }
    

    public IntegerProperty getTotal_price() {
        return total_price;
    }
     public int getTotalPrice(){
        return total_price.get();
    }
    
    public void setTotalPrice(int total_price){
        this.total_price.set(total_price);
    }
    

    public StringProperty getMethod() {
        return method;
    }
    public String getPaymentMethod(){
        return method.get();
    }
    
    public void setPaymentMethod(String method){
        this.method.set(method);
    }
    

    public IntegerProperty getPaid() {
        return paid;
    }
 public int getPaymentPaid(){
        return paid.get();
    }
    
    public void setPaymentPaid(int paid){
        this.paid.set(paid);
    }
    
    public IntegerProperty getDue() {
        return due;
    }
     public int getPaymentDue(){
        return due.get();
    }
    
    public void setPaymentDue(int due){
        this.due.set(due);
    }
    

    public StringProperty getP_date() {
        return p_date;
    }
    public String getPaymentDate(){
        return p_date.get();
    }
    
    public void setPaymentDate(String p_date){
        this.p_date.set(p_date);
    }
    

    public StringProperty getP_time() {
        return p_time;
    }

   public String getPaymentTime(){
        return p_time.get();
    }
    
    public void setPaymentTime(String p_time){
        this.p_time.set(p_time);
    }
    
}
