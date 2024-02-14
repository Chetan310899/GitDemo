package com.practices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// select any checkbox and grab the label of that(put in a variable)
		// select the dropdown which we got at label
		// Enter step2 grabbed label text in EditBox
		// Click alert & verify in the text that label is present
		driver.findElement(By.id("checkBoxOption2")).click();

		String opt = driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]")).getText();
		System.out.println(opt);

		WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));

		Select s = new Select(dropdown);

		s.selectByVisibleText(opt);
		driver.findElement(By.name("enter-name")).sendKeys(opt);
		driver.findElement(By.id("alertbtn")).click();
		String text = driver.switchTo().alert().getText();

		if (text.contains(opt)) {
			Assert.assertTrue(true);
			System.out.println("Sucess");
		} else {
			Assert.assertTrue(false);
		}
	}
}
