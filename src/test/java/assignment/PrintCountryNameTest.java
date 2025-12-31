package assignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import generic_utitilies.WebDriverUtils;
import object_repository.ParisOlympicsMedalResult;
import object_repository.ParisOlympicsMedalTabe;

public class PrintCountryNameTest {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		WebDriverUtils wlib = new WebDriverUtils();
		
		wlib.maximizeWindow(driver);
		
		wlib.waitForPageLoad(driver, 10);
		
		driver.get(" https://www.bbc.com/sport/olympics/paris-2024/medals");
		
		ParisOlympicsMedalTabe mt = new ParisOlympicsMedalTabe(driver);
		mt.clickOnMedalResult();
		
		ParisOlympicsMedalResult mr = new ParisOlympicsMedalResult(driver);
		mr.clickOnSports("Athletics");
		
		mr.nameOfCountry();
		
        Thread.sleep(5000);
		driver.quit();
		
	}

}
