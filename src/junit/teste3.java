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
public class teste3 {

	public static void main(String[] args) throws InterruptedException, BiffException, IOException {

		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.google.com.br/");

		driver.manage().deleteAllCookies();

		Workbook workbook =  
				Workbook.getWorkbook(new File("C:\\Selenium\\Dados\\dados.xls"));

		Sheet sheet = workbook.getSheet(0);

		int rowCount = sheet.getRows();
		System.out.println("Existem " + rowCount + " linhas com dados na " + sheet.getName()
				+ " porém a primeira linha é o cabeçalho.");

		int comece_ler_nesta_linha = 1;

		for (int i = comece_ler_nesta_linha; i < rowCount; i++) {

			String textocelula = sheet.getCell(0, i).getContents();

			driver.findElement(By.name("q")).sendKeys(textocelula);

			WebElement botaoPesquisar = driver.findElement(By.name("btnK"));

			// Este IF esta aqui porque o botão pesquisar muda de nome após a primeira
			// pesquisa
			if (botaoPesquisar.isDisplayed()) {

				driver.findElement(By.name("btnK")).click();
			} else {
				driver.findElement(By.name("btnG")).click();
			}

			driver.findElement(By.name("q")).clear();

			Thread.sleep(2000);
		}

		workbook.close();

		driver.quit();

	}

}
