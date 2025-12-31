package shadow_root;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowRootTest {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com");
		Thread.sleep(3000);
	   
		SearchContext ele = driver.findElement(By.xpath("//div[@id='shadow_host']")).getShadowRoot();
		
		ele.findElement(By.cssSelector("div[id='nested_shadow_host']~[type='text']")).sendKeys("Likitha");
		Thread.sleep(3000);
		ele.findElement(By.cssSelector("[type='file']")).sendKeys("C:\\Users\\hp\\Downloads\\WhatsApp Image 2025-11-25 at 12.37.19 PM.jpeg");
		
		
		Thread.sleep(5000);
		driver.quit();
		
	}

}
