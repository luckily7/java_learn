package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Set;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public  void  ensurePreconditions () {
    app.goTo().groupPage();
    if (app.group().all().size() == 0) {
      app.group().create(new GroupData().withName("test1"));
    }
    app.goTo().homePage();
    if (! app.contact().isThereAContact()) {
      app.contact().create(new ContactData()
              .withFirstname("Ray").withLastname("Kruglov").withAddress("ul. Pechuchkina 56")
              .withHome( "84957561234").withMobile("89265784212").withEmail("kruglovray@gmail.com"));
    }
    app.goTo().homePage();
  }

  @Test
  public void TestContactDeletion () {
    Set<ContactData> before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    app.goTo().homePage();
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(deletedContact);
    Assert.assertEquals(before, after);
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


