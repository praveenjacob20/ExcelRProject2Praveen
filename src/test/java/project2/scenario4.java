package project2;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BasePackage.baseclass;

public class scenario4 extends baseclass {
	
	@BeforeMethod
	public void OpenWebPage() throws IOException {
		loadfileinputstream("./src/main/java/properties/scenario4.properties");
		initialization();
	}
	
	@Test
	private void adminlogin() throws InterruptedException {	
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath(prop.getProperty("forgetpassword"))).click();
		driver.findElement(By.xpath(prop.getProperty("uname"))).sendKeys(prop.getProperty("username"));
		driver.findElement(By.xpath(prop.getProperty("reset"))).click();;
		
		String exptext = prop.getProperty("exptext");
		String acttext = driver.findElement(By.xpath(prop.getProperty("text"))).getText();
		Assert.assertEquals(acttext, exptext);
		
	}
	
	@AfterMethod
	public void Closedriver() {
		tearDown();
	}

}
