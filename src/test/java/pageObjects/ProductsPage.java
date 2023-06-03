package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class ProductsPage extends BasePage {
 public ProductsPage(WebDriver driver) {
 super(driver);
 }
 // Elements
 @FindBy(id = "add-to-cart-sauce-labs-backpack")
 WebElement product1;
 @FindBy(id = "add-to-cart-sauce-labs-bike-light")
 WebElement product2;
 @FindBy(className = "shopping_cart_link")
 WebElement cart;
 // Action Methods
 public void addProd1() {
 product1.click();
 }
 public void addProd2() {
 product2.click();

 }
 public void clickCart() {
 cart.click();
 }
}
