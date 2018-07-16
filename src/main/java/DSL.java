import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DSL {
	private WebDriver driver;
	
	public DSL(WebDriver driver) {
		this.driver = driver;
	}
	
	// Executa comando JS
	public Object ExecutaJS(String cmd, Object... param)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript(cmd, param);
	}
	
	// insere valores no campo texto
	public void InsereEmTextField(String field, String Text)
	{
		driver.findElement(By.id(field)).sendKeys(Text);
	}
	
	// retorna conteúdo de campo
	public String GetFieldValue(String field)
	{
		return driver.findElement(By.id(field)).getAttribute("value");
	}
	
	// Marca radio button ou checkbox
	public void checkelement(String Field)
	{
		driver.findElement(By.id(Field)).click();
	}
	
	// checa se radio button ou checkbox está selecionado
	public Boolean IsCheck(String Field)
	{
		return driver.findElement(By.id(Field)).isSelected();
	}
	
	// Seleciona combobox
	public void Select(String Field, String Value)
	{
		// Cria combobox
		WebElement element = driver.findElement(By.id(Field));
		Select combo = new Select(element);
		
		// pelo index do combobox
		//combo.selectByIndex(3); 
		
		// pelo value do html
		//combo.selectByValue("superior"); 
		
		// pelo texto exibido no combo pro usuário
		combo.selectByVisibleText(Value); 
	}
	
	// Retorna valor selecionado em combobox
	public String getSelectvalue(String Field)
	{
		// Cria combobox
		WebElement element = driver.findElement(By.id(Field));
		Select combo = new Select(element);
		// retorna valor selecionado
		return combo.getFirstSelectedOption().getText();
	}
	
	// Retorna quantidade de itens selecionados
	public Integer getAmountofSelections(String Field)
	{
		// Cria combobox
		WebElement element = driver.findElement(By.id(Field));
		Select combo = new Select(element);
		
		// Verifica quantas seleções foram feitas
		List<WebElement> allSellectedOptions = combo.getAllSelectedOptions();
		return allSellectedOptions.size();
	}
	
	// Clica em button
	public void Click(String Field)
	{
		driver.findElement(By.id(Field)).click();
	}
	
	// Click by text
	public void ClickLink(String Field)
	{
		driver.findElement(By.linkText(Field)).click();
	}
	
	public String GetText(String Field)
	{
		return driver.findElement(By.id(Field)).getText();
	}
	
	/*********** Tabela ************/
	public void ClicarBotaoTabela(String ColunaBusca, String valor, String ColunaBotao, String IdTabela)
	{
		// procurar coluna do registro
		WebElement tabela = driver.findElement(By.xpath("//*[@id='"+IdTabela+"']"));
		int idColuna = oberIndiceColuna(ColunaBusca, tabela);
		
		// encontrar linha do registro
		int idLinha = obterIndiceLinha(valor, tabela, idColuna);
		
		// procurar coluna do botao
		int idColunaBotao = oberIndiceColuna(ColunaBotao, tabela);
		
		// clicar no botao da celula encontrada
		WebElement celula = tabela.findElement(By.xpath(".//tr["+idLinha+"]/td["+idColunaBotao+"]"));
		celula.findElement(By.xpath(".//input[@type='button']")).click();
	}

	protected int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
		List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td["+idColuna+"]"));
		int idLinha = -1;
		for(int i=0; i<linhas.size(); i++)
		{
			if(linhas.get(i).getText().equals(valor)) 
			{
				idLinha = i+1;
				break;
			}
		}
		return idLinha;
	}

	protected int oberIndiceColuna(String coluna, WebElement tabela) {
		List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
		int idColuna = -1;
		
		for(int i=0; i<colunas.size(); i++)
		{
			if(colunas.get(i).getText().equals(coluna)) 
			{
				idColuna = i+1;
				break;
			}
		}
		
		return idColuna;
	}
}
