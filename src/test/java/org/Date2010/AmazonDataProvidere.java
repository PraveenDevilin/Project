package org.Date2010;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonDataProvidere {

	WebDriver driver;

	@BeforeMethod
	private void start() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@Test(dataProvider = "products")
	private void webpage(String productname) {
		driver.get("https://www.amazon.in/");

		Assert.assertEquals("https://www.amazon.in/", driver.getCurrentUrl());
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(productname);
		driver.findElement(By.xpath("(//input[@class='nav-input'])[2]")).click();

		int size = driver
				.findElements(By.xpath("//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']")).size();
		System.out.println("No.of products: " + size + "\nName of each " + productname + " products: ");
		for (int i = 0; i < size; i++) {
			System.out.println(driver
					.findElements(By.xpath("//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']"))
					.get(i).getText());

		}

	}

	@DataProvider(name = "products")
	private String[][] products() {

		return new String[][] { { "nividia rtx" }, { "lenova laptop" }, { "iphone 11" }, { "HCL Laptop" }, { "Timmer" }

		};

	}
}
