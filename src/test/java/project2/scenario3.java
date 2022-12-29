package project2;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import BasePackage.baseclass;

public class scenario3 extends baseclass{

	
	@BeforeMethod
	public void OpenWebPage() throws IOException {
		loadfileinputstream("./src/main/java/properties/scenario3.properties");
		initialization();
	}
	
	@Test
	private void pim() throws InterruptedException, AWTException {	
		
		Robot robot = new Robot();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("uname"))).sendKeys(prop.getProperty("candusername"));
		driver.findElement(By.xpath(prop.getProperty("pswd"))).sendKeys(prop.getProperty("candpassword"));
		driver.findElement(By.xpath(prop.getProperty("login"))).click();
		driver.findElement(By.xpath(prop.getProperty("myinfo"))).click();
		
		driver.findElement(By.xpath(prop.getProperty("nicknames"))).sendKeys(prop.getProperty("nickname"));
		driver.findElement(By.xpath(prop.getProperty("otherid"))).sendKeys(prop.getProperty("id"));
		driver.findElement(By.xpath(prop.getProperty("licenseexpdate"))).sendKeys(prop.getProperty("expdate"));
		driver.findElement(By.xpath(prop.getProperty("gender"))).click();
		driver.findElement(By.xpath(prop.getProperty("military"))).sendKeys(prop.getProperty("militaryservice"));
		driver.findElement(By.xpath(prop.getProperty("save1"))).click();

		driver.findElement(By.xpath(prop.getProperty("contactdetails"))).click();
		driver.findElement(By.xpath(prop.getProperty("s1"))).sendKeys(prop.getProperty("street1"));
		driver.findElement(By.xpath(prop.getProperty("s2"))).sendKeys(prop.getProperty("street1"));
		driver.findElement(By.xpath(prop.getProperty("citties"))).sendKeys(prop.getProperty("city"));
		driver.findElement(By.xpath(prop.getProperty("province"))).sendKeys(prop.getProperty("state"));
		driver.findElement(By.xpath(prop.getProperty("zipcode"))).sendKeys(prop.getProperty("pincode"));
		
		driver.findElement(By.xpath(prop.getProperty("workmail"))).sendKeys(prop.getProperty("email"));
		driver.findElement(By.xpath(prop.getProperty("mobile"))).sendKeys(prop.getProperty("phone"));
		driver.findElement(By.xpath(prop.getProperty("save2"))).click();
		
		robot.setAutoDelay(3000);
		driver.findElement(By.xpath(prop.getProperty("emergencycontact"))).click();
		driver.findElement(By.xpath(prop.getProperty("add"))).click();
		driver.findElement(By.xpath(prop.getProperty("name"))).sendKeys(prop.getProperty("ename"));
		driver.findElement(By.xpath(prop.getProperty("relationships"))).sendKeys(prop.getProperty("relationship"));
		driver.findElement(By.xpath(prop.getProperty("mob"))).sendKeys(prop.getProperty("emobile"));
		driver.findElement(By.xpath(prop.getProperty("save3"))).click();
		
		
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("accicon"))).click();
		driver.findElement(By.xpath(prop.getProperty("logout"))).click();
		
	}
	
	@AfterMethod
	public void Closedriver() {
		tearDown();
	}
	
}
