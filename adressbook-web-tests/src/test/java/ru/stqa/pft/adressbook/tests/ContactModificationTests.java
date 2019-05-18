package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.goTo().contactCreation();
      app.contact().create(new ContactData().withFirstname("Oleg")
                                            .withLastname("Konstantinov")
                                            .withAddress("TestAddress, home№0")
                                            .withHomePhone("+74732111110")
                                            .withEmail("ab@cd.f0")
                                            .withGroup("test3"));
    }
  }

  @Test
  public void testContactModification() {
    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId())
                                           .withFirstname("Test")
                                           .withLastname("Testtantinov")
                                           .withAddress("Address, home№1")
                                           .withHomePhone("+7473214642610")
                                           .withEmail("hr@.jk.f0");
    app.contact().modify(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    verifyContactListInUI();
  }
}
