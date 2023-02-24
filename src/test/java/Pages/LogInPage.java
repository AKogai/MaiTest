package Pages;

import org.example.ConfProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.FindBy;
import services.User;

import java.time.Duration;


public class LogInPage extends BasePage{

    @FindBy(xpath = "//*[contains(@id, 'username')]")
    WebElement user_element;
    @FindBy(id="password")
    WebElement password_element;
    public LogInPage(WebDriver driver) {
        super(driver);
    }

    private void inputUserName(String UserName) {
        user_element.sendKeys(UserName);
    }

    private void inputPasswd(String Password) {
        password_element.sendKeys(Password);
    }
    private void submit() {
        password_element.submit();
    }
    public InBoxPage Login(User user){
        driver.get(ConfProperties.getProperty("loginPage"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@id, 'username')]")));

        inputUserName(user.getUserName());
        inputPasswd(user.getPassword());
        submit();



        return new InBoxPage(driver);
    }
}
