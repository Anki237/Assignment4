package test2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class iframes {
	WebDriver driver;
	 @BeforeTest
	 public void url() throws InterruptedException {
		 WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		 driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		Thread.sleep(3000);
	 }
	 @Test(enabled=true)
	 public void t1() {
		  WebElement frames=driver.findElement(By.id("courses-iframe"));
		  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", frames);
		  driver.switchTo().frame(frames);
		
		 WebElement job= driver.findElement(By.linkText("Job Support"));
		 Actions act=new Actions(driver);
			act.moveToElement(job).build().perform();
		 job.click();
		 driver.switchTo().defaultContent();
		 
		 
	 }
	 @AfterTest
	 public void end() {
		 driver.close();
	 }
	 
	 
}
