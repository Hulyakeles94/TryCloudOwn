package com.tryCloud.step_definitions;

import com.tryCloud.pages.ContactsPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class US13 {

    ContactsPage contactsPage=new ContactsPage();

    @Then("verify the contact names are in the list")
    public void verify_the_contact_names_are_in_the_list() {
        Assert.assertTrue(contactsPage.contactsList.size()>=2);
    }

}
