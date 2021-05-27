package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header {
	
	@FindBy(xpath = "//input[contains(@placeholder,'Rechercher')]")
	private WebElement editSearch;
	
	@FindBy(xpath = "//*[@class='header-search-button fa fa-search']")
	private WebElement btSearch;
	
	@FindBy(xpath = "//button[contains(.,'Refuser')]")
	private WebElement btRefuseNotification;
	
	public void clickBtRefuseNotif() {
		btRefuseNotification.click();
	}
	
	public PageSearchResult clickSearchBt(WebDriver driver, String stSearch) {
		editSearch.clear();
		editSearch.sendKeys(stSearch);
		btSearch.click();
		return PageFactory.initElements(driver, PageSearchResult.class);
	}
	
	
	
	/********Cookies ********/
	@FindBy(xpath = "//*[@id='onetrust-accept-btn-handler']")
	private WebElement btAcceptCookies;
	
	
	public void clickButtonAcceptCookies() {
		btAcceptCookies.click();
	}

}
