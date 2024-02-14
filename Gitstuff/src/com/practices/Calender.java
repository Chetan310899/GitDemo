package com.practices;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calender {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companion/");
		driver.manage().window().maximize();
		Thread.sleep(4000);		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,1200)");

		Thread.sleep(3000);

		driver.findElement(By.xpath("//input [@id='form-field-travel_comp_date']")).click();

		while (!driver.findElement(By.xpath("//div[@class='flatpickr-month']")).getText().contains("August")) {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[@class='flatpickr-next-month']")).click();
		}

		int count = driver.findElements(By.xpath("//span[@class='flatpickr-day ']")).size();

		for (int i = 0; i < count; i++) {
			Thread.sleep(2000);
			String text = driver.findElements(By.xpath("//span[@class='flatpickr-day ']")).get(i).getText();

			if (text.equalsIgnoreCase("31")) {
				driver.findElements(By.xpath("//span[@class='flatpickr-day ']")).get(i).click();
				System.out.println("The select day is:" + text);
				break;
			}
		}
		String date = driver.findElement(By.xpath("//*[@id='form-field-travel_comp_date']")).getAttribute("value");
		System.out.println("The select date is:" + date);
	}

}
