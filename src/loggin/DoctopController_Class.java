/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loggin;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Heshan
 */
class DoctopController_Class {
    
   private StringProperty nameProperty;
   private StringProperty nicProperty;
   private StringProperty emailProperty;
   private StringProperty hospitalProperty;
   private StringProperty telephoneProperty;
   private StringProperty genderProperty;

  public DoctopController_Class(){
      
      this.nameProperty = new SimpleStringProperty();
      this.nicProperty = new SimpleStringProperty();
      this.emailProperty = new SimpleStringProperty();
      this.hospitalProperty = new SimpleStringProperty();
      this.telephoneProperty = new SimpleStringProperty();
      this.genderProperty = new SimpleStringProperty();
  }
   
     public String getName() {
        return nameProperty.get();
    }
     
     public void setName(String name) {
        this.nameProperty.set(name);
    }
     
     public StringProperty getNameProperty(){
         return nameProperty;
     }
     
      public String getNic() {
        return nicProperty.get();
    }
     
     public void setNic(String nic) {
        this.nicProperty.set(nic);
    }
     
     public StringProperty getNicProperty(){
         return nicProperty;
     }
     
      public String getEmail() {
        return emailProperty.get();
    }

     public void setEmail(String email) {
        this.emailProperty.set(email);
    }

     public StringProperty getEmailProperty(){
         return emailProperty;
     }

     public String getHospital() {
        return hospitalProperty.get();
    }

     public void setHospital(String hospital) {
        this.hospitalProperty.set(hospital);
    }

     public StringProperty getHospitalProperty(){
         return hospitalProperty;
     }

     public String getTelephone() {
        return telephoneProperty.get();
    }

     public void setTelephone(String telephone) {
        this.telephoneProperty.set(telephone);
    }

     public StringProperty getTelephoneProperty(){
         return telephoneProperty;
     }

     public String getGender() {
        return genderProperty.get();
    }

     public void setGender(String gender) {
        this.genderProperty.set(gender);
    }

     public StringProperty getGenderProperty(){
         return genderProperty;
     }
  
}
