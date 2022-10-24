package testeeplayers;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testesenaieplayers {
	private WebDriver driver;
	
    @Before
	public void abrirNavegador() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Chrome Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
    }
    
	@Test
	public void testeNavegador(){
		driver.get("http://localhost:4200");
		driver.findElement(By.xpath("//*[@id=\"navMenu\"]/a[5]")).click();
		
		// CRIAR ELEMENTOS
		
		WebElement inputEmail = driver.findElement(By.id("email"));
		WebElement inputSenha = driver.findElement(By.id("senha"));
		WebElement inputSubmit = driver.findElement(By.id("signin"));
		String[] listaEmails = {"fabioguzzi@music.com", "elaine@music.com", "alison@music.com", "alex@music.com", "emailsemformato"};
		String[] listaSenhas = {"123456", "123", "12345678", "54321", "iiii"};
		
		for(int tentativas = 0; tentativas < listaSenhas.length; tentativas++) {
			try {
				// LIMPAR O CAMPO
				inputEmail.clear();
				inputSenha.clear();
				
				//PREENCHER CAMPOS
				inputEmail.sendKeys(listaEmails[tentativas]);
				inputSenha.sendKeys(listaSenhas[tentativas]);
				inputSubmit.click();
				
				Thread.sleep(4000);   // 4 SEGUNDOS
				
			}catch(InterruptedException error) {
				error.getStackTrace();
			}
			
		}
		
}
	@After
	public void finalizarTeste() {
		try {
			Thread.sleep(4000);
			driver.quit();
		}catch(Exception error){
			error.getStackTrace();
		}
	}
}
