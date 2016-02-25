package com.weather;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;

public class test1 {
public static MobileDriver d =null;
	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		 System.out.println("Strted");
		 // capabilities.setCapability(CapabilityType.BROWSER_NAME,"Chrome");
		 capabilities.setCapability("appium-version", "1.0");
		 capabilities.setCapability("platformName", "Android");
		 capabilities.setCapability("platformVersion", "5.0");
		 capabilities.setCapability("deviceName", "Samsung");
		//capabilities.setCapability("app", "D:\\APK\\TWC.apk");
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

}
