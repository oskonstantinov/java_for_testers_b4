package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase{

  @Test
  public void testContactDeletion() {
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactDeletion();
    app.getContactHelper().submitContactDeletion();
  }
}
