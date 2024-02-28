package testNG.testCase;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import factory.BaseClass;
import pageObjects.POM_getDocs;

public class Finding_Docs {
	 public static WebDriver driver;
	 static Properties p;
	 static Logger logger;
	 POM_getDocs ele;
	 List<String> docs=new ArrayList<String>();
	 
	 
	@BeforeSuite
	public static void setup() throws IOException, InterruptedException
   {
   	driver=BaseClass.initilizeBrowser();
   	p=BaseClass.getProperties();
   	driver.get(p.getProperty("appURL"));
   	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
   	driver.manage().window().maximize();
	System.out.println("The user is on practo.com website.");
	}
	@AfterSuite
	public static void tearDown() {
	      driver.quit();
	   }
	
	@Test(priority = 1)
	public void checkPage() throws IOException, InterruptedException {
		
		ele = new POM_getDocs(BaseClass.getDriver());
		ele.pageLogo();

		System.out.println("<-------------------------------------->");
	}
	
	@Test(priority = 2, dependsOnMethods = {"checkPage"})
	public void enterFields() throws IOException, InterruptedException {
		ele = new POM_getDocs(BaseClass.getDriver()); 
		
		ele.LocationBox();
		BaseClass.takeSnapshot(BaseClass.getDriver(), "01_Location Clearing from input box");
		ele.typeLocation();
		BaseClass.takeSnapshot(BaseClass.getDriver(), "02_Typing location in input box");
		ele.searchSpeciality();
		BaseClass.takeSnapshot(BaseClass.getDriver(), "03_Searching for dermatologist");
		System.out.println("Records is displayed without filters and sorting.");
		System.out.println("Filtering results.");
		System.out.println("<-------------------------------------->");
	}
	@Test (priority = 3, dependsOnMethods = {"enterFields"})
	public void applyFilters() throws InterruptedException, IOException {
		ele = new POM_getDocs(BaseClass.getDriver());
		
		ele.applyFilters();
		BaseClass.takeSnapshot(BaseClass.getDriver(), "04_After applying filters.");
		System.out.println("<-------------------------------------->");
	}
	
	@Test (priority = 4, dependsOnMethods = {"applyFilters"})
	public void displayDocs() throws IOException, InterruptedException {
		ele = new POM_getDocs(BaseClass.getDriver());
		
		ele.docNames();
		BaseClass.takeSnapshot(BaseClass.getDriver(), "05_Scrolled to doctor details.");
		System.out.println("<-------------------------------------->");
	}
	   
}
