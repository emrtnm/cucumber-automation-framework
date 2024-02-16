package stepdefinitions;

import utilities.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    @Before
    public void init() {
        DriverManager.get().navigate().to("https://www.google.com");
    }

    @After
    public void quit(Scenario scenario) {
        if (scenario.isFailed()){
            TakesScreenshot ts = ((TakesScreenshot) DriverManager.get());
            byte[] tmpImg = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(tmpImg, "image/png", scenario.getName());
        }

        DriverManager.quit();
    }
}
