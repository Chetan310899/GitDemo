import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SeIntro {

	public static void main(String[] args) {

		// chromedriver.exe -> ChromeBrowser
		
		  System.setProperty("webdriver.chrome.driver",
		  "C:/Users/CHETAN/OneDrive/Documents/chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		 

//		// MicrosoftEdge -> msedgrdriver.exe
//		System.setProperty("webdriver.edge.driver",
//				"C:/Users/CHETAN/OneDrive/Documents/msedgedriver.exe");
//		WebDriver driver = new EdgeDriver();
		driver.get("https://capgemini.udemy.com/organization/home/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		/*
		 * driver.close(); driver.quit();
		 */
	}

}
