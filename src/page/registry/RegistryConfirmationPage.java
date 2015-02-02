package page.registry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import commons.UIMethods;

import page.login.LoginPage;
import driver.SeleniumDriverManager;

/**
 * Title: in this class is verified the confirmation message of created new user
 * @author Ruben Blanco
 *
 */
public class RegistryConfirmationPage {
	private WebDriver driver;
	private WebDriverWait wait; 
	/**
	 * constructor
	 */
	public RegistryConfirmationPage() {
		driver = SeleniumDriverManager.getManager().getDriver();
		wait = SeleniumDriverManager.getManager().getWait();
	} 
	/**
	 * method to verify the message after create the new user 
	 * @param createdUser is the userName of new created user 
	 * @return true if the user is created or false if the user is not created
	 */
	public boolean verifyConfirmMessage(String createdUser) {
		//get the confirmation message after create new user
		String actualMessage = driver.findElement(By.cssSelector("a > font > b")).getText();
		//message that contains the user name of new user created
		String expectedMessage = "Your user name is " + createdUser;
		//verify if the actual message contains the user name
		if(actualMessage.contains(expectedMessage)){
			return true;
		}
		else{
			return false;
		}			
	}
	/**
	 * 
	 * @return a message that contains the new created userName
	 */
	public String getConfirmMessage() {
		//get the confirmation message after create new user
		return driver.findElement(By.cssSelector("a > font > b")).getText();
	}
	/**
	 * 
	 * @param userName is the userName of new created user
	 * @return
	 */
	public Boolean isUserCreated(String userName) {
		//get the confirmation message after create new user
		return UIMethods.isElementPresent(By.xpath("//b[contains(text(),'Note: Your user name is " + userName + ".')]"));
	}
	
	/**
	 * method to login with count of new user created
	 * @param newUser is the userName of new created user
	 * @param newPass is the password of new created user
	 * @return LoginPage object
	 */
	public LoginPage loginCreatedUser(String newUser, String newPass) {
		LoginPage lp = new LoginPage();
		lp.doLogin(newUser, newPass);
		return new LoginPage();
	}	
	
	
}
