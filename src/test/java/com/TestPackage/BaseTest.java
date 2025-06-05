package com.TestPackage;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import org.openqa.selenium.chrome.ChromeOptions; // add this import

public class BaseTest {
	public static WebDriver driver;
	public static PrintWriter writer;
	public static String runTarget;
	
	@BeforeClass
    public void setup() throws FileNotFoundException {
		writer = new PrintWriter("result.txt");
        io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();

	ChromeOptions options = new ChromeOptions(); 
        options.addArguments("--user-data-dir=/tmp/chrome-user-data-" + System.currentTimeMillis());
        options.addArguments("--headless=new"); 
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
	    
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://uat.qaconnector.com/Fintech/tenantLogin");
        writer.print("Test Execution Started ");
        writer.println("Launched"+ " https://uat.qaconnector.com/Fintech/tenantLogin "+ "Successufully");
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
            writer.println("Browser closed");
            writer.print("Test Execution Ended ");
        }
    }
    
    @Test
    public void triggerTests() {
    	try {
    		runTarget = System.getProperty("runTarget", "both").toLowerCase(); 
			writer.println("== Java Test Execution Results ==");
			writer.println("Running " + runTarget);

			switch (runTarget) {
			case "class1":
				new TC01().run();
				break;
			case "class2":
				new TC02().run();
				break;
			case "both":
				new TC01().run();
				new TC02().run();
				break;
			default:
				PrintWriter errorWriter = new PrintWriter(new FileWriter("result.txt", true));
				errorWriter.println("❌ Invalid input: " + runTarget);
				errorWriter.println("Please use one of: class1, class2, both");
				errorWriter.close();
				break;
			}
		} catch (Exception e) {
			writer.println(e);
		} 
    }
	
}
