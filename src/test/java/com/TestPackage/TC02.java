package com.TestPackage;
import java.io.PrintWriter;

import org.openqa.selenium.WebDriver;

public class TC02 {

    private PrintWriter writer;
    
    public TC02(PrintWriter writer) {
        this.writer = writer;
    }
    
    public void run(WebDriver driver) throws Exception {
        writer.println("🚀 TC02: Test started.");
        
        writer.println("✅ TC02: Test completed.");        
    }
}
