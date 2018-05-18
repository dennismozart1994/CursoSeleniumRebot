import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CadastroDesafio {
	@Test
	public void Cadastro()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\INMETRICS\\Downloads\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Dennis");
		Assert.assertEquals("Dennis", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Mozart da Silva");
		Assert.assertEquals("Mozart da Silva", driver.findElement(By.id("elementosForm:sobrenome")).getAttribute("value"));
		
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
		
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
		
		WebElement escolaridadeEl = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(escolaridadeEl);
		combo.selectByVisibleText("Doutorado");
		Assert.assertEquals("Doutorado", combo.getFirstSelectedOption().getText());
		
		WebElement esportesEl = driver.findElement(By.id("elementosForm:esportes"));
		Select esportes = new Select(esportesEl);
		esportes.selectByVisibleText("Futebol");
		esportes.selectByVisibleText("Corrida");
		List<WebElement> esportesSelecionados = esportes.getAllSelectedOptions();
		Assert.assertEquals(2, esportesSelecionados.size());
		
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Nenhuma sugest�o!");
		Assert.assertEquals("Nenhuma sugest�o!", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
		
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		
		Assert.assertTrue(driver.findElement(By.id("resultado")).getText().contains("Cadastrado!"));
		Assert.assertEquals("Nome: Dennis", driver.findElement(By.id("descNome")).getText());
		Assert.assertEquals("Sobrenome: Mozart da Silva", driver.findElement(By.id("descSobrenome")).getText());
		Assert.assertEquals("Sexo: Masculino", driver.findElement(By.id("descSexo")).getText());
		Assert.assertEquals("Comida: Pizza", driver.findElement(By.id("descComida")).getText());
		Assert.assertEquals("Escolaridade: doutorado", driver.findElement(By.id("descEscolaridade")).getText());
		Assert.assertEquals("Esportes: Futebol Corrida", driver.findElement(By.id("descEsportes")).getText());
		Assert.assertEquals("Sugestoes: Nenhuma sugest�o!", driver.findElement(By.id("descSugestoes")).getText());
	
		driver.quit();
	}
}