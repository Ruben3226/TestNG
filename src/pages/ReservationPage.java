package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.SeleniumDriverManager;

public class ReservationPage {

	private WebDriverWait wait;
	private WebDriver driver;
	public ReservationPage(){
		driver = SeleniumDriverManager.getManager().getDriver();
		wait = SeleniumDriverManager.getManager().getWait();		
	}

	public String verifyIsLogin(){		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("SIGN-OFF")));
		//driver.findElement(By.linkText("SIGN-OFF"));
		driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("login")).click();
		return (driver.findElement(By.linkText("SIGN-OFF")).getText());
	}
	public String showButton() {
		String message=""; 
		if (driver.findElement(By.name("findFlights"))!=null) {
			message="exist";	
		}
		else{
			message="not exist";
		}
		return message;
	}

	public void Reservation() {	   
		new Select(driver.findElement(By.name("airline"))).selectByVisibleText("Blue Skies Airlines");
		driver.findElement(By.name("findFlights")).click();		
		driver.findElement(By.name("reserveFlights")).click();
		driver.findElement(By.name("passFirst0")).clear();
		driver.findElement(By.name("passFirst0")).sendKeys("Ruben");
		driver.findElement(By.name("passLast0")).clear();
		driver.findElement(By.name("passLast0")).sendKeys("Blanco");
		new Select(driver.findElement(By.name("creditCard"))).selectByVisibleText("Visa");
		driver.findElement(By.name("creditnumber")).clear();
		driver.findElement(By.name("creditnumber")).sendKeys("4444");
		driver.findElement(By.name("buyFlights")).click();
	}
	public Boolean VerifyConfirmReservation() {	
		String r= driver.findElement(By.xpath("//tr[3]/td/p/font")).getText();
		System.out.print(r);
		Boolean successMess=null;
		if(r.contains("has been booked!")){
			successMess	= true;
		}
		else{
			successMess = false;
		}
		//return	driver.findElement(By.xpath("//tr[3]/td/p/font")).getText();
		return successMess;
	}




}
