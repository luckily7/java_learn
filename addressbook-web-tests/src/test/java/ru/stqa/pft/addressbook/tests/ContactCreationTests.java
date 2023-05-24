package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() throws Exception {
    app.initContactCreation();
    app.fillContactForm(new ContactData("Ray", "Kruglov", "ul. Pechuchkina 56", "84957561234", "89265784212", "kruglovray@gmail.com"));
    app.submitContactCreation();
    app.gotoHomePage();
    app.logout();
  }

}
