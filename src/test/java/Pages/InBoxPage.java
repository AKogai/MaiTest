package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;



public class InBoxPage extends EmailList {

    @FindBy(xpath = "//*[contains(@data-testid, 'sidebar:compose')]")
    WebElement compose_button;
    @FindBy(id="send")
    WebElement send_button;

    public InBoxPage(WebDriver driver) {
        super(driver);
    }

    public EmailPage compose(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@data-testid, 'sidebar:compose')]")));
        compose_button.click();
        return new EmailPage(driver);
    };
}
