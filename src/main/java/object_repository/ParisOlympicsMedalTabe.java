package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ParisOlympicsMedalTabe {
	@FindBy(xpath ="//span[contains(.,'Medal results')]")
	private WebElement medalResult;

	public ParisOlympicsMedalTabe(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getMedalResult() {
		return medalResult;
	}
	public void clickOnMedalResult() {
		medalResult.click();
	}
}
