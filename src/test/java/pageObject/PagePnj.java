package pageObject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PagePnj {

	@FindBy(xpath = "//a[@class=\"q3 listview-cleartext\"]")
	private List<WebElement> listItemsBoss;

	public List<WebElement> getListItemsBoss() {
		return listItemsBoss;
	}
	
	public PageItem clickItemLien(WebDriver driver, WebElement lienItem) {
		 driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	      // Javascript executor
	      ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", lienItem);
		lienItem.click();
		return PageFactory.initElements(driver, PageItem.class);
	}
}
