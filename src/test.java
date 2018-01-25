import java.net.MalformedURLException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class test extends base2 {

	public static void main(String[] args) throws MalformedURLException {
		 //Este teste navega na pagina Preferences/Preference Dependencies, seleciona o checkbox wifi, seleciona Wifi Settings e preenche o pop up com valor texto e clica OK 
		
		AndroidDriver<AndroidElement> driver = Capabilities();
		
		//acoes de navegacao
		
		System.out.println("Fim da execucao!");
	}

} //basics
