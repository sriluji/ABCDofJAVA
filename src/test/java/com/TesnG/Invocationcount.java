package com.TesnG;

import org.testng.annotations.Test;

public class Invocationcount {
	@Test(invocationCount=5)//if this test case has to run more number of times then specify the number
	public void sum() {
		int a=10;
		int b=10;
		int c=a+b;
		System.out.println(c);
}
}