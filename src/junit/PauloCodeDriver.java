package junit;

import java.io.File;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PauloCodeDriver {

	public static void main(String[] args) throws InterruptedException, BiffException, IOException {
		
	  	System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
	  	WebDriver driver = new ChromeDriver();
	  	
	  //Maximizo a janela do Browser
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com.br/");
		
		//Deleto todos os cookies da pagina para n�o ter interfer�ncia nos testes
		driver.manage().deleteAllCookies();

		
		//Dados da planilha com a biblioteca JXL
		
		Workbook workbook = Workbook.getWorkbook(new File("C:\\Selenium\\Dados\\dados.xls"));
		
		//Em qual sheet come�ara a ler a planilha
		Sheet sheet = workbook.getSheet(0);  
		
		//Conte o n�mero de linhas
		int rowCount = sheet.getRows();
		System.out.println("Existem " + rowCount + " linhas com dados na " + sheet.getName() + " por�m a primeira linha � o cabe�alho.");

		
		//indica em qual linha deve come�ar a ler os dados
		int comece_ler_nesta_linha = 1;
		
		//comece o loop
		for(int i =  comece_ler_nesta_linha; i < rowCount; i++){
			
		    String textocelula = sheet.getCell(0, i).getContents();
	    
		    //Pegue o texto da planilha e digite na caixa de texto
		    driver.findElement(By.name("q")).sendKeys(textocelula);
		    
		    WebElement botaoPesquisar = driver.findElement(By.name("btnK"));
		    
		    
		    
		    //Este IF esta aqui porque o bot�o pesquisar muda de nome ap�s a primeira pesquisa		    
		    if (botaoPesquisar.isDisplayed() )
		    {
		    //Clique no bot�o pesquisar
		    driver.findElement(By.name("btnK")).click();
		    }
		    else
		    {
			    driver.findElement(By.name("btnG")).click();
		    }
		    
		    //Limpe a caixa de texto, para a pr�xima pesquisa
		    driver.findElement(By.name("q")).clear();	    
		    
		 	    
			Thread.sleep(2000);
		}
		
		//Fecha a planilha
		workbook.close();
		
		//Encerra o driver
		driver.quit();

	}

}
