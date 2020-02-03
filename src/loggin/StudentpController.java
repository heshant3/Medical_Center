/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loggin;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
import org.controlsfx.control.textfield.TextFields;

/**
 * FXML Controller class
 *
 * @author Heshan
 */
public class StudentpController implements Initializable {

    @FXML
    private JFXTextField txtName;
    @FXML
    private JFXTextField txtRegNo;
    @FXML
    private JFXRadioButton radMale;
    @FXML
    private ToggleGroup gender;
    @FXML
    private JFXRadioButton radFemale;
    @FXML
    private JFXTextField txtEmail;
    @FXML
    private JFXTextField txtTelephone;
    @FXML
    private JFXComboBox<String> txtFaculty;
    ObservableList<String> Facultylist = FXCollections.observableArrayList("Faculty of Applied Sciences", "Faculty of Agriculture", "Faculty of Management Studies", "Faculty of Medical and Allied Sciecnes", "Faculty of Social Sciences and Humanities", "Faculty of Technology");
    @FXML
    private JFXDatePicker txtDOB;
    @FXML
    private JFXTextArea txtAllergies;
    @FXML
    private JFXTextArea txtOperations;
    @FXML
    private JFXTextArea txtOther;
    @FXML
    private JFXTextField txtSearchh;
    
    @FXML
    private void resetFields() {
        txtName.setText(null);
        txtRegNo.setText(null);
        txtTelephone.setText(null);
        txtEmail.setText(null);
       // txtFaculty.setSelectionModel(null);
        txtDOB.setValue(null);
        txtAllergies.setText(null);
        txtOperations.setText(null);
        txtOther.setText(null);
        gender.selectToggle(null);
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtFaculty.setValue("Faculty of Applied Sciences");
       txtFaculty.setItems(Facultylist);
      //  TextField.bindAutoComp
      // txtDOB.getValue();
       Ss();
      
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
    
    
      // get a list of doctors from mysql database
    public ObservableList<Student_Class> getStudentList(){
       ObservableList<Student_Class> studentlist = FXCollections.observableArrayList();
        Connection connection = getConnection();
        String query = "SELECT * FROM `pat`";
        Statement st;
        ResultSet rs;
        
        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);

            while(rs.next()){
              Student_Class stu = new Student_Class();
              stu.setName(rs.getString("name"));
              stu.setRegNo(rs.getString("regno"));
              stu.setEmail(rs.getString("email"));
              stu.setDate(rs.getString("date"));
              stu.setFaculty(rs.getString("faculty"));
              stu.setTelephone(rs.getString("telephone"));
              stu.setGender(rs.getString("gender"));
              stu.setAllergies(rs.getString("allergies"));
              stu.setOperation(rs.getString("operations"));
              stu.setOther(rs.getString("other"));
              studentlist.add(stu); 
              
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentlist;
        
    }
    
    
    public void Ss(){
        
        Student_Class stu = new Student_Class();
        TextFields.bindAutoCompletion(txtSearchh,"qqq");
      
    }

    @FXML
    private void btnSave(MouseEvent event) {
        
                //Gender Selection
        String gn = "Female";
        if (!radFemale.isSelected()){
            gn = "Male";
        } 
       
        //save database Selection
       String query = "INSERT INTO `testde`.`pat` (`name`,`regno`,`email`,`date`,`faculty`,`telephone`, `gender`, `allergies` , `operations` , `other`) VALUES ('"+txtName.getText()+"', '"+txtRegNo.getText()+"', '"+txtEmail.getText()+"', '"+txtDOB.getValue()+"', '"+txtFaculty.getSelectionModel().getSelectedItem() +"', '"+txtTelephone.getText()+"', '"+gn+"', '"+txtAllergies.getText()+"', '"+txtOperations.getText()+"' , '"+txtOther.getText()+"')";
        executeSqlQuery(query, "Saved");
        resetFields();
       // showDoctorTable();
    }

    @FXML
    private void btmDelete(MouseEvent event) {
    }

    @FXML
    private void btmUpdate(MouseEvent event) {
    }

    @FXML
    private void btnUpdate(ActionEvent event) {
    }


    
    
}
