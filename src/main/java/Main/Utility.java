package Main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Utility {
	public static WebDriver driver=null;
	public static Properties prop=null;
	public static By by=null;
    public Utility() throws IOException// Throwable
{
	String ConfigFilePath=System.getProperty("user.dir")+"\\Config.Properties";
	//to read the data from .properties file
	FileInputStream fis=new FileInputStream(ConfigFilePath);
	//create the object of .properties file to excess the method of properties
	prop=new Properties();
	prop.load(fis);
}
   
public void launchBrowser() 
{
	//to fetch the data from config.properties file using reference of properties class	
	String browser=prop.getProperty("browserl");
	String driverPath=prop.getProperty("driverPath1");
	System.out.println("browserl");
	if(browser.equalsIgnoreCase("Chrome"))
	{
		
		//String dpath=System.getProperty("user.dir")+"\\src\\"+driverPath;
		System.setProperty("webdriver.chrome.driver", "C:\\ReqSel_JARs\\CrmDemo\\Browser_drivers\\chromedriver.exe");
		driver=new ChromeDriver();
	}else if (browser.equalsIgnoreCase("firefox"))
		{
		String dpath=System.getProperty("user.dir"+"\\src\\"+driverPath);
		System.setProperty("webdriver.gecko.driver", dpath);
		driver=new FirefoxDriver();

		}
}
	public void app_Launch() 
	{
	String Url=prop.getProperty("appUrl");
	driver.get(Url);
	}

	/*By by=null;
//	WebDriver driver;
	//Launch Browser
	public void launchBrowser(String browser) 
	{
		//String browser="Chrome";
		if(browser.equalsIgnoreCase("Chrome"))
		{
			String dPath =System.getProperty("user.dir")+"\\Browser_drivers\\chromedriver.exe";
			 //.relative path
			System.setProperty("webdriver.chrome.driver",dPath);
			//.WebDriver component of selenium
		 	driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("Firefox"))
		{
			String driverPath =System.getProperty("user.dir")+"\\Browser_drivers\\geckodriver.exe"; 
			System.setProperty("webdriver.gecko.driver",driverPath);
			driver =new FirefoxDriver();
		}
		driver.manage().window().maximize();
	}*/
	//driver.get("https://www.facebook.com/");
	
//	public void launchApp(String appUrl) 
//	{
//		driver.get(appUrl);
//	
//	
//	}
	
	
	public By bylocator(String locname, String locval) 
	//class is By by is odjec
	
	{	
		//By by = null;
		switch(locname) {
		case "id" :
		by=By.id(locval);
		break;
		case "css" :
		by= By.cssSelector(locval);
		break;
		case "xpath" :
		by= By.xpath(locval);
		break;
		case "partial link text" :
		by=By.partialLinkText(locval);
		break;
		case "link text" :
		by=By.linkText(locval);
		break;
		case "name" :
		by=By.name(locval);
		break;
		case "tagname" :
		by=By.tagName(locval);
		break;
	
		}
		return by;
	}
	public void sendData(String emailelmt) 
	{
		String [] ea=emailelmt.split("###");
//		String locname= elmArr[0];
//		String locval= elmArr[1];
//		String testdata= elmArr[2];
//		String [] passArr=passelemt.split("@@@");
//		String locnam= passArr[0];
//		String locvale= passArr[1];
//		String data= passArr[2];
		driver.findElement(bylocator( ea[0],  ea[1])).sendKeys( ea[2]);
	//	driver.findElement(bylocator( locname,  locval)).sendKeys( testdata);
	}
	public void clickElement(String clickfunc) 
	{	
		String [] cl=clickfunc.split("###");
//		String lctrname=clickArr[0];
//		String lctrvalue= clickArr[1]; 
		driver.findElement(bylocator( cl[0],  cl[1])).click();
	}
	public void web_Element(String elm_1) 
	{
		String [] cl=elm_1.split("###");
//		String lctrname=clickArr[0];
//		String lctrvalue= clickArr[1]; 
		WebElement  Elm=driver.findElement(bylocator( cl[0],  cl[1]));
		driver.switchTo().frame(Elm);
	
	}
	}
	/*public void setPassword(String locname, String locval) 
	{
		driver.findElement(bylocator( locname,  locval)).sendKeys("testing2018");
	}*/
//	public void clickElement(String locname, String locval) 
//	{
//		driver.findElement(bylocator( locname,  locval)).click();
//	}
//	public static void main(String[] args) 
//	{
//		Utility  obj =new Utility ();
//		obj.launchBrowser("chrome");
//		obj.launchApp("https://www.facebook.com/");
//		obj.sendData("xpath","//input[@id='email']","testing@123");
//		//obj.setPassword("name", "//input[@name='pass']" );
//		obj.clickElement("id", "//input[@id='u_0_3']");
//	}
//	}
