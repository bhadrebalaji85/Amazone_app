package com.amazon.qa.setup;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import org.openqa.selenium.remote.DesiredCapabilities;

	public class Appium_Server_Status 

    	{
			public static AppiumDriverLocalService service;
			public static AppiumServiceBuilder builder;
			public DesiredCapabilities cap;
		
/*$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ FUNCTION START SERVER $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ */			
	public static  URL startServer(int port) throws InterruptedException 
				{
					String Appium_Node_Path="C:/Program Files/nodejs/node.exe";
					//String Appium_JS_Path="C:/Users/HP/AppData/Local/Programs/Appium/resources/app/node_modules/appium/lib/appium.js";
					//Build the Appium service
					String Appium_JS_Path="C:/Users/HP/AppData/Local/Programs/Appium/resources/app/node_modules/appium/lib/main.js";
					builder = new AppiumServiceBuilder();
					builder.withIPAddress("0.0.0.0");
					builder.usingPort(port);
					builder.usingDriverExecutable(new File(Appium_Node_Path));
					builder.withAppiumJS(new File(Appium_JS_Path));
					//Start the server with the builder
					service = AppiumDriverLocalService.buildService(builder);
					service.start();
					return service.getUrl();
				}
/*$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ END $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ */	
	
/*$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ CHECK SERVER STATUS $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ */			
	public static boolean checkIfServerIsRunnning(int port) 
	   			{
					boolean isServerRunning = false;
					ServerSocket serverSocket;
					try {
				   			serverSocket = new ServerSocket(port);
				   			serverSocket.close();
				   			System.out.println("Appium Server not started");
				   			
			     		} catch (IOException e) 
			     			{
			     			//If control comes here, then it means that the port is in use
			     			isServerRunning = true;
			     			System.out.println("Appium Server is already running");
			     			} finally 
			     			 {
			     				serverSocket = null;
			     			 }
						return isServerRunning;
	   			}	
/*$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ END $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ */	

/*$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$  TO STOP SERVER $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ */	

	public static void stopServer() 
	{
		service.stop();
	}
/*$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ END $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ */	
    }
