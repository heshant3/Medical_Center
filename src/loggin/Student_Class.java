/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loggin;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Heshan
 */
 class Student_Class {
    
   private StringProperty nameProperty;
   private StringProperty regnoProperty;
   private StringProperty emailProperty;
   private StringProperty dateProperty;
   private StringProperty facultyProperty;
   private StringProperty telephoneProperty;
   private StringProperty genderProperty;
   private StringProperty allergiesProperty;
   private StringProperty operationsProperty;
   private StringProperty otherProperty;
    
   
   public Student_Class() {
    
      this.nameProperty = new SimpleStringProperty();
      this.regnoProperty = new SimpleStringProperty();
      this.emailProperty = new SimpleStringProperty();
      this.dateProperty = new SimpleStringProperty();
      this.facultyProperty = new SimpleStringProperty();
      this.telephoneProperty = new SimpleStringProperty();
      this.genderProperty = new SimpleStringProperty();
      this.allergiesProperty = new SimpleStringProperty();
      this.operationsProperty = new SimpleStringProperty();
      this.otherProperty = new SimpleStringProperty();
      
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
     
      public String getRegNo() {
        return regnoProperty.get();
    }
     
     public void setRegNo(String regno) {
        this.regnoProperty.set(regno);
    }
     
     public StringProperty getRegNoProperty(){
         return regnoProperty;
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

     public String getDate() {
        return dateProperty.get();
    }

     public void setDate(String date) {
        this.dateProperty.set(date);
    }

     public StringProperty getDateProperty(){
         return dateProperty;
     }
     
     public String getFaculty() {
        return facultyProperty.get();
    }

     public void setFaculty(String faculty) {
        this.facultyProperty.set(faculty);
    }

     public StringProperty getFacultyProperty(){
         return facultyProperty;
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
     
      public String getAllergies() {
        return allergiesProperty.get();
    }

     public void setAllergies(String gender) {
        this.allergiesProperty.set(gender);
    }

     public StringProperty getAllergiesProperty(){
         return allergiesProperty;
     }
     
      public String getOperation() {
        return operationsProperty.get();
    }

     public void setOperation(String operations) {
        this.operationsProperty.set(operations);
    }

     public StringProperty getOperationProperty(){
         return operationsProperty;
     }
     
      public String getOther() {
        return otherProperty.get();
    }

     public void setOther(String other) {
        this.otherProperty.set(other);
    }

     public StringProperty getOtherProperty(){
         return otherProperty;
     }
      
   
 }
    

