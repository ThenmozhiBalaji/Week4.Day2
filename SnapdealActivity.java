package Week4.Day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapdealActivity {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		WebElement ele1 = driver.findElement(By.xpath("//span[text()=\"Men's Fashion\"]"));
	
		Actions builder = new Actions(driver);
		builder.moveToElement(ele1).perform();
		
		WebElement ShoeSele = driver.findElement(By.xpath("//span[@class='linkTest'][text()='Sports Shoes']"));
		Thread.sleep(500);
		ShoeSele.click();
		Thread.sleep(1500);
		String text = driver.findElement(By.xpath("//span [@class=\"category-name category-count\"]")).getText();
		
		System.out.println(text);	
		driver.findElement(By.xpath("//div[@class='child-cat-name '][text()='Training Shoes']")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//div [@class=\"sort-drop clearfix\"]")).click();
		driver.findElement(By.xpath("//li[@data-sorttype=\"plth\"]")).click();
		Thread.sleep(1500);
		List<WebElement> elements = driver.findElements(By.xpath("//span [@class=\"lfloat product-price\"] "));
		List<Integer> prices = new ArrayList<>();
		
		for (WebElement el: elements) {
			String price = el.getAttribute("display-price");
			System.out.print("1. Price: "); System.out.println(price);
			prices.add(Integer.parseInt(price));
		}
		WebElement elem = driver.findElement(By.xpath("//div [contains(@class, \"sdCheckbox\") and contains(@class, \"filters-list\")] /input [@value=\"Navy\"]/parent::div"));
		System.out.print("1. Prices: "); System.out.println(prices);
		Thread.sleep(1500);
	    JavascriptExecutor executor = (JavascriptExecutor) driver;
	    executor.executeScript("arguments[0].scrollIntoView()", driver.findElement(By.xpath("//div [@class=\"filter-name-section filter-type clearfix\"]")));
		Thread.sleep(1500);
		elem.click();
		Thread.sleep(1500);
		builder.moveToElement(driver.findElement(By.xpath("//div [@class=\"col-xs-6  favDp product-tuple-listing js-tuple \"]"))).perform();
		driver.findElement(By.xpath("//div [@class=\"center quick-view-bar  btn btn-theme-secondary  \"][1]")).click();
		Thread.sleep(1500);
		String cost = driver.findElement(By.xpath("//span [@class=\"payBlkBig\"]")).getText();
		String discount = driver.findElement(By.xpath("//span [@class=\"percent-desc \"]")).getText();
		System.out.print("Cost: "); System.out.println(cost);
		System.out.print("Discount: "); System.out.println(discount);
		driver.findElement(By.xpath("//div [@class=\"close close1 marR10\"]")).click();
		Thread.sleep(2500);
		builder.moveToElement(driver.findElement(By.xpath("//button [@class=\"clear-all-filters  btn-theme-secondary btn-line btn\"][1]"))).perform();
		
		File src = driver.findElement(By.xpath("//section [@class=\"js-section clearfix dp-widget dp-fired\"]")).getScreenshotAs(OutputType.FILE);
		File dest = new File("./snaps/snapdeal002.png");
		FileUtils.copyFile(src, dest);
		
		driver.close();
		driver.quit();
//		driver.executeScript("function getElementByXpath(path) {"
//				+ "  return document.evaluate(path, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue; "
//				+ "}; getElementByXpath(arguments[0]).click()", "//li[@data-sorttype=\"plth\"]");
		
		
	}

}
