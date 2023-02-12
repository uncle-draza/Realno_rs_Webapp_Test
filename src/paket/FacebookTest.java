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

public class FacebookTest 
{
  private WebDriver driver;
  private Logger l = Logger.getLogger(FacebookTest.class.getName());
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
  public void facebook() throws InterruptedException 
  {
    driver.get("https://realno.rs/");
    driver.manage().window().setSize(new Dimension(1382, 754));
    {
      WebElement element = driver.findElement(By.cssSelector(".search-button"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    driver.findElement(By.cssSelector(".top-menu-14 .top-menu-item-1 > a")).click();
    Thread.sleep(5000);
    assertEquals(driver.getCurrentUrl(),"https://www.facebook.com/Realno.rs");
    
    String izvestaj ="\nIme testa : Facebook test \n"+
     	   "Opis testa : Otvaranje Facebook stranice sajta. \n"+
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
