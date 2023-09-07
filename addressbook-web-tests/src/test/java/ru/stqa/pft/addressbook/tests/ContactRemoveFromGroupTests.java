package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactRemoveFromGroupTests extends TestBase{

  @BeforeMethod
  public  void  ensurePreconditions () {
    app.goTo().groupPage();
    if (app.db().contacts().size() == 0) {
      app.group().create(new GroupData().withName("test1"));
    }
    app.goTo().homePage();
    if (! app.contact().isThereAContact()) {
      app.contact().create(new ContactData()
              .withFirstname("Ray").withLastname("Kruglov").withAddress("ul. Pechuchkina 56")
              .withHome( "84957561234").withMobile("89265784212")
              .withEmail("kruglovray@gmail.com").withWork("9123434"));
    }
    app.goTo().homePage();
  }

  @Test
  public void testRemoveFromGroup() {
    Contacts contacts = app.db().contacts();
    ContactData selectContact = getSelectContact(contacts);
    GroupData selectGroup = selectContact.getGroups().iterator().next();
    int beforeDeletingGroup = selectContact.getGroups().size();
    app.contact().removeContactFromGroup(selectGroup, selectContact);
    app.goTo().homePage();
    contacts = app.db().contacts();
    ContactData findContact = getFindContact(contacts, selectContact.getId());
    int afterDeletingGroup = findContact.getGroups().size();
    assertThat(afterDeletingGroup, equalTo(beforeDeletingGroup - 1));
  }
  public ContactData getSelectContact(Contacts contact) {
    return contact.stream().filter((c) -> c.getGroups().size() > 0).findFirst().get();
  }
  private ContactData getFindContact(Contacts contact, int contactId) {
    return contact.stream().filter((c) -> c.getId() == contactId).findFirst().get();
  }
}
