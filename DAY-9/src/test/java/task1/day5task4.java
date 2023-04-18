package task1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class day5task4 {

	public static void main(String args[])
	{

	WebDriverManager.chromedriver().setup();
	WebDriver driver;
	ChromeOptions co = new ChromeOptions();
	co.addArguments("==remote=allow=origins=*");
	
	driver=new ChromeDriver(co);
	driver.get("https://www.abhibus.com/bus-ticket-booking");
	
	WebElement leaving=driver.findElement(By.id("source"));
	leaving.sendKeys("Coimbatore",Keys.ENTER);
	
	WebElement going=driver.findElement(By.id("destination"));
	going.sendKeys("Chennai",Keys.ENTER);
	
	WebElement datepicker=driver.findElement(By.id("datepicker1"));
	
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("arguments[0].setAttribute('value','04/10/2020')",datepicker);
	 
}
}
