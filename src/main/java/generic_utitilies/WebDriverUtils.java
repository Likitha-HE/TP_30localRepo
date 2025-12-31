package generic_utitilies;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtils {
	/**
	 * This method is used to maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	/**
	 * This method is used to add implicit wait
	 * @param driver
	 * @param seconds
	 */
	public void waitForPageLoad(WebDriver driver,int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}
	/**
	 * This method is used to provide explicit wait till the element is visible
	 * @param driver
	 * @param seconds
	 * @param element
	 */
	
	public void waitUntilElementToBeVisible(WebDriver driver,int seconds,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method is used to provide wait till the we click on the element
	 * @param driver
	 * @param seconds
	 * @param element
	 */
	
	public void waitUntilTheElementIsClickable(WebDriver driver,int seconds,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method is used to create the object of select class for provided element
	 * @param element
	 * @return
	 */
	
	public Select dropdown(WebElement element) {
		Select sel = new Select(element);
		return sel;
	}
	/**
	 * This method is used to select the dropdown data using value
	 * @param element
	 * @param value
	 */
	public void dropdownUsingValue(WebElement element,String value) {
		dropdown(element).selectByValue(value);
	}
	/**
	 * This method is used to select the dropdown data using index value
	 * @param element
	 * @param index
	 */
	
	public void dropdownUsingIndex(WebElement element,int index) {
		dropdown(element).selectByIndex(index);
	}
	/**
	 * This method is used to select the dropdown data using visible text value from the options list
	 * @param element
	 * @param name
	 */
	public void dropdownUsingVisibleText(WebElement element,String text) {
		dropdown(element).selectByVisibleText(text);
	}
	/**
	 * This method is used to select the dropdown data using visible text value from the options list
	 * @param element
	 * @param name
	 */
	public void dropdownUsingContainsVisibleText(WebElement element,String text) {
		dropdown(element).selectByContainsVisibleText(text);
	}
	/**
	 * This method is used to create the object of Actions class
	 * @param driver
	 * @return
	 */
	public Actions actions(WebDriver driver) {
		Actions act = new Actions(driver);
		return act;
	}
	/**
	 * This method is used to move the element to the target location
	 * @param driver
	 * @param element
	 */
	
	public void mouseHover(WebDriver driver,WebElement element) {
		actions(driver).moveToElement(element).perform();
	}
	/**
	 * This method is used to move and click on the element
	 * @param driver
	 * @param element
	 */
	
	public void mouseHoverAndClickOnEle(WebDriver driver,WebElement element) {
		actions(driver).moveToElement(element).click(element).perform();
	}
	/**
	 * This method is used to move data from source element to target element
	 * @param driver
	 * @param sourElement
	 * @param targetElement
	 */
	
	public void dragAndDrop(WebDriver driver,WebElement sourElement,WebElement targetElement) {
		actions(driver).dragAndDrop(sourElement,targetElement).perform();
	}
	/**
	 * This Method is used to scroll the web page for the given x and y value
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void scrollWebPAge(WebDriver driver,int x,int y) {
		actions(driver).scrollByAmount(x, y).perform();
	}
	/**
	 * This method is used to scroll the web page to given element
	 * @param driver
	 * @param element
	 */
	
	public void scrollToEle(WebDriver driver,WebElement element) {
		actions(driver).scrollToElement(element).perform();
	}
	/**
	 * This method is used to double click on the web page
	 * @param driver
	 */
	public void doubleClickWebPage(WebDriver driver) {
		actions(driver).doubleClick().perform();
	}
	/**
	 * This method is used to double click on given element
	 * @param driver
	 * @param element
	 */
	public void doubleOnEle(WebDriver driver,WebElement element) {
		actions(driver).doubleClick(element).perform();
	}
	/**
	 * This Method is used to rightClick on web page
	 * @param driver
	 */
	public void rightClickOnwebPage(WebDriver driver) {
		actions(driver).contextClick().perform();
	}
	/**
	 * This method is used to right click on given element
	 * @param driver
	 * @param element
	 */
	public void rightClickOnEle(WebDriver driver,WebElement element) {
		actions(driver).contextClick(element).perform();
	}
	/**
	 * This Method is used to click and hold the web element
	 * @param driver
	 * @param element
	 */
	public void clickAndHoldOnWebEle(WebDriver driver,WebElement element) {
		actions(driver).clickAndHold(element).perform();
	}
	/**
	 * This method is used to click hold and release the mouse on web page
	 * @param driver
	 * @param element
	 */
	public void clickAndHoldAndRelease(WebDriver driver,WebElement element) {
		actions(driver).clickAndHold(element).release().perform();
	}
	/**
	 * This method is used to switch the control to child window
	 * @param driver
	 * @param expTitle
	 */
	public void switchToWindow(WebDriver driver,String expTitle) {
		//String parent=driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		while(it.hasNext()) {
			String currentWin = it.next();
			String actualTitle = driver.switchTo().window(currentWin).getTitle();
			if(actualTitle.contains(expTitle)) {
				break;
			}
			
		}
	}
//	/**
//	 * This method is used to move the control back to parent window
//	 * @param driver
//	 * @param parentID
//	 */
//	public void switchToParentWindow(WebDriver driver,String parentID) {
//		driver.switchTo().window(parentID);
//	}
	//frames
	/**
	 * This method is used to switch control to frame using index value
	 * @param driver
	 * @param index
	 */
	public void switchtochild(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * This method is used to switch control to frame using name of the frame
	 * @param driver
	 * @param name
	 */
	public void switchtochild(WebDriver driver,String name) {
		driver.switchTo().frame(name);
	}
	/**
	 * This method is used to switch control to frame using element
	 * @param driver
	 * @param element
	 */
	public void switchtochild(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	/**
	 * This method is used to switch frame control to parent frame
	 * @param driver
	 */
	public void switchToPArentFrame(WebDriver driver){
		driver.switchTo().parentFrame();
	}
	/**
	 * This method is used to switch control to default/main page 
	 * @param driver
	 */
	public void switchToMainFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	//alerts
	/**
	 * This method is used to accept and handle the alert pop up 
	 * @param driver
	 */
	public void acceptAlertPopup(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/**
	 * This method is used to dismiss and handle the alert pop up 
	 * @param driver
	 */
	public void dismissAlertPopup(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This method is used get text present on alert pop up
	 * @param driver
	 */
	public void getTextFromAlertPopup(WebDriver driver) {
		driver.switchTo().alert().getText();
	}
	/**
	 * This method is used to send text data to the alert popup
	 * @param driver
	 * @param value
	 */
	public void enterValueInToAlertTextField(WebDriver driver,String value) {
		driver.switchTo().alert().sendKeys(value);
	}
	
	//javaScript Executor methods
	/**
	 * This method is used to type cast java script executor
	 * @param driver
	 * @return
	 */
	public JavascriptExecutor javaScriptExecuter(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		return js;
	}
	/**
	 * This method is used to scroll the web page till end
	 * @param driver
	 */
	
	public void scrollHeight(WebDriver driver) {
		
		javaScriptExecuter(driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	//scrollTillElement
	/**
	 * This method is used to scroll the web page till the given element
	 * @param driver
	 * @param element
	 */
	public void scrollUntilEleIsVisibleUsingJSE(WebDriver driver,WebElement element) {
		javaScriptExecuter(driver).executeScript("arguments[0].scrollIntoView()", element);
	}
	
	//click on element
	/**
	 * This method is used to click on given web element on the we page
	 * @param driver
	 * @param element
	 */
	public void clickOnElementUsingJSE(WebDriver driver,WebElement element) {
		javaScriptExecuter(driver).executeScript("arguments[0].click()", element);
	}
	
	//sendkeys
	/**
	 * This method is used to send the value to the given element field
	 * @param driver
	 * @param element
	 * @param value
	 */
	public void enterValueIntoTextFieldUsingJSE(WebDriver driver,WebElement element,String value) {
		javaScriptExecuter(driver).executeScript("arguments[0].value=arguments[1];", element,value);
	}
	/**
	 * This method is used to get the location of the element and 
	 * @param driver
	 * @param element
	 */
	public void scrollToEleUsingXYCoOrdinate(WebDriver driver,WebElement element) {
	   Point loc=element.getLocation();
	   int x=loc.getX();
	   int y=loc.getY();
	   javaScriptExecuter(driver).executeScript("window.scrollBy("+x+","+y+");");
	   
	}
	
	

}
