package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SendPage extends EmailList{
    @FindBy(id="letter")
    WebElement sended_letter;

    public SendPage(WebDriver driver) {
        super(driver);
    }
}
