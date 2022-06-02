package com.TesnG;

import org.testng.annotations.Test;

public class TestNGFeatureDepen {
	
	@Test
	public void googleTitlePage() {
		System.out.println("title");
	}
	@Test(dependsOnMethods="googleTitlePage")//these test cases are dependent, only if url is correct homepage will b displayed
	//if dependency is not given all the test cases will run. if dependency is mentioned then this test case will not run if the above tc fails
	public void homePage() {
		System.out.println("HomePage");
	}


}
