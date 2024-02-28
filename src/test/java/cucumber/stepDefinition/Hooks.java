package cucumber.stepDefinition;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import factory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;


public class Hooks {
	 public static WebDriver driver;
	 static Properties p;
	 
	 
	@BeforeAll
   public static void setup() throws IOException, InterruptedException
   {
   	driver=BaseClass.initilizeBrowser();
   	p=BaseClass.getProperties();
   	driver.get(p.getProperty("appURL"));
   	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
   	driver.manage().window().maximize();
   	//Thread.sleep(2000);

	}
	
	@AfterStep
    public void addScreenshot(Scenario scenario) {
    	// this is for cucumber junit report
        	TakesScreenshot ts=(TakesScreenshot) driver;
        	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
        	scenario.attach(screenshot, "image/png",scenario.getName());
    }

   @AfterAll
   public static void tearDown() {
      driver.quit();
   }
   
   
   
   
}