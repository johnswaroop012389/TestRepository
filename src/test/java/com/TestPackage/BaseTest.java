package com.TestPackage;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.io.IOException;


public class BaseTest {
	public static WebDriver driver;
	public static PrintWriter writer;
	public static String runTarget;
	
	@BeforeClass
    public void setup() throws IOException  {
	writer = new PrintWriter("results.txt");
	    
	io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
	   
	ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");  // modern headless mode
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://uat.qaconnector.com/Fintech/tenantLogin");
        writer.println("Launched"+ " https://uat.qaconnector.com/Fintech/tenantLogin "+ "Successufully");

	driver.findElement(By.name("user_name")).sendKeys("amith.nadig");
	writer.println("Username Entered Successufully");
	driver.findElement(By.name("password")).sendKeys("ViratKohli@123");
	writer.println("Password Entered Successufully");
	driver.findElement(By.id("Login_loginbtn__7Tj03")).click();
	writer.println("Clicked on Login Successufully");
	Assert.assertEquals(driver.getTitle(), "Fintech Solutions");
	writer.println("Homepage Loaded Successufully");

    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
            writer.println("Browser closed");
	    writer.flush();  // Add this to flush buffer
            writer.close();  // Add this to close the writer properly
        }
    }
    
    @Test
    public void triggerTests() {
    	try {
    		runTarget = System.getProperty("runTarget", "all").toLowerCase(); 

			switch (runTarget) {
			case "test1":
				new TC01(writer).run();
				break;
			case "test2":
				new TC02(writer).run();
				break;
			case "all":
				new TC01(writer).run();
				new TC02(writer).run();
				break;
			default:
				PrintWriter errorWriter = new PrintWriter(new FileWriter("result.txt", true));
				errorWriter.println("❌ Invalid input: " + runTarget);
				errorWriter.println("Please use one of: test1, test2, all");
				errorWriter.close();
				break;
			}
		} catch (Exception e) {
			writer.println(e);
		} 
    }
	
}
