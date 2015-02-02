package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import page.home.HomePage;
import page.registry.RegistryConfirmationPage;
import page.registry.RegistryPage;

/**
 * Title: Verify that a new user is created
 * @author Ruben Blanco
 *
 */
public class NewUserTest {	
	@DataProvider(name = "Reserv")
	public Object[][] createData() {
		Object[][] objUser={{"Name", "Lname", "789987", "emailTest@test.com", "test address", "test city", "test stateProvince", "123", "BAHAMAS", "testUser1", "123", "123"},
				            {"Name2", "Lname2", "7899872", "emailTest2@test.com", "test address 2", "test city 2", "test stateProvince 2", "123", "BAHAMAS", "testUser2", "123", "123"}};
		return(objUser);
	}
	
	@Test(dataProvider = "Reserv")	
	public void ReservationTest(String fName, String lName,String phone,String email,String address,String city,String stateProvince,String postalCode,String country,String userName,String pass,String rePass) {			
		HomePage hp = new HomePage();
		RegistryPage regisUser = hp.clickNewUserLink();
		RegistryConfirmationPage confirmPage = regisUser.setNewUser(fName, lName, phone, email, address, city, stateProvince, postalCode, country, userName, pass, rePass);
		String expectedMessage = "Note: Your user name is " + userName + ".";
		Assert.assertEquals(confirmPage.getConfirmMessage(),expectedMessage);		
		//Assert.assertTrue(confirmPage.isUserCreated(userName));
	}
}
