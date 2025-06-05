package com.TestPackage;
import java.io.FileWriter;
import java.io.PrintWriter;

public class TC01 {

    private PrintWriter writer;

    public TC01(PrintWriter writer) {
        this.writer = writer;
    }
    
    public void run() throws Exception {
        writer.println("🚀 TC01: Test started.");
        
        writer.println("✅ TC01: Test completed.");
    }
}
