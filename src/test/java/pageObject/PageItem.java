package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageItem {

	@FindBy(xpath = "//b[@class=\"q3\"]/parent::td")
	private WebElement statItem;
	
	public String statItemString() {
		System.out.println("test :"+statItem.getText());
		return statItem.getText();
	}
	
	
	public void returnPagePrecending(WebDriver driver) {
		driver.navigate().back();
	}
	
}
