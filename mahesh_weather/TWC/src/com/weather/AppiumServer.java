package com.weather;

import java.io.IOException;

public class AppiumServer {
	
	public static void AppiumStart() throws IOException, InterruptedException{
	
//	Process p = Runtime.getRuntime().exec("\"C:/Appium/node.exe\" \"C:/Appium/node_modules/appium/bin/Appium.js\" --no-reset --log-level --local-timezone");
	
	Process p = Runtime.getRuntime().exec("\"C:/Program Files (x86)/Appium/node.exe\" \"C:/Program Files (x86)/Appium/node_modules/appium/bin/Appium.js\" --no-reset --log-level --local-timezone");


	Thread.sleep(80000);
    }
	
	public static void AppiumStop() throws IOException, InterruptedException{
		
		Process q = Runtime.getRuntime().exec("cmd /c echo off & FOR /F \"usebackq tokens=5\" %a in (`netstat -nao ^| findstr /R /C:\"4723\"`) do (FOR /F \"usebackq\" %b in (`TASKLIST /FI \"PID eq %a\" ^| findstr /I node.exe`) do taskkill /F /PID %a)");
		
//		Process q = Runtime.getRuntime().exec("\"C:/Program Files (x86)/Appium/node.exe\" \"C:/Program Files (x86)/Appium/node_modules/appium/bin/Appium.js\" --no-reset --log-level --local-timezone");

		Thread.sleep(10000);
	    }
	
}

