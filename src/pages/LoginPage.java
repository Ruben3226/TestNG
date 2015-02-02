package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.SeleniumDriverManager;

public class LoginPage {
	
	@FindBy(name = "userName") WebElement txtName;
	private WebDriver driver;
	private WebDriverWait wait; 
	private String baseUrl = "http://newtours.demoaut.com/";

	public LoginPage() {
		driver = SeleniumDriverManager.getManager().getDriver();
		wait = SeleniumDriverManager.getManager().getWait();
		driver.get(baseUrl);
	}	 
	public ReservationPage doLogin(String user, String pass) {
		txtName.sendKeys("Rub");
		//driver.findElement(By.name("userName")).clear();
		//driver.findElement(By.name("userName")).sendKeys("Rub");
		driver.findElement(By.name("userName")).sendKeys(user);
		driver.findElement(By.name("password")).clear();
		//driver.findElement(By.name("password")).sendKeys("123");
		driver.findElement(By.name("password")).sendKeys(pass);
		driver.findElement(By.name("login")).click();		
		return new ReservationPage();
	}


} 
