package org.Date2010;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Web {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://www.w3schools.com/html/html_tables.asp");
		WebElement o_tbl_object = driver.findElement(By.id("customers"));
		LinkedHashMap<Integer, LinkedHashMap<Integer, String>> o_result = f_get_table_content(o_tbl_object);
		System.out.println(o_result.toString());

	}

	public static LinkedHashMap<Integer, LinkedHashMap<Integer, String>> f_get_table_content(WebElement o_tbl_object) {
		try {

			LinkedHashMap<Integer, String> o_clm_data;// = new LinkedHashMap<Integer,String>();
			LinkedHashMap<Integer, LinkedHashMap<Integer, String>> tbl_map_result = new LinkedHashMap<Integer, LinkedHashMap<Integer, String>>();

			List<WebElement> list_rows = o_tbl_object.findElements(By.tagName("tr"));
			List<WebElement> list_clms;
			int i_row_count = list_rows.size();
			int i_clm_count;// = list_clms.size();
			for (int i = 0; i < i_row_count; i++) {
				list_clms = list_rows.get(i).findElements(By.tagName("td"));
				i_clm_count = list_clms.size();
				o_clm_data = new LinkedHashMap<Integer, String>();
				for (int j = 0; j < i_clm_count; j++) {

					o_clm_data.put(j, list_clms.get(j).getText());

				} // End Inner For

				tbl_map_result.put(i, o_clm_data);
			} // End Outer For

			if ((tbl_map_result.get(0).size() > 0) && (tbl_map_result.size() > 0)) {
				System.out.println("info:HTML table fetched and returned in dual hashmap");

			} else {
				System.out.println("fail:Unable to fetch data from table. Row Count:" + (tbl_map_result.size())
						+ " Clm Count: " + (tbl_map_result.get(0).size()));

			}

			return tbl_map_result;
		} catch (Exception e) {
			System.out.println("fail:Unable to fetch data from Html table." + " Stack Trace: " + e.getMessage());
			return null;
		}
	}// End Function

}
