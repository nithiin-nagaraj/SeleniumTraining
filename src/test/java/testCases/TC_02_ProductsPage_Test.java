package testCases;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;
import testBase.BaseClass;
public class TC_02_ProductsPage_Test extends BaseClass {
 @Test
 public void test_products() {
 logger.info("********* Starting TC_1_LoginPage_Test ******");
 LoginPage lp = new LoginPage(driver);
 lp.clickUserName(rb.getString("email"));
 lp.clickPassword(rb.getString("password"));
 lp.clickLoginBtn();
 logger.info("Login Success");
 
 
 logger.info("********* TC_2_ProductsPage_Test ******");
 ProductsPage pp = new ProductsPage(driver);
 pp.addProd1();
 pp.addProd2();
 pp.clickCart();
 logger.info("Products Added Success");
 }
}