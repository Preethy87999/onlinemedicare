package testPage;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.simplilearn.medicare.AddItems;
import com.simplilearn.medicare.AddMultiItems;
import com.simplilearn.medicare.CheckoutPage;
import com.simplilearn.medicare.LoginPage;
import com.simplilearn.medicare.RegisterPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MedicarePageTest {

	public static WebDriver driver =null;
	@BeforeTest
	public void homePage() {
		// WebDriverManager.chromedriver().setup();
		// driver = new ChromeDriver();
		// driver.manage().window().maximize();
		// driver.manage().deleteAllCookies();
		// driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// driver.get("http://localhost:8081/medicare/");	

		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized"); // open Browser in maximized mode
		options.addArguments("disable-infobars"); // disabling infobars
		options.addArguments("--disable-extensions"); // disabling extensions
		options.addArguments("--disable-gpu"); // applicable to windows os only
		options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
		options.addArguments("--no-sandbox"); // Bypass OS security model
		
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8081/medicare/");
	}
	
	@Test(priority =1)
	public static void userRegisterPageVerfiy() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div/ul[2]/li[1]")).click();
		Thread.sleep(1000);
		RegisterPage signUpObj = new RegisterPage(driver);
		signUpObj.sendTextForSign("preethy", "v s", "pooja37@gmail.com", "7777775589", "pree123", "pree123");
		String title2 = "Medicare - Membership";
		AssertJUnit.assertEquals(title2, driver.getTitle());
		signUpObj.clickBtnbill();
		Thread.sleep(1000);
		signUpObj.sendTextForBill("aaa", "bbb", "chennai", "6320602", "TamilNadu", "India");
		signUpObj.clickBtnconfirm();
		Thread.sleep(1000);
	   driver.findElement(By.xpath("(//a[normalize-space()='Confirm'])[1]")).click();
        
	}
	
	@Test(priority =2)
	public void userLoginPageVerify() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[normalize-space()='Login Here'])[1]")).click();
		Thread.sleep(1000);
        LoginPage loginPageObj = new LoginPage(driver);
        loginPageObj.sendTextInLogin("preethycse20@gmail.com", "pree123");
        String title = driver.getTitle();
        AssertJUnit.assertEquals(title,"Medicare - Login");
        loginPageObj.clickBtnLogin();
        
	}
	
	

	@Test(priority=5)
	public void logoutPage() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.id("dropdownMenu1")).click();
		driver.findElement(By.id("logout")).click();
		System.out.println(driver.findElement(By.cssSelector(".alert.alert-success")).getText());
	}
	
	@Test(priority =3)
	public void validateSingleProduct() throws InterruptedException {
		Thread.sleep(2000);
		AddItems additemobj = new  AddItems(driver);
		additemobj.addSingleItem();
		Thread.sleep(2000);
		additemobj.btnforadd();
		String text3 ="Product has been successfully added inside cart!";
		String actualText= driver.findElement(By.cssSelector("div[class='alert alert-info'] h3[class='text-center']")).getText();
		AssertJUnit.assertEquals(text3, actualText);
		Thread.sleep(2000);
		additemobj.cartpage();
		AssertJUnit.assertEquals("Paracetamol", driver.findElement(By.tagName("h4")).getText());
		Thread.sleep(2000);
		CheckoutPage checkoutobj = new CheckoutPage(driver);
		checkoutobj.checkoutbtn();
		Thread.sleep(1000);
		checkoutobj.payment();
		Thread.sleep(2000);
		checkoutobj.confirmPayment();
		Thread.sleep(1000);
		
	}
	
	@Test(priority=4)
	public void verfiyMultiProductAdd() throws InterruptedException{
		Thread.sleep(2000);
		AddMultiItems addmultiobj = new AddMultiItems(driver);
		addmultiobj.multiProducts();
		Thread.sleep(2000);
		CheckoutPage checkoutobj = new CheckoutPage(driver);
		checkoutobj.checkoutbtn();
		Thread.sleep(2000);
		checkoutobj.payment();
		checkoutobj.confirmPayment();
		int expecteditems= 5;
		int actualitems= driver.findElements(By.cssSelector("tbody tr td:nth-child(1)")).size();
		AssertJUnit.assertEquals(actualitems,expecteditems);
		
	}
	
	@Test(priority =6)
	public static void supplierRegisterPageVerify() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("a[href='/medicare/membership']")).click();
		Thread.sleep(1000);
		RegisterPage signUpObj = new RegisterPage(driver);
		signUpObj.sendTextForSignSupplier("Ravi", "R", "ravi6@gmail.com", "7777773389", "ravi", "ravi");
		String title2 = "Medicare - Membership";
		AssertJUnit.assertEquals(title2, driver.getTitle());
		signUpObj.clickBtnbill();
		Thread.sleep(1000);
		signUpObj.sendTextForBill("xxx", "yyy", "Banglore", "6320602", "TamilNadu", "India");
		Thread.sleep(1000);
		signUpObj.clickBtnconfirm();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[normalize-space()='Confirm'])[1]")).click();
        
	}
	
	@Test(priority=7)
	public static void supplierLoginPageVerify() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[normalize-space()='Login Here'])[1]")).click();
		Thread.sleep(1000);
        LoginPage loginPageObj = new LoginPage(driver);
        loginPageObj.sendTextInLogin("ravi@gmail.com", "ravi");
        Thread.sleep(1000);
        String title = driver.getTitle();
        AssertJUnit.assertEquals(title,"Medicare - Login");
        loginPageObj.clickBtnLogin();
	}
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}
