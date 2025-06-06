package com.TestPackage;
import java.io.PrintWriter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TC01 {

    private PrintWriter writer;

    public TC01(PrintWriter writer) {
        this.writer = writer;
    }
    
    public void run(WebDriver driver) throws Exception {
        writer.println("🚀 TC01: Test started.");
        Assert.assertTrue(driver.findElements(By.xpath("//span[contains(text(), 'Dashboard')]")).size() > 0, "Expected element not found!");
        Assert.assertTrue(driver.findElements(By.xpath("//span[contains(text(), 'Projects')]")).size() > 0, "Expected element not found!");
        Assert.assertTrue(driver.findElements(By.xpath("//span[contains(text(), 'Test Bank')]")).size() > 0, "Expected element not found!");
        Assert.assertTrue(driver.findElements(By.xpath("//span[contains(text(), 'Test Plans')]")).size() > 0, "Expected element not found!");
        Assert.assertTrue(driver.findElements(By.xpath("//span[contains(text(), 'Test Execution')]")).size() > 0, "Expected element not found!");
        Assert.assertTrue(driver.findElements(By.xpath("//span[contains(text(), 'Defects')]")).size() > 0, "Expected element not found!");
        Assert.assertTrue(driver.findElements(By.xpath("//span[contains(text(), 'Admin11')]")).size() > 0, "Expected element not found!"); 
        writer.println("Dashboard Elements Visibility Verified");
        writer.println("✅ TC01: Test completed.");
    }
}
