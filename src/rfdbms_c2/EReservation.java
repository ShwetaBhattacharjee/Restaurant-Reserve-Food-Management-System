
package rfdbms_c2;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class EReservation {
    
    private IntegerProperty reserv_id;
    private StringProperty name;
    private StringProperty phone;
    private IntegerProperty numofPeope;
    private IntegerProperty table_id;
    private IntegerProperty numofTable;
    private StringProperty reservDate;
    private StringProperty reservTime;
    private StringProperty time;
    private StringProperty date;
    private IntegerProperty totalPrice;
    private IntegerProperty paid;
    private IntegerProperty due;
    private StringProperty payMethod;
    
    public EReservation(){
        this.reserv_id = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty();
        this.phone = new SimpleStringProperty();
        this.numofPeope = new SimpleIntegerProperty();
        this.table_id = new SimpleIntegerProperty();
        this.numofTable = new SimpleIntegerProperty();
        this.reservDate = new SimpleStringProperty();
        this.reservTime = new SimpleStringProperty();
        this.time = new SimpleStringProperty();
        this.date = new SimpleStringProperty();
        this.totalPrice = new SimpleIntegerProperty();
        this.paid = new SimpleIntegerProperty();
        this.due = new SimpleIntegerProperty();
        this.payMethod = new SimpleStringProperty();
    }

    public IntegerProperty getReserv_id() {
        return reserv_id;
    }
    
    public int getRid(){
        return reserv_id.get();
    }
    
    public void setRid(int reserv_id){
        this.reserv_id.set(reserv_id);
    }
    

    public StringProperty getName() {
        return name;
    }
    
    public String getRName(){
        return name.get();
    }
    
    public void setRName(String name){
        this.name.set(name);
    }
    

    public StringProperty getPhone() {
        return phone;
    }
    
    public String getRPhone(){
        return phone.get();
    }
    
    public void setRPhone(String phone){
        this.phone.set(phone);
    }
    

    public IntegerProperty getNumofPeope() {
        return numofPeope;
    }
    
    public int getRNumofPeope(){
        return numofPeope.get();
    }
    
    public void setRNumofPeope(int numofPeope){
        this.numofPeope.set(numofPeope);
    }
    

    public IntegerProperty getTable_id() {
        return table_id;
    }
    
    public int getRTable_id(){
        return table_id.get();
    }
    
    public void setRTable_id(int table_id){
        this.table_id.set(table_id);
    }
    

    public IntegerProperty getNumofTable() {
        return numofTable;
    }
    
    public int getRNumofTable(){
        return numofTable.get();
    }
    
    public void setRNumofTable(int numofTable){
        this.numofTable.set(numofTable);
    }
    

    public StringProperty getReservDate() {
        return reservDate;
    }
    
    public String getRReservDate(){
        return reservDate.get();
    }
    
    public void setRReservDate(String reservDate){
        this.reservDate.set(reservDate);
    }
    

    public StringProperty getReservTime() {
        return reservTime;
    }
    
    public String getRReservTime(){
        return reservTime.get();
    }
    
    public void setRReservTime(String reservTime){
        this.reservTime.set(reservTime);
    }
    

    public StringProperty getTime() {
        return time;
    }
    
    public String getRTime(){
        return time.get();
    }
    
    public void setRTime(String time){
        this.time.set(time);
    }
    

    public StringProperty getDate() {
        return date;
    }
    
    public String getRDate(){
        return date.get();
    }
    
    public void setRDate(String date){
        this.date.set(date);
    }
    

    public IntegerProperty getTotalPrice() {
        return totalPrice;
    }
    
    public int getRTotalPrice(){
        return totalPrice.get();
    }
    
    public void setRTotalPrice(int totalPrice){
        this.totalPrice.set(totalPrice);
    }
    

    public IntegerProperty getPaid() {
        return paid;
    }
    
    public int getRPaid(){
        return paid.get();
    }
    
    public void setRPaid(int paid){
        this.paid.set(paid);
    }
    

    public IntegerProperty getDue() {
        return due;
    }
    
    public int getRDue(){
        return due.get();
    }
    
    public void setRDue(int due){
        this.due.set(due);
    }
    

    public StringProperty getPayMethod() {
        return payMethod;
    }
    
    public String getRPayMethod(){
        return payMethod.get();
    }
    
    public void setRPayMethod(String payMethod){
        this.payMethod.set(payMethod);
    }
    
    
    
}
