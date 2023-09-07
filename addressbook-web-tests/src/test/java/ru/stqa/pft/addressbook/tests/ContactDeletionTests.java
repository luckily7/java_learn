package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.junit.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.junit.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public  void  ensurePreconditions () {
    app.goTo().groupPage();
    if (app.db().contacts().size() == 0) {
      app.group().create(new GroupData().withName("test1"));
    }
    app.goTo().homePage();
    if (! app.contact().isThereAContact()) {
      app.contact().create(new ContactData()
              .withFirstname("Ray").withLastname("Kruglov").withAddress("ul. Pechuchkina 56")
              .withHome( "84957561234").withMobile("89265784212")
              .withEmail("kruglovray@gmail.com").withWork("9123434"));
    }
    app.goTo().homePage();
  }

  @Test
  public void TestContactDeletion () {
    Contacts before = app.db().contacts();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    app.goTo().homePage();
    assertThat(app.contact().count(), equalTo(before.size() - 1));
    Contacts after = app.db().contacts();

    assertThat(after, equalTo(before.without(deletedContact)));
    verifyContactListInUI();
  }
}

// @Test
//  public void TestContactEditDeletion () {
//    app.getNavigationHelper().gotoGroupPage();
//    if (! app.getGroupHelper().isThereAGroup()) {
//     app.getGroupHelper().createGroup(new GroupData("test1", null, null));
//    }
//    app.getNavigationHelper().gotoHomePage();
//    if (! app.getContactHelper().isThereAContact()) {
//      app.getContactHelper().createContact(new ContactData("Ray",
//              "Kruglov",
//              "ul. Pechuchkina 56", "84957561234",
//              "89265784212", "kruglovray@gmail.com"));
//      app.getNavigationHelper().gotoHomePage();
//    }
//    app.getContactHelper().initContactModification();
//    app.getContactHelper().deleteContactInEdit();
//  }


