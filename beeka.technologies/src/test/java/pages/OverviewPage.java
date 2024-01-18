package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWait;
import utilities.TakeScreenShot;

public class OverviewPage {
	WebDriver driver;
	ExplicitWait explicitWait;
	TakeScreenShot takeScreenShot;
	
	@FindBy(xpath = "//div[@class='summary_subtotal_label']")
	WebElement itemTotal;

	@FindBy(xpath = "//div[@class='summary_info_label summary_total_label']")
	WebElement total;
	
	@FindBy(id="finish")
	WebElement finishButton;

	public OverviewPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		 this.explicitWait = new ExplicitWait(driver);
		 this.takeScreenShot = new TakeScreenShot();
	}
	
	public String getItemTotal() {
		explicitWait.procedure(itemTotal);
		 return itemTotal.getText();
	}

	public String getTotal() {
		explicitWait.procedure(total);
		return total.getText();
	}
	public void completePurchase() {
		finishButton.click();
	}
	
}
