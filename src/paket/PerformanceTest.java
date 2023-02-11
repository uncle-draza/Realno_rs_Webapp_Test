package paket;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.Assert;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class PerformanceTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void performance() {
	  double v1 = System.currentTimeMillis();
	  driver.get("https://realno.rs/");
	  double t1 = System.currentTimeMillis();
	  double r= t1 - v1;
	  System.out.println(r);

	  
	  
	  double v2 = System.currentTimeMillis();
	  driver.get("https://realno.rs/Filmovi/John-Wick/Blue-Portait-John-Wick-Majica");
	  double t2 = System.currentTimeMillis();
	  double r2= t2 - v2;
	  System.out.println(r2);
		
		
	  
	  double v3 = System.currentTimeMillis();
	  driver.get("https://realno.rs/index.php?route=account/login");
	  double t3 = System.currentTimeMillis();
	  double r3= t3 - v3;
	  System.out.println(r3);


	  
	  double v4 = System.currentTimeMillis();
	  driver.get("https://realno.rs/index.php?route=information/contact");
	  double t4 = System.currentTimeMillis();
	  double r4= t4 - v4;
	  System.out.println(r4);


	  
	  double v5 = System.currentTimeMillis();
	  driver.get("https://realno.rs/index.php?route=checkout/cart");
	  double t5 = System.currentTimeMillis();
	  double r5= t5 - v5;
	  System.out.println(r5);
		
	  double s_vrednost = (r + r2 + r3 + r4 + r5)/5;

	  System.out.println("Srednja vrednost: " + s_vrednost);
  }
}
