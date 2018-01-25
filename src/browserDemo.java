import java.net.MalformedURLException;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import static org.junit.Assert.*;

public class browserDemo extends baseChrome {

	public static void main(String[] args) throws MalformedURLException{
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> driver = Capabilities("android device");
		
		driver.get("http://www.wikipedia.org"); //URL do website que desejamos
			
		driver.findElementById("searchLanguage").click();
		driver.findElementByXPath("//*[@id=\"searchLanguage\"]/option[39]").click();
		driver.findElementById("searchInput").sendKeys("Teste de Software"); //digitando na caixa de busca 
		driver.findElementByXPath("//*[@id=\"search-form\"]/fieldset/button/i").click(); //clicando no botão da lupa
		
		//scroll demo
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,400)", "");
		
		//verificar que o link "Visão Geral" pertence a classe "headline alguma coisa"
		Assert.assertTrue(driver.findElementByXPath("//*[@id=\"Visão_geral\"]").getAttribute("class").contains("headline"));
		System.out.println(driver.findElementByXPath("//*[@id=\"Visão_geral\"]").getAttribute("class").contains("headline")); //deveria imprimir "true"
		
		
		System.out.println("Fim do teste");
	}

}
