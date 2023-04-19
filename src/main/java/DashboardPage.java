import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    private WebDriver driver;
    private By createButton = By.xpath("//p[contains(text(),'Create')]");
    private By createBoardDiv = By.xpath("//button[@data-testid='header-create-board-button']");
    private By boardTitleTextbox = By.xpath("//input[@data-testid=\"create-board-title-input\"]");
    private By createBoardButton = By.xpath("//button[contains(text(),'Create')]");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public void createBoard(String boardName){
        driver.findElement(createButton).isDisplayed();
        driver.findElement(createButton).click();
        driver.findElement(createBoardDiv).isDisplayed();
        driver.findElement(createBoardDiv).click();
        driver.findElement(boardTitleTextbox).clear();
        driver.findElement(boardTitleTextbox).sendKeys(boardName);
        driver.findElement(createBoardButton).click();
        ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");

    }

}
