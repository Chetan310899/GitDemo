package com.tests;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvokingMultipleTabs {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:/Users/CHETAN/OneDrive/Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.switchTo().newWindow(WindowType.TAB);
		Set<String> handles =  driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String ParentWindow = it.next();
		String ChildWindow = it.next();
		driver.switchTo().window(ChildWindow);
		driver.get("https://www.rahulshettyacademy.com/");
		String CourseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
		driver.switchTo().window(ParentWindow);
		WebElement name= driver.findElement(By.cssSelector("[name='name']"));
		name.sendKeys(CourseName);
		
		//Taking PartialScreenShot
		File file = name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("name.png"));
		
		//GetHeight & Width
		System.out.println(name.getRect().getHeight());
		System.out.println(name.getRect().getWidth());
		System.out.println(name.getRect().getDimension());
	}

}
