import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class BaseSteps {
    private String BASE_URL = "https://github.com/";

    @Step("Открываем главную страницу")
    void openMainPage() {
        open(BASE_URL);
    }

    @Step("Ищем репозиторий {repository}")
    void searchRepository(String repository) {
        $("input[name='q']").setValue(repository).pressEnter();
    }

    @Step("Открываем репозиторий {repository}")
    void openRepository(String repository) {
        $(".repo-list").$(linkText(repository)).click();
    }

    @Step("Открываем раздел Issues")
    void openIssues() {
        $("span[data-content='Issues']").click();
    }

    @Step("Проверяем, что Issue {issue} существует")
    void checkIssueExistence(String issue) {
        $("div[aria-label='Issues']").$(byText(issue)).shouldBe(visible);
    }

}
