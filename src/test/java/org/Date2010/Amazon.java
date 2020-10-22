package org.Date2010;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

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

		// to compare if any two products on the page are same

		List<WebElement> many = driver
				.findElements(By.xpath("//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']"));
		int listSize = many.size();

		Set<WebElement> items = new LinkedHashSet<WebElement>();
		System.out.println();
		items.addAll(many);
		int setSize = items.size();

		if (listSize != setSize) {
			System.out.println("Has duplicte, i.e products with same name");
		} else {
			System.err.println("\nno dupicates present\n");
		}

	}

	@Test
	private void testCase3() {
		// print products that has a minimum value of 50,000
		driver.findElement(By.id("low-price")).sendKeys("50000");
		driver.findElement(By.xpath("//input[@class='a-button-input']")).click();
		int size = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']")).size();
		List<WebElement> many = driver
				.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		System.out.println("\nName of the products\n");
		System.out.println("No .of products with minimum price 50,000 and above: " + size);
		for (WebElement one : many) {

			System.out.println("\n" + one.getText());

		}
	}

}
