package ru.stqa.pft.adressbook.tests;

import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.Contacts;
import ru.stqa.pft.adressbook.model.GroupData;
import ru.stqa.pft.adressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactToGroupTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.db().groups().size() == 0) {
      app.group().create(new GroupData().withName("test1"));
    }
    app.goTo().homeOnTab();
    if (app.db().contacts().size() == 0) {
      Groups groups = app.db().groups();
      app.goTo().contactCreation();
      app.contact().create(new ContactData().withFirstname("Oleg")
              .withLastname("Konstantinov")
              .withAddress("TestAddress, home№0")
              .withHomePhone("+74732111110")
              .withEmail("ab@cd.f0")
              .inGroup(groups.iterator().next()));
    }
  }

  @Test
  public void testAddContactToGroup() throws InterruptedException {
    Contacts before = app.db().contacts();
    ContactData selectedContact = before.iterator().next();
    app.contact().addToGroup(selectedContact);
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.withAdded(selectedContact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
                                  // withAdded(selectedContact.inGroup(after.stream().mapToLong((c) -> c.getId()).max().getAsLong()))));
  }

  @Test
  public void testDeleteContactFromGroup() {
    app.contact().goIntoSelectedGroup();
    Contacts before = app.db().contacts();
    ContactData removedContact = before.iterator().next();
    app.contact().removeFromGroup(removedContact);
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(removedContact)));
  }
}
