import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.*;

public class TesteCampotreinamento {
	
	// Text Field
	@Test
	public void InsereEmTextField()
	{
		// Cria driver
		WebDriver driver = Drivers.CreateDriver("Chrome");
		// abre p�gina importada para a pasta sources
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		// insere valores no campo texto
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste de Escrita");
		// Captura valor do campo texto e compara se o valor foi realmente inserido no campo
		Assert.assertEquals("Teste de Escrita", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		driver.quit();
	}
	
	// Text Area
	@Test
	public void InsereEmTextArea()
	{
		// Cria driver
		WebDriver driver = Drivers.CreateDriver("Chrome");
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		// insere valores no campo
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Teste de Escrita");
		// Captura valor do campo e compara se o valor foi realmente inserido no campo
		Assert.assertEquals("Teste de Escrita", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
		driver.quit();
	}
	
	// Radio Button
		@Test
		public void MarcaRadioButton()
		{
			// Cria driver
			WebDriver driver = Drivers.CreateDriver("Chrome");
			driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
			// Marca radio button
			driver.findElement(By.id("elementosForm:sexo:0")).click();
			// Verifica se o campo est� selecionado
			Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());;
			driver.quit();
		}
		
		// Check Box
		@Test
		public void MarcaCheckBox()
		{
			// Cria driver
			WebDriver driver = Drivers.CreateDriver("Chrome");
			driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
			// Marca Check box
			driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
			// Verifica se o campo est� marcado
			Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());;
			driver.quit();
		}
		
		// Combo Box
		@Test
		public void SelecionaComboBox()
		{
			// Cria driver
			WebDriver driver = Drivers.CreateDriver("Chrome");
			driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
			// Marca Combo Box
			WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
			Select combo = new Select(element);
			//combo.selectByIndex(3); // pelo index do combobox
			//combo.selectByValue("superior"); // pelo value do html
			combo.selectByVisibleText("2o grau completo"); // pelo texto exibido no combo pro usu�rio
			// Verifica se a sele��o foi feita
			Assert.assertEquals("2o grau completo", combo.getFirstSelectedOption().getText());
			driver.quit();
		}
		
		// Combo Box de multipla escolhas
		@Test
		public void SelecionaMultiploComboBox()
		{
			// Cria driver
			WebDriver driver = Drivers.CreateDriver("Chrome");
			driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
			// Seleciona v�rias op��es
			WebElement element = driver.findElement(By.id("elementosForm:esportes"));
			Select combo = new Select(element);
			combo.selectByVisibleText("Natacao");
			combo.selectByVisibleText("Corrida");
			combo.selectByVisibleText("O que eh esporte?");
			// Verifica se a sele��o foi feita
			List<WebElement> allSellectedOptions = combo.getAllSelectedOptions();
			Assert.assertEquals(3, allSellectedOptions.size());
			driver.quit();
		}
		
		// Clicar em bot�o
		@Test
		public void ClicaEmBot�o()
		{
			// Cria driver
			WebDriver driver = Drivers.CreateDriver("Chrome");
			driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
			// Clica no bot�o
			driver.findElement(By.id("buttonSimple")).click();
			Assert.assertEquals("Obrigado!", driver.findElement(By.id("buttonSimple")).getAttribute("value"));
			driver.quit();
		}
		
		// Clicar em link
		@Test
		public void ClicaEmLink()
		{
			// Cria driver
			WebDriver driver = Drivers.CreateDriver("Chrome");
			driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
			// clica no link
			driver.findElement(By.linkText("Voltar")).click();
			// Checa se clicou no link
			Assert.assertEquals("Voltou!", driver.findElement(By.id("resultado")).getText());
			driver.quit();
		}
}
