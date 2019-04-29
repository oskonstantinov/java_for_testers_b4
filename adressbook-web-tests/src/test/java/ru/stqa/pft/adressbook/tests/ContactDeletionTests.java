package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase{

  @Test
  public void testContactDeletion() {
    if (! app.getContactHelper().isThereAContact()) {
      app.getNavigationHelper().gotoContactCreation();
      app.getContactHelper().createContact(new ContactData("Oleg", "Sergeevich"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().initContactDeletion();
    app.getContactHelper().submitContactDeletion();
    app.getNavigationHelper().gotoHomeOnTab();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);
  }
}
