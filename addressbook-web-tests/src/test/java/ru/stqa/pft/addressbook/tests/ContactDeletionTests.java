package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public  void  ensurePreconditions () {
    app.goTo().groupPage();
    if (app.group().list().size() == 0) {
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
    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    app.contact().delete(index);
    app.goTo().homePage();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(index);
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


