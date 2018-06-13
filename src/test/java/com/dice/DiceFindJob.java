package com.dice;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DiceFindJob {

	public static void main(String[] args) throws InterruptedException {
		
		//setup chrome driver path
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		String url = "https://www.dice.com/";
		driver.get(url);
		
		String title = driver.getTitle();
		System.out.println(title);
		if(title.equals("Job Search for Technology Professionals | Dice.com")) {
			System.out.println(title+"Title Pass");
		}else {
			System.out.println("Title Fail");
			throw new RuntimeException("step Fail, did not load home page Line 24");
		}
		String keyWord = "project owner";
		driver.findElement(By.id("search-field-keyword")).sendKeys(keyWord);
		
		String location = "60452";
		driver.findElement(By.id("search-field-location")).clear();
		driver.findElement(By.id("search-field-location")).sendKeys(location);
		
		driver.findElement(By.id("findTechJobs")).click();
		
		String count = driver.findElement(By.id("posiCountId")).getText();
		System.out.println(count);
		int countResult = Integer.parseInt(count.replace(",", ""));
		if(countResult > 0) {
			System.out.println("Step Pass: Keyword: " + keyWord.toUpperCase() + " search returned " + countResult+ " result in " +location);
		}else {
			System.out.println("nothing avaliable. ");
		}
		
		
		
		//driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		Thread.sleep(3000);
		driver.quit();
		System.out.println("TEST COMPLETED "+ LocalDateTime.now());
		

	}

}
