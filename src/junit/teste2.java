package junit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class teste2 {


    public static void main(String[] args) {
      
    	System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	
        String baseUrl = "http://demo.guru99.com/test/newtours/";
        String expectedTitle = "123";
        String actualTitle = "";

        driver.get(baseUrl);

        actualTitle = driver.getTitle();

 
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
       
        driver.close();
    }

}