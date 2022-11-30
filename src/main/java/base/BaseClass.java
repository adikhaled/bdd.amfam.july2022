package base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.BasicInfoAboutYou;
import pages.ContinueToHomePage;
import pages.HomePage;
import pages.LetsGoStarted;
import utils.Configuration;
import static utils.IConstant.*;
import java.time.Duration;

public class BaseClass {

	public Configuration config = new Configuration();
	public static HomePage homePage;
	public static LetsGoStarted letsGoStarted;
	public static ContinueToHomePage continueToHomePage;
	public static BasicInfoAboutYou basicInfoAboutYou;
	public static WebDriver driver;

	public void setUpDriver() {
			initDriver(config.getProperty(BROWSER));
			driver.manage().window().maximize();
			driver.get(config.getProperty((URL))); 
			long pageLoadTime = Long.parseLong(config.getProperty(PAGELOAD_WAIT));
			long implicitWait = Long.parseLong(config.getProperty(IMPLICIT_WAIT));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTime));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
			initObjectClasess();
		}

		private void initDriver(String browser) {
			switch (browser) {
			case CHROME:
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case FIREFOX:
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case EDGE:
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;

			default:
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			}
		}

    public static void initObjectClasess() {
    	homePage=new HomePage(driver);
    	letsGoStarted=new LetsGoStarted(driver);
    	continueToHomePage =new ContinueToHomePage(driver);
    	//enterYourAddress = new EnterYourAddress(driver);
    }
    
	public WebDriver getDriver() {
		return driver;
	}
	
	
	public void closingTheDriverSession() {
		getDriver().quit();
	}

}
