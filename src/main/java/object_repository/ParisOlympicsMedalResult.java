package object_repository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utitilies.WebDriverUtils;

public class ParisOlympicsMedalResult extends WebDriverUtils {
	@FindBy(id="discipline-selector")
	private WebElement selectSports;
	
	@FindBy(xpath="//img[@class='ssrcss-1cwmkkr-MedalIcon emhtsls0']/ancestor::tr/descendant::div[@class='ssrcss-7dafha-DesktopNames e1dg50ic3']/div[@class='ssrcss-ljn8wi-PrimaryName e1dg50ic1']")
	private List<WebElement> country;
	
	@FindBy(xpath="//img[@class='ssrcss-1cwmkkr-MedalIcon emhtsls0']/ancestor::tr/descendant::div[@class='ssrcss-7dafha-DesktopNames e1dg50ic3']/div[@class='ssrcss-1n8wi18-SecondaryName e1dg50ic0']")
	private List<WebElement> countryNameOfPalyaers;
	
	@FindBy(xpath="//img[@class='ssrcss-1cwmkkr-MedalIcon emhtsls0']/ancestor::tr/descendant::div[@class='ssrcss-7dafha-DesktopNames e1dg50ic3']/div[@class='ssrcss-1n8wi18-SecondaryName e1dg50ic0']")
	private WebElement secodaryName;
	
	public ParisOlympicsMedalResult(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getSlectSports() {
		return selectSports;
	}
	public List<WebElement> getCountry() {
		return country;
	}
	public List<WebElement> getCountryNameOfPalyaers() {
		return countryNameOfPalyaers;
	}
	
	
	public WebElement getSecodaryName() {
		return secodaryName;
	}
	
	public WebElement getSelectSports() {
		return selectSports;
	}
	
	public void clickOnSports(String sportsName) {
		selectSports.click();
		dropdownUsingContainsVisibleText(selectSports, sportsName);
		
	}
	
	public void nameOfCountry() throws InterruptedException {
		   try {
			   secodaryName.getText();
			   List<WebElement> countryNames = countryNameOfPalyaers;
			   for(WebElement names : countryNames) {
			        String name = names.getText();
			        System.out.println(name);
		   }
		   }catch(Exception e) {
			   
			   List<WebElement> countryNames = country;		
			    for(WebElement names : countryNames) {
			        String name = names.getText();
			        System.out.println(name);
			    }
		   }
	}
	
	}
