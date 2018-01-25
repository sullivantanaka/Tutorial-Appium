import java.net.MalformedURLException;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class swipe extends base{

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub

		AndroidDriver<AndroidElement> driver = Capabilities("peregrine");
		
		TouchAction t = new TouchAction(driver); //para interacoes especiais como swipe, longpress, etc. Cuidado: "TouchActionS" é para Selenium!!
		
		
		//navegar até a tela desejada
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		driver.findElementByAndroidUIAutomator("text(\"Date Widgets\")").click();
		driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();
		
		//Iremos clicar no numero 9 (horas) e em seguida faremos um swipe do numero 15 ao numero 45 (hora final será 9h45)
		
		//temos um problema: os numeros pertencem todos a mesma classe, mas temos o atributo "content-desc", entao podemos utiliza-lo
		//temos outro problema: o nome da classe contem o caractere especial $, desta forma, iremos utilizar uma expressao regular
		driver.findElementByXPath("//*[@content-desc='9']").click(); //utilizando o *, nao precisamos explicitar o nome da classe!
		
		//iremos agora fazer o swipe, utilizando o método moveTo
		t.press(driver.findElementByXPath("//*[@content-desc='15']")).waitAction().moveTo(driver.findElementByXPath("//*[@content-desc='45']")).perform();
		
	} //main

}
