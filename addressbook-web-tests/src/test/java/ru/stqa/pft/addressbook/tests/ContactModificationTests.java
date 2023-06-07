package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Ray", "Kruglov", null, "ul. Pechuchkina 56", "84957561234", "89265784212", "kruglovray@gmail.com"), false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().gotoHomePage();
  }

  @Test
  public void testContactModification2() {
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Ray", "Kruglov", null, "ul. Pechuchkina 56", "84957561234", "89265784212", "kruglovray@gmail.com"), false);
    app.getContactHelper().submitContactModification1();
    app.getNavigationHelper().gotoHomePage();
  }
}