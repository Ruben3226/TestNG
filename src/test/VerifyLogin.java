package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import page.home.HomePage;
import page.login.LoginPage;


/**
 * Title:
 * @author Ruben Blanco
 *
 */
public class VerifyLogin {	
	
	@DataProvider(name = "Login")
	public Object[][] createData() {
		Object[][] objUser={{"Login1","123"},{"Rub","123"}};
		return(objUser);
	}

	@Test(dataProvider = "Login")	
	public void testVerifyLogin(String user, String pass) {
		HomePage hp = new HomePage();
		LoginPage loginPage = hp.clickSignonLink();		
	}
}
