package org.Date2010;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Webtable {

	public WebDriver driver;

	@Test
	private void Testcase1() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://covidindia.org/");
		driver.manage().window().maximize();

		int manyTh = driver.findElements(By.xpath("//*[@id=\"tablepress-96\"]/thead/tr/th")).size();
		int manyTr = driver.findElements(By.xpath("//*[@id=\"tablepress-96\"]/tbody/tr")).size();
		int manyTb = driver.findElements(By.xpath("//*[@id=\"tablepress-96\"]/tbody/tr[9]/td")).size();

		for (int i = 1; i < manyTh - 1; i++) {
			WebElement one = driver.findElement(By.xpath("//*[@id=\"tablepress-96\"]/thead/tr/th[" + i + "]"));
			System.out.println("");
			System.err.print("\t\t\t" + one.getText());

		}

		for (int i = 1; i <= manyTr; i++) {
			System.out.println("");
			for (int j = 1; j < manyTb - 1; j++) {
				WebElement one1 = driver
						.findElement(By.xpath("//*[@id=\"tablepress-96\"]/tbody/tr[" + i + "]/td[" + j + "]"));
				System.out.println(" ");
				System.out.print("\t\t\t" + one1.getText());

			}

		}
		System.out.println("\n");
	}
}
