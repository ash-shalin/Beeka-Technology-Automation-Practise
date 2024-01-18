package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	WebDriver driver;

	@FindBy(id = "checkout")
	WebElement checkoutButton;

	@FindBy(id = "shopping_cart_container")
	WebElement cartIcon;

	@FindBy(id = "remove-sauce-labs-bike-light")
	WebElement removeButton;

	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void goToCart() {
		cartIcon.click();
	}

	public void removeItem() {
		removeButton.click();
	}

	public void clickCheckout() {

		checkoutButton.click();
	}

}
