package com.TestPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TC02 extends BaseTest {

	@Test
	public void runTC02() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		TestLogger.logStep("Click on Flood Renewals", () -> {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(), 'Flood Renewals')]")))
					.click();
		});

		TestLogger.logStep("Click on Edit Project", () -> {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), 'Edit Project')]")))
					.click();
		});
		
		TestLogger.logStep("Update Button is Visible", () -> {
			boolean isPresent = driver.findElements(By.xpath("//span[text()='Update']")).size() > 0;
			if (!isPresent) {
				throw new RuntimeException(); 
			}
		});
	}
}
