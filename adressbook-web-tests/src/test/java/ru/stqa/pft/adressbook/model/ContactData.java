package ru.stqa.pft.adressbook.model;

public class ContactData {
  // "final" value is assigned only once
  private final String firstname;
  private final String middlename;
  private final String lastname;
  private final String address;
  private final String phone;
  private final String email;
  private String group;

  public ContactData(String firstname, String middlename, String lastname, String address, String phone, String email, String group) {
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.address = address;
    this.phone = phone;
    this.email = email;
    this.group = group;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getMiddlename() {
    return middlename;
  }

  public String getLastname() {
    return lastname;
  }

  public String getAddress() {
    return address;
  }

  public String getPhone() {
    return phone;
  }

  public String getEmail() {
    return email;
  }

  public String getGroup() {
    return group;
  }
}
