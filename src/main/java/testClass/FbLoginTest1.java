package testClass;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class FbLoginTest1 {
	
	WebDriver driver;
	
	@Test(priority = 1)
	public void openBrowser() {
		
		ChromeOptions op=new ChromeOptions();
		op.addArguments("--remote-allow-origins=*");
		op.addArguments("--disable-notifications");
		
		driver=new ChromeDriver(op);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.facebook.com/");
	}
	
	@Test(priority = 2)
	public void loginFB() throws InterruptedException {
		driver.findElement(By.name("email")).sendKeys("ninjajod619@gmail.com");
		driver.findElement(By.cssSelector("#pass")).sendKeys("Test@Ninja619");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@name='login']")).click();

	}
	
	@Test(priority = 4)
	public void logoutFB() throws InterruptedException {
		Thread.sleep(9000);
		driver.findElement(By.xpath("//div[@class='x1rg5ohu x1n2onr6 x3ajldb x1ja2u2z']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Log Out']")).click();
		
		driver.quit();
	}
	
	@Test(priority = 3)
	public void verifyNinja() {
		driver.findElement(By.xpath("//span[text()='Ninj Jod']")).click();
		String name = driver.findElement(By.xpath("//div[@class='x78zum5 xdt5ytf x1wsgfga x9otpla']//h1")).getText();
		System.out.println(name);
		assertEquals(name, "Ninj Jod");
		
		System.out.println("Jai Shree Ram...");
		System.out.println("Jai Shree Hanuman...");
		System.out.println("Shree Ganeshay Namh...");
		System.out.println("Om Namh Shivay...");
		
	}
}
