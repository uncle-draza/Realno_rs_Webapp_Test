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
import java.util.logging.Logger;
import java.io.FileWriter;
import java.net.MalformedURLException;
import java.net.URL;

public class PretragaTest 
{
  private WebDriver driver;
  private Logger l = Logger.getLogger(PretragaTest.class.getName());
  private Map<String, Object> vars;
  JavascriptExecutor js;
  String searchWord = "bending bars";
  
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
  public void pretraga() 
  {
    driver.get("https://realno.rs/");
    driver.manage().window().setSize(new Dimension(1382, 754));
    driver.findElement(By.name("search")).click();
    driver.findElement(By.name("search")).sendKeys(searchWord);
    driver.findElement(By.name("search")).sendKeys(Keys.ENTER);
    {
      WebElement element = driver.findElement(By.id("btn-grid-view"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    driver.findElement(By.id("btn-grid-view")).click();
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
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
    driver.findElement(By.cssSelector(".product-layout:nth-child(1) .name > a")).click();
    String result = driver.findElement(By.cssSelector("#product > .title")).getText();
    result = result.toLowerCase();
    boolean isContained = result.contains(searchWord) ? true : false;
    
    Assert.assertTrue(isContained);
    
    String izvestaj ="\nIme testa : Pretraga proizvoda \n"+
     	   "Opis testa : Provera funkcije pretrage proizvoda \n"+
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
