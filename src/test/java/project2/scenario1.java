package project2;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import BasePackage.baseclass;

public class scenario1 extends baseclass {
	
	@BeforeMethod
	public void OpenWebPage() throws IOException {
		loadfileinputstream("./src/main/java/properties/scenario1.properties");
		initialization();
	}
	
	@Test
	private void adminlogin() throws InterruptedException {	
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath(prop.getProperty("uname"))).sendKeys(prop.getProperty("username"));
		driver.findElement(By.xpath(prop.getProperty("pswd"))).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath(prop.getProperty("login"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("accicon"))).click();
		driver.findElement(By.xpath(prop.getProperty("logout"))).click();
	}
	
	@AfterMethod
	public void Closedriver() {
		tearDown();
	}
}
