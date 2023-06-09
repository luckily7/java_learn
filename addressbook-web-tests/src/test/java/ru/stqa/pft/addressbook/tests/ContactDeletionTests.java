package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactDeletionTests extends TestBase {

  @Test
  public void TestContactDeletion () {
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Ray",
              "Kruglov", "test1",
              "ul. Pechuchkina 56", "84957561234",
              "89265784212", "kruglovray@gmail.com"), true);
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContacts();
    app.getContactHelper().acceptContactsDeletion();
  }

  @Test
  public void TestContactEditDeletion () {
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Ray",
              "Kruglov", "test1",
              "ul. Pechuchkina 56", "84957561234",
              "89265784212", "kruglovray@gmail.com"), true);
      app.getNavigationHelper().gotoHomePage();
    }
    app.getContactHelper().initContactModification();
    app.getContactHelper().deleteContactInEdit();
  }
}

