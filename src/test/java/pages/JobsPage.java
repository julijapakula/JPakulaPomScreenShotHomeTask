package pages;

import core.BaseFunc;
import org.openqa.selenium.By;

public class JobsPage {
    private final By JOB_AT_IF = By.xpath(".//a[@title ='Darbs If']");
    private final By VACANCIES = By.xpath(".//a[contains(text(), 'Vakances')]");
    public BaseFunc baseFunc;

    public JobsPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void goToJobAtIf() {
        baseFunc.waitClick(JOB_AT_IF);
    }

    public void goToVacancies() {
        baseFunc.waitClick(VACANCIES);
    }
}
