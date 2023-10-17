package Runners;

import com.aventstack.extentreports.service.ExtentService;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;

@CucumberOptions(
        tags = "@RegressionTest",
        features = {"src/test/java/FeatureFiles"},
        glue = {"StepDefinitions"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class RegressionTest extends AbstractTestNGCucumberTests {
    @AfterClass
    public  static void writeExtentReport(){
        ExtentService.getInstance().setSystemInfo("Operating System Name", System.getProperty("os.name"));
        ExtentService.getInstance().setSystemInfo("Operating System Version", System.getProperty("os.version"));
        ExtentService.getInstance().setSystemInfo("Operating System Arch", System.getProperty("os.arch"));
        ExtentService.getInstance().setSystemInfo("Time Zone", System.getProperty("user.timezone"));
        ExtentService.getInstance().setSystemInfo("Username",System.getProperty("user.name"));
        ExtentService.getInstance().setSystemInfo("User Home Directory",System.getProperty("user.home"));
        ExtentService.getInstance().setSystemInfo("User Working Directory",System.getProperty("user.dir"));
        ExtentService.getInstance().setSystemInfo("Test Type", "Regression Test in All Features");
    }
}
