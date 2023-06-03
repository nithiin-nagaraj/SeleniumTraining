package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class LoginPage extends BasePage {
 public LoginPage(WebDriver driver) {

 super(driver);
 }
 // Elements
 @FindBy(id = "user-name")
 WebElement uname;
 @FindBy(id = "password")
 WebElement pswd;
 @FindBy(id = "login-button")
 WebElement loginbtn;
 // Action Methods
 public void clickUserName(String usercred) {
 uname.sendKeys(usercred);
 }
 public void clickPassword(String userpswd) {
 pswd.sendKeys(userpswd);
 }
 public void clickLoginBtn() {
 loginbtn.click();
 }
}