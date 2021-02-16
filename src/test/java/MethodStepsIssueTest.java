import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

public class MethodStepsIssueTest extends TestBase {
    BaseSteps steps = new BaseSteps();

    private String repository = "Alekseev-s/qa_guru_lesson_5";
    private String issue = "Allure test issue";

    @Test
    @Feature("Issues")
    @Story("Поиск Issue в репозитории.")
    @Tags({@Tag("web"), @Tag("critical")})
    @Severity(SeverityLevel.CRITICAL)

    @DisplayName("Поиск Issue по названию в репозитории.")
    @Owner("Alekseev-s")
    void searchGitHubIssue() {
        steps.openMainPage();
        steps.searchRepository(repository);
        steps.openRepository(repository);
        steps.openIssues();
        steps.checkIssueExistence(issue);
    }
}
