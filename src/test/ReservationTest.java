package test;


import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Util.Authentication;
import page.home.HomePage;
import page.login.LoginPage;
import page.reservation.AirlinePage;
import page.reservation.FlightConfirmationPage;
import page.reservation.FlightFinderPage;
import page.reservation.PurchasePage;

/**
 * Title:
 * @author Ruben Blanco
 *
 */
public class ReservationTest {
	
	
	@DataProvider(name = "Reserv")
	public Object[][] createData2() {
		Object[][] objUser={{"2","March","3","London","July", "25", "Blue Skies Airlines"}};
		return(objUser);
	}
	
	@Test(dataProvider = "Reserv")	
	public void ReservationTest(String passengerCount, String month, String day, String arriveCity, String returnMonth, String returnDay, String air) {			
		HomePage hp = new HomePage();
		LoginPage login=hp.clickSignonLink();
		FlightFinderPage fly=login.doLogin("Rub", "123");
		AirlinePage airLine=fly.selectFlight(passengerCount,month,day,arriveCity,returnMonth, returnDay, air);
		PurchasePage purchasePage=airLine.SelectAirline();
		FlightConfirmationPage purchase = purchasePage.makePurchase();
		boolean isReserved = purchase.verifyConfirmMessage();
		Assert.assertTrue(isReserved);
	}
	@AfterTest
	public void PostConditionReserv() {	
		Authentication authentication = new Authentication();
		authentication.logOut(); 
	}
	
}
