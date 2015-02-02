package page.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import page.login.LoginPage;
import page.registry.RegistryPage;
import driver.SeleniumDriverManager;

/**
 * 
 * @author Ruben Blanco
 *
 */
public class HomePage {
	private WebDriver driver;	
	private WebDriverWait wait;
	/**
	 * Constructor
	 */
	public HomePage() {
		driver = SeleniumDriverManager.getManager().getDriver();
		wait = SeleniumDriverManager.getManager().getWait();
	}	
	/**
	 * get home page title
	 * @return page title
	 */
	public String getHomeTitle(){
		return driver.getTitle();
	}
	/**
	 * click on login link
	 * @return LoginPage object
	 */
	public LoginPage clickSignonLink() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("SIGN-ON")));
		driver.findElement(By.linkText("SIGN-ON")).click();
		return new LoginPage();
	}
	/**
	 * click on create user link
	 * @return RegistryPage object
	 */
	public RegistryPage clickNewUserLink() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("REGISTER")));
		driver.findElement(By.linkText("REGISTER")).click();
		return new RegistryPage();
	}
}
