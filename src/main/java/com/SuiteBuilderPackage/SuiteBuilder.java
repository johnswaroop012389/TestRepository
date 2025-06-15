package com.SuiteBuilderPackage;

import java.io.FileWriter;
import java.io.PrintWriter;

public class SuiteBuilder {
	public static void main(String[] args) throws Exception {
		String runTarget = System.getProperty("runTarget", "all").toLowerCase();
		PrintWriter writer = new PrintWriter(new FileWriter("testng.xml"));

		writer.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		writer.println("<!DOCTYPE suite SYSTEM \"https://testng.org/testng-1.0.dtd\">");
		writer.println("<suite name=\"DynamicSuite\" verbose=\"1\">");
		writer.println("  <test name=\"DynamicTest\">");
		writer.println("    <classes>");

		if ("test1".equals(runTarget) || "all".equals(runTarget)) {
			writer.println("      <class name=\"com.TestPackage.TC01\"/>");
		}
		if ("test2".equals(runTarget) || "all".equals(runTarget)) {
			writer.println("      <class name=\"com.TestPackage.TC02\"/>");
		}

		writer.println("    </classes>");
		writer.println("  </test>");
		writer.println("</suite>");
		writer.close();
	}
}
