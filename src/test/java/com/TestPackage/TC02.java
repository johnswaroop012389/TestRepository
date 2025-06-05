package com.TestPackage;
import java.io.FileWriter;
import java.io.PrintWriter;

public class TC02 {
    public void run() throws Exception {
        PrintWriter writer = new PrintWriter(new FileWriter("result.txt", true));
        writer.println(">> Running TestClass2...");
        writer.println("Result: TestClass2 Passed ✅");
        writer.close();
        
    }
}
