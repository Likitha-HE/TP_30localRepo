package object_repository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAltChunk;

import generic_utitilies.WebDriverUtils;

public class WorldometerHomePage extends WebDriverUtils {

	@FindBy(css = "[aria-haspopup='menu']")
	private WebElement slectMore;

	@FindBy(xpath="//a[contains(.,'Food & Agriculture')]")
	private WebElement selectOption;

	@FindBy(xpath="//a[contains(.,'India')]")
	private WebElement countryName;

	@FindBy(xpath="//*[name()='path' and contains(@class,'highcharts-point')]")
	private WebElement graph;

	@FindBy(xpath="//*[name()='g' and contains(@class,'highcharts-label highcharts-tooltip highcharts-color-undefined')]//*[name()='text']")
	private WebElement graphData;

	@FindBy(xpath="//a[@class='transition-all duration-200 hover:underline']")
	private List<WebElement> cNames;

	@FindBy(xpath="//span[contains(.,'see all countries')]")
	private WebElement seeAllCountries;

	@FindBy(xpath="//a[contains(.,'Holy See')]/ancestor::tr[@id='holy-see']/td[contains(.,'0.00')]")
	private WebElement worldShare;

	@FindBy(xpath="//a[@class='transition-all duration-200 text-lime-600 hover:text-lime-500']")
	private List<WebElement> conNames;


	public WorldometerHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}	
	public WebElement getSlectMore() {
		return slectMore;
	}
	public WebElement getSelectOption() {
		return selectOption;
	}
	public WebElement getCountryName() {
		return countryName;
	}
	public WebElement getGraphData() {
		return graph;
	}
	public WebElement getGraph() {
		return graph;
	}
	public List<WebElement> getcName() {
		return cNames;
	}
	public WebElement getSeeAllCountries() {
		return seeAllCountries;
	}

	public List<WebElement> getcNames() {
		return cNames;
	}
	public WebElement getWorldShare() {
		return worldShare;
	}

	public List<WebElement> getConNames() {
		return conNames;
	}
	public void clickOnFoodAndAgriculture(String ddValue) throws InterruptedException {
		slectMore.click();
		selectOption.click();

	}

	public void ClickOnIndia(WebDriver driver) throws InterruptedException {
		Thread.sleep(3000);
		clickOnElementUsingJSE(driver, countryName);


	}

	public void printTheToolTipData(WebDriver driver) {
		mouseHover(driver, graph);
		String data = graphData.getText();		
		System.out.println(data);
	}

	public void searchHolySee(String contryName) throws InterruptedException {
//		List<WebElement> countryData=cNames;
//		try {
//			for(WebElement names:countryData) {
//				String name = names.getText();
//				if(name.equalsIgnoreCase(contryName)) {
//					String wShare = worldShare.getText();
//					System.out.println(wShare);
//				}
//			}
//		}catch(Exception e) {
			seeAllCountries.click();
			List<WebElement> countryData2=conNames;
			for(WebElement names1:countryData2) {
				String name1 = names1.getText();
				if(name1.equalsIgnoreCase(contryName)) {
					String wShare = worldShare.getText();
					System.out.println(wShare);

				}
			}


		}
	}
//}