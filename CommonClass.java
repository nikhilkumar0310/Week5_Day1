package assignments.day9;

import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class CommonClass {
 
	public ChromeDriver driver;
	
  @BeforeMethod
  public void preCondition() throws InterruptedException {
	  
	  WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		driver.get("https://dev67933.service-now.com/");
		
		driver.switchTo().frame("gsft_main");
		
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Testleaf@6117");
		driver.findElement(By.id("sysverb_login")).click();
		WebElement filter = driver.findElement(By.id("filter"));
		filter.sendKeys("Incidents");
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.xpath("(//div[text()='Incidents'])[1]"))).click().perform();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gsft_main"));
		
  }

  @AfterMethod
  public void postCondition() {
	  driver.close();
  }

}
