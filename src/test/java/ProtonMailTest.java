import Pages.EmailPage;
import Pages.InBoxPage;
import Pages.LogInPage;
import Pages.SendPage;
import org.example.ConfProperties;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import services.Message;
import services.User;


public class ProtonMailTest {

    private ChromeDriver driver;
    private LogInPage loginPage;
    private Message message;
    private User receptionist;
    private User sender;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        loginPage = new LogInPage(driver);
        sender = new User(
                ConfProperties.getProperty("sender_name"),
                ConfProperties.getProperty("sender_password"));
        receptionist = new User(
                ConfProperties.getProperty("receptionist_name"),
                ConfProperties.getProperty("receptionist_password"));
        message = new Message(sender, receptionist);
    }

    @Test
    public void sendAndVerifyEmail() {
        InBoxPage inboxPage = loginPage.Login(sender);
        EmailPage emailPage = inboxPage.compose();
        emailPage.SendEmail(message);
        SendPage sendPage = inboxPage.goToSendPage();
        if (sendPage.waitForEmail(message)){
            sendPage.deleteEmail(message);
        };

        sendPage.logOut();

        loginPage.Login(receptionist);

        inboxPage.waitForEmail(message);
        Assert.assertTrue(inboxPage.waitForEmail(message));

        inboxPage.deleteEmail(message);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
