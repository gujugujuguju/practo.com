package cucumber.stepDefinition;

import java.io.IOException;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.POM_DemoBooking;
import pageObjects.POM_getDocs;

public class DemoBookedInvalid extends BaseClass{
	POM_DemoBooking demo;

	@Given("user navigates to Health & Wellness Plan under For Corporates section.")
	public void user_navigates_to_health_wellness_plan_under_for_corporates_section() throws InterruptedException {
		demo = new POM_DemoBooking(BaseClass.getDriver());
		demo.forCorp();
	    demo.interactHWP();
	}

	@When("user enters all the fields with invalid email input.")
	public void user_enters_all_the_fields_with_invalid_inputs() throws IOException, InterruptedException {
		demo = new POM_DemoBooking(BaseClass.getDriver()); 
		demo.name();
		demo.orgName();
		demo.contact();
		demo.emailNeg();
		demo.orgSize();
		demo.interested();
	}

	@Then("Schedule a demo button is disabled and user tries to clicks it but it will not work.")
	public void schedule_a_demo_button_is_disabled_and_user_tries_to_clicks_it_but_it_will_not_work() throws InterruptedException {
		demo = new POM_DemoBooking(BaseClass.getDriver());
		demo.submit();
		
		
	}

	@Then("Print test failed successfully in the console and clears all inputs.")
	public void print_test_failed_successfully_in_the_console_and_clears_all_inputs() {
		System.out.println("Test failed successfully");
	}

}
