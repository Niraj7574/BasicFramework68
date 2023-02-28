package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Xls_Reader;

public class LoginPage {
	WebDriver driver;
	Xls_Reader reader =  new  Xls_Reader("C:\\QA\\Testing\\wetransfer_build-xml_2022-12-03_2020\\NikulTest.xlsx");
	
	/*public WebElement email = driver.findElement(By.id("usernameInput-input"));
	public WebElement password = driver.findElement(By.id("password-input"));
	public WebElement signInButton = driver.findElement(By.id("signIn"));
	public WebElement emailErr = driver.findElement(By.id("UsernameTextField__errors-usernameInput"));
	public WebElement passwordErr = driver.findElement(By.id("PasswordTextField__errors-password"));
	public WebElement globalErr = driver.findElement(By.id("globalError"));*/
	
	@FindBy(id = "usernameInput-input")
	public WebElement email;
	
	@FindBy(id = "password-input")
	public WebElement password;
	
	@FindBy(id = "signIn")
	public WebElement signInButton;
	
	@FindBy(id = "UsernameTextField__errors-usernameInput")
	public WebElement emailErr;
	
	@FindBy(id = "PasswordTextField__errors-password")
	public WebElement passwordErr;
	
	@FindBy(id = "globalError")
	public WebElement globalErr;
	
	
	public void openbrowser() throws IOException {
		FileInputStream input = new FileInputStream("C:\\QA\\Testing\\prop.properties");
		Properties prop = new Properties();
		prop.load(input);
		
		String browser = prop.getProperty("browser");
		
		if(browser.equals("Firefox")) {
			driver = new FirefoxDriver();
		}else if (browser.equals("Chrome")) {
			driver = new ChromeDriver();
		}else if (browser.equals("Safari")) {
			driver = new SafariDriver();
		}
		PageFactory.initElements(driver, this);
	}
	
	
	public void loginpage() {
		driver.get("https://auth.scotiaonline.scotiabank.com/online?oauth_key=2gwE_0lrd7I&oauth_key_signature=eyJraWQiOiJrUFVqdlNhT25GWUVDakpjMmV1MXJvNGxnb2VFeXJJb2tCbU1oX3BiZXNVIiwidHlwIjoiSldUIiwiYWxnIjoiUlMyNTYifQ.eyJyZWZlcmVyIjoiaHR0cHM6XC9cL3d3dy5zY290aWFiYW5rLmNvbVwvIiwib2F1dGhfa2V5IjoiMmd3RV8wbHJkN0kiLCJjb25zZW50X3JlcXVpcmVkIjpmYWxzZSwicmVkaXJlY3RfdXJpIjoiaHR0cHM6XC9cL3d3dy5zY290aWFvbmxpbmUuc2NvdGlhYmFuay5jb21cL29ubGluZVwvbGFuZGluZ1wvb2F1dGhsYW5kaW5nLmJucyIsImV4cCI6MTY2OTA4ODAwNCwiaWF0IjoxNjY5MDg2ODA0LCJqdGkiOiJhNWZiNmZjYS0zZWU0LTQwYjctYThjNi1jNDBiMzk0NDNjMmMiLCJjbGllbnRfaWQiOiI4ZWU5MGMzOS0xYzUyLTRmZjQtOGFlNi1hN2I1NGM1Mzk5MzMiLCJjbGllbnRfbWV0YWRhdGEiOnsiQ2hhbm5lbElEIjoiU09MIiwiQXBwbGljYXRpb25Db2RlIjoiSDcifSwiaXNzdWVyIjoiaHR0cHM6XC9cL3Bhc3Nwb3J0LnNjb3RpYWJhbmsuY29tIn0.lj6odAo_ZMa24zXFLNYrG4x6q1OD6ohP0p41sxKxhG91caphfN_6Ueoq46zJUqlz97Vla6PKNbGNucb8a83dhpY-1EeaIvIxyJhN9hkvbk1tAFjaWcKQ7zYAKS_gDWQP7tXENaKlhnml6JTMZnvfxEzYYu19LH4i-MoQZ_LpUdZVWlLToP4YA9254baEk27TPPfcXJgI_SDgE0yKsHIx36q7eN5AcCSqTSLQdtCQI-4_lMruynJNZq11WlyBZTx8lDVS3E7dP88n5OoGZ46eaTC4TiiOosfZQ3XVGNQaZGbb3QjXPC2PXcTsTNCxDuNVg3B_ACqMPX1-SIlsBcVHZw&preferred_environment=");
	}
	
	public void closebrowser() {
		driver.quit();
	}
	
	public void login(String a, String b) throws InterruptedException {
		email.sendKeys(a);
		password.sendKeys(b);
		signInButton.click();
		Thread.sleep(2000);
	}
	
	public String readEmailErr() {
		String actualErr = emailErr.getText();
		System.out.println(actualErr);
		return actualErr;
	}
	
	public String readPasswordErr() {
		String actualErr = passwordErr.getText();
		System.out.println(actualErr);
		return actualErr;
	}
	
	public String readGlobalErr() {
		String actualErr = globalErr.getText();
		System.out.println(actualErr);
		return actualErr;
	}
}




