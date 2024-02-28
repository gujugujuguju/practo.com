package cucumber.stepDefinition;

import java.io.IOException;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.POM_Surgeries;
import pageObjects.POM_getDocs;

public class getTheSurgeryDone extends BaseClass{

	POM_Surgeries surg;
	
	@Given("user navigate to surgeries section.")
	public void user_navigate_to_surgeries_section() {
		surg= new POM_Surgeries(BaseClass.getDriver());
	   	surg.selectSurgery();
	}

	@When("scrolls the page.")
	public void scrolls_the_page() throws InterruptedException {
		surg= new POM_Surgeries(BaseClass.getDriver());  
		surg.scroll();
	}

	@Then("user gets a list of popular surgery and prints it.")
	public void user_gets_a_list_of_popular_surgery_and_prints_it() throws IOException, InterruptedException {
		surg= new POM_Surgeries(BaseClass.getDriver());
		surg.popSurgery();
		
	}
}
