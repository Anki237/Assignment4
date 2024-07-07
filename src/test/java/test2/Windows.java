package test2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Windows {
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
		 driver.findElement(By.id("openwindow")).click();
//		 Set<String> windows=driver.getWindowHandles();
//		 Iterator<String> it= windows.iterator();
		 ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
	        driver.switchTo().window(tabs.get(1));
	        WebElement click = driver.findElement(By.linkText("Access all our Courses"));
	        click.click();
	        driver.switchTo().window(tabs.get(0));
	 }
	 @AfterTest
	 public void end() {
		 driver.close();
	 }
	 
}
