package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DriverManager {
    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    public static ThreadLocal<String> threadBrowserName = new ThreadLocal<>();
    private static WebDriverWait wait;

    public static WebDriver get() {
        Locale.setDefault(new Locale("EN"));
        System.setProperty("user.language", "EN");

        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);

        if (threadBrowserName.get() == null) {
            threadBrowserName.set("chrome");
        }

        if (threadDriver.get() == null) {
            switch (threadBrowserName.get()){
                case "firefox": threadDriver.set(new FirefoxDriver()); break;
                case "safari":  threadDriver.set(new SafariDriver());  break;
                case "edge":    threadDriver.set(new EdgeDriver());    break;
                default :       threadDriver.set(new ChromeDriver());
            }
        }

        threadDriver.get().manage().window().maximize();
        threadDriver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        threadDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        return threadDriver.get();
    }

    public static WebDriverWait getWait() {
        if (wait == null) {
            wait = new WebDriverWait(threadDriver.get(), Duration.ofSeconds(20));
        }

        return wait;
    }

    public static void quit() {
        if (threadDriver.get() != null) {
            threadDriver.get().quit();
            threadDriver = null;
            wait = null;
        }
    }
}
