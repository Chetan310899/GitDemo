package com.problemsandmethods;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				 "C:/Users/CHETAN/OneDrive/Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		
		int rows = driver.findElements(By.cssSelector(".table-display tr")).size();
		System.out.println("No.of.Rows = "+rows);
		
		int columns = driver.findElements(By.cssSelector(".table-display th")).size();
		System.out.println("No.of.Columns = "+columns);
		
		List<WebElement> secondrow=driver.findElements(By.cssSelector(".table-display tr:nth-child(3) td"));

		System.out.println(secondrow.get(0).getText());
		System.out.println(secondrow.get(1).getText());
		System.out.println(secondrow.get(2).getText());

		






	}

}
