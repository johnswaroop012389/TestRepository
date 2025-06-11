package com.TestPackage;

import java.io.PrintWriter;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TC02 {

	private PrintWriter writer;

	public TC02(PrintWriter writer) {
		this.writer = writer;
	}

	public void run(WebDriver driver) throws Exception {
		writer.println("🚀 TC02: Test started.");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		TestLogger.logStep("Click on Flood Renewals", () -> {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(), 'Flood Renewals')]")))
					.click();
		});

		TestLogger.logStep("Click on Edit Project", () -> {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), 'Edit Project')]")))
					.click();
		});

		TestLogger.logStep("Check 'Update' button is visible", () -> {
			Assert.assertTrue(driver.findElements(By.xpath("//span[contains(text(), 'Update')]")).size() > 0,
					"Expected element not found!");
		});

		writer.println("✅ TC02: Test completed.");
	}
}
