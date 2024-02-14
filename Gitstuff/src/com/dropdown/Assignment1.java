package com.dropdown;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.cssSelector("input[name='name']:nth-child(2)")).sendKeys("Chetan");
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("c@gmail.com");
		driver.findElement(By.cssSelector("input[type='Password']")).sendKeys("Chetan");
		driver.findElement(By.id("exampleCheck1")).click();
		WebElement staticDropdown = driver.findElement(By.id("exampleFormControlSelect1"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByIndex(0);
		driver.findElement(By.id("inlineRadio2")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='bday']")).sendKeys("31-08-1999");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.className("close")).getText());
	}

}
