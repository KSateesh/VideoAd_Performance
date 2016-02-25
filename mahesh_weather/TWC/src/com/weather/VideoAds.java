package com.weather;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

//import java.io.Console;
import java.io.File;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.DoubleClickAction;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.webdriven.commands.DoubleClick;

@SuppressWarnings("unused")
public class VideoAds {
	@SuppressWarnings("rawtypes")
 public static MobileDriver d;

	@BeforeClass
	public void setUp() throws Exception
	{

		/*System.out.println("Stop the Appium sever");
			AppiumServer.AppiumStop();
			System.out.println("Appium sever is stopped");

			System.out.println("===================================");

			System.out.println("Start the Appium sever");
			AppiumServer.AppiumStart();
			System.out.println("Appium sever is started and running");

			System.out.println("===================================");*/

		File app=new File("F:/APK/TWC_610001066_googleRelease.apk");
		System.out.println("Caps setting");

//		DesiredCapabilities caps=new DesiredCapabilities();
//		caps.setCapability("deviceName", "Android");
//		caps.setCapability("platformName", "Android");
//		caps.setCapability("platformVersion", "5.0.1");
//		//			caps.setCapability("browserName", "chrome");
//		caps.setCapability("app",app.getAbsolutePath());
//		caps.setCapability("Debug", false);
//		caps.setCapability("appPackage", "com.weather.Weather");
//		caps.setCapability("appActivity", "com.weather.Weather.app.SplashScreenActivity");
//		System.out.println("Capabilities are done");
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		 System.out.println("Strted");
		 // capabilities.setCapability(CapabilityType.BROWSER_NAME,"Chrome");
		 capabilities.setCapability("appium-version", "1.0");
		 capabilities.setCapability("platformName", "Android");
		 capabilities.setCapability("platformVersion", "5.0");
		 capabilities.setCapability("deviceName", "Samsung");
		 capabilities.setCapability("app", "D:\\APK\\TWC.apk");
		 capabilities.setCapability("appPackage", "com.weather.Weather");
		 capabilities.setCapability("appActivity", "com.weather.Weather.app.SplashScreenActivity");
		 capabilities.setCapability("newCommandTimeout", 100000);
//		 Proxy proxy = new Proxy();
//		 proxy.setHttpProxy("192.168.1.91:8888");
//		 capabilities.setCapability(CapabilityType.PROXY, proxy);
		 System.out.println("found");

		 d = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		System.out.println("Caps done");
		d.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		System.out.println("Waiting for app push");


	}
	@Test
	public void testAd() throws Exception
	{



		System.out.println("Now in Test method");
		Thread.sleep(8000);

		/*	
			Thread.sleep(8000);

			d.findElement(By.id("com.weather.Weather:id/location_actionbar_name")).click();
			Thread.sleep(1000);
			d.findElement(By.name("Cresbard, SD (57435)")).click();
			Thread.sleep(1000);


			//scrolling down to videos module

			System.out.println("Scrolling started ");

			 Dimension dimensions = d.manage().window().getSize();
			  System.out.println("dimensions :: "+dimensions);

			  Double startY1 = dimensions.getHeight() * 0.99;
			  System.out.println("startY value :: "+ startY1);

			  int startY = startY1.intValue();
			  System.out.println("startY value = " + startY);

			  Double endY1 = (double) (dimensions.getHeight()/60);  //  dimensions.getHeight()  0.2;  == 512.0
			  System.out.println("endY value :: " + endY1);

			       int endY = endY1.intValue(); 
			       System.out.println("scroll to end = " + endY);

//			       Thread.sleep(1000);

			  for (int i = 0; i < dimensions.getHeight(); i++) 
				{
				  System.out.println("In for loop");

					WebElement videoModule = null;

					try {
//						videoModule = d.findElementById("com.weather.Weather:id/video_title");
						videoModule = d.findElementByName("Video");

					 } catch (Exception e) {
						// System.out.println(e);	
					 }

					if(videoModule!= null && videoModule.isDisplayed())	
					{ 

						System.out.println("video section is displayed and tap on video section");

						Thread.sleep(4000);

						d.findElement(By.id("com.weather.Weather:id/grid_item_image")).click();

						long startTime = System.currentTimeMillis();

						System.out.println("startTime MilliSec: "+startTime);

						try {

						Thread.sleep(2000);

						d.findElementByAccessibilityId("Learn More").isDisplayed();

						long endTime = System.currentTimeMillis();

						System.out.println("startTime MilliSec: "+endTime);

						double finalTime = endTime-startTime;

						System.out.println("startTime MilliSec: "+finalTime);

						System.out.println("Total time taken to display the Ad in MilliSec: "+finalTime);

						System.out.println("Total time taken to display the Ad in Sec: "+finalTime/1000);

						}catch(Exception e){

							System.out.println("Ad is not displayed");

						}

					}else
					{
		                System.out.println("video section is not presented and scrolling down");

		                d.swipe(0, startY,0, endY,2000);

					}
				}



					Thread.sleep(10000);
		 */
	}
	@AfterClass
	public void stop()
	{
		d.closeApp();

	}



}
