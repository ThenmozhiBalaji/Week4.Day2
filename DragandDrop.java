package Week4.Day2;

import java.awt.Desktop.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragandDrop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/drag.xhtml");
		driver.manage().window().maximize();
		WebElement ele1 = driver.findElement(By.xpath("//span[@class='ui-panel-title'][text()='Drag and Drop']"));
		WebElement ele2 = driver.findElement(By.xpath("//div[@class='ui-panel-titlebar ui-widget-header ui-helper-clearfix ui-corner-all']"));
		WebElement ele3 = driver.findElement(By.xpath("//p[text()='Drag to target']"));
		//p[text()='Drag to target']
		Actions builder = new Actions(driver);
		
		//driver.switchTo().frame(0);
		builder.dragAndDrop(ele1, ele2).perform();
		builder.dragAndDrop(ele3, ele2).perform();
		
	}

}
