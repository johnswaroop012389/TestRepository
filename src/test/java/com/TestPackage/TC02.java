package com.TestPackage;
import java.io.PrintWriter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TC02 {

    private PrintWriter writer;
    
    public TC02(PrintWriter writer) {
        this.writer = writer;
    }
    
    public void run(WebDriver driver) throws Exception {
        writer.println("🚀 TC02: Test started.");
        driver.findElement(By.xpath("//td[contains(text(), 'Flood Renewals')]")).click();
        driver.findElement(By.xpath("//span[contains(text(), 'Edit Project')]")).click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElements(By.xpath("//span[contains(text(), 'Update')]")).size() > 0, "Expected element not found!");
        writer.println("✅ TC02: Test completed.");        
    }
}
