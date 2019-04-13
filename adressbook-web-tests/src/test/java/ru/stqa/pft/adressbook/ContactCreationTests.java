package ru.stqa.pft.adressbook;

import org.testng.annotations.*;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    gotoContactCreation();
    fillContactForm(new ContactData("Oleg", "Sergeevich", "Konstantinov", "Test sample address", "+71111111111", "abc@def.g"));
    submitContactCreation();
    gotoHomePage();
  }
}
