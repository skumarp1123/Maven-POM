package POM;

public class dbDashboard {
	
//	public class OHRMLoginPage {
//
//	    WebDriver driver;
//	  
//	    By userName = By.name("username");
//	    By password = By.name("password");
//	    By login = By.xpath("//button[@type='submit']");
//
//	    public OHRMLoginPage(WebDriver driver){
//	        this.driver = driver;
//	    }
//
//	    //Set user name in textbox
//
//	    public void setUserName(String strUserName){
//	    driver.findElement(userName).sendKeys(strUserName);
//	    }
//
//	    //Set password in password textbox
//
//	    public void setPassword(String strPassword){
//	    driver.findElement(password).sendKeys(strPassword);
//	    }
//
//	    //Click on login button
//
//	    public void clickLogin(){
//	    driver.findElement(login).click();
//	    }
//
//	    public void loginToOHRM(String strUserName,String strPasword){
//	    //Fill user name
//	    this.setUserName(strUserName);
//	    //Fill password
//	    this.setPassword(strPasword);
//	    //Click Login button
//	    this.clickLogin();        
//	    }
//
//	}
//
//	dashboardclass
//
//	public class OHRMHomePage {
//	   WebDriver driver;
//	   By homePageUserName = By.xpath("//p[@class='oxd-userdropdown-name']");
//
//	public OHRMHomePage(WebDriver driver){
//	   this.driver = driver;}
//	   //Get the User name from Home Page
//
//	public String getHomePageDashboardUserName(){
//	   return driver.findElement(homePageUserName).getText();
//	 }
//	}
//
//	TestClass
//
//	import POM.OHRMHomePage;
//	import POM.OHRMLoginPage;
//
//	public class OHRMTest {
//
//	    String driverPath = "D:\\Softwares\\geckodriver-v0.31.0-win64\\geckodriver.exe";
//	    WebDriver driver;
//
//	    OHRMLoginPage objLoginPage;
//	    OHRMHomePage objHomePage;
//
//	    @BeforeTest
//	    public void setup(){
//
//		System.setProperty("webdriver.gecko.driver", driverPath);
//	        driver = new FirefoxDriver();
//	        driver.get("https://opensource-demo.orangehrmlive.com/");
//	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//	      }
//
//	    @Test(priority=0)
//	    public void test_Home_Page_Appear_Correct(){
//	    //Create Login Page object
//	    objLoginPage = new OHRMLoginPage(driver);
//	    //login to application
//	    objLoginPage.loginToOHRM("Admin", "admin123");
//	    // go the next page
//	    objHomePage = new OHRMHomePage(driver);
//	    //Verify home page
//	    //Assert.assertTrue(objHomePage.getHomePageDashboardUserName().matches(".*"));
//	    Assert.assertTrue(objHomePage.getHomePageDashboardUserName().matches("[a-z|A-Z|\\W]+"));
//	    driver.close();
//	    }
//	    

}
