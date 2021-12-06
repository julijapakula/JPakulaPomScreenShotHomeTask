package pages;

import core.BaseFunc;
import org.openqa.selenium.By;

public class AboutPage {
    private final By ABOUT = By.xpath(".//a[@title = 'Par If']");

    public BaseFunc baseFunc;

    public AboutPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void goToAbout() {
        baseFunc.waitClick(ABOUT);
    }
}
