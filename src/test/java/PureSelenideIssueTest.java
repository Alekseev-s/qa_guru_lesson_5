import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class PureSelenideIssueTest extends TestBase {
    private String baseURL = "https://github.com/";
    private String repository = "Alekseev-s/qa_guru_lesson_5";
    private String issue = "Allure test issue";

    @Test
    void searchGitHubIssue() {
        open(baseURL);
        $("input[name='q']").setValue(repository).pressEnter();
        $(".repo-list").$(linkText(repository)).click();
        $("span[data-content='Issues']").click();
        $("div[aria-label='Issues']").shouldHave(text(issue));
    }
}
