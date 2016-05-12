# VideoAd_Performance

 elcome to the VideoAd_Performance wiki!

Video Ads performance project provides performance numbers for pre roll Ads in our Android Phones.

How the performance numbers are captured: Step by Step

1) Script downloads the build from the Hockey App ( run s daily after Jenkins integration). 2) Pushes the build to the test device already attached with the server. 3) Build is installed on the test device. 4) Script logs into the phone with pre defined test user name and password 5) Gets into test mode of the Ads 6) Kills the App 7) Launches the APP 8) Navigates to the test locations( test lines set up by Adtech Parson)

Line item name Targeting Creative Benchmark_AdLoad_AdX (test_app_iphone_us, test_app_android_us) and zip=59465 AdX Tag Benchmark_AdLoad_1stParty (test_app_iphone_us, test_app_android_us) and zip=83113 Ice Pilots, 1st Party Served (DFP) Benchmark_AdLoad_Skippable (test_app_iphone_us, test_app_android_us) and zip=57260 IMA Test ad: Skippable Test Benchmark_AdLoad_3rdParty (test_app_iphone_us, test_app_android_us) and zip=48467 IMA Test ad: Single Redirect Linear

9) All the test locations are picked up by the script one by one ( All are save in the user name logged into App) 10) Scripts timer starts as soon as the user click on the Video and the timer stops as soon as the Assets for the Ads are loaded on the screen. 11) Navigates through all the Video's available on the Phone Screen and captures the data in a excel file.
