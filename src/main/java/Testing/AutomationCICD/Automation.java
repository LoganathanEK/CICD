package Testing.AutomationCICD;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class Automation {
	ExtentReports extent;
 	@BeforeTest
    public void config() {
        String path = System.getProperty("user.dir") + "\\reports\\index.html";
        ExtentSparkReporter report = new ExtentSparkReporter(path);
        report.config().setDocumentTitle("Logesh Test Result");
        report.config().setReportName("Logesh Web Automation");
        
        extent = new ExtentReports();
        extent.attachReporter(report);
        extent.setSystemInfo("Tester", "Logesh");
    }

    @Test
     
    public void simplerun() {
    	ExtentTest test = extent.createTest("Simple Run");
    	ChromeOptions options = new ChromeOptions();
//    	options.addArguments("headless");
//        System.setProperty("webdriver.chrome.driver", "C:\\Logesh\\Automation\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://rahulshettyacademy.com");
        System.out.println(driver.getTitle());
        driver.findElement(By.xpath("/html/body/div/header/div[2]/div/div/div[2]/div[2]/a")).click();
        test.fail("Result does not match");
//        driver.close();
        extent.flush();
    }
    

}
