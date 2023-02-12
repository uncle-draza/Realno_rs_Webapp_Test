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

public class PrijavaTest 
{
  private WebDriver driver;
  private Logger l = Logger.getLogger(PrijavaTest.class.getName());
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
  public void prijava() throws InterruptedException 
  {
    driver.get("https://realno.rs/");
    driver.manage().window().setSize(new Dimension(1382, 754));
    driver.findElement(By.cssSelector(".links-menu-76 .links-menu-item-2 .links-text")).click();
    driver.findElement(By.id("input-email")).click();
    driver.findElement(By.id("input-email")).sendKeys("dilpdrazovic@gmail.com");
    driver.findElement(By.id("input-password")).click();
    driver.findElement(By.id("input-password")).sendKeys("Realnolozinka123!");
    driver.findElement(By.cssSelector(".btn > span")).click();
    Thread.sleep(5000);
    assertEquals(driver.getCurrentUrl(), "https://realno.rs/index.php?route=account/account");
    
    String izvestaj ="\nIme testa : Prijava korisnika na sajt\n"+
      	   "Opis testa : Testiranje funkcije prijavljivanja korisnika na svoj nalog na sajtu \n"+
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
