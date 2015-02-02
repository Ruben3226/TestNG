package page.reservation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.SeleniumDriverManager;

/**
 * Title:
 * @author Ruben Blanco
 *
 */
public class AirlinePage {
	private WebDriver driver;
	private WebDriverWait wait;
    /**
     * Contructor
     */
	public AirlinePage() {
		driver = SeleniumDriverManager.getManager().getDriver();		
		wait = SeleniumDriverManager.getManager().getWait();
	}	
	/**
	 * 
	 * @return PurchasePage object
	 */
	public PurchasePage SelectAirline(){
		driver.findElement(By.name("reserveFlights")).click();	
		return new PurchasePage();
	}
	

}
