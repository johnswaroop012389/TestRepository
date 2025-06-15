package com.TestPackage;

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

    @BeforeClass
    public void setup() throws Exception {
        writer = new PrintWriter("results.txt");
        TestLogger.setWriter(writer); // register writer

        io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        TestLogger.logStep("Launched https://uat.qaconnector.com/Fintech/tenantLogin Successfully", () -> {
            driver.get("https://uat.qaconnector.com/Fintech/tenantLogin");
        });

        TestLogger.logStep("Username Entered Successfully", () -> {
            driver.findElement(By.name("user_name")).sendKeys("amith.nadig");
        });

        TestLogger.logStep("Password Entered Successfully", () -> {
            driver.findElement(By.name("password")).sendKeys("ViratKohli@123");
        });

        TestLogger.logStep("Clicked on Login Successfully", () -> {
            driver.findElement(By.id("Login_loginbtn__7Tj03")).click();
        });

        Thread.sleep(2000);

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
            writer.flush();
            writer.close();
        }
    }
}
