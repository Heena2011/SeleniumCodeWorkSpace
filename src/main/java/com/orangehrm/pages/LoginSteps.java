package com.orangehrm.pages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	 

	    @Given("I open the login page")
	    public void i_open_the_login_page() {
	        System.out.println("Login page opened");
	    }

	    @When("I enter valid username and password")
	    public void i_enter_valid_username_and_password() {
	        System.out.println("Entered username and password");
	    }

	    @Then("I should see the homepage")
	    public void i_should_see_the_homepage() {
	        System.out.println("Homepage displayed");
	    }
	}

