import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.KeyInput;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Exercise2 {
    private static WebDriver driver;

    @BeforeClass
    public static void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Denis.Kozyra\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://dgotlieb.github.io/Actions/");
    }

    @Test
    public void elementScreenshotTest() {
        takeElementScreenshot(driver.findElement(By.id("div1")));
    }
    
    
    @Test
    public void drugAndDrop(){
        WebElement dragelement = driver.findElement(By.id("drag1"));
        WebElement destination = driver.findElement(By.id("div1"));
        Actions dnd = new Actions(driver);
        dnd.dragAndDrop(dragelement,destination).build().perform();
    }

    @Test
    public void doubleClick(){
        WebElement doubleElement = driver.findElement(By.xpath("/html/body/p[2]"));
        Actions doubleAction = new Actions(driver);
        doubleAction.doubleClick(doubleElement);
        doubleAction.perform();
        String excpected = "You double clicked";
        String actual = driver.findElement(By.id("demo")).getText();
        Assert.assertEquals(actual,excpected);
    }

    @Test
    public void mouseHover(){
        Actions hover = new Actions(driver);
        WebElement element = driver.findElement(By.id("close"));
        hover.moveToElement(element).perform();
    }

    @Test
    public void shiftItems(){
        Select box = new Select(driver.findElement(By.name("food")));
        box.selectByValue("pizza");
        box.selectByValue("burger");
    }

    @Test
    public void uploadFile(){
        driver.findElement(By.name("pic")).sendKeys("C:\\Users\\Denis.Kozyra\\OneDrive - xcircular.com\\Desktop\\125.jpg");
    }

    @Test
    public void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement Element = driver.findElement(By.id("clickMe"));
      //js.executeScript("arguments[0].scrollIntoView();", Element); //by element
        //js.executeScript("window.scrollBy(0,1000)", ""); //by location
    }



    private static void takeElementScreenshot(WebElement element){
        File screenShotFile = element.getScreenshotAs(OutputType.FILE); // take the screenshot
        try {
            FileUtils.copyFile(screenShotFile, new File("element-screenshot"+ timestamp()+ ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }
}
