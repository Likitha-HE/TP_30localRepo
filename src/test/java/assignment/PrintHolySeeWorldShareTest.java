package assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintHolySeeWorldShareTest {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.worldometers.info/world-population/");
		String countryname="Holy See";
		for(;;) {
			List<WebElement> names = driver.findElements(By.xpath("//h2[@id='country']/following::div[@class='not-prose']/descendant::a"));
			for(WebElement name:names) {
				String cname = name.getText();
				Thread.sleep(500);
				if(cname.contains(countryname)) {
					String wShare = driver.findElement(By.xpath("//a[contains(.,'Holy See')]/parent::td/following::td[10]")).getText();
					System.out.println(wShare);
					Thread.sleep(2000);
					driver.quit(); 
					return; 
				}		
			}
			driver.findElement(By.xpath("//button[contains(.,'›')]")).click();
		}
	}

}
