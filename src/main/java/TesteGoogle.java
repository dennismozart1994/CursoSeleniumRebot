import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class TesteGoogle {
	
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
	
	@Test
	public void teste() {
		// Acessa a página
		driver.get("https://www.google.com.br");
		Assert.assertEquals("Google", driver.getTitle());
	}
}
