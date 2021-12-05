package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import pages.HomePage;

public class QaVacancyTest {
    private static final Logger LOGGER = LogManager.getLogger(QaVacancyTest.class);
    public BaseFunc baseFunc = new BaseFunc();
    public HomePage homePage = new HomePage(baseFunc);

    @Test
    public void aqVacancyCheck() {
        LOGGER.info("Open if.lv");
        homePage.goToIfPage();
        LOGGER.info("Navigate to 'Par If'");
        homePage.goToAbout();
        LOGGER.info("Navigate to 'Darbs If'");
        homePage.goToJobAtIf();
        LOGGER.info("Navigate to 'Vakances'");
        homePage.goToVacancies();
        LOGGER.info("Click the button that would lead to QA vacancy");
        homePage.goToQaSpecialist();
    }
}
