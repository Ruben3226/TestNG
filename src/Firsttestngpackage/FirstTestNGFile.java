package Firsttestngpackage;

import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.apache.bcel.generic.Select;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.asserts.*;
import org.testng.annotations.*;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class FirstTestNGFile {
	
	  private WebDriver driver;
	  private String baseUrl;
	
  @BeforeTest
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = baseUrl="http://newtours.demoaut.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  
 
	
  @Test(priority=1)
  public void VerifyHomepageTitle() {	 
	  String expectedTitle="Welcome: Mercury Tours";
	  String actualTitle=driver.getTitle();
	  Assert.assertEquals(actualTitle, expectedTitle);
  }  
  
  @AfterTest
  public void CloseBrowser() {
	  driver.quit();	  
  }
  
  @Test
  public void testCreateUser() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.name("login")).click();
    driver.findElement(By.cssSelector("p > font > a")).click();
    driver.findElement(By.name("firstName")).clear();
    driver.findElement(By.name("firstName")).sendKeys("Ruben");
    driver.findElement(By.name("lastName")).clear();
    driver.findElement(By.name("lastName")).sendKeys("Blanco");
    driver.findElement(By.name("phone")).clear();
    driver.findElement(By.name("phone")).sendKeys("123456");
    driver.findElement(By.id("userName")).clear();
    driver.findElement(By.id("userName")).sendKeys("rbg@yahoo.com");
    driver.findElement(By.name("address1")).clear();
    driver.findElement(By.name("address1")).sendKeys("none");
    driver.findElement(By.name("city")).clear();
    driver.findElement(By.name("city")).sendKeys("none");
    driver.findElement(By.name("state")).clear();
    driver.findElement(By.name("state")).sendKeys("none");
    driver.findElement(By.name("postalCode")).clear();
    driver.findElement(By.name("postalCode")).sendKeys("591");
    new org.openqa.selenium.support.ui.Select(driver.findElement(By.name("country"))).selectByVisibleText("BOLIVIA");
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("Rub");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("123");
    driver.findElement(By.name("confirmPassword")).clear();
    driver.findElement(By.name("confirmPassword")).sendKeys("123");
    driver.findElement(By.name("register")).click();
  }
  
}
