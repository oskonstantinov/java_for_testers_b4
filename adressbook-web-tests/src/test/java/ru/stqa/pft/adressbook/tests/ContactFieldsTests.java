package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactFieldsTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.contact().all().size() == 0) {
      app.goTo().contactCreation();
      app.contact().create(new ContactData().withFirstname("Oleg")
                                            .withLastname("Konstantinov")
                                            .withAddress("Test sample address")
                                            .withHomePhone("+74732111111")
                                            .withMobilePhone("+71111111111")
                                            .withWorkPhone("+74732222222")
                                            .withEmail("abc@def.g")
                                            .withEmail2("xyz@qwe.r")
                                            .withEmail3("bnm@ghj.y"));
    }
  }

  @Test
  public void testContactFields() {
    app.goTo().homeOnTab();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));
    assertThat(contact.getAllEmails(), equalTo(mergeEmailes(contactInfoFromEditForm)));
    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
  }

  private String mergeEmailes(ContactData contact) {
    return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
            .stream().filter((s) -> ! s.equals("")).map(ContactFieldsTests::cleaned).collect(Collectors.joining("\n"));
  }

  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
            .stream().filter((s) -> ! s.equals("")).map(ContactFieldsTests::cleaned).collect(Collectors.joining("\n"));
  }

  public static String cleaned(String phone) {
    return phone.replaceAll("\\s","").replaceAll("[-()]","");
  }
}
