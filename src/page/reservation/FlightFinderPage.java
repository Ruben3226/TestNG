package page.reservation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import driver.SeleniumDriverManager;

/**
 * 
 * @author Ruben Blanco
 *
 */
public class FlightFinderPage {	
	private WebDriver driver;
	private WebDriverWait wait;
	/**
	 * Constructor
	 */
	public FlightFinderPage() {
		driver = SeleniumDriverManager.getManager().getDriver();
		wait = SeleniumDriverManager.getManager().getWait();
	}
	/**
	 * 
	 * @return AirlinePage object
	 */
	public AirlinePage selectFlight(String passengerCount, String month, String day, String arriveCity, String returnMonth, String returnDay, String air){
		//Set the number of passengers
		new Select(driver.findElement(By.name("passCount"))).selectByVisibleText(passengerCount);
		//select the month 
		new Select(driver.findElement(By.name("fromMonth"))).selectByVisibleText(month);
		//select the day
		new Select(driver.findElement(By.name("fromDay"))).selectByVisibleText(day);
		//select the arrive city
		new Select(driver.findElement(By.name("toPort"))).selectByVisibleText(arriveCity);
		//select the return month
		new Select(driver.findElement(By.name("toMonth"))).selectByVisibleText(returnMonth);
		//select the return day
		new Select(driver.findElement(By.name("toDay"))).selectByVisibleText(returnDay);
		//select the flight type
		driver.findElement(By.cssSelector("font > font > input[name=\"servClass\"]")).click();
		//select the airline
		new Select(driver.findElement(By.name("airline"))).selectByVisibleText(air);
		//click on continue button
		driver.findElement(By.name("findFlights")).click();		
		return new AirlinePage();
	}
}
