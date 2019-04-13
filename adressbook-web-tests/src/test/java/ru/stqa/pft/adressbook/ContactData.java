package ru.stqa.pft.adressbook;

public class ContactData {
  private final String firstname;
  private final String middlename;
  private final String lastname;
  private final String adress;
  private final String phone;
  private final String email;

  public ContactData(String firstname, String middlename, String lastname, String adress, String phone, String email) {
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.adress = adress;
    this.phone = phone;
    this.email = email;
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

  public String getAdress() {
    return adress;
  }

  public String getPhone() {
    return phone;
  }

  public String getEmail() {
    return email;
  }
}
