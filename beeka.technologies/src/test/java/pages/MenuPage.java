package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWait;

public class MenuPage {
	WebDriver driver;
	
	ExplicitWait explicitWait;

	@FindBy(id = "react-burger-menu-btn")
	WebElement menuButton;

	@FindBy(id = "logout_sidebar_link")
	WebElement logoutButton;

	public MenuPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.explicitWait = new ExplicitWait(driver);
	}

	public void openMenu() {

		menuButton.click();
		explicitWait.procedure(menuButton);
	}

	public void logout() {
		explicitWait.procedure(logoutButton);
		logoutButton.click();
	}
}
