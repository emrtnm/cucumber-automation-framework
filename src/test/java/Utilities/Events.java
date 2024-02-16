package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Events {
    private Events() {
    }

    public static void sendKeys(WebElement element, String text) {
        DriverManager.getWait().until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }

    public static void click(WebElement element) {
        DriverManager.getWait().until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public static void jsClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.get();
        js.executeScript ("arguments[0].click();", element);
    }

    public static void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.get();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public static void verifyContainsText(WebElement element, String value) {
        DriverManager.getWait().until(ExpectedConditions.textToBePresentInElement(element, value));
        Assert.assertTrue(element.getText().toLowerCase().contains(value.toLowerCase()));
    }

    public static Select select(WebElement element) {
        DriverManager.getWait().until(ExpectedConditions.elementToBeClickable(element));
        return new Select(element);
    }

    public static void upload(WebElement element, String filePath) {
        Events.scrollToElement(element);
        Path path = Paths.get(filePath);
        File imagePath = new File(path.toUri());
        Events.sendKeys(element, imagePath.toString());
    }
}