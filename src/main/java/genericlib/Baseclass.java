package genericlib;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class Baseclass {
       public WebDriver driver;
       public Webdriverutilities utilities=new Webdriverutilities();
       public Propertyfile propertyfile=new Propertyfile();
       @BeforeMethod
       public void app() throws FileNotFoundException, IOException {
    	   ChromeDriverManager.chromedriver().setup();
    	     driver=new ChromeDriver();
    	     driver.manage().window().maximize();
    	     driver.get(propertyfile.getpropertyfile("url"));
    	     driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    	    
       }
       
       @AfterMethod
       public void closeapp(ITestResult r) throws IOException
       {
    	   int status = r.getStatus();
    	    String name = r.getName();
    	    if(status==2)
    	    {
    	   Screenshot s=new Screenshot();
    	   s.getscreenshot(driver,name);
    	    }
    	   driver.close();
       }
       
}
