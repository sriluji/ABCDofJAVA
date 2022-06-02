package com.TesnG;

import org.testng.annotations.Test;

public class GoogleTitleTest {

	@Test(priority=1, groups="Title")
	public void googleTitleTest(){
		System.out.println("test1");
		
	}
	@Test(priority=2, groups="Login")
	public void googleLoginTest(){
		System.out.println("test1");
		
	}
	@Test(priority=3, groups="user")//multiple test cases can b grouped into same group or different groups
	public void googleUserNTest(){
		System.out.println("test1");
		
	}
	@Test(priority=4,groups ="user")
	public void googlePassWTest(){
		System.out.println("test1");
		
	}
}
