package slider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderTest {
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver=null;
		//Read data from property File
		FileInputStream access = new FileInputStream(".\\src\\test\\resources\\commondata1.properties");
		Properties pObj = new Properties();
		pObj.load(access);

		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("Firefox")) {
			driver=new FirefoxDriver();
		}
		else {
			driver=new EdgeDriver();
		}

		driver.manage().window().maximize();

		//Open/get the application
		driver.get(URL);
		
		WebElement sliderHandle1 = driver.findElement(By.xpath("//span[contains(@class,'ui-slider-handle')][1]"));
		System.out.println(sliderHandle1.getLocation().getX());
		WebElement sliderHandle2 = driver.findElement(By.xpath("//span[contains(@class,'ui-slider-handle')][2]"));
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//h2[.='SVG Elements']"))).perform();
		act.dragAndDropBy(sliderHandle1, 15, 0).perform();
		act.dragAndDropBy(sliderHandle2, 59,0).perform();
		
        // Print selected amount (100-400)
        String price = driver.findElement(By.id("amount")).getAttribute("value");
        System.out.println(price);
        
        Thread.sleep(5000);
        driver.quit();
	}

}
