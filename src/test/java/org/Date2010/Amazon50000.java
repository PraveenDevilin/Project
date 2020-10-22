package org.Date2010;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon50000 {
	WebDriver driver;

	@Test
	private void testCase1() {

		// Print no of products on the searched page

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nvidia rtx");
		driver.findElement(By.xpath("(//input[@class='nav-input'])[2]")).click();

		System.out.println("No. of products on this page : "
				+ driver.findElements(By.xpath("//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']"))
						.size());

	}

	@Test
	private void testCase2() {

		for (int i = 0; i < driver.findElements(By.xpath("//span[@class='a-price-whole']")).size(); i++) {
			if (Integer.parseInt(driver.findElements(By.xpath("//span[@class='a-price-whole']")).get(i).getText()
					.replace(",", "")) > 50000) {
				System.out.println(Integer.parseInt(driver.findElements(By.xpath("//span[@class='a-price-whole']"))
						.get(i).getText().replace(",", "")));

			}

		}

	}
}
