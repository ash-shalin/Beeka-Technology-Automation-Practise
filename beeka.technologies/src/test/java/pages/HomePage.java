package pages;

//pages/HomePage.java

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ExplicitWait;

public class HomePage {
 WebDriver driver;

 @FindBy(id = "item_4_title_link")
 WebElement bagpack;

 @FindBy(id = "item_0_title_link")
 WebElement bikeLight;

 @FindBy(xpath = "(//button[contains(text(),'Add to')])[1]")
 WebElement bagpackAddtoCart;

 @FindBy(xpath = "(//button[contains(text(),'Add to')])[1]")  
 WebElement bikeLightAddtoCart;

 ExplicitWait explicitWait;

 public HomePage(WebDriver driver) {
     this.driver = driver;
     PageFactory.initElements(driver, this);
     this.explicitWait = new ExplicitWait(driver);
 }

 public void backPackAddToCart() {
	 explicitWait.procedure(bagpack);
     bagpackAddtoCart.click();
 }

 public void bikeLightAddToCart() {
	 explicitWait.procedure(bikeLight);
     bikeLightAddtoCart.click();
 }
}
