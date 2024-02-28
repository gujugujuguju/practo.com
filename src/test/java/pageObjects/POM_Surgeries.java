package pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import utilities.WriteDate;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import factory.BaseClass;

public class POM_Surgeries extends BasePage{
	public static WebDriver driver;
	List<String> surgeries=new ArrayList<String>();
	public POM_Surgeries(WebDriver driver) {
		super(driver);
		}
	@FindBy(xpath="(//div[@class='product-tab__title'])[5]") WebElement surgeryTab;
	@FindBy(xpath="//div[@id='surgeries']") WebElement scrollTo;
	@FindBy(xpath="//p[@data-qa-id]") List<WebElement> popSurgeries;
	
	public void selectSurgery() {
		
		surgeryTab.click();
		System.out.println("User navigates to Surgery section");
	}
	
	public void scroll() throws InterruptedException {
		Thread.sleep(1000);
		System.out.println("Scrolling to the popular surgeries section.");
		JavascriptExecutor js = (JavascriptExecutor) BaseClass.getDriver();
		js.executeScript("arguments[0].scrollIntoView();",scrollTo);	
		}
	
	public void popSurgery() throws IOException, InterruptedException {
		Thread.sleep(1000);
		System.out.println("Printing all popular surgeries displayed: ");
		System.out.println("");
		String jobtitles="";
		List<WebElement> ele = popSurgeries;
		for(int i=0;i<ele.size()-1;i++) {
			jobtitles= ele.get(i).getText();
			System.out.println(jobtitles);
			surgeries.add(jobtitles);
			}
		WriteDate.writeSurgerExcel(surgeries);
	}
}
