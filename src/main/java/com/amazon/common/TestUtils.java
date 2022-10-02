package com.amazon.common;

public class TestUtils {

	public final static void hardWait(int seconds) {

		try {
			Thread.sleep(1000 * seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
