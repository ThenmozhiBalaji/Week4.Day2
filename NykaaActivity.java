package Week4.Day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NykaaActivity {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		WebElement ele1 = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(ele1).perform();
	
		WebElement searchElement = driver.findElement(By.xpath("//input[@id='brandSearchBox']"));
		searchElement.sendKeys("L'Oreal Paris\n\n");
		searchElement.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//div[@class=\"css-ov2o3v\"]/a[text()=\"L'Oreal Paris\"][1]")).click();
		Thread.sleep(2000);
		String title = driver.getTitle();
		System.out.println(title);
		
		WebElement Catelement = driver.findElement(By.xpath("//span[@class='title '][text()='Category']"));
		Catelement.click();
		driver.findElement(By.xpath("//span[@class='filter-name '][text()='Hair']"))
			.click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//span[@class='filter-name '][text()='Hair Care']")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//span[@class=\"title\" and text()=\"Shampoo\"]/parent::div/following-sibling::div[@class=\"control-indicator checkbox \"]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//span[@class='title '][text()='Concern']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//span[@class='title'][text()='Color Protection']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//div[@class='css-43m2vm']")).click();
		Thread.sleep(1500);
		List<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windowHandles.get(1));
//		String text = driver.findElement(By.xpath("//span[@class='css-1jczs19']")).getText();
//		System.out.println(text);
		
		driver.findElement(By.xpath("//span[text()='Add to Bag']/parent::button[1]")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//span[@class='cart-count']")).click();
		Thread.sleep(3500);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class=\"css-acpm4k\"]")));
		Thread.sleep(3500);
		String text2 = driver.findElement(By.xpath("//div[@class=\"first-col\"]/div[@class=\"value\"]")).getText().substring(1);
		
		System.out.println(text2);
		Thread.sleep(1500);
		driver.findElement(By.xpath("//span[text()=\"Proceed\" and @class='vernacular-string']")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//button[@class='btn full big']")).click();
		Thread.sleep(1500);
		driver.switchTo().defaultContent();
		String text3 = driver.findElement(By.xpath("//div[@class='payment-details-tbl grand-total-cell prl20']/div[@class=\"value\"]/span")).getText();
		System.out.println(text3);
		if (text2.equals(text3))
			System.out.println("Grand Total is correct");
		else
			System.out.println("Grand Total not correct");
		File src = driver.findElement(By.xpath("//div[@class=\"col-md-4  pr0 pl5\"]/div[@class=\"dc-container-box sticky-contents\"]")).getScreenshotAs(OutputType.FILE);
		File dest = new File("./snaps/nykaa001.png");
		FileUtils.copyFile(src, dest);
		driver.close();
		driver.quit();
			
		
		
	}

}
