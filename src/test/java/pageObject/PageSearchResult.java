package pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageSearchResult extends Header{
	
	@FindBy(xpath = "//td[@class=\"icon-boss-padded\"]/descendant::a")
	private WebElement bossLien;
	
	public PagePnj clickLienBoss(WebDriver driver) {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", bossLien);
		bossLien.click();
		return PageFactory.initElements(driver, PagePnj.class);
	}
}
