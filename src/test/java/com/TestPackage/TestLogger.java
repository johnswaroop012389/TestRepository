package com.TestPackage;

import java.io.PrintWriter;

public class TestLogger {
	private static PrintWriter writer;

	public static void setWriter(PrintWriter w) {
		writer = w;
	}

	public static void logPass(String message) {
		if (writer != null)
			writer.println("[PASS] " + message);
	}

	public static void logFail(String message) {
		if (writer != null)
			writer.println("[FAIL] " + message);
	}

	public static void logStep(String message, Runnable step) {
		try {
			step.run(); // Run the test step
			logPass(message);
		} catch (Exception e) {
			logFail(message);
			throw new RuntimeException(e); // Rethrow to fail the test
		}
	}

}
