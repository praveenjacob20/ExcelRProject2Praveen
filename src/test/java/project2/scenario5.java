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

public class scenario5  extends baseclass{
	
	@BeforeMethod
	public void OpenWebPage() throws IOException {
		loadfileinputstream("./src/main/java/properties/scenario5.properties");
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
		driver.findElement(By.xpath(prop.getProperty("add"))).click();
		
		driver.findElement(By.xpath(prop.getProperty("firstname"))).sendKeys(prop.getProperty("fname"));
		driver.findElement(By.xpath(prop.getProperty("middlename"))).sendKeys(prop.getProperty("mname"));
		driver.findElement(By.xpath(prop.getProperty("lastname"))).sendKeys(prop.getProperty("lname"));
		driver.findElement(By.xpath(prop.getProperty("mail"))).sendKeys(prop.getProperty("email"));
		driver.findElement(By.xpath(prop.getProperty("phone"))).sendKeys(prop.getProperty("contact"));
		driver.findElement(By.xpath(prop.getProperty("keyword"))).sendKeys(prop.getProperty("skills"));
		driver.findElement(By.xpath(prop.getProperty("note"))).sendKeys(prop.getProperty("notes"));
		driver.findElement(By.xpath(prop.getProperty("keepdata"))).click();
		
		driver.findElement(By.xpath(prop.getProperty("resume"))).click();
		StringSelection resumepath = new StringSelection(prop.getProperty("document"));
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(resumepath, null);
		robot.setAutoDelay(1000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.setAutoDelay(1000);
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
