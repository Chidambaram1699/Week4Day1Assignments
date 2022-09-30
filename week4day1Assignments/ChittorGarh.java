package week4day1Assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChittorGarh {

	public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	ChromeOptions notifi=new ChromeOptions();
	notifi.addArguments("--disable-notifications");
	ChromeDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.get("https://www.chittorgarh.com/");
	driver.findElement(By.xpath("//a[@title='Stock Market']")).click();
	driver.findElement(By.xpath("//a[text()='NSE Bulk Deals']")).click();
	List<WebElement> lstOfSecurity = driver.findElements(By.xpath("//table[contains(@class,'table table-bordered table-condensed')]//tr"));
	List<String> lst1=new ArrayList<String>();
//	for(WebElement i : lstOfSecurity) {
//		lst1.add(i.getText());
//	}
	for(int i = 1;i<lstOfSecurity.size();i++) {
		String text = driver.findElement(By.xpath("//table[contains(@class,'table table-bordered table-condensed')]//tr["+i+"]/td[3]")).getText();
		lst1.add(text);
	}
	Set<String> dup = new LinkedHashSet<String>(lst1);
	System.out.println(lst1.size()+" "+dup.size()+" "+(lst1.size()-dup.size()));
	if(lst1.size()==dup.size()) {
		System.out.println("No Duplicates Present");
	}else {
		System.out.println("Duplicates Present");
	}

	}
	}


