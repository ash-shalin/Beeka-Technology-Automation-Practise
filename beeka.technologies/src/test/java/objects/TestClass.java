package objects;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;

import pages.CartPage;
import pages.CheckOutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MenuPage;
import pages.OverviewPage;
import utilities.TakeScreenShot;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestClass {
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	CartPage cartPage;
	CheckOutPage checkOutPage;
	OverviewPage overviewPage;
	MenuPage menuPage;
	TakeScreenShot takeScreenShot;
	ExtentReports extent;

	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		cartPage = new CartPage(driver);
		checkOutPage = new CheckOutPage(driver);
		overviewPage = new OverviewPage(driver);
		menuPage = new MenuPage(driver);
		takeScreenShot = new TakeScreenShot();
	}

	@BeforeTest
	public void getReportObject() {

		String path = System.getProperty("user.dir") + "//reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Sauce Demo Automation Results");
		reporter.config().setReportName("Beeka Technologies Automation Practise");
		reporter.config();
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Automation Tester", "Ashik Shalin");
	}

	@Test(priority = 1)
	public void loginAndAddToCart() {

		
		extent.createTest("loginAndAddToCart");
		// login with credentials
		loginPage.login("standard_user", "secret_sauce");
		System.out.println("Login Successfull");

		// Add items to the cart
		homePage.backPackAddToCart();
		homePage.bikeLightAddToCart();
		System.out.println("successfully added items to cart");
		extent.flush();

	}

	@Test(priority = 2)
	public void removeItemAndCheckout() throws InterruptedException {
		extent.createTest("removeItemAndCheckout");
		cartPage.goToCart();

		cartPage.removeItem();
		cartPage.clickCheckout();
		checkOutPage.checkoutComplete("test_first-name", "test_last-name", "123456");
		extent.flush();

	}

	@Test(priority = 3)
	public void getTextofItemTotalAndtotal() {
		extent.createTest("getTextofItemTotalAndtotal");
		System.out.println(overviewPage.getItemTotal());
		System.out.println(overviewPage.getTotal());
		overviewPage.completePurchase();
		TakeScreenShot takeScreenShot = new TakeScreenShot();
		takeScreenShot.printScreen(driver, "completedpurchase.png");
		extent.flush();

	}

	@Test(priority = 4)
	public void loggingOutFromMenuPage() {
		extent.createTest("loggingOutFromMenuPage");
		menuPage.openMenu();
		menuPage.logout();
		extent.flush();

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
