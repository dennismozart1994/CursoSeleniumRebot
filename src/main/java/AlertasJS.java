import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertasJS {
	
	private WebDriver driver;
	
	@Before
	public void inicializa()
	{
		driver = Drivers.CreateDriver("Chrome");	
	}
	
	@After
	public void fecha()
	{
		driver.quit();
	}
	
	// Alerta Js com botão OK
	@Test
	public void AlertSimples()
	{
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		// Clica no botao
		driver.findElement(By.id("alert")).click();

		// Altera foco para o alerta JS da página
		Alert alert = driver.switchTo().alert();
		
		Assert.assertEquals("Alert Simples", alert.getText());
		
		// clica no botão OK
		alert.accept();
	}
	
	// Alerta Js de confirmação
	@Test
	public void AlertConfirm()
	{
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		// Cenário de negar alerta
		// Clica no botao
		driver.findElement(By.id("confirm")).click();
		// Altera foco para o alerta JS da página
		Alert alerta = driver.switchTo().alert();
		Assert.assertEquals("Confirm Simples", alerta.getText());
		// clica no botão Cancel
		alerta.dismiss();
		Assert.assertEquals("Negado", alerta.getText());
		// clica no botão Confirm
		alerta.accept();
		
		// Cenário de confirmar alerta
		driver.findElement(By.id("confirm")).click();
		// Altera foco para o alerta JS da página
		alerta = driver.switchTo().alert();
		Assert.assertEquals("Confirm Simples", alerta.getText());
		// clica no botão Cancel
		alerta.accept();
		Assert.assertEquals("Confirmado", alerta.getText());
		// clica no botão Confirm
		alerta.accept();
	}
	
	// Alerta Js de confirmação
		@Test
		public void PromptAlert()
		{
			driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
			
			// Cenário de negar alerta
			// Clica no botao
			driver.findElement(By.id("prompt")).click();
			// Altera foco para o alerta JS da página
			Alert alerta = driver.switchTo().alert();
			Assert.assertEquals("Digite um numero", alerta.getText());
			// preenche campo do alerta JS
			alerta.sendKeys("12");
			// Envia campo
			alerta.accept();
			// Verifica Resultado
			Assert.assertEquals("Era 12?", alerta.getText());
			alerta.accept();
			Assert.assertEquals(":D", alerta.getText());
			alerta.accept();
		}
}
