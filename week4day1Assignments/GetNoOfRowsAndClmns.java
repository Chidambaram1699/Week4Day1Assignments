package week4day1Assignments;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GetNoOfRowsAndClmns {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions notifi=new ChromeOptions();
		notifi.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://html.com/tags/table/");
		int rows = driver.findElements(By.xpath("//div[@class='render']//table/tbody/tr")).size();
		int columns = driver.findElements(By.xpath("//div[@class='render']//th")).size();
		System.out.println("The number of rows present is "+ rows);
		System.out.println("The number of Columns present is "+ columns);
		driver.close();
	}

}
