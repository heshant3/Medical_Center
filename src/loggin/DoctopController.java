/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loggin;

import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import org.controlsfx.control.textfield.TextFields;


/**
 * FXML Controller class
 *
 * @author Heshan
 */
public class DoctopController implements Initializable {

    @FXML
    private JFXTextField txtName;
    @FXML
    private JFXTextField txtNic;
    @FXML
    private JFXTextField txtHospital;
    @FXML
    private JFXTextField txtEmail;
    @FXML
    private JFXTextField txtTelephone;
    @FXML
    private JFXRadioButton radMale;
    @FXML
    private ToggleGroup gender;
    @FXML
    private JFXRadioButton radFemale;
    @FXML
    private TableView<DoctopController_Class> jTable_Display_Doctor;
    @FXML
    private TableColumn<DoctopController_Class, String> tableName;
    @FXML
    private TableColumn<DoctopController_Class, String> tableNic;
    @FXML
    private TableColumn<DoctopController_Class, String> tableEmail;

    //reset the fields
    @FXML
    public void resetFields(){
        txtName.setText(null);
        txtNic.setText(null);
        txtTelephone.setText(null);
        txtEmail.setText(null);
        txtHospital.setText(null);
        gender.selectToggle(null);
    }
    
    
    
    public Connection getConnection(){
        Connection conn;
        try {
            conn = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql:///testde","root","");
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
   // get a list of doctors from mysql database
    public ObservableList<DoctopController_Class> getDoctorList(){
       ObservableList<DoctopController_Class> doctorlist = FXCollections.observableArrayList();
        Connection connection = getConnection();
        String query = "SELECT * FROM `doc`";
        Statement st;
        ResultSet rs;
        
        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);

            while(rs.next()){
              DoctopController_Class doc = new DoctopController_Class();
              doc.setName(rs.getString("name"));
              doc.setNic(rs.getString("nic"));
              doc.setEmail(rs.getString("email"));
              doc.setHospital(rs.getString("hospital"));
              doc.setTelephone(rs.getString("telephone"));
              doc.setGender(rs.getString("gender"));
              doctorlist.add(doc); 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doctorlist;
    }
    
    public void executeSqlQuery(String query, String message){
        Connection conn = getConnection();
        Statement st;
        try {
            st = conn.createStatement();
            if((st.executeUpdate(query)) == 1){
                JOptionPane.showMessageDialog(null, "Data " + message+ " Successfully ");
            }else{
                JOptionPane.showMessageDialog(null, "Data Not "+message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showDoctorTable();
        
    }  
    
     //Display data in jTable
    public void showDoctorTable(){
       tableName.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
       tableNic.setCellValueFactory(cellData -> cellData.getValue().getNicProperty());
       tableEmail.setCellValueFactory(cellData -> cellData.getValue().getEmailProperty());
       ObservableList<DoctopController_Class> doctorlist = getDoctorList();
       populateTable(doctorlist);
    }
    
    
    public void populateTable(ObservableList<DoctopController_Class>doctorlist){
        jTable_Display_Doctor.setItems(doctorlist);
    }
    
   
    
    //save database Button
    @FXML
    private void btnSave(MouseEvent event) {
        
        //Gender Selection
        String gn = "Female";
        if (!radFemale.isSelected()){
            gn = "Male";
        } 
        //save database Selection
        String query = "INSERT INTO `testde`.`doc` (`name`,`nic`,`email`,`hospital`,`telephone`, `gender`) VALUES ('"+txtName.getText()+"', '"+txtNic.getText()+"', '"+txtEmail.getText()+"', '"+txtHospital.getText()+"', '"+txtTelephone.getText()+"', '"+gn+"')";
        executeSqlQuery(query, "Saved");
        resetFields();
        showDoctorTable();
    }

    @FXML
    private void deletebtm(MouseEvent event) {
        String query = "DELETE FROM `testde`.`doc`  WHERE name = '"+txtName.getText()+"'";
        executeSqlQuery(query, "Deleted");
         resetFields();
         showDoctorTable();
    }

    @FXML
    private void onmouseclick(MouseEvent event) {
        resetFields();
        ObservableList<DoctopController_Class> doctorlist = FXCollections.observableArrayList();
        Connection connection = getConnection();
        String query = "SELECT * FROM `doc`";
        Statement st;
        ResultSet rs;
        
        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);

            while(rs.next()){
             // DoctopController_Class doc = new DoctopController_Class();
              txtName.setText(rs.getString("name"));
              txtNic.setText(rs.getString("nic"));
              txtTelephone.setText(rs.getString("telephone"));
              txtEmail.setText(rs.getString("email"));
              txtHospital.setText(rs.getString("hospital"));
        if(null !=rs.getString("gender")) switch (rs.getString("gender")){

          case "Male":
             radMale.setSelected(true);
             break;

          case "Female":
             radFemale.setSelected(true);
             break;
             default:
            radMale.setSelected(false);
            radFemale.setSelected(false);
            break;
        }

        else {
          radMale.setSelected(false);
          radFemale.setSelected(false);
        }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @FXML
    private void btnUpdate(ActionEvent event) {
                //Gender Selection
        String gn = "Female";
        if (!radFemale.isSelected()){
            gn = "Male";
        } 
        String query = "UPDATE `testde`.`doc` SET `name` ='"+txtName.getText()+"',`nic` ='"+txtNic.getText()+"',`telephone` ='"+txtTelephone.getText()+"',`email` ='"+txtEmail.getText()+"',`hospital` ='"+txtHospital.getText()+"',`gender` ='"+gn+"'";
        executeSqlQuery(query, "Updated");
         resetFields();
         showDoctorTable();
    }
    
    
}