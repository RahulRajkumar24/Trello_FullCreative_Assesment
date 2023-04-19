import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

public class CommonBaseTest {
    public static WebDriver driver;
    String baseUrl = "https://trello.com/login";

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        driver.get(baseUrl);
    }


    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}