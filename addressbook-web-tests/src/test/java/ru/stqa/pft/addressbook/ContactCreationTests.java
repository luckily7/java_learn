package ru.stqa.pft.addressbook;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.tests.TestBase;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() throws Exception {
    initContactCreation();
    fillContactForm(new ContactData("Ray", "Kruglov", "ul. Pechuchkina 56", "84957561234", "89265784212", "kruglovray@gmail.com"));
    submitContactCreation();
    gotoHomePage();
    logout();
  }

}
