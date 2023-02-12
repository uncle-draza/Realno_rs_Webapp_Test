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

public class ONamaTest 
{
  private WebDriver driver;
  private Logger l = Logger.getLogger(ONamaTest.class.getName());
  private Map<String, Object> vars;
  JavascriptExecutor js;
  String onama;
  
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
  public void oNama() 
  {
    driver.get("https://realno.rs/");
    driver.manage().window().setSize(new Dimension(1366, 738));
    driver.findElement(By.cssSelector(".links-menu-item-9 .links-text")).click();
    onama = driver.findElement(By.cssSelector(".content > p:nth-child(1)")).getText() + "\n";
    for(int i = 2; i<=14; i++)
    {
    	onama += driver.findElement(By.cssSelector("p:nth-child("+i+")")).getText();
    	onama += "\n";
    }
    onama += driver.findElement(By.cssSelector(".nitro-offscreen:nth-child(15)")).getText();
    onama += "\n";
    onama += driver.findElement(By.cssSelector(".nitro-offscreen:nth-child(16)")).getText();
    
    System.out.println(onama);
    String izvestaj ="\nIme testa : O nama \n"+
      	   "Opis testa : Prikupljanje podataka o sajtu \n"+
    	   onama + "\n" +
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
