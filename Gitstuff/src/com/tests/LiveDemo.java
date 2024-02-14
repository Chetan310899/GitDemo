package com.tests;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LiveDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:/Users/CHETAN/OneDrive/Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		//List<WebElement> List =  driver.findElements(By.xpath("//tr/td[1]"));
		
		driver.findElement(By.xpath("(//th[@role='columnheader'])[1]")).click();
		
		//capture all webelements into list
		List<WebElement> elementsList =  driver.findElements(By.xpath("//tr/td[1]"));
		
		//capture text of all webelemnts into newlist
		List<String> newList = elementsList.stream().map(s->s.getText()).collect(Collectors.toList());
		System.out.println("New List is "+newList);
		
		//sort on orginalList of step3 -> sortedlist
		List<String> sortedList = newList.stream().sorted().collect(Collectors.toList());
		System.out.println("Sorted List is "+sortedList);
		
		//compare orginal vs sorted
		Assert.assertTrue(newList.equals(sortedList));
		
		List<String> price;
		
		//scan name column with getText - Rice - print the price
		do
		{
			List<WebElement> rows =  driver.findElements(By.xpath("//tr/td[1]"));
		price = rows.stream().filter(s->s.getText().contains("Rice")).
		map(s->getpriceVeggie(s)).collect(Collectors.toList());
		price.forEach(a->System.out.println(a));
		if(price.size()<1)
		{
			driver.findElement(By.cssSelector("[aria-label='Next']")).click();
		}
		}while(price.size()<1);
		
	}

	
	private static String getpriceVeggie(WebElement s) {
		// TODO Auto-generated method stub
		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceValue;
	}

}
