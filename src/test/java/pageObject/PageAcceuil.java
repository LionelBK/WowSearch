package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageAcceuil extends Header{

	@FindBy(xpath = "//*[@id='onetrust-accept-btn-handler']")
	private WebElement btAcceptCookies;
	
	
	public void clickButtonAcceptCookies() {
		btAcceptCookies.click();
	}
	
	
}
