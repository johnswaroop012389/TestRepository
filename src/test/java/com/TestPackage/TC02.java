package com.TestPackage;
import java.io.FileWriter;
import java.io.PrintWriter;

public class TC02 {

    public TC02(PrintWriter writer) {
        this.writer = writer;
    }
    
    public void run() throws Exception {
        writer.println("🚀 TC02: Test started.");
        
        writer.println("✅ TC02: Test completed.");        
    }
}
