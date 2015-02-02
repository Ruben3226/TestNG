package Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import driver.SeleniumDriverManager;

	/**
	 * Title:
	 * @author Ruben Blanco
	 *
	 */
	public class Factory {	
	private WebDriver driver;
	public Factory(){		 
		this.driver = SeleniumDriverManager.getManager().getDriver();	        	 
		PageFactory.initElements(driver, this);	 
	}	
}
