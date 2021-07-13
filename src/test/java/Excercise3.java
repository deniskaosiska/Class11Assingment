import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class Excercise3 {
    private static WebDriver driver;

    @Test

    public void beforeTest(){
        getDriverInstance();

    }






    public static WebDriver getDriverInstance() {

            try {
                String URL = getData("URL");
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\Denis.Kozyra\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
                driver = new ChromeDriver();
                driver.get(URL);
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return driver;
        }




    //Getting info from data.xml by tag
    private static String getData(String keyName) throws Exception {
        ClassLoader classLoader = Excercise3.class.getClassLoader();
        String xmlFilePath = String.valueOf(new File(classLoader.getResource("data.xml").getFile()));
        File fXmlFile = new File(xmlFilePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(keyName).item(0).getTextContent();
    }
}