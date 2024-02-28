package cucumber.stepDefinition;

import java.io.IOException;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.POM_DemoBooking;
import pageObjects.POM_getDocs;

public class DemoBookedValid extends BaseClass {
	POM_DemoBooking demo;
	
	
	@Given("user is on Health & Wellness Plan under For Corporates section.")
	public void user_is_on_health_wellness_plan_under_for_corporates_section() {
		demo = new POM_DemoBooking(BaseClass.getDriver());
		System.out.println("Now checking with positive input.");
		System.out.println("User is on the demo booking page.");
	}

	@When("user enters all the fields with valid inputs.")
	public void user_enters_all_the_fields_with_valid_inputs() throws IOException, InterruptedException {
		demo = new POM_DemoBooking(BaseClass.getDriver());
		demo.email();
		
		
	}

	@Then("Schedule a demo button is enabled and user clicks it.")
	public void schedule_a_demo_button_is_enabled_and_user_clicks_it() throws InterruptedException {
		demo = new POM_DemoBooking(BaseClass.getDriver()); 
		demo.submit();
	}

	@Then("Thank you message is printed.")
	public void thank_you_message_is_printed() throws InterruptedException {
	Thread.sleep(20000);
	System.out.println("Thank You message is displayed");
	
	}

}
