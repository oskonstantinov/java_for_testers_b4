package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.GroupData;
import ru.stqa.pft.adressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
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
  public void testAddContactToGroup() {
    ContactData selectedContact = app.db().contacts().iterator().next();
    GroupData currentGroup = app.db().groups().iterator().next();
    Groups groupsBefore = selectedContact.getGroups();
    if (groupsBefore.size() < app.db().groups().size()) {
      app.contact().addToGroup(selectedContact, currentGroup);
    }
    ContactData updatedContact = app.db().contacts().iterator().next().inGroup(currentGroup);
    Groups groupsAfter = updatedContact.getGroups();
    assertThat(groupsAfter, equalTo(groupsBefore.withAdded(currentGroup)));
  }

  @Test
  public void testDeleteContactFromGroup() {
    GroupData currentGroup = app.db().groups().iterator().next();
    app.contact().goIntoSelectedGroup(currentGroup);
    ContactData removedContact = app.db().contacts().iterator().next();
    Integer contactId = removedContact.getId();
    Groups groupsBefore = removedContact.getGroups();
    if (groupsBefore.size() > 0) {
      app.contact().removeFromGroup(removedContact);
    }
    ContactData updatedContact = app.db().contacts().iterator().next().withId(contactId);
    Groups groupsAfter = updatedContact.getGroups();
    assertThat(groupsAfter, equalTo(groupsBefore.without(currentGroup)));
  }
}
