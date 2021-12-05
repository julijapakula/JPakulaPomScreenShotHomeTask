package pages;

import core.BaseFunc;
import org.openqa.selenium.By;
import org.testng.Assert;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePage {
    private final By TOP_HEADER = By.xpath(".//h1[contains(@class,'if heading')]");
    private final By INSURANCE = By.id("js-toggle-insurances");
    private final By CONSENT = By.xpath(".//button[contains(@class, 'accept-cookies-button')]");
    private final By ABOUT = By.xpath(".//a[@title = 'Par If']");
    private final By JOB_AT_IF = By.xpath(".//a[@title ='Darbs If']");
    private final By VACANCIES = By.xpath(".//a[contains(text(), 'Vakances')]");
    private final By QA_SPECIALIST = By.xpath(".//a[@href = '/par-if/darbs-if/vakances/quality-assurance-specialist']");
    private final By HEADING_LARGE = By.xpath(".//h1[@class = 'if heading large']");

    public BaseFunc baseFunc;
    String url = "if.lv";
    String pageHeaderActual;
    String pageHeaderExpected = "Quality Assurance Analyst";

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void goToIfPage() {
        baseFunc.goToUrl(url);
        baseFunc.waitClick(CONSENT);
        assertTrue(baseFunc.findElement(TOP_HEADER).isDisplayed(), "Something different");
    }

    public void goToAbout() {
        baseFunc.waitClick(ABOUT);
    }

    public void goToJobAtIf() {
        baseFunc.waitClick(JOB_AT_IF);
    }

    public void goToVacancies() {
        baseFunc.waitClick(VACANCIES);
    }

    public void goToQaSpecialist() {
        baseFunc.waitClick(QA_SPECIALIST);
        pageHeaderActual = baseFunc.findElement(HEADING_LARGE).getText();
        Assert.assertEquals(pageHeaderActual,pageHeaderExpected);
        baseFunc.catchExceptions();
    }


}
