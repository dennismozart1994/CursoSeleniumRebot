import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class TesteGoogle {
	
	@Test
	public void teste() {
		
		WebDriver driver = Drivers.CreateDriver("Chrome");
		// Acessa a página
		driver.get("https://www.google.com.br");
		Assert.assertEquals("Google", driver.getTitle());
		driver.quit();
	}
}
