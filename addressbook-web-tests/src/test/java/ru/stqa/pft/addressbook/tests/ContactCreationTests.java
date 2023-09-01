package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @BeforeMethod
  public  void  ensurePreconditions () {
    app.goTo().groupPage();
    if (app.group().all().size() == 0) {
      app.group().create(new GroupData().withName("test1"));
    }
    app.goTo().homePage();
  }


  @Test
  public void testContactCreation() throws Exception {
    Contacts before = app.contact().all();
    ContactData contact = new ContactData()
            .withFirstname("Ray").withLastname("Kruglov").withAddress("ul. Pechuchkina 56")
            .withHome( "84957561234").withMobile("89265784212").withEmail("kruglovray@gmail.com")
            .withWork("9123434").withEmail2("krug@mail.ru").withEmail3("krug@ya.ru");
    app.contact().create(contact);
    app.goTo().homePage();
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();

    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }

  @Test
  public void testBadContactCreation() throws Exception {
    Contacts before = app.contact().all();
    ContactData contact = new ContactData()
            .withFirstname("Ray'").withLastname("Kruglov").withAddress("ul. Pechuchkina 56")
            .withHome( "84957561234").withMobile("89265784212").withEmail("kruglovray@gmail.com")
            .withWork("9123434").withEmail2("krug@mail.ru").withEmail3("krug@ya.ru");
    app.contact().create(contact);
    app.goTo().homePage();
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();

    assertThat(after, equalTo(before));
  }

}
