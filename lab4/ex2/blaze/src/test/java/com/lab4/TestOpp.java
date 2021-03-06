// Generated by Selenium IDE
import static org.assertj.core.api.Assertions.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.HashMap;
import io.github.bonigarcia.seljup.SeleniumJupiter;

@ExtendWith(SeleniumJupiter.class)
public class TestOpp  {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @BeforeEach
  public void setUp() {
    driver = new FirefoxDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @AfterEach
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void testOpp() {
    // Test name: testOpp
    // Step # | name | target | value
    // 1 | open | / | 
    driver.get("https://blazedemo.com/");
    // 2 | setWindowSize | 1920x1048 | 
    driver.manage().window().setSize(new Dimension(1920, 1048));
    // 3 | select | name=fromPort | label=Portland
    {
      WebElement dropdown = driver.findElement(By.name("fromPort"));
      dropdown.findElement(By.xpath("//option[. = 'Portland']")).click();
    }
    // 4 | click | css=.form-inline:nth-child(1) > option:nth-child(4) | 
    driver.findElement(By.cssSelector(".form-inline:nth-child(1) > option:nth-child(4)")).click();
    // 5 | click | name=toPort | 
    driver.findElement(By.name("toPort")).click();
    // 6 | select | name=toPort | label=Rome
    {
      WebElement dropdown = driver.findElement(By.name("toPort"));
      dropdown.findElement(By.xpath("//option[. = 'Rome']")).click();
    }
    // 7 | click | css=.form-inline:nth-child(4) > option:nth-child(2) | 
    driver.findElement(By.cssSelector(".form-inline:nth-child(4) > option:nth-child(2)")).click();
    // 8 | click | css=.btn-primary | 
    driver.findElement(By.cssSelector(".btn-primary")).click();
    // 9 | click | css=tr:nth-child(2) .btn | 
    driver.findElement(By.cssSelector("tr:nth-child(2) .btn")).click();
    // 10 | click | id=inputName | 
    driver.findElement(By.id("inputName")).click();
    // 11 | type | id=inputName | a??sld
    driver.findElement(By.id("inputName")).sendKeys("a??sld");
    // 12 | type | id=address | as??dlk
    driver.findElement(By.id("address")).sendKeys("as??dlk");
    // 13 | type | id=city | ass??ldk
    driver.findElement(By.id("city")).sendKeys("ass??ldk");
    // 14 | type | id=state | a??lsdka
    driver.findElement(By.id("state")).sendKeys("a??lsdka");
    // 15 | type | id=zipCode | l??askd
    driver.findElement(By.id("zipCode")).sendKeys("l??askd");
    // 16 | type | id=creditCardNumber | asdl??
    driver.findElement(By.id("creditCardNumber")).sendKeys("asdl??");
    // 17 | type | id=creditCardMonth | asld??k
    driver.findElement(By.id("creditCardMonth")).sendKeys("asld??k");
    // 18 | type | id=creditCardYear | as??ldk
    driver.findElement(By.id("creditCardYear")).sendKeys("as??ldk");
    // 19 | type | id=nameOnCard | as??skld
    driver.findElement(By.id("nameOnCard")).sendKeys("as??skld");
    // 20 | click | css=.checkbox | 
    driver.findElement(By.cssSelector(".checkbox")).click();
    // 21 | click | css=.btn-primary | 
    driver.findElement(By.cssSelector(".btn-primary")).click();
    // 22 | click | css=h1 | 
    driver.findElement(By.cssSelector("h1")).click();
    // 23 | click | css=h1 | 
    driver.findElement(By.cssSelector("h1")).click();
    // 24 | doubleClick | css=h1 | 
    {
      WebElement element = driver.findElement(By.cssSelector("h1"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    // 25 | click | css=h1 | 
    driver.findElement(By.cssSelector("h1")).click();
    // 26 | assertText | css=h1 | Thank you for your purchase today!
    assertEquals("Thank you for your purchase today!", driver.findElement(By.cssSelector("h1")).getText());  }
}
