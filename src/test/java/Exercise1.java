import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Exercise1 {

    private static WebDriver driver;

        @BeforeClass
        public static void beforeClass() {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Denis.Kozyra\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.get("https://dgotlieb.github.io/Navigation/Navigation.html");
    }
        @Test
        public void printFrame(){
            driver.switchTo().frame("my-frame");
            System.out.println(driver.findElement(By.id("iframe_container")).getText());

        }


        }
