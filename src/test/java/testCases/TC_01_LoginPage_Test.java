package testCases;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import testBase.BaseClass;
public class TC_01_LoginPage_Test extends BaseClass {
 @Test
 public void test_account_login() {
 logger.info("********* Starting TC_01_LoginPage_Test ******");
 LoginPage lp = new LoginPage(driver);
 lp.clickUserName(rb.getString("email"));
 lp.clickPassword(rb.getString("password"));
 lp.clickLoginBtn();
 logger.info("Login Success");
 }
}