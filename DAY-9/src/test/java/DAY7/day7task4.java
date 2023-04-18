package DAY7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
public class day7task4 {
	WebDriver driver;
	@BeforeSuite	
	void init()
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions co = new ChromeOptions();
		co.addArguments("==remote=allow=origins=*");
		driver=new ChromeDriver(co);
	}
	@Test
	void Test1() throws InterruptedException
	{
		String url ="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		driver.get(url);
		Thread.sleep(3000);
		WebElement username= driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));
		username.sendKeys("Admin");
		WebElement password= driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));
		password.sendKeys("admin123");
		WebElement submit= driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
		submit.click();
		String url1="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		String actual=driver.getCurrentUrl();
		Assert.assertEquals(url1, actual);
	}
	@Test(dependsOnMethods = "Test1")
	void Test2() throws InterruptedException
	{
		WebElement profile= driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span/p"));
		profile.click();
		Thread.sleep(3000);
		WebElement logout =driver.findElement(By.linkText("Logout"));
		logout.click();
		driver.close();
		}
	
}
