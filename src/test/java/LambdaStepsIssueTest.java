import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.parameter;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class LambdaStepsIssueTest extends TestBase {
    private String baseURL = "https://github.com/";
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
        parameter("Repository", repository);
        parameter("Issue", issue);

        step("Открываем главную страницу", () -> {
            open(baseURL);
        });
        step("Ищем репозиторий " + repository, () -> {
            $("input[name='q']").setValue(repository).pressEnter();
        });
        step("Открываем репозиторий " + repository, () -> {
            $(".repo-list").$(linkText(repository)).click();
        });
        step("Открываем раздел Issues", () -> {
            $("span[data-content='Issues']").click();
        });
        step("Проверяем, что Issue " + issue + " существует", () -> {
            $("div[aria-label='Issues']").$(byText(issue)).shouldBe(visible);
        });
    }
}
