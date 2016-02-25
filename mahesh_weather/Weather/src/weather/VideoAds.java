package weather;

import io.appium.java_client.AppiumDriver;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

//import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
 public static AppiumDriver d;

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

		File app=new File("F:/APK/TWC_640001164_googleRelease.apk");
		System.out.println("Caps setting");

		DesiredCapabilities caps=new DesiredCapabilities();
		caps.setCapability("deviceName", "Android");
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "5.0.1");
		//			caps.setCapability("browserName", "chrome");
     caps.setCapability("app",app.getAbsolutePath());
		caps.setCapability("Debug", false);
		caps.setCapability("appPackage", "com.weather.Weather");
		caps.setCapability("appActivity", "com.weather.Weather.app.SplashScreenActivity");
		System.out.println("Capabilities are done");
		
		
//		 capabilities.setCapability(CapabilityType.PROXY, proxy);
		 System.out.println("found");

		 d = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		System.out.println(" done caps settings");
		d.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		System.out.println("Waiting for app push");


	}
	@Test
	public void testAd() throws Exception
	{
		 
		System.out.println("Now in Test method");
		Thread.sleep(8000);
	
	/*FileOutputStream fos=new FileOutputStream("F:\\mahesh_weather\\w1.xlsx");
       
	    
	   XSSFWorkbook wb=new XSSFWorkbook();
	    XSSFSheet s = wb.createSheet("Weather");
	    Row row = s.createRow(0);
		row.createCell(0).setCellValue("SNO");
		row.createCell(1).setCellValue("AdTime");
		wb.write(fos);
		fos.close();*/
		
	  //creating excel sheet 
		FileOutputStream fos=new FileOutputStream("F:\\mahesh_weather\\w1.xls");
		WritableWorkbook wwb=Workbook.createWorkbook(fos);
		WritableSheet ws=wwb.createSheet("Results",0);
		Label l1=new Label(0,0,"Videos");
		Label l2=new Label(1,0,"AdTime");
		ws.addCell(l1);
		ws.addCell(l2);
		
		
		
		Thread.sleep(8000);
		//clicking on main menu 
		
		
		
		
		
				
			
			//clicking on menu 
			d.findElementByClassName("android.widget.ImageButton").click();
			//clicking on settings
			Thread.sleep(2000);
			d.findElementByName("Settings").click();
			//clicking on about this app
			d.findElementByName("About this app").click();
			for (int i=1; i<=8; i++){
				
				d.findElementById("com.weather.Weather:id/about_version").click();
			}
			//clicking on test mode 
			d.findElementByName("TEST MODE SETTINGS").click();
			
			//clicking on ads 
			d.findElementByName("Ads").click();
			//chooce ads as test
			d.findElementByName("Test").click();
			System.out.println("settings done for ads as test ");
			// Close the app
			d.closeApp();
			Thread.sleep(1000);
			System.out.println("App closed successfully");

			// Relaunch the app
			d.launchApp();
			System.out.println("App launched successfully");
			Thread.sleep(1000);
			d.findElementByClassName("android.widget.ImageButton").click();
			//clicking on login
			d.findElementByName("Log in").click();
			
			//uname
			d.findElementByName("Email").sendKeys("chikotimahesh471@gmail.com");
			//pwd
			d.findElementById("com.weather.Weather:id/et_password").sendKeys("9705545051");
					
			//Login button
			d.findElementById("com.weather.Weather:id/bt_twc_login").click();
			System.out.println("Login success" );
			Thread.sleep(10000);
			d.findElement(By.id("com.weather.Weather:id/location_actionbar_name")).click();
			Thread.sleep(1000);
			//adding test location 
			System.out.println("Adding test location ");
			d.findElement(By.name("Cresbard, SD")).click();
			//d.findElementById("com.weather.Weather:id/place_name").click();
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
						//int  num_of_videos=d.findElementsByClassName("android.widget.RelativeLayout").size();
						
						int  num_of_videos=d.findElementsById("com.weather.Weather:id/video_row").size();
						//how many videos 
						System.out.println("num of videos:"+num_of_videos);
						int m=1;
						int val=1;
						while(m<=10)
						{
							for( int n=0;n<num_of_videos;n++)
							{
								// taking one string variable for kkep the values of video num in excel coloumn 
								String num=Integer.toString(m);
								//printing video num in first coloumn 
								Label l3=new Label(0,val,num);
								ws.addCell(l3);
								val++;
								//d.findElement(By.id("com.weather.Weather:id/grid_item_image")).click();
							WebElement clickVideo= (WebElement) d.findElementsById("com.weather.Weather:id/video_row").get(n);
							clickVideo.click();
							
							
							
							
							long startTime = System.currentTimeMillis();

							System.out.println("startTime MilliSec: "+startTime);
							
							

							try {

							//Thread.sleep(2000);

							d.findElementByAccessibilityId("Learn More").isDisplayed();
							

							long endTime = System.currentTimeMillis();

							System.out.println("EndTime MilliSec: "+endTime);

							double finalTime = endTime-startTime;

							System.out.println("finalTime MilliSec: "+finalTime);
						//row.createCell(1,n).setCellValue(finalTime);
						double adTime=finalTime/1000;
						
						String numberAsString = new Double(adTime).toString();
									
							
							Label l4=new Label(1,val,numberAsString);
							val++;
						ws.addCell(l4);
							System.out.println("Total time taken to display the Ad in MilliSec of "+n+"_Video"+":"+finalTime);

							System.out.println("Total time taken to display the Ad in Sec of "+n+"_Video"+":"+finalTime/1000);
							

							}catch(Exception e){

								System.out.println("Ad is not displayed");

								Label l4=new Label(1,val,"no ad");
								val++;
							ws.addCell(l4);

							}
							
							}
							m++;
						
						
						
						}
						
						break;
				
					}else
					{
		                System.out.println("video section is not presented and scrolling down");

		                d.swipe(0, startY,0, endY,2000);

					}
					
						
				}

			  wwb.write();
				wwb.close();

					//Thread.sleep(10000);
	
	}
	@AfterClass
	public void stop()
	{
		d.closeApp();

	}



}
