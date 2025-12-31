package broken_links;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrokenLinkTest {
	public static void main(String[] args) throws IOException, InterruptedException {
		String eachLink="";
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
		
		List<WebElement> links = driver.findElements(By.xpath("//div[@id='broken-links']/a"));
		System.out.println(links.size());
		
		//checking broken links
		for(WebElement link:links) {
			try {
				//take href attribute value
				eachLink=link.getDomAttribute("href");
				URI uri=new URI(eachLink);
				URL url=uri.toURL();
				//Making connection between code and the specific url
				HttpURLConnection http = (HttpURLConnection) url.openConnection();
				
				if(http.getResponseCode()>=400)
					System.out.println("Fail"+eachLink+"--------->"+http.getResponseMessage()+"--------->"+http.getResponseCode());
				
			}catch(Exception e) {
				System.out.println("EachLink failed "+eachLink+" eachLink");
			}
			
		}
		Thread.sleep(5000);
		driver.quit();
	}

}
