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
}
