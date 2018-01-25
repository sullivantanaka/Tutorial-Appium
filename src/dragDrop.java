import java.net.MalformedURLException;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class dragDrop extends base{ //Temos que rodar a tela até o link "ScrollBars". NAO há metodo scroll em Appium, teremos que trabalhar diretamente com código. 

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> driver = Capabilities("android device");
		TouchAction t = new TouchAction(driver); //para interacoes especiais como swipe, longpress, etc. Cuidado: "TouchActionS" é para Selenium!!
		
		
		//navegar até a tela desejada
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		driver.findElementByAndroidUIAutomator("text(\"Drag and Drop\")").click();
		//fazendo o drag and drop do ponto 1 ao ponto 3: aperta segura o 1, move até o 2, solta.
		//t.longPress(driver.findElementById("io.appium.android.apis:id/drag_dot_1")).moveTo(driver.findElementById("io.appium.android.apis:id/drag_dot_2")).release().perform();
	
		//outra forma, utilizando byClassName (caso o caractere especial do Id cause problema)
		t.longPress(driver.findElementsByClassName("android.view.View").get(0)).moveTo(driver.findElementsByClassName("android.view.View").get(1)).release().perform();
		t.longPress(driver.findElementsByClassName("android.view.View").get(0)).moveTo(driver.findElementsByClassName("android.view.View").get(3)).release().perform();
		t.longPress(driver.findElementsByClassName("android.view.View").get(0)).moveTo(driver.findElementsByClassName("android.view.View").get(2)).release().perform();
		
				
		System.out.println("Fim do teste");
	} //main

}