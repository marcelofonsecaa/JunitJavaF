package junit;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.apache.commons

public class webd {

	public static void main(String[] args) throws InterruptedException, BiffException, IOException {
		
	  	System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
	  	WebDriver driver = new ChromeDriver();
	  	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		Workbook workbook = Workbook.getWorkbook(new File("C:\\Selenium\\Dados\\dados.xls"));
		Sheet sheet = workbook.getSheet(0);  
		
		driver.get("http://www.juliodelima.com.br/taskit/");
		
	
	
		driver.findElement(By.xpath("/html/body/nav/div/div/ul[1]/li/a")).click();
		
		WebElement modal = driver.findElement(By.id("signinbox"));
		
		
		String log = sheet.getCell(0, 0).getContents();
		modal.findElement(By.name("login")).sendKeys(log);
		
		String pass = sheet.getCell(0, 1).getContents();
		modal.findElement(By.name("password")).sendKeys(pass);
		
		modal.findElement(By.linkText("SIGN IN")).click();
		
		      
			Thread.sleep(2000);
			
			driver.findElement(By.className("me")).click();
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[3]/a")).click();
			
			driver.findElement(By.xpath("//*[@id=\"moredata\"]/div[2]/button")).click();
			
			String dados = sheet.getCell(0, 1).getContents();
			driver.findElement(By.name("contact")).sendKeys(dados);
		
			
			WebElement pagina2 = driver.findElement(By.id("addmoredata"));
			pagina2.findElement(By.linkText("SAVE")).click();
			
			Thread.sleep(6000);
			
			driver.findElement(By.xpath("//span[text()='11 4789-1215']/following-sibling::a")).click();
			
			Alert alert = driver.switchTo().alert();
		
			alert.accept();
			
			File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			FileUtils.copyFile(screenshotFile, new File("C://Selenium//Dados//screenshotFile.png"));
			
	
			driver.quit();	    
		
	}

}
