package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() throws Exception {
    app.getContactHelper().createContact(new ContactData("Ray", "Kruglov", "test1",
            "ul. Pechuchkina 56", "84957561234",
            "89265784212", "kruglovray@gmail.com"), true);
    app.getNavigationHelper().gotoHomePage();
  }

}
