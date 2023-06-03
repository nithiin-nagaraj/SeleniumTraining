package testBase;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger; // for logger
import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
 public static WebDriver driver;
 public ResourceBundle rb;
 public Logger logger;
 
 
 @BeforeClass
 public void setup() throws IOException {
 rb = ResourceBundle.getBundle("config");
 logger = LogManager.getLogger(this.getClass());
 WebDriverManager.chromedriver().setup();
 driver = new ChromeDriver();
 driver.manage().deleteAllCookies();
 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 //driver.get("https://www.saucedemo.com/");
 driver.get(rb.getString("appURL"));
 driver.manage().window().maximize();
 }

 @AfterClass
 public void tearDown() {
 driver.quit();
 }
 public String captureScreen(String tname) throws IOException {
 /*Date dt=new Date();
 SimpleDateFormat df=new SimpleDateFormat("yyyyMMddhhmmss");
 String timeStamp=df.format(dt);
 */
 String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
 TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
 File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
 String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" +
timeStamp + ".png";
 try {
 FileUtils.copyFile(source, new File(destination));
 } catch (Exception e) {
 e.getMessage();
 }
 return destination;
 }
}