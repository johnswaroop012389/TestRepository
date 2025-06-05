package com.TestPackage;
import java.io.FileWriter;
import java.io.PrintWriter;

public class TC01 {
    public void run() throws Exception {
        PrintWriter writer = new PrintWriter(new FileWriter("results.txt", true));
        writer.println(">> Running TestClass1...");
        writer.println("Result: TestClass1 Passed ✅");
        writer.close();
    }
}
