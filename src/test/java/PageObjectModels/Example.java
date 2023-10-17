package PageObjectModels;

import Utilities.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Example {
    public Example() {
        PageFactory.initElements(DriverManager.get(), this);
    }

    @FindBy(xpath = "//textarea[@aria-label='Ara']")
    public WebElement searchBox;

    @FindBy(xpath = "(//input[@name='btnK'])[2]")
    public WebElement searchBtn;
}
