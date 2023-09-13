import java.nio.channels.SelectionKey;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.TimeZone;
import java.util.Calendar;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Sitatest {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\think\\Downloads\\Installers\\geckodriver\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("https://sitatesting.github.io/AutomationTest/index.html");
		driver.findElement(By.xpath("(//a[@href='about.html'])[3]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.navigate().to("https://sitatesting.github.io/AutomationTest/about.html");
		driver.findElement(By.xpath("(//a[@href='reservation.html'])[3]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.cssSelector("input.Name")).sendKeys("KamalaPriya");
		driver.findElement(By.cssSelector("input.Number")).sendKeys("0899414757");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement dropdown = driver.findElement(By.id("chooseGuests"));
		Select drop=new Select(dropdown);
		drop.selectByIndex(2);

		LocalDateTime now = LocalDateTime.now(); 
		String dt = now.toString(); 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(sdf.parse(dt));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.add(Calendar.DATE, 2);  
		dt = sdf.format(c.getTime());  
		driver.findElement(By.cssSelector("input.date")).sendKeys(dt);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement dropdown1=driver.findElement(By.id("chooseCategory"));
		Select drop1=new Select(dropdown1);
		drop1.selectByIndex(1);
		driver.findElement(By.className("main-button")).click();  
	}

}
