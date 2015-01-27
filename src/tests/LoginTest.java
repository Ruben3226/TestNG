package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ReservationPage;
import driver.SeleniumDriverManager;

public class LoginTest {
	private WebDriver driver;
	private String baseUrl="http://newtours.demoaut.com/";
	private HomePage hp;
	private LoginPage lp; 	
	/*
	@BeforeTest
	public void preCondition(){				
	}
	 */
	/*
	@Test
	public void VerifyTitle() {		
		String expectedTitle="Welcome: Mercury Tours";
		HomePage hp = new HomePage();
		String actualTitle=hp.getHomeTitleisLoad();
		Assert.assertEquals(expectedTitle, actualTitle);		
	}
	*//*
	@Test	
	public void VerifyLogin() {
		HomePage hp = new HomePage();		
		ReservationPage reservPage=new ReservationPage();		
		hp.clickSignonLink().doLogin().verBoton();
		Assert.assertEquals(reservPage.verBoton(), "exist");
	}*/
	
	@Test	
	public void Reservation() {		
		HomePage hp = new HomePage();		
		ReservationPage reservPage=new ReservationPage();		
		hp.clickSignonLink().doLogin().Reservation();
		Assert.assertEquals(reservPage.VerifyConfirmReservation(), "Your itinerary has been booked!\n \n Please print a copy of this screen for your records. Thank you for choosing Mercury Tours.");
	}
}
