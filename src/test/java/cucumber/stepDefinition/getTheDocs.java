package cucumber.stepDefinition;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.POM_getDocs;


public class getTheDocs extends BaseClass{

	
	POM_getDocs ele;
	
	@Given("user is on practo.com website.")
	public void user_is_on_practo_com_website() {
		System.out.println("The user is on practo.com website. ");
	}

	@Given("verifying the logo of webpage.")
	public void verifying_the_logo_of_webpage() throws InterruptedException {
		ele = new POM_getDocs(BaseClass.getDriver());
		ele.pageLogo();
	}

	@When("user clicks the location box and clears existing data.")
	public void user_clicks_the_location_box_and_clears_existing_data() throws InterruptedException {
		ele = new POM_getDocs(BaseClass.getDriver()); 
		ele.LocationBox();
	}

	@When("enters required location.")
	public void enters_required_location() throws IOException, InterruptedException {
		ele = new POM_getDocs(BaseClass.getDriver()); 
		ele.typeLocation();
	}

	@When("clicks the search box to type Dermatologist doctors.")
	public void clicks_the_search_box_to_type_dermatologist_doctors() throws IOException, InterruptedException {
		ele = new POM_getDocs(BaseClass.getDriver());   
		ele.searchSpeciality();
	}

	@Then("the page starts to search for records of doctors who are Dermatologist and its displayed.")
	public void the_page_starts_to_search_for_records_of_doctors_who_are_dermatologist_and_its_displayed() {
		System.out.println("Records is displayed without filters and sorting.");
		System.out.println("Filtering results.");
	}

	@Then("applying filters for Patient Stories, Experience, Fees, Availability and any one Sorting.")
	public void applying_filters_for_patient_stories_experience_fees_availability_and_any_one_sorting() throws InterruptedException {
		ele = new POM_getDocs(BaseClass.getDriver());
		ele.applyFilters();
	}

	@Then("Fetch & display the first five Doctor details.")
	public void fetch_display_the_first_five_doctor_details() throws IOException, InterruptedException {
		ele = new POM_getDocs(BaseClass.getDriver());
		ele.docNames();
	}
}
