package com.TestPackage;

import java.io.FileWriter;
import java.io.PrintWriter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import org.testng.Assert;

public class BaseTest {
	public static WebDriver driver;
	public static PrintWriter writer;
	public static String runTarget;

	@BeforeClass
	public void setup() throws Exception {
		writer = new PrintWriter("results.txt");
		TestLogger.setWriter(writer); // register writer

		io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new"); // modern headless mode
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--disable-gpu");
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		//Launch Url 
		TestLogger.logStep("Launched" + " https://uat.qaconnector.com/Fintech/tenantLogin " + "Successufully", () -> {
			driver.get("https://uat.qaconnector.com/Fintech/tenantLogin");
		});

		// Enter username 
		TestLogger.logStep("Username Entered Successfully", () -> {
			driver.findElement(By.name("user_name")).sendKeys("amith.nadig");
		});
		
		// Enter password
		TestLogger.logStep("Password Entered Successfully", () -> {
			driver.findElement(By.name("password")).sendKeys("ViratKohli@123");
		});
		
		// Click on login button 
		TestLogger.logStep("Clicked on Login Successfully", () -> {
			driver.findElement(By.id("Login_loginbtn__7Tj03")).click();
		});
		Thread.sleep(2000);
		
		// Page loaded successfully
		TestLogger.logStep("Homepage Loaded Successfully", () -> {
			Assert.assertTrue(driver.findElements(By.className("landingPage_companyName__2RiNM")).size() > 0,
					"Element not found!");
		});
	}

	@AfterClass
	public void teardown() {
		if (driver != null) {
			TestLogger.logStep("Browser closed", () -> {
				driver.quit();
			});
			writer.flush(); // Add this to flush buffer
			writer.close(); // Add this to close the writer properly
		}
	}

	@Test
	public void triggerTests() {
		try {
			runTarget = System.getProperty("runTarget", "all").toLowerCase();

			switch (runTarget) {
			case "test1":
				new TC01().run(driver);
				break;
			case "test2":
				new TC02().run(driver);
				break;
			case "all":
				writer.println("<!-- 🧪 Starting Test Case: TC01 -->");
				new TC01().run(driver);
				writer.println("<!-- 🧪 Starting Test Case: TC02 -->");
				new TC02().run(driver);
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
