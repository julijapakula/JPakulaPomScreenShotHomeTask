package core;

import com.beust.jcommander.converters.PathConverter;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.core.config.plugins.convert.TypeConverters;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.openqa.selenium.Keys.DELETE;

public class BaseFunc {
    Actions actions;
    private WebDriver driver;
    private WebDriverWait wait;
    private BaseFunc TakesScreenshot;

    public BaseFunc() {
        System.setProperty("webdriver.chrome.driver", "C:/webdriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public void goToUrl(String url) {
        if (url.startsWith("http://") || url.startsWith("https://")) {
        } else {
            url = "http://" + url;
        }
        driver.get(url);
    }

    public void waitClick(By locator) {
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        findElement(locator).click();
    }

    public List<WebElement> findElements(By locator) {
        assertFalse(driver.findElements(locator).isEmpty(), "No elements found by this locator");
        return driver.findElements(locator);
    }

    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public void clickOnElementById(int id, By locator) {
        findElements(locator).get(id).click();
    }

    public void clickOnElementInListByName(By locator, String name) {
        List<WebElement> listOfElements = findElements(locator);
        for (WebElement we : listOfElements) {
            if (we.getText().toLowerCase().contains(name)) {
                we.click();
                break;
            }
        }
    }

    public void typeToField(By locator, String text) {
        findElement(locator).sendKeys(DELETE);
        findElement(locator).sendKeys(text);
    }

    public void quitBrowser() {
        driver.quit();
    }
    @AfterMethod(alwaysRun=true)
    public void catchExceptions(ITestResult result){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        String methodName = result.getName();
        if (!result.isSuccess()){
            File scrFile = ((org.openqa.selenium.TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(scrFile, new File("failure_screenshots/" + methodName+ "_" + formater.format(calendar.getTime()) + ".png"));
            }
            catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    public void catchExceptions() {
    }
}
