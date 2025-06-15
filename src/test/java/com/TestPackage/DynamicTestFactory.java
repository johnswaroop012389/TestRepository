package com.TestPackage;

import org.testng.annotations.Factory;

import java.util.ArrayList;
import java.util.List;

public class DynamicTestFactory {

	@Factory
	public Object[] createTests() {
		String runTarget = System.getProperty("runTarget", "all").toLowerCase();
		List<Object> tests = new ArrayList<>();

		if (runTarget.equals("test1") || runTarget.equals("all")) {
			tests.add(new TC01());
		}

		if (runTarget.equals("test2") || runTarget.equals("all")) {
			tests.add(new TC02());
		}

		return tests.toArray();
	}
}
