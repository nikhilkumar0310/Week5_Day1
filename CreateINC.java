package assignments.day9;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CreateINC extends CommonClass {
	
	@Test
	public void createInc() throws InterruptedException {
		
		
		driver.findElement(By.xpath("//button[text()='New']")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("incident.short_description")).sendKeys("This is a password faliure related INC");
		WebElement numberINC = driver.findElement(By.xpath("//input[@name='incident.number']"));
		String textINC = numberINC.getAttribute("value");
		System.out.println(textINC);
		driver.findElement(By.id("sysverb_insert_bottom")).click();
		
		Thread.sleep(3000);
		WebElement searchField = driver.findElement(By.xpath("(//input[@placeholder='Search'])[1]"));
		Thread.sleep(2000);
		searchField.sendKeys(textINC);
		//Thread.sleep(3000);
		searchField.sendKeys(Keys.ENTER);
		
		String searchedINC = driver.findElement(By.xpath("//tr[@record_class='incident']/td[3]/a")).getText();
		
		if(textINC.equals(searchedINC)) {
			System.out.println("The required INC has been created and is "+textINC);
		}
		else {
			System.out.println("The found INC "+searchedINC+" is inncorect");
		}
	}

}
