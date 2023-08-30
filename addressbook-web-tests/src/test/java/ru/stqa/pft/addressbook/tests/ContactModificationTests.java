package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public  void  ensurePreconditions () {
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
  }

  @Test
  public void testContactModification() {
    List<ContactData> before = app.getContactHelper().getContactList ();
    int index = before.size() - 1;
    ContactData contact = new ContactData(before.get(index).getId(),"Anton", "Kruglov",
            "ul. Pechuchkina 56", "84957561234", "89265784212", "kruglovray@gmail.com");
    app.getContactHelper().modifyTest(index, contact);
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList ();
    Assert.assertEquals(before.size(), after.size());

    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);


  }
}
// @Test
// public void testContactModification2() {
// app.getNavigationHelper().gotoGroupPage();
//  if (! app.getGroupHelper().isThereAGroup()) {
//    app.getGroupHelper().createGroup(new GroupData("test1", null, null));
//   }
//  app.getNavigationHelper().gotoHomePage();
// if (! app.getContactHelper().isThereAContact()) {
//    app.getContactHelper().createContact(new ContactData("Ray",
//             "Kruglov",
//             "ul. Pechuchkina 56", "84957561234",
//             "89265784212", "kruglovray@gmail.com"));
//    app.getNavigationHelper().gotoHomePage();
//  }
//   app.getContactHelper().initContactModification();
//   app.getContactHelper().fillContactForm(new ContactData("Sergey", "Kruglov", "ul. Pechuchkina 56", "84957561234", "89265784212", "kruglovray@gmail.com"), false);
//   app.getContactHelper().submitContactModification1();
//   app.getNavigationHelper().gotoHomePage();
//}
