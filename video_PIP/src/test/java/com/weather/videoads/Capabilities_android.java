package com.weather.videoads;







import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;



@SuppressWarnings("unused")
public class Capabilities_android extends Driver {

	
	@SuppressWarnings({ "rawtypes" })
	public void dcap() throws InterruptedException, IOException {

		//Read data from PropertyFile
		//	d.property();
		
		PropertyFile.property();

	    //  Appium auto start and Killing ADB server
		     
		Start_Stop_AppiumServer as = new Start_Stop_AppiumServer();
		
		System.out.println("Stopping the ADB server");
		as.killadb();
		System.out.println("ADB Server is stopped");
		Thread.sleep(9000);
		
		System.out.println("===================================");

		
		//To Uninstall the APK
		 System.out.println("Uninstall the APP and Install");	
		 String[] uninstall ={"/bin/bash", "-c",  properties.getProperty("adbPath")+" uninstall com.weather.Weather"};
	     Process  apk_uninstall = Runtime.getRuntime().exec(uninstall);	
	     Thread.sleep(4000);
	     
	     /*      
		//To Install the APK
	     String apkPath = properties.getProperty("appPath");
	     System.out.println("Apk Path : "+apkPath);
	     System.out.println("adb Path : "+properties.getProperty("adbPath"));
	     
		 String[] install ={"/bin/bash", "-c", "/Users/monocept/Documents/adt-bundle-mac-x86_64-20130522/sdk/platform-tools/adb install "+properties.getProperty("appPath")};
	     Process  apk_install = Runtime.getRuntime().exec(install);	
	     Thread.sleep(28000);
	     */
		System.out.println("===================================");
		
		
		System.out.println("Stopping the appium server");
		as.stopAppiumServer();
		System.out.println("Appium server is stopped");
     	
		Thread.sleep(10000);
     	
		System.out.println("Starting the appium server");
		as.startAppiumServer();
		System.out.println("Appium server is started an"
				+ "d running");
		System.out.println("Install the app");
		Thread.sleep(30000);
		
        //Setting the Capabilities 
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability("appium-version", "1.0");
		capabilities.setCapability("platformName",  properties.getProperty("platformName")); 
		capabilities.setCapability("platformVersion", properties.getProperty("platformVersion"));
		capabilities.setCapability("deviceName", properties.getProperty("deviceName")); 
		capabilities.setCapability("app", properties.getProperty("appPath"));
		capabilities.setCapability("appPackage", "com.weather.Weather");
		capabilities.setCapability("appActivity", "com.weather.Weather.app.SplashScreenActivity");
		capabilities.setCapability("autoAcceptAlerts",true);
		capabilities.setCapability("newCommandTimeout",100000);

		d = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		d.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		System.out.println("Working fine");
	
		//System.out.println("logfile is ::"properties.getProperty("LogFilePath"));

		System.out.println("Capabilities are launched");

	}
}







