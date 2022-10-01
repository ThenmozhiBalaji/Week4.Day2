/**
 * 
 */
package Week4.Day2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author bkshr
 *
 */
public class StockBSEActivity {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.chittorgarh.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@id=\"navbtn_stockmarket\"]")).click();
		driver.findElement(By.xpath("//a[@class=\"ch-bar-item ch-button\" and text()=\"NSE Bulk Deals\"]")).click();
		Thread.sleep(1500);
		List<WebElement> stockNameEL = driver.findElements(By.xpath("//table[@class=\"table table-bordered table-condensed table-striped\"]/tbody/tr/td[3]"));
		List<String> stockNames = new ArrayList<String>();
		
		
		for(WebElement ele2:stockNameEL) {
			String text = ele2.getText();
			stockNames.add(text);
			System.out.println(text);
		}
		System.out.println();
		Set<String>	stocks = new HashSet<String>(stockNames);
		if(stockNames.size() == stocks.size()) {
			System.out.println("No Duplicates");
		}
		else
		{
			System.out.println("Duplicates found");
		}
	}

}
