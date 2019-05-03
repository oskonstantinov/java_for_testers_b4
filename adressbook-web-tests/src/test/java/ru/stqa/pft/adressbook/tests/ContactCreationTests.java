package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.adressbook.model.ContactData;
import java.util.Set;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    Set<ContactData> before = app.contact().all();
    app.goTo().contactCreation();
    ContactData contact = new ContactData().withFirstname("Oleg")
                                           .withMiddlename("Sergeevich")
                                           .withLastname("Konstantinov")
                                           .withAddress("Test sample address")
                                           .withPhone("+71111111111")
                                           .withEmail("abc@def.g")
                                           .withGroup("test1");
    app.contact().create(contact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);
  }
}
