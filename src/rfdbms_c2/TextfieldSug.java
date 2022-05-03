
package rfdbms_c2;

import java.util.ArrayList;
import javafx.scene.control.TextField;
import org.controlsfx.control.textfield.TextFields;

/**
 *
 * @author rkana
 */
public class TextfieldSug {
    
    
    public void customerNameTextFieldSug(TextField eOrderNameTextField){
        DbConnect db = new DbConnect();
        ArrayList datalist = new ArrayList();
        
        String sql = "SELECT * FROM Customer";
        String columnName = "Name";
        
        datalist = db.getArrayData(sql, columnName);
        
        TextFields.bindAutoCompletion(eOrderNameTextField, datalist);
    }
    
    public void customerPhoneTextFieldSug(TextField PhoneTextField){
        DbConnect db = new DbConnect();
        ArrayList datalist = new ArrayList();
        
        String sql = "SELECT * FROM Customer";
        String columnName = "Phone";
        
        datalist = db.getArrayData(sql, columnName);
        
        TextFields.bindAutoCompletion(PhoneTextField, datalist);
    }
    
    public void customerEmailTextFieldSug(TextField EmailTextField){
        DbConnect db = new DbConnect();
        ArrayList datalist = new ArrayList();
        
        String sql = "SELECT * FROM Customer";
        String columnName = "Email";
        
        datalist = db.getArrayData(sql, columnName);
        
        TextFields.bindAutoCompletion(EmailTextField, datalist);
    }
    
    public void customerAddressTextFieldSug(TextField AddressTextField){
        DbConnect db = new DbConnect();
        ArrayList datalist = new ArrayList();
        
        String sql = "SELECT * FROM Customer";
        String columnName = "Address";
        
        datalist = db.getArrayData(sql, columnName);
        
        TextFields.bindAutoCompletion(AddressTextField, datalist);
    }
    
    
    public void TableIDTextfieldSug(TextField tableIdTextField){
        DbConnect db = new DbConnect();
        ArrayList datalist = new ArrayList();
        
        String sql = "SELECT * FROM TableT";
        String columnName = "T_id";
        
        datalist = db.getArrayData(sql, columnName);
        
        TextFields.bindAutoCompletion(tableIdTextField, datalist);
        
    }
    
}
