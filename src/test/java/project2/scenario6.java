package project2;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import BasePackage.baseclass;

public class scenario6 extends baseclass {
	
	@BeforeMethod
	public void OpenWebPage() throws IOException {
		loadfileinputstream("./src/main/java/properties/scenario6.properties");
		initialization();
	}
	
	@Test
	private void adminlogin() throws InterruptedException, AWTException {	
		
		Robot robot = new Robot();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath(prop.getProperty("uname"))).sendKeys(prop.getProperty("username"));
		driver.findElement(By.xpath(prop.getProperty("pswd"))).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath(prop.getProperty("login"))).click();
		
		driver.findElement(By.xpath(prop.getProperty("rec"))).click();
		driver.findElement(By.xpath(prop.getProperty("vacancies"))).click();
		driver.findElement(By.xpath(prop.getProperty("add"))).click();
		driver.findElement(By.xpath(prop.getProperty("vacname"))).sendKeys(prop.getProperty("vacancyname"));
		driver.findElement(By.xpath(prop.getProperty("description"))).sendKeys(prop.getProperty("texthere"));
		driver.findElement(By.xpath(prop.getProperty("numofpositions"))).sendKeys(prop.getProperty("num"));
		//driver.findElement(By.xpath(prop.getProperty("hiringmanager"))).sendKeys(prop.getProperty("manager"));
		
		driver.findElement(By.xpath(prop.getProperty("jobtitles"))).click();
		robot.setAutoDelay(2000);
		robot.keyPress(KeyEvent.VK_Q);
		robot.keyRelease(KeyEvent.VK_Q);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		driver.findElement(By.xpath(prop.getProperty("save"))).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("accicon"))).click();
		driver.findElement(By.xpath(prop.getProperty("logout"))).click();
	}
	
	@AfterMethod
	public void Closedriver() {
		tearDown();
	}

}
