package pagination_web_table;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PaginationWebTableTest {
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver=null;

		//Read data from property File
		FileInputStream access = new FileInputStream(".\\src\\test\\resources\\commondata1.properties");
		Properties pObj = new Properties();
		pObj.load(access);

		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");

		//Read Data from Excel
		FileInputStream testData = new FileInputStream(".\\src\\test\\resources\\TestData1.xlsx");
		Workbook wb = WorkbookFactory.create(testData);
		Sheet sh = wb.getSheet("Pagination");
		String data = sh.getRow(0).getCell(1).getStringCellValue();

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

		int totalPages=4;

		for (int i = 1; i <= totalPages; i++) {

			// Fetch all product names on the page
			List<WebElement> names = driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr/td[2]"));

			for (WebElement name : names) {
				String productName = name.getText();

				if (productName.equalsIgnoreCase(data)) {

					// Click corresponding checkbox without boolean
					driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[td[2][text()='" + data + "']]//input[@type='checkbox']")).click();

					System.out.println("Selected checkbox for: " + data);

					Thread.sleep(2000);
					driver.quit();  // <<< Direct exit
					return;        // <<< No 'found' variable needed
				}
			}

			// Go to next page if not last page
			if (i < totalPages) {
				driver.findElement(By.xpath("//a[text()='" + (i + 1) + "']")).click();
				Thread.sleep(2000);
			}
		}

		// If control reaches here, item was not found
		System.out.println("Item not found in any page!");
		Thread.sleep(5000);
		driver.quit();
	}
}