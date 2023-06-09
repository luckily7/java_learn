package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Ray",
              "Kruglov", "test1",
              "ul. Pechuchkina 56", "84957561234",
              "89265784212", "kruglovray@gmail.com"), true);
      app.getNavigationHelper().gotoHomePage();
    }
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Anton", "Kruglov", null, "ul. Pechuchkina 56", "84957561234", "89265784212", "kruglovray@gmail.com"), false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().gotoHomePage();
  }

  @Test
  public void testContactModification2() {
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Ray",
              "Kruglov", "test1",
              "ul. Pechuchkina 56", "84957561234",
              "89265784212", "kruglovray@gmail.com"), true);
      app.getNavigationHelper().gotoHomePage();
    }
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Sergey", "Kruglov", null, "ul. Pechuchkina 56", "84957561234", "89265784212", "kruglovray@gmail.com"), false);
    app.getContactHelper().submitContactModification1();
    app.getNavigationHelper().gotoHomePage();
  }
}