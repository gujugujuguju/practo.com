package pageObjects;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import factory.BaseClass;

public class POM_DemoBooking extends BasePage{
	public POM_DemoBooking(WebDriver driver) {
		super(driver);
		
	}
	static Properties p;
	public static WebDriver driver;

	@FindBy(xpath="//span[@class='nav-interact']") WebElement forCorporates;
	@FindBy(xpath="//a[@class='nav-interact' and contains(text(),'Health')]") WebElement HealthWP;
	@FindBy(xpath="(//input[@name='name'])[1]") WebElement name;
	@FindBy(xpath="(//input[@id='organizationName'])[1]") WebElement orgName;
	@FindBy(xpath="(//input[@id='contactNumber'])[1]") WebElement contact;
	@FindBy(xpath="(//input[@id='officialEmailId'])[1]") WebElement email;
	@FindBy(xpath="(//select[@id='organizationSize'])[1]") WebElement dropOrg;
	@FindBy(xpath="(//select[@id='interestedIn'])[1]") WebElement dropInterested;
	@FindBy(xpath="(//button[@type='submit'])[1]") WebElement submit;
	@FindBy(xpath="(//div[@class='u-m-t--10'])[2]") WebElement thankYou;
	public void forCorp() {
		System.out.println("Clicking For Corporates section.");
		forCorporates.click();
	}
	
	public void interactHWP() throws InterruptedException {
		Thread.sleep(1000);
		System.out.println("Clicking Health & Wellness Plan");
		HealthWP.click();
	}
	
	public void name() throws IOException, InterruptedException {
		p=BaseClass.getProperties();
		System.out.println("Entering user name.");
		name.click();
		Thread.sleep(1000);
		String nametxt=p.getProperty("name");
		name.sendKeys(nametxt);
		System.out.println("Entered name as: "+nametxt);
	}
	
	public void orgName() throws IOException, InterruptedException {
		Thread.sleep(1000);
		p=BaseClass.getProperties();
		System.out.println("Entering organization name.");
		orgName.click();
		Thread.sleep(1000);
		String orgNametxt=p.getProperty("Org_name");
		orgName.sendKeys(orgNametxt);
		System.out.println("Entered name as: "+ orgNametxt);
	}
	
	public void contact() throws IOException, InterruptedException {
		Thread.sleep(1000);
		p=BaseClass.getProperties();
		System.out.println("Entering contact.");
		contact.click();
		Thread.sleep(1000);
		String contacttxt=p.getProperty("contact");
		contact.sendKeys(contacttxt);
		System.out.println("Entered contact info as: "+contacttxt);
	}
	
	public void email() throws IOException, InterruptedException {
		Thread.sleep(1000);
		p=BaseClass.getProperties();
		email.click();
		email.clear();
		Thread.sleep(1000);
		System.out.println("Entering valid email.");
		String emailtxt=p.getProperty("valid_email");
		email.sendKeys(emailtxt);
		System.out.println("Entered valid email as: "+emailtxt);
	}
	public void emailNeg() throws IOException, InterruptedException {
		JavascriptExecutor js =(JavascriptExecutor) BaseClass.getDriver();
		js.executeScript("arguments[0].scrollIntoView(true);",email);
		Thread.sleep(1000);
		p=BaseClass.getProperties();
		System.out.println("Entering invalid email. ");
		email.click();
		Thread.sleep(1000);
		String invalidemailtxt=p.getProperty("invalid_email");
		email.sendKeys(invalidemailtxt);
		System.out.println("Entered invalid email as: "+invalidemailtxt);
	}
	
	public void orgSize() throws InterruptedException {
		Thread.sleep(1000);
		System.out.println("Selecting Organization Size as 501-1000.");
		dropOrg.click();
		Thread.sleep(1000);
		Select options = new Select(dropOrg);
		options.selectByValue("501-1000");
	}
	
	public void interested() throws InterruptedException {
		Thread.sleep(1000);
		System.out.println("Selecting Interested in as Taking a demo.");
		dropInterested.click();
		Thread.sleep(1000);
		Select options = new Select(dropInterested);
		options.selectByValue("Taking a demo");
	}
	
	public void submit() throws InterruptedException {
	
		Thread.sleep(1000);
		if (submit.isDisplayed() && submit.isEnabled()) {
			submit.click();
			} else {
			  System.out.println("Element is not clickable.");
			}
	}
	
	public void thanks() throws InterruptedException{
		Thread.sleep(1000);
		if(thankYou.isDisplayed()) {
			String thanks= thankYou.getText();
			System.out.println(thanks);
		}
		else {
			System.out.println("Captcha failed. Try again.");
		}
		}
}
