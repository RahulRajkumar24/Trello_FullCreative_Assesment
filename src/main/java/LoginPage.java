import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private By loginTextBox = By.xpath("//input[@id='user']");
    private By loginButton = By.xpath("//input[@id='login']");
    private By passwordTextBox =By.xpath("//input[@id='password']");
    private By submitButton = By.xpath("//button[@id='login-submit']");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String Password){
        driver.findElement(loginTextBox).clear();
        driver.findElement(loginTextBox).sendKeys(username);
        driver.findElement(loginButton).click();
        ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        driver.findElement(passwordTextBox).isDisplayed();
        try{
            driver.findElement(passwordTextBox).clear();
        }catch (StaleElementReferenceException e){
            driver.navigate().refresh();
            driver.findElement(passwordTextBox).clear();
        }

        driver.findElement(passwordTextBox).sendKeys(Password);
        driver.findElement(submitButton).click();
        ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
    }


}
