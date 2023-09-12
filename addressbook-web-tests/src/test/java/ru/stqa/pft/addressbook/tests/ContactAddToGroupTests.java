package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddToGroupTests  extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.db().contacts().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1"));
      app.goTo().homePage();
    }
    app.contact().create(new ContactData()
            .withFirstname("Ray").withLastname("Kruglov").withAddress("ul. Pechuchkina 56")
            .withHome("84957561234").withMobile("89265784212")
            .withEmail("kruglovray@gmail.com").withWork("9123434"));
    app.goTo().homePage();
    
    Contacts contacts = app.db().contacts();
    Groups groups = app.db().groups();
    int contactFullSize = 0;
    for (
            ContactData contact : contacts) {
      if (contact.getGroups().size() == groups.size()) {
        contactFullSize++;
      }
      if (contactFullSize == contacts.size()) {
        app.goTo().groupPage();
        app.group().create(new GroupData().withName("test1").withHeader("test2")
                .withFooter("test3"));
        app.goTo().homePage();
      }
    }
  }

  @Test
  public void testAddContactToGroup() {
    Groups groups = app.db().groups();
    Contacts contacts = app.db().contacts();
    ContactData selectContact = getSelectContact(contacts, groups.size());
    GroupData selectGroup = getSelectGroup(groups,selectContact);
    int beforeAddingGroup = selectContact.getGroups().size();
    app.contact().addGroup(selectContact, selectGroup);
    contacts = app.db().contacts();
    ContactData findContact = getFindContact(contacts, selectContact.getId());
    int afterAddingGroup = findContact.getGroups().size();
    assertThat(afterAddingGroup, equalTo(beforeAddingGroup + 1));
  }
  public ContactData getSelectContact (Contacts contact, int groupsSize){
    return contact.stream().filter((c) -> c.getGroups().size() != groupsSize).findFirst().get();
  }
  public  GroupData getSelectGroup (Groups groupsAll,ContactData contact){
    groupsAll.removeAll(contact.getGroups());
    return groupsAll.iterator().next();
  }
  private ContactData getFindContact(Contacts contact, int contactId) {
    return contact.stream().filter((c) -> c.getId() == contactId).findFirst().get();
  }
}
