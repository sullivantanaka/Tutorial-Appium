import java.net.MalformedURLException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class basics extends base{

	public static void main(String[] args) throws MalformedURLException {
		 //Este teste navega na pagina Preferences/Preference Dependencies, seleciona o checkbox wifi, seleciona Wifi Settings e preenche o pop up com valor texto e clica OK 
		
		AndroidDriver<AndroidElement> driver = Capabilities("peregrine");
		
		//acoes de navegacao
		driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click(); //identificando por xpath e texto
		//driver.findElementByXPath("//android.widget.TextView[3]").click(); //identificando por xpath e indice da ocorrencia [3]
		//abaixo uma forma alternativa de reproduzir o passo acima usando o método AndroidUIAutomator
		driver.findElementByAndroidUIAutomator("text(\"3. Preference dependencies\")").click();
		driver.findElementById("android:id/checkbox").click(); //identificando por id
		driver.findElementByXPath("//android.widget.TextView[@text='WiFi settings']").click(); //ao selecionar wifi, habilita o link WifiSettings, que é clicado
		driver.findElementByClassName("android.widget.EditText").sendKeys("Hello"); //identificando por classname
		//para clicar no botao OK, ao invés de utilizar a forma usual, vamos identificar todos os elementos da mesma classe através do metodo findElements
		driver.findElementsByClassName("android.widget.Button").get(1).click(); //o metodo get(1) identifica o 2o elemento, no caso botao OK. Lembrando que o indice comeca em zero, por isso colocamos 1
		System.out.println("Fim da execucao!");
	}

} //basics
