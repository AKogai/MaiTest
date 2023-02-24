package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import services.Message;

import java.time.Duration;

public class EmailList extends BasePage{

    @FindBy(xpath = "//*[contains(@data-testid, 'navigation-link:sent')]")
    public WebElement send_button;;
    @FindBy(id="letter")
    WebElement sended_letter;

    @FindBy(xpath = "//*[contains(@data-testid, 'eading:userdropdown')]")
    WebElement settings_button;

    @FindBy(xpath = "//*[contains(@data-testid, 'userdropdown:button:logout')]")
    WebElement logOut_button;
    public EmailList(WebDriver driver) {
        super(driver);
    }


    public void deleteEmail(Message message){

    }

    public SendPage goToSendPage(){
        send_button.click();
        return new SendPage(driver);
    }

    public void logOut(){
        settings_button.click();
        logOut_button.click();
    }

    public boolean waitForEmail(Message message){
        String subject = message.getSubject();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@title, '"+subject+"')]"))).isDisplayed();
    }
}
