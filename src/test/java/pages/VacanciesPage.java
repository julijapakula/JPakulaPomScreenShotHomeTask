package pages;

import core.BaseFunc;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import java.io.IOException;

public class VacanciesPage {
    private final By QA_SPECIALIST = By.xpath(".//a[@href = '/par-if/darbs-if/vakances/quality-assurance-specialist']");
    private final By HEADING_LARGE = By.xpath(".//h1[@class = 'if heading large']");
    public BaseFunc baseFunc;
    String pageHeaderActual;
    String pageHeaderExpected = "Quality Assurance Analyst";

    public VacanciesPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void goToQaSpecialist() throws IOException {
        baseFunc.waitClick(QA_SPECIALIST);
        pageHeaderActual = baseFunc.findElement(HEADING_LARGE).getText();
        try {
            Assertions.assertEquals(pageHeaderActual, pageHeaderExpected, "Wrong header!");
        } catch (AssertionError e) {
            baseFunc.takeScreenShot();
        }
    }
}