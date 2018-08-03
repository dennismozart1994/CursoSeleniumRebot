import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TesteCampotreinamento {
	
	private WebDriver driver;
	private CampoTreinamentoPage page;
	
	@Before
	public void inicializa()
	{
		driver = Drivers.CreateDriver("Chrome");
		// abre página importada para a pasta sources
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		page = new CampoTreinamentoPage(driver);
	}
	
	@After
	public void fecha()
	{
		driver.quit();
	}
	
	// Text Field
	@Test
	public void InsereEmTextField()
	{
		page.SetName("Teste de Escrita");
		Assert.assertEquals("Teste de Escrita", page.getName(0));
	}
	
	// Text Area
	@Test
	public void InsereEmTextArea()
	{
		page.TypeSugestions("Teste de Escrita");
		// Captura valor do campo e compara se o valor foi realmente inserido no campo
		Assert.assertEquals("Teste de Escrita", page.getSugestions(0));
	}
	
	// Radio Button
		@Test
		public void MarcaRadioButton()
		{
			page.clickSexo();
			// Verifica se o campo está selecionado
			Assert.assertTrue(page.SexoCheck());
		}
		
		// Check Box
		@Test
		public void MarcaCheckBox()
		{
			page.clickComida();
			// Verifica se o campo está marcado
			Assert.assertTrue(page.FoodCheck());
		}
		
		// Combo Box
		@Test
		public void SelecionaComboBox()
		{
			// Marca Combo Box
			page.SelectEscolaridade("2o grau completo");
			// Verifica se a seleção foi feita
			Assert.assertEquals("2o grau completo", page.getEscolaridadeValue());
		}
		
		// Combo Box de multipla escolhas
		@Test
		public void SelecionaMultiploComboBox()
		{
			// Seleciona várias opções
			page.SelectSport("Natacao");
			page.SelectSport("Corrida");
			page.SelectSport("O que eh esporte?");
			
			// Cria combobox
			WebElement element = driver.findElement(By.id("elementosForm:esportes"));
			Select combo = new Select(element);
			
			// Verifica quantas seleções foram feitas
			List<WebElement> allSellectedOptions = combo.getAllSelectedOptions();			
			Assert.assertEquals(3, allSellectedOptions.size());
		}
		
		// Clicar em botão
		@Test
		public void ClicaEmBotão()
		{
			// Clica no botão
			page.ClickButton();
			Assert.assertEquals("Obrigado!", page.getButtonValue());
		}
		
		// Clicar em link
		@Test
		public void ClicaEmLink()
		{
			// clica no link
			page.BackLinkClick();
			
			// Checa se clicou no link
			Assert.assertEquals("Voltou!", page.getResult());
		}
		
		@Test
		public void DeveClicarBotaoTabela()
		{
			page.DeveClicarBotaoTabela("Nome", "Maria", "Botao", "elementosForm:tableUsuarios");
		}
}
