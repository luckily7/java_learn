package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    }
    app.getContactHelper().createContact(new ContactData("Ray", "Kruglov", "test1",
            "ul. Pechuchkina 56", "84957561234",
            "89265784212", "kruglovray@gmail.com"), true);
    app.getNavigationHelper().gotoHomePage();
  }

}
