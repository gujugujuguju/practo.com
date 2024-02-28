package testNG.testCase;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import factory.BaseClass;
import pageObjects.POM_DemoBooking;

public class InvalidBooking extends GetSurgeries {
	POM_DemoBooking invalid;
	static Logger logger;
	
	@Test( priority = 8)
	public void navToHWP() throws InterruptedException {
		
		
		invalid = new POM_DemoBooking(BaseClass.getDriver());
		Thread.sleep(3000);
		invalid.forCorp();
		
		invalid.interactHWP();
	}
	@Test(priority =9, dependsOnMethods = {"navToHWP"})
	public void enterFormDetails() throws IOException, InterruptedException {
		invalid = new POM_DemoBooking(BaseClass.getDriver());
		Thread.sleep(5000);
		invalid.name();
		
		invalid.orgName();
		
		invalid.contact();
		
		invalid.emailNeg();
		BaseClass.takeSnapshot(BaseClass.getDriver(), "07_Invalid email.");
		invalid.orgSize();
		
		invalid.interested();
		
		invalid.submit();
		
		System.out.println("<-------------------------------------->");
	}
}
