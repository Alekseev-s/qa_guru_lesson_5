package steps;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class BaseSteps {
    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("");
    }

    @Step("Ищем репозиторий {repository}")
    public void searchRepository(String repository) {
        $("input[name='q']").setValue(repository).pressEnter();
    }

    @Step("Открываем репозиторий {repository}")
    public void openRepository(String repository) {
        $(".repo-list").$(linkText(repository)).click();
    }

    @Step("Открываем раздел Issues")
    public void openIssues() {
        $("span[data-content='Issues']").click();
    }

    @Step("Проверяем, что Issue {issue} существует")
    public void checkIssueExistence(String issue) {
        $("div[aria-label='Issues']").shouldHave(text(issue));
    }

}
