package com.practices;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		System.out.println(footerDriver.findElements(By.tagName("a")).size());
		
		WebElement columnDriver = footerDriver.findElement(By.xpath("//tbody/tr/td[1]/ul"));
		System.out.println(columnDriver.findElements(By.tagName("a")).size());
		
		for (int i = 1; i < columnDriver.findElements(By.tagName("a")).size(); i++) 
		{
			String clickToOpenNewTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickToOpenNewTab);
			Thread.sleep(5000);
		}//open all the tabs
		
		
		//naviagte to each tab and gets the title
			Set<String> w = driver.getWindowHandles();
			Iterator<String> it = w.iterator();
			while (it.hasNext()) 
			{
				driver.switchTo().window(it.next());
				System.out.println(driver.getTitle());
			}
		}
	}


