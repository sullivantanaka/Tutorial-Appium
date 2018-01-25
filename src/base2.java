
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

//Esta classe roda um APK já instalado no dispositivo, através dos comandos APP_PACKAGE e APP_ACTVITY. É necessário usar o programa "apk info" para obter as informacoes

public class base2 {

	public static AndroidDriver<AndroidElement> Capabilities() throws MalformedURLException {
		// TODO Auto-generated method stub
	
		//DesiredCapabilities: configuracoes do dispositivo
		DesiredCapabilities cap = new DesiredCapabilities();
		String app_package = "com.intelloware.apkinfo";
		String app_activity = "com.intelloware.apkinfo.MainActivity";
		
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		//cap.setCapability(MobileCapabilityType.DEVICE_NAME, "DemoSullivan"); //emulador Android Studio
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "peregrine"); //device Moto G
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "25");
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, app_package); //note que é AndroidMobileCapabilityType
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, app_activity);  
		
		//iniciando o webdriver
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(10,  TimeUnit.SECONDS);
		return driver;	
	}//Capabilities

}//base
