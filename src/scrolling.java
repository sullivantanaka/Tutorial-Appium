import java.net.MalformedURLException;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class scrolling extends base{ //Temos que rodar a tela até o link "ScrollBars". NAO há metodo scroll em Appium, teremos que trabalhar diretamente com código. 

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> driver = Capabilities("");
		TouchAction t = new TouchAction(driver); //para interacoes especiais como swipe, longpress, etc. Cuidado: "TouchActionS" é para Selenium!!
		
		
		//navegar até a tela desejada
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		//fazendo o scroll
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));");
		driver.findElementByAndroidUIAutomator("text(\"WebView\")").click();
		
		System.out.println("Fim do teste");
		
	} //main

}
