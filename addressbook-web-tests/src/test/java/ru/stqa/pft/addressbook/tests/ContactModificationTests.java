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
    app.goTo().groupPage();
    if (! app.group().isThereAGroup()) {
      app.group().create(new GroupData().withName("test1"));
    }
    app.goTo().homePage();
    if (! app.contact().isThereAContact()) {
      app.contact().create(new ContactData("Ray",
              "Kruglov",
              "ul. Pechuchkina 56", "84957561234",
              "89265784212", "kruglovray@gmail.com"));
    }
    app.goTo().homePage();
  }

  @Test (enabled = false)
  public void testContactModification() {
    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    ContactData contact = new ContactData(before.get(index).getId(),"Anton", "Kruglov",
            "ul. Pechuchkina 56", "84957561234", "89265784212", "kruglovray@gmail.com");
    app.contact().modify(index, contact);
    app.goTo().homePage();
    List<ContactData> after = app.contact().list();
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
