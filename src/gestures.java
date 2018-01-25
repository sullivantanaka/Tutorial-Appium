import java.net.MalformedURLException;

import org.openqa.selenium.interactions.touch.TouchActions;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class gestures extends base {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> driver = Capabilities("peregrine");
		
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		//tap ao invés de click. o objeto touchAction fornece outras acoes uteis como pressionar e segurar (long press)
		TouchAction t = new TouchAction(driver);
		t.tap(driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']")).perform();
		
		driver.findElementByAndroidUIAutomator("text(\"1. Custom Adapter\")").click();
		t.press(driver.findElementByXPath("//android.widget.TextView[@text='People Names']")).waitAction().perform(); //apertar, esperar 3 sec e soltar
		//t.longPress(driver.findElementByXPath("//android.widget.TextView[@text='People Names']"), 3000, 0); //alternativa pro comando acima, depois testar
	
		//verificar se o titulo do pop-up exibido é de fato "Sample Menu":
		System.out.println("Exibiu: " + driver.findElementById("android:id/title").getText());
		//problema: os ID dos elementos Sample Menu e Sample Action sao os mesmos, como diferenciar ????
		//solucao: como eu espero que a frase exibida seja "Sample action" eu forço o script a procurar esta string, caso nao encontrar é falha
		System.out.println("Exibiu: " + driver.findElementByAndroidUIAutomator("text(\"Sample action\")").getText());
		
	} //
} //gestures
