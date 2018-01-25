import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class baseChrome { //configuracao para rodar o chrome do celular

	public static AndroidDriver<AndroidElement> Capabilities(String deviceName) throws MalformedURLException {
		if (deviceName == "")  {
			deviceName = "peregrine";  //Moto G
		}
		//DesiredCapabilities: configuracoes do dispositivo
		DesiredCapabilities cap = new DesiredCapabilities();
		//cap.setCapability(MobileCapabilityType.DEVICE_NAME, "vbox86p"); //emulador GenyMotion
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName); //device real
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		cap.setCapability("fullReset","false");
		cap.setCapability("no-Reset","true");
				
		//iniciando o webdriver
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(10,  TimeUnit.SECONDS);
		return driver;	
	}//Capabilities

}//base
