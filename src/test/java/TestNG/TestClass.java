package TestNG;

import java.io.IOException;

import org.testng.annotations.Test;

import Main.mavendemo;

public class TestClass extends mavendemo{

	public TestClass() throws IOException {
		super();
		}
	@Test
	public void mainMethod() throws InterruptedException 
	{
		launchBrowser();
		app_Launch();
		method();
		
		
	}
	/*@Test
	public void loginpage()
	{
		
	}*/
}
