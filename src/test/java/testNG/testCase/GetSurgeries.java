package testNG.testCase;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import factory.BaseClass;
import pageObjects.POM_Surgeries;


public class GetSurgeries extends Finding_Docs{
	 POM_Surgeries sur;
	 
	 @Test(priority = 5)
	 public void navToSurgery() {
		 
		 
		 sur = new POM_Surgeries(BaseClass.getDriver());
		 sur.selectSurgery();
	 }
	 
	 @Test(priority = 6, dependsOnMethods = {"navToSurgery"})
	 public void scroll() throws InterruptedException {
		 sur = new POM_Surgeries(BaseClass.getDriver());
		 Thread.sleep(5000);
		 sur.scroll();
		 System.out.println("<-------------------------------------->");
	 }
	 
	 @Test(priority =7, dependsOnMethods = {"scroll"})
	 public void printSurgeries() throws IOException, InterruptedException{
		 sur = new POM_Surgeries(BaseClass.getDriver());
		 sur.popSurgery();
		 BaseClass.takeSnapshot(BaseClass.getDriver(), "06_Surgeries names.");
		 System.out.println("<-------------------------------------->");
	 }
}
