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

public class ProveraPodatakaTest 
{
  private WebDriver driver;
  private Logger l = Logger.getLogger(ProveraPodatakaTest.class.getName());
  private Map<String, Object> vars;
  JavascriptExecutor js;
  
  String ime;
  String prezime;
  String email;
  String telefon;
  
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
  public void proveraPodataka() 
  {
    driver.get("https://realno.rs/");
    driver.manage().window().setSize(new Dimension(1382, 754));
    driver.findElement(By.cssSelector(".links-menu-76 .links-menu-item-3 .links-text")).click();
    driver.findElement(By.cssSelector(".links-menu-76 .links-menu-item-1 .links-text")).click();
    driver.findElement(By.id("input-email")).click();
    driver.findElement(By.id("input-email")).sendKeys("dilpdrazovic@gmail.com");
    driver.findElement(By.id("input-password")).click();
    driver.findElement(By.id("input-password")).sendKeys("Realnolozinka123!");
    driver.findElement(By.cssSelector(".buttons:nth-child(3) .btn")).click();
    driver.findElement(By.linkText("Izmeni lične podatke")).click();
    driver.findElement(By.id("input-firstname")).click();
    {
      String value = driver.findElement(By.id("input-firstname")).getAttribute("value");
      ime = value;
      assertThat(value, is("Dragoljub"));
    }
    driver.findElement(By.id("input-lastname")).click();
    {
      String value = driver.findElement(By.id("input-lastname")).getAttribute("value");
      prezime = value;
      assertThat(value, is("Drazovic"));
    }
    driver.findElement(By.id("input-email")).click();
    {
      String value = driver.findElement(By.id("input-email")).getAttribute("value");
      email = value;
      assertThat(value, is("dilpdrazovic@gmail.com"));
    }
    driver.findElement(By.id("input-telephone")).click();
    {
      String value = driver.findElement(By.id("input-telephone")).getAttribute("value");
      telefon = value;
      assertThat(value, is("+381613213743"));
    }
    
    String izvestaj ="\nIme testa : Provera podataka\n"+
       	   "Opis testa : Provera podataka unetih prilikom kreiranja naloga \n"+
    	   "Podaci:\n" + "Ime: " + ime + "\nPrezime: " + prezime + "\nEmail adresa: " + email + "\nBroj telefona: " + telefon +
           "\nTest je uspesno izvrsen! \n\n";
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
