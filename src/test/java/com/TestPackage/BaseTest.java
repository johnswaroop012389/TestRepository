package com.TestPackage;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class BaseTest {
	public static WebDriver driver;
	public static PrintWriter writer;
	public static WebDriverWait wait;

	@BeforeSuite
	public void initializeWriter() throws Exception {
		writer = new PrintWriter(new FileOutputStream("results.txt"), true); // overwrite mode
		TestLogger.setWriter(writer);
	}

	@BeforeClass
	public void beforeClassSetup() {
		io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--disable-gpu");
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		writer.println("***Starting New Test Execution***");
		TestLogger.logPass("Browser launched");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@BeforeMethod
	public void setup(ITestResult result) throws Exception {
		TestLogger.logPass("✅ Starting Test Case: " + result.getTestClass().getRealClass().getSimpleName());

		TestLogger.logStep("Launched https://uat.qaconnector.com/Fintech/tenantLogin Successfully", () -> {
			driver.get("https://uat.qaconnector.com/Fintech/tenantLogin");
		});

		TestLogger.logStep("Username Entered Successfully", () -> {
			driver.findElement(By.name("user_name")).sendKeys("amith.nadig");
		});

		TestLogger.logStep("Password Entered Successfully", () -> {
			driver.findElement(By.name("password")).sendKeys("ViratKohli@123");
		});

		Thread.sleep(2000);
		TestLogger.logStep("Clicked on Login Successfully", () -> {
			wait.until(ExpectedConditions.elementToBeClickable(By.id("Login_loginbtn__7Tj03"))).click();
		});

		Thread.sleep(3000);
		TestLogger.logStep("Homepage Loaded Successfully", () -> {
			boolean isPresent = driver.findElements(By.className("landingPage_companyName__2RiNM")).size() > 0;
			if (!isPresent) {
				throw new RuntimeException("Homepage not loaded");
			}
		});
	}

	@AfterMethod
	public void endTest(ITestResult result) throws Exception {
		TestLogger.logPass("✅ Ending Test Case: " + result.getTestClass().getRealClass().getSimpleName());
	}

	@AfterClass
	public void teardown() {
		if (driver != null) {
			TestLogger.logStep("Browser closed", () -> driver.quit());
		}
	}

	@AfterSuite
	public void closeWriter() {
		if (writer != null) {
			writer.flush();
			writer.close();
		}
	}
}
