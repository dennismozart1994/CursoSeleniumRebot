import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class CadastroDesafio {
	
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
	
	@Test
	public void Cadastro()
	{
		page.SetName("Dennis");
		Assert.assertEquals("Dennis", page.getName(0));
		
		page.SetSurname("Mozart da Silva");
		Assert.assertEquals("Mozart da Silva", page.getSurname(0));
		
		page.clickSexo();
		Assert.assertTrue(page.SexoCheck());
		
		page.clickComida();
		Assert.assertTrue(page.FoodCheck());

		page.SelectEscolaridade("Doutorado");
		
		Assert.assertEquals("Doutorado", page.getEscolaridadeValue());
		
		
		page.SelectSport("Futebol");
		page.SelectSport("Corrida");
		
		page.TypeSugestions("Nenhuma sugestão!");
		Assert.assertEquals("Nenhuma sugestão!", page.getSugestions(0));
		
		
		page.CadastrarClick();
		
		Assert.assertTrue(page.getResult().contains("Cadastrado!"));
		Assert.assertEquals("Nome: Dennis", page.getName(1));
		Assert.assertEquals("Sobrenome: Mozart da Silva", page.getSurname(1));
		Assert.assertEquals("Sexo: Masculino", page.getSex());
		Assert.assertEquals("Comida: Pizza", page.getFood());
		Assert.assertEquals("Escolaridade: doutorado", page.getEscolaridade());
		Assert.assertEquals("Esportes: Futebol Corrida", page.getSports());
		Assert.assertEquals("Sugestoes: Nenhuma sugestão!", page.getSugestions(1));
	}
}
