package com.locators;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class Locators2 {

	public static void main(String[] args) throws InterruptedException {
		String name = "Chetan";
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "C:/Users/CHETAN/OneDrive/Documents/chromedriver.exe");
		 * WebDriver driver = new ChromeDriver();
		 */
		// MicrosoftEdge -> msedgrdriver.exe
				System.setProperty("webdriver.edge.driver",
						"C:/Users/CHETAN/OneDrive/Documents/msedgedriver.exe");
				WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String password = getPassword(driver);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//h2")).getText());
		Assert.assertEquals(driver.findElement(By.xpath("//h2")).getText(), "Hello " + name + ",");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Log Out']  ")).click();
		//Thread.sleep(1000);
		driver.close();
	}

	public static String getPassword(WebDriver driver) throws InterruptedException

	{

		driver.get("https://rahulshettyacademy.com/locatorspractice/");

		driver.findElement(By.linkText("Forgot your password?")).click();

		Thread.sleep(1000);

		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();

		String passwordText = driver.findElement(By.cssSelector("form p")).getText();

		// Please use temporary password 'rahulshettyacademy' to Login.

		String[] passwordArray = passwordText.split("'");
		System.out.println(passwordArray[0]);
		System.out.println(passwordArray[1]);
		System.out.println(passwordArray[2]);
		System.out.println("Hi");

		// String[] passwordArray2 = passwordArray[1].split("'");

		// passwordArray2[0]

		String password = passwordArray[1].split("'")[0];
		System.out.println(password);

		return password;

		// 0th index - Please use temporary password

		// 1st index - rahulshettyacademy' to Login.

		// 0th index - rahulshettyacademy

		// 1st index - to Login.

	}

}
