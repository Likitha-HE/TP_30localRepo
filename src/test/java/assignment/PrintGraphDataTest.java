package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import generic_utitilies.WebDriverUtils;

public class PrintGraphDataTest {
	public static void main(String[] args) throws InterruptedException {
		WebDriverUtils wlib = new WebDriverUtils();
		WebDriver driver=new ChromeDriver();
		wlib.maximizeWindow(driver);
		wlib.waitForPageLoad(driver, 10);
		driver.get("https://www.worldometers.info/geography/countries-of-the-world/");
		driver.findElement(By.xpath("//button[@aria-haspopup='menu']")).click();
		driver.findElement(By.xpath("//a[contains(.,'Food & Agriculture')]")).click();
		driver.findElement(By.xpath("//a[contains(.,'India')]")).click();
		wlib.mouseHoverAndClickOnEle(driver, driver.findElement(By.xpath("//*[name()='path' and contains(@class,'highcharts-point')]")));
		System.out.println(driver.findElement(By.xpath("//*[name()='g' and contains(@class,'highcharts-label highcharts-tooltip highcharts-color-undefined')]//*[name()='text']")).getText());
		
		Thread.sleep(5000);
		driver.quit();
		
		
		
	}
}
