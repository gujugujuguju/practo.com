package pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import factory.BaseClass;
import utilities.WriteDate;

import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class POM_getDocs extends BasePage{
	
	static Properties p;
	public static WebDriver driver;
	List<String> docs=new ArrayList<String>();

	public POM_getDocs(WebDriver driver) {
		super(driver);
		
	}
@FindBy(xpath="(//i[@class='practo_logo_new'])[1]") WebElement practoLogo;
@FindBy(xpath="//input[@placeholder='Search location']")WebElement searchLocBox;
@FindBy(xpath="(//div[contains(text(),'Chennai')])[1]")WebElement locationtxt;
@FindBy(xpath="//input[contains(@placeholder,'Search doctors, clinics')]") WebElement searchBox;
@FindBy(xpath="//div[text()='Dermatologist']") WebElement clickTxtSearch;
@FindBy(xpath="(//span[text()='Patient Stories'])[1]") WebElement patientStories;
@FindBy(xpath="//span[contains(text(),'20+ Patient')]") WebElement clickPatientStories;
@FindBy(xpath="//span[text()='Experience']") WebElement experience;
@FindBy(xpath="//span[text()='5+ Years of experience']") WebElement clickExp;
@FindBy(xpath="//span[text()='All Filters']") WebElement allFilters;
@FindBy(xpath="//span[contains(text(),'Above ₹500')]") WebElement feeOpt;
@FindBy(xpath="//span[contains(text(),'Available in next 4 hours')]") WebElement Availablity;
@FindBy(xpath="//span[contains(text(),'Relevance')]") WebElement sortBy;
@FindBy(xpath="//li[@aria-label='Experience - High to Low']") WebElement sortByOpt;
@FindBy(xpath="//div[@class='info-section']") List<WebElement> docDetails;
@FindBy(xpath="(//h2[@class='doctor-name'])") List<WebElement> docScroll;

public void pageLogo() throws InterruptedException {
	Thread.sleep(1000);
	practoLogo.isDisplayed();
	System.out.println("Practo logo is displayed");
}

public void LocationBox() throws InterruptedException {
	searchLocBox.click();
	Thread.sleep(1000);
	searchLocBox.clear();
	System.out.println("Location box field is cleared to type.");
}

public void typeLocation() throws IOException, InterruptedException {
	System.out.println("Typing Chennai.");
	p=BaseClass.getProperties();
	String location =p.getProperty("SearchLocation");
	Thread.sleep(1000);
	searchLocBox.sendKeys(location);
	Thread.sleep(1000);
	locationtxt.click();
	System.out.println("Bangalore is selected from the suggested list.");	
}

public void searchSpeciality() throws IOException, InterruptedException {
	Thread.sleep(1000);
	p=BaseClass.getProperties();
	searchBox.click();
	System.out.println("Typing Dermatologist.");
   	String search =p.getProperty("search");
	searchBox.sendKeys(search);
	Thread.sleep(1000);
	clickTxtSearch.click();
	System.out.println("Dermatologist is selected from the suggested list.");
}

public void applyFilters() throws InterruptedException {
	Thread.sleep(2000);
	
	System.out.println("Selecting patient stories.");
	patientStories.click();
	Thread.sleep(1000);
	System.out.println("Choosing 20+ patient stories.");
	clickPatientStories.click();
	Thread.sleep(1000);
	
	System.out.println("Selecting Experience.");
	experience.click();
	Thread.sleep(1000);
	System.out.println("Choosing 5+ Years of Experience");
	clickExp.click();
	Thread.sleep(1000);
	
	System.out.println("Selecting All Filters.");
	allFilters.click();
	Thread.sleep(1000);
	System.out.println("Choosing fee, above 500");
	feeOpt.click();
	Thread.sleep(1000);
	
	allFilters.click();
	System.out.println("Choosing Availablilty for next 4 hours.");
	Availablity.click();
	Thread.sleep(1000);
	
	System.out.println("Sorting by relevance.");
	sortBy.click();
	Thread.sleep(1000);
	System.out.println("Choosing High-Low experience.");
	sortByOpt.click();
}

public void docNames() throws IOException, InterruptedException {
	 JavascriptExecutor jsExecutor = (JavascriptExecutor) BaseClass.getDriver();
	 
	List<WebElement> elements = docDetails;

	Thread.sleep(2000);
	System.out.println("Getting first 5 names of doctors after filtering: ");
	System.out.println();
	for (int i = 1; i <=5; i++) {
		WebElement scroll = docScroll.get(i);
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);",scroll);
		
		  WebElement element = elements.get(i);
		  String text = element.getText();
		  System.out.println(text);
		  docs.add(text);//write data in excel
		  System.out.println("----------------");
		}
	WriteDate.writeExcel(docs);
}



}

