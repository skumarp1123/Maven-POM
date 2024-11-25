package BDD;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class googleimagesearch {
	public static WebDriver driver;
	//public WebElement searchbox;
	@Given("user is on google home")
	public void user_is_on_google_home() {
		driver= new ChromeDriver();
		System.setProperty("webdriver.ChromeDriver", "C:\\Users\\Administrator\\Desktop\\Selenium\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver.get("http://www.google.com");
	}

	@When("user clicks image hyperlink")
	public void user_clicks_image_hyperlink() {
		driver.findElement(By.linkText("Images")).click();
	}

	@Then("user navigates to Google image page")
	public void user_navigates_to_google_image_page() {
		if(driver.getTitle().equalsIgnoreCase(
		         "Google Images")){ 
		            System.out.println("Navigated to Google Image Page"); 
		      } else { 
		         System.out.println("Not on Google Image Page :("); 
		      }   
	}

	@Given("user enter search word")
	public void user_enter_search_word(DataTable searchword) throws InterruptedException {
		//for(int i=0;i<2;i++){
		Thread.sleep(3000);
		driver.findElement(By.name("q")).sendKeys(searchword.cell(0, 0));
		//}
			
	}

	@When("user clicks enter")
	public void user_clicks_enter() throws InterruptedException {
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
	}

	@Then("user navigates to search result page")
	public void user_navigates_to_search_result_page() {
		System.out.println(driver.getTitle());
		driver.close();
	}

}
