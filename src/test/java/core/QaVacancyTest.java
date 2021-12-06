package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import pages.AboutPage;
import pages.HomePage;
import pages.JobsPage;
import pages.VacanciesPage;

import java.io.IOException;

public class QaVacancyTest {
    private static final Logger LOGGER = LogManager.getLogger(QaVacancyTest.class);
    public BaseFunc baseFunc = new BaseFunc();
    public HomePage homePage = new HomePage(baseFunc);
    public AboutPage aboutPage = new AboutPage(baseFunc);
    public JobsPage jobsPage = new JobsPage(baseFunc);
    public VacanciesPage vacanciesPage = new VacanciesPage(baseFunc);
    @Test
    public void aqVacancyCheck() throws IOException {
        LOGGER.info("Open if.lv");
        homePage.goToIfPage();
        LOGGER.info("Navigate to 'Par If'");
        aboutPage.goToAbout();
        LOGGER.info("Navigate to 'Darbs If'");
        jobsPage.goToJobAtIf();
        LOGGER.info("Navigate to 'Vakances'");
        jobsPage.goToVacancies();
        LOGGER.info("Check QA vacancy");
        vacanciesPage.goToQaSpecialist();
        baseFunc.quitBrowser();
    }
}
