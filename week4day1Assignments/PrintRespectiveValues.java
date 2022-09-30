package week4day1Assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintRespectiveValues {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions notifi=new ChromeOptions();
		notifi.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://html.com/tags/table/");
		Thread.sleep(3000);
		WebElement scroll = driver.findElement(By.xpath("//h2[text()='Tables for Data, Not Layout']"));
		Actions builder=new Actions(driver);
		builder.scrollToElement(scroll).perform();
		Thread.sleep(3000);
		List<WebElement> test1 = driver.findElements(By.xpath("//div[@class='render']//table/tbody/tr"));
		for(int i = 0;i<=test1.size();i++) {
				String text = test1.get(i).getText();
			if(text.contains("Absolute")) {
				System.out.println(text);
			}
			}
		driver.close();
	}

}
