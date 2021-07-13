import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Set;

public class Excercise7 {
    private static WebDriver driver;

   @Test
    public void openTabs() throws AWTException {
       System.setProperty("webdriver.chrome.driver", "C:\\Users\\Denis.Kozyra\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
       driver = new ChromeDriver();
       driver.get("http://google.com");
       driver.manage().window().maximize();
       String parent = driver.getWindowHandle();
       Robot r = new Robot();
       r.keyPress(KeyEvent.VK_CONTROL);
       r.keyPress(KeyEvent.VK_T);

       Set<String> browsers = driver.getWindowHandles();
       for (String i : browsers) {
           if (!i.equals(parent)) {
               driver.switchTo().window(i);
               driver.get("http://www.gmail.com");
           }
       }
       }
   }

