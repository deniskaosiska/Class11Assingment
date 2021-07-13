import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Exercise4 {
    private static WebDriver driver;
    private static ExtentReports extent;
    private static ExtentTest test;


    @BeforeTest

    public  void beforeClass() throws Exception {
        String cwd = System.getProperty("user.dir");
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(cwd + "\\extent.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        test = extent.createTest("Excercise4", "Class11 Assignment");
        test.log(Status.INFO, "Start test");
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Denis.Kozyra\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.get("https://translate.google.com/");
            driver.manage().window().maximize();
            test.log(Status.PASS, "Browser opened ");
            test.pass("ScreenShot", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(driver, "homePage")).build());
        } catch (Exception e){
            e.printStackTrace();
            test.log(Status.FAIL, "Driver failed "+ e.getMessage());
            throw new Exception("Driver failed");
        }
    }

    @Test
    public void homePageScreenShot() throws Exception {
        test.log(Status.INFO, "Test screenshot of home page");
        try{
            driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div[1]/div[2]/div[2]/c-wiz[1]/span/span/div/textarea")).sendKeys("xCircular");
            extent. setSystemInfo("Company","xCircular");
        } catch (Exception e){
            e.printStackTrace();
            test.log(Status.FAIL, "Test failed "+ e.getMessage());
            throw new Exception("Test failed");
        }
    }


    @AfterClass
    public static void afterClass() {
        test.log(Status.INFO, "Test over");
        extent.flush();
    }




    private static String takeScreenShot(WebDriver driver, String ImagesPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath + ".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return ImagesPath + ".png";
    }



}
