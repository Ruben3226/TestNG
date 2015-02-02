package page.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.reservation.FlightFinderPage;
import driver.SeleniumDriverManager;

/**
 * 
 * @author Ruben Blanco
 *
 */
public class LoginPage {

	@FindBy(name = "userName") WebElement txtName;
	@FindBy(name = "password") WebElement txtPass;
	private WebDriver driver;
	private WebDriverWait wait; 
	/**
	 * Constructor
	 */
	public LoginPage() {
		driver = SeleniumDriverManager.getManager().getDriver();
		wait = SeleniumDriverManager.getManager().getWait();
	}
	/**
	 * Login method
	 * @param user is a valid userName
	 * @param pass is a valid password of user
	 * @return FlightFinderPage object
	 */
	public FlightFinderPage doLogin(String user, String pass) {	
		//clear user name field
		driver.findElement(By.name("userName")).clear();
		//enter user name
		driver.findElement(By.name("userName")).sendKeys(user);
		//clear password field
		driver.findElement(By.name("password")).clear();
		//enter password
		driver.findElement(By.name("password")).sendKeys(pass);
		//click on submit button
		driver.findElement(By.name("login")).click();			
		return new FlightFinderPage();
	}
	
	
} 
