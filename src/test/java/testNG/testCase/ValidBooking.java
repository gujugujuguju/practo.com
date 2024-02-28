package testNG.testCase;

import java.io.IOException;

import org.testng.annotations.Test;

import factory.BaseClass;
import pageObjects.POM_DemoBooking;

public class ValidBooking extends InvalidBooking{
	POM_DemoBooking valid;
	
	@Test(priority = 10, dependsOnMethods= {"enterFormDetails"})
	public void userInHWP() {
		
		System.out.println("Now checking with positive input.");
		System.out.println("User is on the demo booking page.");
	}
	
	@Test(priority = 11, dependsOnMethods = {"userInHWP"})
	public void validEmail() throws IOException, InterruptedException
	{
		valid = new POM_DemoBooking(BaseClass.getDriver());
		Thread.sleep(3000);
		valid.email();
		BaseClass.takeSnapshot(BaseClass.getDriver(), "10_Valid email.");
	}
	
	@Test(priority = 12, dependsOnMethods = {"validEmail"})
	public void book() throws InterruptedException {

		valid = new POM_DemoBooking(BaseClass.getDriver());
		
		valid.submit();
	}
	
	@Test(priority = 13, dependsOnMethods = {"book"})
	public void thankYou() throws InterruptedException, IOException {
		Thread.sleep(20000);

		valid = new POM_DemoBooking(BaseClass.getDriver());
	
		valid.thanks();
		BaseClass.takeSnapshot(BaseClass.getDriver(), "11_thanks!");
	}
}
