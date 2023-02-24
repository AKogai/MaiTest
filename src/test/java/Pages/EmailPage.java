package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import services.Message;

import java.time.Duration;

public class EmailPage extends BasePage {

    @FindBy(xpath = "//*[contains(@data-testid, 'composer:send-button')]")
    private WebElement send_button;
    @FindBy(xpath = "//*[contains(@data-testid, 'composer:subject')]")
    private WebElement subject_field;

    @FindBy(xpath = "//*[contains(@data-testid, 'composer:address')]")
    private WebElement address_button;
    @FindBy(xpath = "//input[contains(@data-testid, 'composer:to')]")
    private WebElement address;

    @FindBy(xpath = "//*[contains(@id, 'rooster-editor')]/div[1]")
    private WebElement body_field;
    public EmailPage(WebDriver driver) {
        super(driver);
    }

    private void fillForm(Message message){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@data-testid, 'composer:subject')]")));
        subject_field.sendKeys(message.getSubject());
        address_button.click();
        address.sendKeys(message.getAddress());
    }

    public void SendEmail(Message message){
        fillForm(message);
        ClickButton(send_button);
    }

}
