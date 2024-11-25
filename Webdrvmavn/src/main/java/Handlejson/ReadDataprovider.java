package Handlejson;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadDataprovider {
static String driverPath ="C:\\Users\\Administrator\\Desktop\\Selenium\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe";
	
	@DataProvider(name="Testdata")
	public Object[][] getData()
	{
		Object[][] data = new Object[3][2];// 2 dimentional array rows and col
		//row 1 data
		data[0][0]="happyrockstar";
		data[0][1]="R0ckst@r";
		//row 2 data
		data[1][0]="happyhours01";
		data[1][1]="H@ppyH0ur$";
		//row 3 data
		data[2][0]="happyrockstar";
		data[2][1]="R0ckst@r";
		return data;
	}
	
	@Test(dataProvider="Testdata")
	public void Loginvalidation(String username, String password) throws InterruptedException
	{
		System.setProperty("webdriver.chromedriver", driverPath);
		ChromeDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.demoblaze.com/");
		
		
		driver.findElement(By.linkText("Log in")).click();
	    driver.findElement(By.id("loginusername")).sendKeys(username);
	    driver.findElement(By.id("loginpassword")).sendKeys(password);
	    driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
	    Thread.sleep(3000);
	    System.out.println(driver.findElement(By.id("nameofuser")).getText());
	    driver.findElement(By.xpath("//a[@id='logout2']")).click();
		driver.close();
	}

}
	
