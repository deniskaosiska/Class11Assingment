import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Exercise6 {
    private static WebDriver driver;

    @BeforeTest

    public void onceBefore() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Denis.Kozyra\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://dgotlieb.github.io/Navigation/Navigation.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void showAlert() {
        driver.findElement(By.cssSelector("input[type='button']")).click();
        System.out.println(driver.switchTo().alert().getText());
    }

    @Test
    public void showPrompt() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"MyPrompt\"]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
        Alert promptAlert  = driver.switchTo().alert();
        promptAlert.sendKeys("Denis");
       // String typedName = driver.switchTo().alert().getText();
        String name = "Denis";
       // Assert.assertEquals(typedName, name);

    }

    @Test
    public void showBox(){

        driver.findElement(By.xpath("//*[@id=\"MyConfirm\"]")).click();
        driver.switchTo().alert().dismiss();
        String actual =driver.findElement(By.id("output")).getText();
        String excepted = "canceled";
        Assert.assertEquals(actual,excepted);
    }

    @Test
    public void openNewTab(){

        driver.findElement(By.xpath("//*[@id=\"openNewTab\"]")).click();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        //driver.close();
        driver.switchTo().window(tabs.get(0));
    }

    @Test
    public void openNewWindow(){
        driver.findElement(By.xpath("//*[@id=\"contact_info_left\"]/a")).click();
        String handle= driver.getWindowHandle();
        driver.switchTo().window(handle);
    }


}
