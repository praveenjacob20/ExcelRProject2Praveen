package project2;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BasePackage.baseclass;

public class scenario2  extends baseclass{
	
	@BeforeMethod
	public void OpenWebPage() throws IOException {
		loadfileinputstream("./src/main/java/properties/scenario2.properties");
		initialization();
	}
	
	@Test
	private void pim() throws InterruptedException, AWTException {	
		
		Robot robot = new Robot();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath(prop.getProperty("uname"))).sendKeys(prop.getProperty("adminusername"));
		driver.findElement(By.xpath(prop.getProperty("pswd"))).sendKeys(prop.getProperty("adminpassword"));
		driver.findElement(By.xpath(prop.getProperty("login"))).click();
		driver.findElement(By.xpath(prop.getProperty("pim"))).click();
		driver.findElement(By.xpath(prop.getProperty("add"))).click();
		driver.findElement(By.xpath(prop.getProperty("firstname"))).sendKeys(prop.getProperty("fname"));
		driver.findElement(By.xpath(prop.getProperty("middlename"))).sendKeys(prop.getProperty("mname"));
		driver.findElement(By.xpath(prop.getProperty("lastname"))).sendKeys(prop.getProperty("lname"));
		driver.findElement(By.xpath(prop.getProperty("createlogin"))).click();
		driver.findElement(By.xpath(prop.getProperty("canduname"))).sendKeys(prop.getProperty("candusername"));
		driver.findElement(By.xpath(prop.getProperty("candpswd"))).sendKeys(prop.getProperty("candpassword"));
		driver.findElement(By.xpath(prop.getProperty("candconfpswd"))).sendKeys(prop.getProperty("candpassword"));
		
		driver.findElement(By.xpath(prop.getProperty("uploadimg"))).click();
		StringSelection imagepath = new StringSelection(prop.getProperty("photo"));
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(imagepath, null);
		robot.setAutoDelay(2000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.setAutoDelay(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		driver.findElement(By.xpath(prop.getProperty("save"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("accicon"))).click();
		driver.findElement(By.xpath(prop.getProperty("logout"))).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("uname"))).sendKeys(prop.getProperty("candusername"));
		driver.findElement(By.xpath(prop.getProperty("pswd"))).sendKeys(prop.getProperty("candpassword"));
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
