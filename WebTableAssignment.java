package Week4.Day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://html.com/tags/table/");
		driver.manage().window().maximize();
		List<WebElement> rows = driver.findElements(By.xpath("//div [@class=\"render\"] /table /tbody /tr"));
		int rowsCount = rows.size() + 1;
		int colsCount = rows.get(0).findElements(By.tagName("td")).size();
		System.out.print("Rows: "); System.out.print(rowsCount);
		System.out.print(" Cols: "); System.out.println(colsCount);
	}

}
