package com.TestPackage;

import java.io.PrintWriter;

public class TestLogger {
	private static PrintWriter writer;

	// ANSI escape codes for colors
	private static final String RESET = "\u001B[0m";
	private static final String GREEN = "\u001B[32m";
	private static final String RED = "\u001B[31m";

	public static void setWriter(PrintWriter w) {
		writer = w;
	}

	public static void logPass(String message) {
		if (writer != null)
			writer.println(GREEN + "[PASS] " + message + RESET);
	}

	public static void logFail(String message, Exception e) {
		if (writer != null)
			writer.println(RED + "[FAIL] " + message + " - " + e.getMessage() + RESET);
	}

	public static void logStep(String message, Runnable step) {
		try {
			step.run(); // Run the test step
			logPass(message);
		} catch (Exception e) {
			logFail(message, e);
		}
	}
}
