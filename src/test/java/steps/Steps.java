package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Steps extends BaseClass {

	WebDriver driver;
	WebElement element;

	@Given("user navigate to homePage")
	public void user_navigate_to_home_page() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amfam.com/");
		System.out.println("This is Given");

	}

	@When("user click start new quote")
	public void user_click_start_new_quote() {
		element = driver.findElement(By.xpath("(//button[@class='OpenQrfButton button-primary'])[3]"));
		element.click();
		System.out.println("This is When");

	}

	@When("user input zipcode")
	public void user_input_zipcode() {
		element = driver.findElement(By.xpath("//input[@name='zipCode']"));
		element.sendKeys("85141");
		System.out.println("This is When");
	}

	@When("user click car insurance option")
	public void user_click_car_insurance_option() {
		element = driver.findElement(By.xpath("(//div[@class='SelectionTiles__tile QrfProductTiles__tile'])[1]"));
		element.click();
		System.out.println("This is When");
	}

	@When("user click lets go button")
	public void user_click_lets_go_button() {
		element = driver.findElement(By.className("LoadingButton__content"));
		element.click();
		System.out.println("This is When");
	}

	@When("select address,city and state")
	public void select_city_and_state() {
		element = driver.findElement(By.xpath("//input[@id='pni-residence-address-line-1-id']"));
		element.sendKeys("1074 E 14Th street");
		System.out.println("This is When");
	}

	@When("user click on continue button")
	public void user_click_on_continue_button() {
		System.out.println("This is When");
	}

	@When("continue overlay handled")
	public void continue_overlay_handled() {
		System.out.println("This is When");
	}

	@Then("title of the page will be <auto quote page>")
	public void title_of_the_page_will_be_auto_quote_page() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println("This is Then");
	}

	@When("user input address")
	public void user_input_address() {
		System.out.println("This is When");
	}

	@Then("user able to click start new quote button")
	public void user_able_to_click_start_new_quote_button() {
		System.out.println("This is Then");
	}
}
