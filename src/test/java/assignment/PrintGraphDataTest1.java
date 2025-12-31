package assignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import generic_utitilies.WebDriverUtils;
import object_repository.WorldometerHomePage;

public class PrintGraphDataTest1{
	public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	WebDriverUtils wlib = new WebDriverUtils();
	
	wlib.maximizeWindow(driver);
	wlib.waitForPageLoad(driver, 10);
	
	driver.get("https://www.worldometers.info/geography/countries-of-the-world/");
	
	WorldometerHomePage whp = new WorldometerHomePage(driver);
	
	whp.clickOnFoodAndAgriculture("Food & Agriculture");
	
	whp.printTheToolTipData(driver);
	
	Thread.sleep(5000);
	driver.quit();

	}

}
