package tests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import data.DataFile;
import pages.LoginPage;

public class LoginTest {
	
	LoginPage lp = new LoginPage();
	DataFile df = new DataFile();			
		
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  lp.openbrowser();
	  lp.loginpage();
  }
  
  @AfterMethod
  public void afterMethod() {
	  lp.closebrowser();
  }
  
  @Test (priority = 1)
  public void LoginWithSpecialCharEmailTest() throws InterruptedException {
	  lp.login(df.emailWithSpecialChar, df.wrongPassword);
	  Assert.assertEquals(df.specialCharErr, lp.readEmailErr());
 }
  
  @Test (priority = 2)
  public void LoginWithEmptyEmailTest() throws InterruptedException {
	  lp.login("",df.wrongPassword);
	  Assert.assertEquals(df.emailErr, lp.readEmailErr());
  }
  
  @Test (priority = 3)
  public void LoginWithEmptyPasswordTest() throws InterruptedException {
	  lp.login(df.wrongEmail, "");
	  Assert.assertEquals(df.passwordErr, lp.readPasswordErr());
  }
 
  @Test (priority = 4)
  public void LoginWithWrongEmailAndPasswordTest() throws InterruptedException {
	  lp.login(df.wrongEmail, df.wrongPassword);
	  Assert.assertEquals(df.globalErr, lp.readGlobalErr());
 }
 
}
