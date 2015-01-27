package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.SeleniumDriverManager;

public class HomePage {
	private WebDriver driver;
	private String baseUrl = "http://newtours.demoaut.com/";
	private WebDriverWait wait;
	public HomePage() {
		driver = SeleniumDriverManager.getManager().getDriver();
		driver.get(baseUrl);
		wait = SeleniumDriverManager.getManager().getWait();
	}	

	public String getHomeTitleisLoad(){
		return driver.getTitle();
	}

	public LoginPage clickSignonLink() {
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("SIGN-OFF")));
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("SIGN-ON")));
		  driver.findElement(By.linkText("SIGN-ON")).click();
		return new LoginPage();
	}
	public String verBoton() {
	  return driver.findElement(By.name("findFlights")).getAttribute("value");		
	}

}
