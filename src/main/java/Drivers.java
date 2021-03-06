import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Drivers {
	public static WebDriver CreateDriver(String type)
	{
		WebDriver driver;
		switch(type)
		{
			case "Chrome": 
				// Seta qual navegador o sistema deve abrir
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dennis\\eclipse-workspace\\CursoSeleniumRebot\\drivers\\chromedriver.exe");
				// Cria um webdriver do tipo correto
				driver = new ChromeDriver();
				// maximiza a janela
				driver.manage().window().maximize();
				break;
			case "Firefox":
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\Dennis\\eclipse-workspace\\CursoSeleniumRebot\\drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				break;
			default:
				System.setProperty("webdriver.ie.driver", "C:\\Users\\Dennis\\eclipse-workspace\\CursoSeleniumRebot\\drivers\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				driver.manage().window().maximize();
				break;
		}
		return driver;
	}
}
