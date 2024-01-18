package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWait;

public class CheckOutPage {

	WebDriver driver;

	ExplicitWait explicitWait;

	@FindBy(id = "first-name")
	WebElement firstNameInput;

	@FindBy(id = "last-name")
	WebElement lastNameInput;

	@FindBy(id = "postal-code")
	WebElement postalCodeInput;

	@FindBy(xpath = "//input[@type=\"submit\"]")
	WebElement continueButton;

	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.explicitWait = new ExplicitWait(driver);

	}

	public void checkoutComplete(String firstName, String lastName, String postalCode) {
		explicitWait.procedure(firstNameInput);
		firstNameInput.sendKeys(firstName);
		lastNameInput.sendKeys(lastName);
		postalCodeInput.sendKeys(postalCode);
		continueButton.click();
		System.out
				.println("check out completed with provided details:" + firstName + "," + lastName + "," + postalCode);

	}

}
