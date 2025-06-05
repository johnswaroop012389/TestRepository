package com.TestPackage;

import java.io.FileWriter;
import java.io.PrintWriter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
	public static WebDriver driver;
	public static PrintWriter writer;
	public static void main(String[] args) throws Exception {
		System.out.println("Here ");
		
		try {
			String runTarget = args.length > 0 ? args[0].toLowerCase() : "both";
			writer = new PrintWriter("result.txt");
			writer.println("== Java Test Execution Results ==");
			writer.println("Runing " + runTarget);
			setup(writer);
			System.out.println("Here2 ");

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
		} finally {
			tearDown(writer);
			writer.close();
		}
		
	}
	
    public static void setup(PrintWriter writer) {
    	String driverPath = System.getProperty("user.dir") + "/drivers/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://uat.qaconnector.com/Fintech/tenantLogin");
        writer.println("Launched"+ " https://uat.qaconnector.com/Fintech/tenantLogin "+ "Successufully");
    }
    
    public static void tearDown(PrintWriter writer) {
        if (driver != null) {
            driver.quit();
            writer.println("Browser closed");
        }
    }
}
