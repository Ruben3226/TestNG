package Util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.SeleniumDriverManager;

public class Authentication {
	private WebDriver driver;
	private WebDriverWait wait;
	public Authentication() {
		driver = SeleniumDriverManager.getManager().getDriver();		
		wait = SeleniumDriverManager.getManager().getWait();
	}
	
	public void logIn(String user, String pass){
		//clear user name field
		driver.findElement(By.name("userName")).clear();	
		//enter user name
		driver.findElement(By.name("userName")).sendKeys(user);
		//clear password field
		driver.findElement(By.name("password")).clear();
		//enter password
		driver.findElement(By.name("password")).sendKeys(pass);	
		//click submit button
		driver.findElement(By.name("login")).click();		
	}
	
	public void logOut(){
		//logout user 
		driver.findElement(By.linkText("SIGN-OFF")).click();		
	}	
}
