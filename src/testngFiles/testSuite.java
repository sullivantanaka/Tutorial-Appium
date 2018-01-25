package testngFiles;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

/*
 * Demonstracao do uso do TestNG
 * 
 * Este test suite apresenta algumas validações do site www.xxxxxxxxxx.com
 * 
 * 
 */

public class testSuite {
	
	private AndroidDriver<AndroidElement> driver; //driver que iremos utilizar (Android ou IOS)
	String deviceName = "android device";
	//String baseUrl = "https://goo.gl/forms/UZ8sb7N7XgvIufJU2"; //url do site que iremos automatizar
	String baseUrl = "https://www.somatematica.com.br";
	
	@BeforeMethod
	public void setUp() throws Exception { //executa antes de cada teste, construindo o driver
		//configuração das capabilities: neste caso, rodamos os testes com Chrome em um device real
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName); //device real
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
		//iniciando o AndroidDriver
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap); //URL: onde executa o servidor Appium
		driver.manage().timeouts().implicitlyWait(30,  TimeUnit.SECONDS);
	    driver.get(baseUrl + "/matkids/game.php");
	    
	    //fecha o popup de traducao chato
	    String context = driver.getContext();
	    driver.context("NATIVE_APP");
	    driver.findElementById("Close").click();
	    driver.context(context);

	} //setUp
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	@AfterMethod
	public void tearDown() throws Exception { //executa após cada teste, liberando recursos ao destruir o driver
		driver.quit();
	}
	
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	  public void tiraScreenshot (String scrShot_arq) throws Exception {
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(scrShot_arq));
		} //tiraScreenshot

	//////////////////////////////////////////////////////////////////////////////////////////////////	
	
	 @Test
	  public void CT_001_adicao() throws Exception { //Teste da adição
	    //nome e caminho padrão onde grava os printscreens

	    driver.findElement(By.name("nome")).clear();
	    driver.findElement(By.name("nome")).sendKeys("Adição");
	    driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td/form/p[2]/font[2]/input[1]")).click(); //escolhe o operador adiçao
	    driver.findElement(By.name("envia")).click();
	    String valor1 = driver.findElement(By.xpath("//td[2]/font/b")).getText();
	    String valor2 = driver.findElement(By.xpath("//tr[2]/td/font/b")).getText();
	    int resultado;
	    resultado = Integer.parseInt(valor1) + Integer.parseInt(valor2);
	    System.out.println("Resultado da Adição: " + resultado);
	    driver.findElement(By.name("resposta")).clear();
	    driver.findElement(By.name("resposta")).sendKeys(String.valueOf(resultado)); //converte variavel int resultado para string para o método sendKeys do selenium funcionar
	    tiraScreenshot("c:\\temp\\CT_001_a.jpg");
	    driver.findElement(By.name("envia")).click();
	    assertEquals("Você acertou!!!", driver.findElement(By.xpath("//p[2]/font/b")).getText());
	    tiraScreenshot("c:\\temp\\CT_001_b.jpg");
	 }
	 
	  //////////////////////////////////////////////////////////////////////////////////////////////////

	 
	  @Test
	  public void CT_002_subtracao() throws Exception { //teste da subtração

		driver.findElement(By.name("nome")).clear();
	    driver.findElement(By.name("nome")).sendKeys("Subtração");
	    driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td/form/p[2]/font[2]/input[2]")).click(); //escolhe o operador subtracao
	    driver.findElement(By.name("envia")).click();
	    String valor1 = driver.findElement(By.xpath("//td[2]/font/b")).getText();
	    String valor2 = driver.findElement(By.xpath("//tr[2]/td/font/b")).getText();
	    int resultado;
	    resultado = Integer.parseInt(valor1) - Integer.parseInt(valor2);
	    System.out.println("Resultado Subtração: " + resultado);
	    driver.findElement(By.name("resposta")).clear();
	    driver.findElement(By.name("resposta")).sendKeys(String.valueOf(resultado)); //converte variavel int resultado para string para o método sendKeys do selenium funcionar
	    tiraScreenshot("c:\\temp\\CT_002_a.jpg");
	    driver.findElement(By.name("envia")).click();
	    assertEquals("Você acertou!!!", driver.findElement(By.xpath("//p[2]/font/b")).getText());
	    tiraScreenshot("c:\\temp\\CT_002_b.jpg");
	  }

	  //////////////////////////////////////////////////////////////////////////////////////////////////

	  @Test
	  public void CT_003_multiplicacao() throws Exception { //teste da multiplicação
	    driver.findElement(By.name("nome")).clear();
	    driver.findElement(By.name("nome")).sendKeys("Multiplicação");
	    driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td/form/p[2]/font[2]/input[3]")).click(); //escolhe o operador multiplicacao
	    driver.findElement(By.name("envia")).click();
	    String valor1 = driver.findElement(By.xpath("//td[2]/font/b")).getText();
	    String valor2 = driver.findElement(By.xpath("//tr[2]/td/font/b")).getText();
	    int resultado;
	    resultado = Integer.parseInt(valor1) * Integer.parseInt(valor2);
	    System.out.println("Resultado da Multiplicação: " + resultado);
	    driver.findElement(By.name("resposta")).clear();
	    driver.findElement(By.name("resposta")).sendKeys(String.valueOf(resultado)); //converte variavel int resultado para string para o método sendKeys do selenium funcionar
	    driver.findElement(By.name("envia")).click();
	    assertEquals("Você acertou!!!", driver.findElement(By.xpath("//p[2]/font/b")).getText());
	  }

	  //////////////////////////////////////////////////////////////////////////////////////////////////

	  @Test
	  public void CT_004_divisao() throws Exception { //teste da divisão
	    driver.findElement(By.name("nome")).clear();
	    driver.findElement(By.name("nome")).sendKeys("Divisão");
	    driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td/form/p[2]/font[2]/input[4]")).click(); //escolhe o operador divisao
	    driver.findElement(By.name("envia")).click();
	    String valor1 = driver.findElement(By.xpath("//td[2]/font/b")).getText();
	    String valor2 = driver.findElement(By.xpath("//tr[2]/td/font/b")).getText();
	    int resultado;
	    resultado = Integer.parseInt(valor1) / Integer.parseInt(valor2);
	    System.out.println("Resultado da Divisão: " + resultado);
	    driver.findElement(By.name("resposta")).clear();
	    driver.findElement(By.name("resposta")).sendKeys(String.valueOf(resultado)); //converte variavel int resultado para string para o método sendKeys do selenium funcionar
	    driver.findElement(By.name("envia")).click();
	    assertEquals("Você acertou!!!", driver.findElement(By.xpath("//p[2]/font/b")).getText());
	  }

	  //////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	  @Test
	  public void CT_005_aleatorio() throws Exception { //teste do aleatório
	    
	    //iniciando teste na aplicacao web
	    driver.findElement(By.name("nome")).clear();
	    driver.findElement(By.name("nome")).sendKeys("Todos");
	    driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td/form/p[2]/font[2]/input[5]")).click(); //escolhe a opção Todos
	    driver.findElement(By.name("envia")).click(); //botao Quero Praticar
	    
	    String valor1 = driver.findElement(By.xpath("//td[2]/font/b")).getText();
	    String valor2 = driver.findElement(By.xpath("//tr[2]/td/font/b")).getText();
	    String operador = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[1]/div/table/tbody/tr[1]/td[1]/p/font/b")).getText(); //obtém o operador
	    
	    int resultado = 0;
	    
	    switch (operador) {
	    	case "+": resultado = Integer.parseInt(valor1) + Integer.parseInt(valor2);
	    	break;
	    	case "-": resultado = Integer.parseInt(valor1) - Integer.parseInt(valor2);
	    	break;
	    	case "x": resultado = Integer.parseInt(valor1) * Integer.parseInt(valor2);
	    	break;
	    	case "÷": resultado = Integer.parseInt(valor1) / Integer.parseInt(valor2);
	    	break;
	    }
	    System.out.println("Resultado: " + resultado);
	    driver.findElement(By.name("resposta")).clear();
	    driver.findElement(By.name("resposta")).sendKeys(String.valueOf(resultado)); //converte variavel int resultado para string para o método sendKeys do selenium funcionar
	    driver.findElement(By.name("envia")).click();
	    assertEquals("Você acertou!!!", driver.findElement(By.xpath("//p[2]/font/b")).getText()); //valida que a mensagem final é exibida de acordo com o esperado	
				
	} //CT005
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
} //testSuite
