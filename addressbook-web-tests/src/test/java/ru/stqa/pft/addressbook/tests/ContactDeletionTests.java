package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

  @Test
  public void TestContactDeletion () {
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    }
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Ray",
              "Kruglov",
              "ul. Pechuchkina 56", "84957561234",
              "89265784212", "kruglovray@gmail.com"));
    }
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> before = app.getContactHelper().getContactList ();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().deleteSelectedContacts();
    app.getContactHelper().acceptContactsDeletion();
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList ();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);
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


