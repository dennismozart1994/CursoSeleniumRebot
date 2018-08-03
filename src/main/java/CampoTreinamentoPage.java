import org.openqa.selenium.WebDriver;

public class CampoTreinamentoPage {
	
	private DSL dsl;
	
	public CampoTreinamentoPage(WebDriver driver) {
		dsl = new DSL(driver);
	}
	
	public void SetName(String Name)
	{
		dsl.InsereEmTextField("elementosForm:nome", Name);
	}
	
	public void SetSurname(String Surname)
	{
		dsl.InsereEmTextField("elementosForm:sobrenome", Surname);
	}
	
	public void clickSexo()
	{
		dsl.Click("elementosForm:sexo:0");
	}
	
	public void clickComida()
	{
		dsl.Click("elementosForm:comidaFavorita:2");
	}
	
	public void SelectEscolaridade(String escolaridade)
	{
		dsl.Select("elementosForm:escolaridade", escolaridade);
	}
	
	public void SelectSport(String Sport)
	{
		dsl.Select("elementosForm:esportes", Sport);
	}
	
	public void TypeSugestions(String sugestions)
	{
		dsl.InsereEmTextField("elementosForm:sugestoes", sugestions);
	}
	
	public void BackLinkClick()
	{
		dsl.ClickLink("Voltar");
	}
	
	public void ClickButton()
	{
		dsl.Click("buttonSimple");
	}
	
	public void CadastrarClick()
	{
		dsl.Click("elementosForm:cadastrar");
	}
	
	public String getResult()
	{
		return dsl.GetText("resultado");
	}
	
	public String getName(Integer type)
	{
		if(type == 0)
		{
			return dsl.GetFieldValue("elementosForm:nome");
		}
		else
		{
			return dsl.GetText("descNome");
		}
	}
	
	public String getSurname(Integer type)
	{
		if(type == 0)
		{
			return dsl.GetFieldValue("elementosForm:sobrenome");
		}
		else
		{
			return dsl.GetText("descSobrenome");
		}
	}
	
	public String getSex()
	{
		return dsl.GetText("descSexo");
	}
	
	public String getFood()
	{
		return dsl.GetText("descComida");
	}
	
	public String getEscolaridade()
	{
		return dsl.GetText("descEscolaridade");
	}
	
	public String getSports()
	{
		return dsl.GetText("descEsportes");
	}
	
	public String getSugestions(Integer type)
	{
		if(type == 0)
		{
			return dsl.GetFieldValue("elementosForm:sugestoes");
		}
		else
		{
			return dsl.GetText("descSugestoes");
		}
	}
	
	public Boolean SexoCheck()
	{
		return dsl.IsCheck("elementosForm:sexo:0");
	}
	
	public Boolean FoodCheck()
	{
		return dsl.IsCheck("elementosForm:comidaFavorita:2");
	}
	
	public String getEscolaridadeValue()
	{
		return dsl.getSelectvalue("elementosForm:escolaridade");
	}
	
	public String getButtonValue()
	{
		return dsl.GetFieldValue("buttonSimple");
	}
	
	
	public void DeveClicarBotaoTabela(String Coluna, String Nome, String Botao, String IdTabela)
	{
		dsl.ClicarBotaoTabela(Coluna, Nome, Botao, IdTabela);
	}
}
