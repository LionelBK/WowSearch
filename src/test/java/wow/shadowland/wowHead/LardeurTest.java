package wow.shadowland.wowHead;


import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.PageAcceuil;
import pageObject.PageItem;
import pageObject.PagePnj;
import pageObject.PageSearchResult;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LardeurTest {
	
	
	String stSearch= "Lardeur";
	protected static WebDriver driver;
	protected WebDriverWait wait;
	private String resourcesPath;

	public File getFileAsResource(String filePath) {
		Path resourceDirectory = Paths.get(filePath);
		return resourceDirectory.toFile();
	}
	
	@Test
	public void run() throws InterruptedException{
		String BROWSER=System.getProperty("browser");

		if(BROWSER.equals("firefox")) {
			
			File file = getFileAsResource("src/main/resources/driver/geckodriver.exe");
			driver = new FirefoxDriver();
			
		}else if(BROWSER.equals("chrome")) {
			
			File file = getFileAsResource("src/main/resources/driver/chromedriver.exe");
			
			System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
			ChromeOptions options = new ChromeOptions();
			options.setCapability("chrome.switches", Arrays.asList("--ignore-certificate-errors"));
			driver = new ChromeDriver(options);
		}
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://fr.wowhead.com");
		PageAcceuil pageAcceuil = PageFactory.initElements(driver, PageAcceuil.class);
		Thread.sleep(3000);
		pageAcceuil.clickButtonAcceptCookies();
		pageAcceuil.clickBtRefuseNotif();
		
		
		PageSearchResult pageSearchResult = pageAcceuil.clickSearchBt(driver, stSearch);
		pageSearchResult.clickButtonAcceptCookies();
		
		PagePnj paPnj = pageSearchResult.clickLienBoss(driver);
		
		
		List <WebElement> listItemsBoss = paPnj.getListItemsBoss();
		for(int i=0; i!=listItemsBoss.size();i++) {
			
			PageItem pageItem = paPnj.clickItemLien(driver, listItemsBoss.get(i));
			String statItem = pageItem.statItemString();
			//assertEquals("Les Stat ne sont pas correct", expetedStatItem ,ActualStatItem);
			pageItem.returnPagePrecending(driver);
			
		}
		
		
		
		

	}
}
