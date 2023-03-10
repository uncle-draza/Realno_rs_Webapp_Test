package paket;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
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
import java.util.logging.Logger;
import java.io.FileWriter;
import java.net.MalformedURLException;
import java.net.URL;

public class DodavanjeUKorpuTest 
{
  private WebDriver driver;
  private Logger l = Logger.getLogger(DodavanjeUKorpuTest.class.getName());
  private Map<String, Object> vars;
  JavascriptExecutor js;
  
  @Before
  public void setUp() 
  {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  
  @After
  public void tearDown() 
  {
    driver.quit();
  }
  
  @Test
  public void dodavanjeUKorpu1() throws InterruptedException 
  {
    driver.get("https://realno.rs/");
    driver.manage().window().setSize(new Dimension(1382, 754));
    driver.findElement(By.cssSelector(".accordion-menu-item-2 > a > .links-text")).click();
    driver.findElement(By.id("MzQzNzozNTg=-1")).click();
    driver.findElement(By.id("btn-list-view")).click();
    driver.findElement(By.id("btn-grid-view")).click();
    {
      WebElement element = driver.findElement(By.id("btn-list-view"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    driver.findElement(By.id("btn-list-view")).click();
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    driver.findElement(By.linkText("Black - Alien - Poster sa nosa??em")).click();
    Thread.sleep(4000);
    driver.findElement(By.cssSelector("#button-cart > .btn-text")).click();
    Thread.sleep(4000);
    driver.findElement(By.cssSelector(".accordion-menu-item-1 > a > .links-text")).click();
    driver.findElement(By.id("MzQ0NDozODY=-1")).click();
    driver.findElement(By.id("btn-grid-view")).click();
    {
      WebElement element = driver.findElement(By.id("btn-list-view"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    driver.findElement(By.id("btn-list-view")).click();
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    driver.findElement(By.linkText("All Green - Breaking Bad - Ceger")).click();
    driver.findElement(By.cssSelector("#button-cart > .btn-text")).click();
    Thread.sleep(4000);
    driver.findElement(By.cssSelector(".accordion-menu-item-4 > a > .links-text")).click();
    driver.findElement(By.cssSelector(".refine-item:nth-child(2) img")).click();
    driver.findElement(By.id("btn-grid-view")).click();
    {
      WebElement element = driver.findElement(By.id("btn-list-view"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    driver.findElement(By.id("btn-list-view")).click();
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    
    driver.findElement(By.linkText("Call Of Duty - Black Ops 4 - ??olja")).click();
    driver.findElement(By.cssSelector("#button-cart > .btn-text")).click();
    Thread.sleep(4000);
    driver.findElement(By.cssSelector(".fa-shopping-cart")).click();
    driver.findElement(By.linkText("Call Of Duty - Black Ops 4 - ??olja")).click();
    assertThat(driver.findElement(By.cssSelector("#product > .title")).getText(), is("CALL OF DUTY - BLACK OPS 4 - ??OLJA"));
    driver.findElement(By.cssSelector(".fa-shopping-cart")).click();
    driver.findElement(By.linkText("All Green - Breaking Bad - Ceger")).click();
    assertThat(driver.findElement(By.cssSelector("#product > .title")).getText(), is("ALL GREEN - BREAKING BAD - CEGER"));
    driver.findElement(By.cssSelector(".fa-shopping-cart")).click();
    driver.findElement(By.linkText("Black - Alien - Poster sa nosa??em")).click();
    assertThat(driver.findElement(By.cssSelector("#product > .title")).getText(), is("BLACK - ALIEN - POSTER SA NOSA??EM"));
    
    String izvestaj ="\nIme testa : Dodavanje proizvoda u korpu \n"+
            	   "Opis testa : Dodavanje tri proizvoda iz razlicitih kategorija u korpu \n"+
                   "Test je uspesno izvrsen! \n\n";
    l.info(izvestaj.toString());
    try 
    {
    	FileWriter fw = new FileWriter("C:\\Users\\dilpd\\Desktop\\test-report.txt", true);
    	fw.write(izvestaj.toString());
    	fw.flush();
    	fw.close();
    }
    catch (Exception e) 
    {
    	System.out.println(e.getMessage());
  	}
  }
}
