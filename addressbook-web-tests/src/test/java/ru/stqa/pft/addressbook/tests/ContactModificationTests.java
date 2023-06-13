package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    }
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Ray",
              "Kruglov", "test1",
              "ul. Pechuchkina 56", "84957561234",
              "89265784212", "kruglovray@gmail.com"));
      app.getNavigationHelper().gotoHomePage();
    }
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Anton", "Kruglov", null, "ul. Pechuchkina 56", "84957561234", "89265784212", "kruglovray@gmail.com"), false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().gotoHomePage();
  }

  @Test
  public void testContactModification2() {
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    }
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Ray",
              "Kruglov", "test1",
              "ul. Pechuchkina 56", "84957561234",
              "89265784212", "kruglovray@gmail.com"));
      app.getNavigationHelper().gotoHomePage();
    }
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Sergey", "Kruglov", null, "ul. Pechuchkina 56", "84957561234", "89265784212", "kruglovray@gmail.com"), false);
    app.getContactHelper().submitContactModification1();
    app.getNavigationHelper().gotoHomePage();
  }
}