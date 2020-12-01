package com.sbs.selenium.exam;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Main {
	public static void main(String[] args) {
		Path path = Paths.get(System.getProperty("user.dir"), "src/main/resources/chromedriver.exe");
		
		System.setProperty("webdriver.chrome.driver", path.toString());
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--disable-default-apps");
		
		ChromeDriver driver = new ChromeDriver(options);
		
		List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		
		driver.switchTo().window(tabs.get(0));
		driver.get("https://d8040.tistory.com/");
		
//		Util.sleep(2000);
		List<WebElement> elements = driver
				.findElements(By.cssSelector("#mArticle>div.list_content > a.link_post > strong"));
		
		for(WebElement element : elements) {
			String title = element.getText().trim();
			
			System.out.println(title);
		}
	}
}
