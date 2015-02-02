package page.registry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import driver.SeleniumDriverManager;

/**
 * Title: This class is performed to create the new user
 * @author Ruben Blanco
 *
 */
public class RegistryPage {
	private WebDriver driver;
	private WebDriverWait wait; 
	/**
	 * Constructor
	 */
	public RegistryPage() {
		driver = SeleniumDriverManager.getManager().getDriver();
		wait = SeleniumDriverManager.getManager().getWait();
	}
	/**
	 * Method to fill the create new user form
	 * @param firstName is the user first name
	 * @param lName is the user last name
	 * @param phone is the user phone number
	 * @param email is a valid user email
	 * @param address the current user address
	 * @param city is the user city
	 * @param stateProvince is the user state or province
	 * @param postalCode is the user postal code
	 * @param country is the user country 
	 * @param userName is the userName
	 * @param pass is the user password
	 * @param rePass is the same that pass variable
	 * @return
	 */
	public RegistryConfirmationPage setNewUser(String firstName,	String lastName, String phone, 
			String email, String address, String city, String stateProvince, String postalCode,
			String country,
			String userName,
			String pass,
			String rePass) {		
	    setFirstName(firstName);
	    setLastName(lastName);
	    setPhoneNumber(phone);
	    setEmail(email);
	    setAddress(address);
	    setCity(city);
	    setStateProvince(stateProvince);
	    setPostalCode(postalCode);
	    selectCountry(country);
	    setUserName(userName);
	    setPassword(pass);
	    confirmPassword(rePass);
	    clickSubmitButton();	
		return new RegistryConfirmationPage();
	}
	/**
	 * Click after to fill the form
	 */
	public void clickSubmitButton() {
		driver.findElement(By.name("register")).click();
	}
	/**
	 * @param rePass is the same password in the setPassword method
	 */
	public void confirmPassword(String rePass) {
		driver.findElement(By.name("confirmPassword")).clear();
	    driver.findElement(By.name("confirmPassword")).sendKeys(rePass);
	}
	/**
	 * @param pass is the user password 
	 */
	public void setPassword(String pass) {
		driver.findElement(By.name("password")).clear();
	    driver.findElement(By.name("password")).sendKeys(pass);
	}
	/**
	 * @param userName is nick that will use the user
	 */
	public void setUserName(String userName) {
		driver.findElement(By.id("email")).clear();
	    driver.findElement(By.id("email")).sendKeys(userName);
	}
	/**
	 * @param country is the country if user
	 */
	public void selectCountry(String country) {
		new Select(driver.findElement(By.name("country"))).selectByVisibleText(country);//"BAHAMAS"
	}
	/**
	 * @param postalCode is the postal code that have the user
	 */
	public void setPostalCode(String postalCode) {
		driver.findElement(By.name("postalCode")).clear();
	    driver.findElement(By.name("postalCode")).sendKeys(postalCode);
	}
	/**
	 * @param stateProvince is the state or province of the user
	 */
	public void setStateProvince(String stateProvince) {
		driver.findElement(By.name("state")).clear();
	    driver.findElement(By.name("state")).sendKeys(stateProvince);
	}
	/**
	 * @param city is the city of the user
	 */
	public void setCity(String city) {
		driver.findElement(By.name("city")).clear();
	    driver.findElement(By.name("city")).sendKeys(city);
	}
	/**
	 * @param address is the current address of user
	 */
	public void setAddress(String address) {
		driver.findElement(By.name("address1")).clear();
	    driver.findElement(By.name("address1")).sendKeys(address);
	}
	/**
	 * @param email is a valid email of the user
	 */
	public void setEmail(String email) {
		driver.findElement(By.id("userName")).clear();
	    driver.findElement(By.id("userName")).sendKeys(email);
	}
	/**
	 * @param phone is the user phone number
	 */
	public void setPhoneNumber(String phone) {
		driver.findElement(By.name("phone")).clear();
	    driver.findElement(By.name("phone")).sendKeys(phone);
	}
	/**
	 * 
	 * @param lastName is the user last name
	 */
	public void setLastName(String lastName) {
		driver.findElement(By.name("lastName")).clear();
	    driver.findElement(By.name("lastName")).sendKeys(lastName);
	}
	/**
	 * 
	 * @param firstName is the user first name
	 */
	public void setFirstName(String firstName) {
		driver.findElement(By.name("firstName")).clear();
	    driver.findElement(By.name("firstName")).sendKeys(firstName);
	}
	
}
