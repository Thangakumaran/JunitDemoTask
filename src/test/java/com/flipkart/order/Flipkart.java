package com.flipkart.order;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart {
     
	
	static WebDriver driver;
	static long start;
	
	@BeforeClass
	public static void browserLaunch() {
       System.out.println("BeforeClass");
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	@AfterClass
	public static void quit() {
       System.out.println("AfterClass");
		//driver.quit();
	}
	
	@Before
	public void startTime() {
		System.out.println("Before");
		 start = System.currentTimeMillis();

	}
	@After
	public void endTime() {
		System.out.println("After");
        long end = System.currentTimeMillis();
        
     long s =end-start ;
        
        System.out.println("Time taken "+s);
	}
	
	@Test
	public void testA() throws InterruptedException {
		try {
			WebElement a = driver.findElement(By.xpath("//button[text()='✕']"));
	          a.isDisplayed();
	          a.click();
		} 
		catch (Exception e) {
			System.out.println("Login popup is closed");
		}
		Thread.sleep(2000);
          WebElement b = driver.findElement(By.xpath("//input[@type='text']"));
          b.sendKeys("Laptop",Keys.ENTER);
	}
	static String text;
	@Test
	public void testB() throws InterruptedException {
		Thread.sleep(3000);
		 WebElement b = driver.findElement(By.xpath("//div[contains(text(),'RedmiBook 15 e-Le')]"));
		JavascriptExecutor j =(JavascriptExecutor)driver;
		j.executeScript("arguments[0].scrollIntoView(true)", b);
		j.executeScript("arguments[0].click()", b);
		 text = b.getText();
		 System.out.println(text);
	}
	
	@Test
	public void testC() throws InterruptedException {
		
         String c = driver.getWindowHandle();
         Set<String> d = driver.getWindowHandles();
         for (String e : d) {
        	 if(!c.equals(e)) {
        		 driver.switchTo().window(e);	 
        	 }
			
		}
        	}
	@Test
	public void testD() throws InterruptedException {
		Thread.sleep(3000);
        WebElement i = driver.findElement(By.xpath("//button[text()='ADD TO CART']"));
        i.click();
        
	}
	static String text2;
	@Test
	public void assertionE() {
		WebElement g = driver.findElement(By.xpath("//span[contains(text(),'RedmiBook 15 e-L')]"));
        String text2 = g.getText();  
        System.out.println(text2);
		Assert.assertTrue(text.equals(g));
	}
	
	@Test
	public void assertionF() {
		WebElement l = driver.findElement(By.xpath("//a[contains(text(),'RedmiBook 15 e-Learning ')]"));
		String text3 = l.getText();
		System.out.println(text3);
		Assert.assertTrue(text2.equals(text3));

	}
	
	
}
