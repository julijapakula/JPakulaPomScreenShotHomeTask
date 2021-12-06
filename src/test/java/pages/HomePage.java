package pages;

import core.BaseFunc;
import org.openqa.selenium.By;

public class HomePage {
    private final By CONSENT = By.xpath(".//button[contains(@class, 'accept-cookies-button')]");

    public BaseFunc baseFunc;
    String url = "if.lv";

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void goToIfPage() {
        baseFunc.goToUrl(url);
        baseFunc.waitClick(CONSENT);
    }

}

