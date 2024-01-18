package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class LoginPage {
	WebDriver driver;

    @FindBy(id = "user-name")
    WebElement usernameInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(id = "login-button")
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
    	SoftAssert softAssert=new SoftAssert();
    	String actualTitle=driver.getTitle();
    	String expectedTitle="Swag Labs";
    	softAssert.assertEquals(actualTitle,expectedTitle, "Title Does Not Match" );
    	softAssert.assertEquals(loginButton.isDisplayed(),true, "Login Button Not Found");
    	softAssert.assertAll();
    	
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }
}
