package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.adressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.gotoContactCreation();
    app.fillContactForm(new ContactData("Oleg", "Sergeevich", "Konstantinov", "Test sample address", "+71111111111", "abc@def.g"));
    app.submitContactCreation();
    app.gotoHomePage();
  }
}
