import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class base {

	public static AndroidDriver<AndroidElement> Capabilities(String deviceName) throws MalformedURLException {
		
		if (deviceName == "")  {
			deviceName = "Android device";  //Moto G
		}
		
		File f = new File("src"); //src é o folder onde está o apk
		File fs = new File(f, "ApiDemos-debug.apk"); //este script sempre fará a instalacao do APK no device
		
		//DesiredCapabilities: configuracoes do dispositivo
		DesiredCapabilities cap = new DesiredCapabilities();
		//cap.setCapability(MobileCapabilityType.DEVICE_NAME, "DemoSullivan"); //usando emulador do Android Studio
		//cap.setCapability(MobileCapabilityType.DEVICE_NAME, "vbox86p"); //usando emulador do genymotion
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName); //device real
		
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		//cap.setCapability("fullReset","true"); //caso nao deseje instalar o APK toda vez
		
		//iniciando o webdriver
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(10,  TimeUnit.SECONDS);
		return driver;	
	}//Capabilities

}//base
