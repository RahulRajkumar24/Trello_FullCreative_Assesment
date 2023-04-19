import org.testng.annotations.Test;

public class trelloTest extends CommonBaseTest{
    LoginPage loginPage;
    DashboardPage dashboardPage;
    BoardPage boardPage;

    @Test
    public void testTrello(){
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        boardPage = new BoardPage(driver);

        loginPage.login("rahulrajkumarb24@gmail.com","Saibaba@24");
        dashboardPage.createBoard("Test_Trello_Board");
        boardPage.createList();
        boardPage.addCard();
        boardPage.moveCard();
        boardPage.logout();
    }
}
