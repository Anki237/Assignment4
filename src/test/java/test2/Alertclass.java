package test2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alertclass {
	WebDriver driver;
@BeforeTest
public void url() throws InterruptedException{
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.get("https://www.hyrtutorials.com/p/alertsdemo.html#google_vignette");
	Thread.sleep(3000);
}
@Test
public void t1() {
  WebElement alert1 = driver.findElement(By.cssSelector("button[id=\"alertBox\"]"));
  alert1.click();
  Alert a1=driver.switchTo().alert();
  a1.accept();
  
}
@Test(dependsOnMethods = {"t1"},alwaysRun = true)
public void t2() {
	WebElement alert2 = driver.findElement(By.id("confirmBox"));
	Actions act1=new Actions(driver);
	act1.moveToElement(alert2).click().build().perform();
	Alert a2=driver.switchTo().alert();
	a2.accept();
}
@Test(dependsOnMethods = {"t2"},alwaysRun = true)
public void t3() {
	WebElement alert3 = driver.findElement(By.id("promptBox"));
	Actions act2=new Actions(driver);
	act2.moveToElement(alert3).click().build().perform();
	Alert a3=driver.switchTo().alert();
	a3.sendKeys("Ankita Verma");
	a3.accept();
}
@AfterTest
public void end() {
	driver.close();
}
}
