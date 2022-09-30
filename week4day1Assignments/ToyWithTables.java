package week4day1Assignments;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToyWithTables {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions notifi=new ChromeOptions();
		notifi.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://testleaf.herokuapp.com/pages/table.html");
		int rows = driver.findElements(By.xpath("//div//table//tr")).size();
		int columns = driver.findElements(By.xpath("//div//table//th")).size();
		System.out.println("The number of rows present is "+ (rows-1));
		System.out.println("The number of Columns present is "+ columns);
		for(int i=2;i<=rows;i++) {
		String text = driver.findElement(By.xpath("//tr["+i+"]")).getText();
		if(text.contains("interact with Elements")) {
			String text1 = driver.findElement(By.xpath("//tr["+i+"]/td[2]")).getText();
				System.out.println("The Progress value of 'Learn to interact with Elements' is  "+text1);
		}
		if(text.contains("100")) {
			driver.findElement(By.xpath("(//input[@type='checkbox'])["+(i-1)+"]")).click();
		Thread.sleep(3000);
		
		}
		}
		
		
		driver.close();
		
	}

}
