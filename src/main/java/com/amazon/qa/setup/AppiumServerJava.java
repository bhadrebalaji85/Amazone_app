package com.amazon.qa.setup;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AppiumServerJava {

private AppiumDriverLocalService service;
private AppiumServiceBuilder builder;
private DesiredCapabilities cap;

public void startServer(int port) throws InterruptedException {
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
	//return service.getUrl();
}

public void stopServer() {
	service.stop();
}

public boolean checkIfServerIsRunnning(int port) {
	boolean isServerRunning = false;
	ServerSocket serverSocket;
	try {
		serverSocket = new ServerSocket(port);
		serverSocket.close();
	} catch (IOException e) {
		//If control comes here, then it means that the port is in use
		isServerRunning = true;
	} finally {
		serverSocket = null;
	}
	return isServerRunning;
}	

public static void main(String[] args) throws InterruptedException {
	AppiumServerJava appiumServer = new AppiumServerJava();
	int port = 4723;
	if(!appiumServer.checkIfServerIsRunnning(port)) {
		//System.out.println(appiumServer.startServer(port));
		appiumServer.startServer(port);
	} else {
		System.out.println("Appium Server already running on Port - " + port);
	}
}
}