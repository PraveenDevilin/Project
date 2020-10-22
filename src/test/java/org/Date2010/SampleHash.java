package org.Date2010;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleHash {
	public WebDriver driver;

	@Test
	private void Testcase1() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://covidindia.org/");
		driver.manage().window().maximize();

		List<WebElement> states = driver.findElements(By.xpath("//td[@class='column-1']"));
		List<WebElement> cases = driver.findElements(By.xpath("//td[@class='column-2']"));

		LinkedHashMap<String, String> hmap = new LinkedHashMap<String, String>();

		for (int i = 0; i < cases.size(); i++) {
			hmap.put(states.get(i).getText(), cases.get(i).getText());
		}
		Set<Entry<String, String>> b = hmap.entrySet();
		for (Entry<String, String> entry : b) {
			System.out.println(entry);
		}

	}

}
