import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class BoardPage {
    private WebDriver driver;
    private By addListLabel =By.xpath("//div[@id='board']//form/a");
    private By listNameTextBox = By.xpath("//input[@class='list-name-input']");
    private By addListButton = By.xpath("//input[@value='Add list']");
    private By addCardListA = By.xpath("//div[@id='board']/div[1]/div[1]/div[3]/a[1]");
    private By cardTitleTextbox = By.xpath("//textarea[@placeholder='Enter a title for this card…']");
    private By addCardButton = By.xpath("//input[@value='Add card']");
    private By profileIcon = By.xpath("//span[@title='Rahul B (rahulrajkumarb24)']");
    private By logout = By.xpath("//span[contains(text(),'Log out')]");
    private By deleteMenu = By.xpath("//body/div[@id='trello-root']/div[@id='chrome-container']/div[1]/div[1]/main[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[2]/a[1]");
    private By deleteList = By.xpath("//a[contains(text(),'Archive this list')]");

    public BoardPage(WebDriver driver) {
        this.driver = driver;
    }

    public void createList(){
//        for(int i = 1;i<=3;i++){
//        if(driver.findElement(deleteMenu).isDisplayed()){
//            driver.findElement(deleteMenu).click();
//            driver.findElement(deleteList).click();
//        }
//        }
        driver.findElement(addListLabel).isDisplayed();
        driver.findElement(addListLabel).click();
        driver.findElement(listNameTextBox).clear();
        driver.findElement(listNameTextBox).sendKeys("List A");
        driver.findElement(addListButton).click();
        driver.findElement(listNameTextBox).sendKeys("List B");
        driver.findElement(addListButton).click();
    }

    public void addCard(){
        driver.findElement(addCardListA).isDisplayed();
        driver.findElement(addCardListA).click();
        driver.findElement(cardTitleTextbox).sendKeys("Card in List A");
        driver.findElement(addCardButton).click();
    }

    public void moveCard(){
        WebElement cardA = driver.findElement(By.xpath("//span[@class='list-card-title js-card-name']"));
        WebElement ListBboard = driver.findElement(By.xpath("//body/div[@id='trello-root']/div[@id='chrome-container']/div[1]/div[1]/main[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[3]/div[3]/div[2]/div[1]/div[3]"));
        Actions a=new Actions(driver);
        a.dragAndDrop(cardA, ListBboard).perform();

        WebElement element = driver.findElement(By.xpath("//body/div[@id='trello-root']/div[@id='chrome-container']/div[1]/div[1]/main[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[3]/div[3]/div[2]/div[1]/div[2]/a[1]/div[3]/span[1]"));
        //Used points class to get x and y coordinates of element.
        Point point = element.getLocation();
        int xcord = point.getX();
        System.out.println("Position of the webelement from left side is "+xcord +" pixels");
        int ycord = point.getY();
        System.out.println("Position of the webelement from top side is "+ycord +" pixels");
    }

    public void logout(){
        driver.findElement(profileIcon).click();
        driver.findElement(logout).click();
        ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
    }


}
