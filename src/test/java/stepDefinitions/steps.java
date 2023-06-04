package stepDefinitions;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;
//import utilities.DataReader;
public class steps {
WebDriver driver;
LoginPage lp;
ProductsPage pp;
List<HashMap<String, String>> datamap; //Data driven
public Logger logger; //for logging
public ResourceBundle rb; // for reading properties file
public String br; //to store browser name
@Before
public void setup() //Junit hook - executes once before starting
{
//for logging
logger= LogManager.getLogger(this.getClass());
//Reading config.properties (for browser)
rb=ResourceBundle.getBundle("config");
br=rb.getString("browser");
pp=new ProductsPage(driver);

}
@After
public void tearDown(Scenario scenario) {
System.out.println("Scenario status ======>"+scenario.getStatus());
if(scenario.isFailed()) {
byte[] screenshot = ((TakesScreenshot)
driver).getScreenshotAs(OutputType.BYTES);
scenario.attach(screenshot, "image/png",scenario.getName());
}
driver.quit();
}
@Given("User Launch browser")
public void user_launch_browser() {
if(br.equals("chrome"))

{
driver=new ChromeDriver();
}
else if (br.equals("firefox")) {
driver = new FirefoxDriver();
}
else if (br.equals("edge")) {
driver = new EdgeDriver();
}
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
}
//Login-feature
@Given("opens URL {string}")
public void opens_url(String url) {
driver.get(url);
driver.manage().window().maximize();
}

@When("browser navigate to Login Page")
public void browser_navigate_to_login_page() {
logger.info("Navigated to Login Page ");
}
@When("User enters Username as {string} and Password as {string}")
public void user_enters_username_as_and_password_as(String email, String
pwd) {

lp=new LoginPage(driver);
lp.clickUserName(email);
logger.info("Provided Email ");
lp.clickPassword(pwd);
logger.info("Provided Password ");
}
@When("Click on Login button")
public void click_on_login_button() {



lp.clickLoginBtn();

logger.info("Clicked on Login button");
}
@Then("User navigates to Products Page")
public void user_navigates_to_products_page() {
//ProductsPage pp=new ProductsPage(driver);
logger.info("Navigated to products Page ");
}
//ProductPage-feature
@Then("User Added Product1")
public void user_added_product1() {
pp.addProd1();
}
@Then("User Added Product2")
public void user_added_product2() {
pp.addProd2();
}
@Then("User clicks on the Cart button")
public void user_clicks_on_the_cart_button() {
pp.clickCart();
logger.info("Products Added Success");
}

}