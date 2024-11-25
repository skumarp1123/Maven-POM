package Annotatons;
	import java.io.FileInputStream;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	//import org.testng.Assert;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	public class ReadExcel {
		
		public String baseUrl = "https://demoblaze.com/";
//		String driverPath = "D:\\Softwares\\geckodriver-v0.31.0-win64\\geckodriver.exe";
		String driverPath = "C:\\Users\\Administrator\\Desktop\\Selenium\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe";
			public WebDriver driver; 
			JavascriptExecutor js = (JavascriptExecutor) driver; 
			
		@BeforeTest
		  public void launch() 
		{
		  System.setProperty("webdriver.chromedriver", driverPath);
		  driver= new ChromeDriver();
		  driver.get(baseUrl);
		  driver.manage().window().maximize();
		  System.out.println("launching application");
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
		}
		
		@Test (priority = 0)
		public void login() 
			{
			
			FileInputStream fis = new FileInputStream("C:\\Users\\Administrator\\Desktop\\Selenium\\TestData\\.xlsx");
			 workbook = new XSSFWorkbook(fis);
			 XSSFSheet ws = workbook.getSheetAt(0);
			
			 int rownum  = ws.getLastRowNum();
			 int colnum = ws.getRow(0).getPhysicalNumberOfCells();
			 System.out.println(colnum);
			 System.out.println(rownum);
			 XSSFCell login;
			 for(int i = 1; i <= rownum ; i++) 
			 {
				 
				 login= ws.getRow(i).getCell(0);
				 System.out.println("User logged in : "+login);
			
		  driver.findElement(By.xpath("//a[@id='login2']")).click();
		  
		  driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[2]/form")).click(); 
		  
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  	  
		  driver.findElement(By.id("loginusername")).sendKeys(login.toString());
//		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  driver.findElement(By.id("loginpassword")).sendKeys("siva");
		  
		  driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")).click();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  
		  System.out.println(driver.getTitle());
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 }	
		
		@Test(priority = 1)
		public void nameofuser()
		{
		String username =driver.findElement(By.id("nameofuser")).getText();
		System.out.println("User Name is:" +username);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		
		@Test(priority = 2)
		//Select a product>Add to cart>Chechout
		public void addtocart() 
		{
			//a[normalize-space()='Samsung galaxy s6']
		js.executeScript("window.scrollBy(0,250)"); //*[@id="tbodyid"]/div[1]/div/a/img
		 WebElement Element1=driver.findElement(By.xpath("//a[normalize-space()='Samsung galaxy s6']"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().back();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		js.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/div/h4/a")).click(); //*[@id="tbodyid"]/div[2]/div/a
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		
		@Test(priority = 3)
		public void checkout() 
		{
		driver.findElement(By.xpath("//*[@id=\"navbarExample\"]/ul/li[4]/a")).click(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//entering details for the check out
		driver.findElement(By.id("name")).sendKeys("Shiva");
		driver.findElement(By.id("country")).sendKeys("india");
		driver.findElement(By.id("city")).sendKeys("vizag");
		driver.findElement(By.id("card")).sendKeys("123");
		//Scroll down to enter details
		js.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.id("month")).sendKeys("nov");
		driver.findElement(By.id("month")).sendKeys("2024");
		
		driver.findElement(By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//swtich to pop up
		System.out.println(driver.switchTo().alert().getText());
		}
		
		@AfterTest
		public void logout() 
		{
			driver.findElement(By.id("logout2")).click();
			driver.close();
		}
		
	}




}
