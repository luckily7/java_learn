package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {

  @Test
  public void TestContactDeletion () {
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContacts();
    app.getContactHelper().acceptContactsDeletion();
  }

  @Test
  public void TestContactEditDeletion () {
    app.getContactHelper().initContactModification();
    app.getContactHelper().deleteContactInEdit();
  }
}

