package page.reservation;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import driver.SeleniumDriverManager;

/**
 * Title:
 * @author Ruben Blanco
 *
 */
public class PurchasePage {
	private WebDriver driver;
	private WebDriverWait wait;
	private boolean acceptNextAlert = true;
	/**
	 * constructor
	 */
	public PurchasePage() {
		driver = SeleniumDriverManager.getManager().getDriver();		
		wait = SeleniumDriverManager.getManager().getWait();
	}
	/**
	 * 
	 * @return FlightConfirmationPage object
	 */
	public FlightConfirmationPage makePurchase(){		
		driver.findElement(By.name("passFirst0")).clear();
		driver.findElement(By.name("passFirst0")).sendKeys("Pass1");
		driver.findElement(By.name("passLast0")).clear();
		driver.findElement(By.name("passLast0")).sendKeys("Pass1");
		new Select(driver.findElement(By.name("pass.0.meal"))).selectByVisibleText("Diabetic");
		new Select(driver.findElement(By.name("creditCard"))).selectByVisibleText("Visa");
		driver.findElement(By.name("creditnumber")).clear();
		driver.findElement(By.name("creditnumber")).sendKeys("456");
		new Select(driver.findElement(By.name("cc_exp_dt_mn"))).selectByVisibleText("01");
		new Select(driver.findElement(By.name("cc_exp_dt_yr"))).selectByVisibleText("2010");
		driver.findElement(By.name("cc_frst_name")).clear();
		driver.findElement(By.name("cc_frst_name")).sendKeys("Pass2");
		driver.findElement(By.name("cc_mid_name")).clear();
		driver.findElement(By.name("cc_mid_name")).sendKeys("Pass2");
		driver.findElement(By.name("cc_last_name")).clear();
		driver.findElement(By.name("cc_last_name")).sendKeys("Pass2");
		driver.findElement(By.name("billAddress1")).clear();
		driver.findElement(By.name("billAddress1")).sendKeys("1325 Borregas Avenue");
		driver.findElement(By.name("billCity")).clear();
		driver.findElement(By.name("billCity")).sendKeys("CBBA");
		driver.findElement(By.name("buyFlights")).click();			
		return new FlightConfirmationPage();
	}
	/**
	 * 
	 * @return
	 */
	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}

	


}
