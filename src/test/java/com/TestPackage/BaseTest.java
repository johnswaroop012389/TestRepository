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

	@Test(enabled = true)
	public void runTC01() {
		if (shouldRun("test1") || shouldRun("all")) {
			writer.println("<!-- 🧪 Starting Test Case: TC01 -->");
			try {
				new TC01().run(driver);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Test(enabled = true)
	public void runTC02() {
		if (shouldRun("test2") || shouldRun("all")) {
			writer.println("<!-- 🧪 Starting Test Case: TC02 -->");
			try {
				new TC02().run(driver);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private boolean shouldRun(String target) {
		String runTarget = System.getProperty("runTarget", "all").toLowerCase();
		return runTarget.equals(target) || runTarget.equals("all");
	}

}
