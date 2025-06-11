package com.TestPackage;
import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TC01 {

    public void run(WebDriver driver) throws Exception {
    	TestLogger.logPass("🚀 TC01: Test started.");
    	Map<String, String> validations = new LinkedHashMap<>();
    	validations.put("Dashboard is visible", "//span[contains(text(), 'Dashboard')]");
    	validations.put("Projects is visible", "//span[contains(text(), 'Projects')]");
    	validations.put("Test Bank is visible", "//span[contains(text(), 'Test Bank')]");
    	validations.put("Test Plans is visible", "//span[contains(text(), 'Test Plans')]");
    	validations.put("Test Execution is visible", "//span[contains(text(), 'Test Execution')]");
    	validations.put("Defects is visible", "//span[contains(text(), 'Defects')]");
    	validations.put("Admin is visible", "//span[contains(text(), 'Admin')]");
    	
    	for (Map.Entry<String, String> entry : validations.entrySet()) {
    	    String label = entry.getKey();
    	    String xpath = entry.getValue();

    	    TestLogger.logStep(label, () -> {
    	        Assert.assertTrue(driver.findElements(By.xpath(xpath)).size() > 0, "Expected element not found: " + label);
    	    });
    	}
    	TestLogger.logPass("✅ TC01: Test completed.");
    }
}
