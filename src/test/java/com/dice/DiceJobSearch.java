package com.dice;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DiceJobSearch {
	public static void main(String[] args) {
		// System.setProperty("webdriver.chrome.driver",
		// "/Users/Sema/Documents/seleniumdependencies /drivers/chromedriver/");

		// Set up chrome driver path
		WebDriverManager.chromedriver().setup();
		// invoke selenium webdriver
		WebDriver driver = new ChromeDriver();
		// finding webside

		// full screen
		// driver.manage().window().fullscreen();

		// set universal wait time in case web page is slow
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String url = "https://dice.com";
		driver.get(url);

		String actualTitle = driver.getTitle();
		String expectedTitle = "Job Search for Technology Professionals | Dice.com";

		if (actualTitle.equals(expectedTitle)) {
			System.out.println(" Step Pass");
		} else {
			System.out.println("Step Fail");
			throw new RuntimeException("Step Fail");
			// System.out.println("ExpectedTitle: \t"+expectedTitle);
			// System.out.println("ActualTitle: \t" + actualTitle);
		}
		// searching jobs name
		String keyword = "java developer";
		driver.findElement(By.id("search-field-keyword")).clear();// clearing
		driver.findElement(By.id("search-field-keyword")).sendKeys(keyword);

		// finding the location
		String location = "Chicago,IL";
		driver.findElement(By.id("search-field-location")).clear();// clearing
		driver.findElement(By.id("search-field-location")).sendKeys(location);

		// Clicking the search button

		driver.findElement(By.id("findTechJobs")).click();// with id
		// driver.findElement(By.className("btn btn-primary btn-lg btn-block")).click();
		// //className
		// Finfding with XPath
		// driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg
		// btn-block']")).click();
		String count = driver.findElement(By.id("posiCountId")).getText();
		System.out.println(count);
		// ensure count is more than 0 ;
		int countResult = Integer.parseInt(count.replace(",", ""));
		if (countResult > 0) {
			System.out.println(
					" Stepp Pass keyword :" + keyword + "searchReturn" + countResult + "result in " + location);
		} else {
			System.out
					.println("Step Fail keyword :" + keyword + "searchReturn" + countResult + "result in " + location);

		}

	}
}

// Test case:
// Title: dice job search
//
// Step 1. Launch browser and navigate to https://dice.com
// Expected: dice home page should be displayed
//
// Step 2. Insert search keyword and location then click on
// find tech jobs
// Expected: -Search results page should be loaded.
// -Page title should contain count of results ,
// along with search keyword.
// -Count of results should be displayed on the page.