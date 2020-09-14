package com.companyname.projectname;

public User implements Serializable {

 /** Serial Version UID. */
 private static final long serialVersionUID = 1L;

 private int id;
 private String firstName;
 private String lastName;
 private LocalDate dob;

 public int getId () {
     return this.id;
 }

 public void setId (int id) {
     this.id = id;
 }
 public String getFirstName () {
     return this.firstName;
 }

 public void setFirstName (String firstName) {
     this.firstName = firstName;
 }
 public String getLastName () {
     return this.lastName;
 }

 public void setLastName (String lastName) {
     this.lastName = lastName;
 }
 public LocalDate getDob () {
     return this.dob;
 }

 public void setDob (LocalDate dob) {
     this.dob = dob;
 }
}