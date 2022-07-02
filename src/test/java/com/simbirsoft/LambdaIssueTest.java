package com.simbirsoft;

import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

@Feature("Issues")
@Owner("a.dankov")
public class LambdaIssueTest {

    private final static String REPOSITORY = "eroshenkoam/allure-example";
    private final static String ISSUE_NAME = "С Новым Годом (2022)";

    @Test
    @Story("Поиск по Issue")
    @Link(name = "Главная страница", url = "https://github.com")
    @DisplayName("Проверка, что первый Issue в списке имеет название С Новым Годом (2022)")
    @Severity(SeverityLevel.NORMAL)
    public void issueShouldBeInList() {
        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });

        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });

        step("Переходим в репозиторий " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });

        step("Открываем Issues", () -> {
            $(partialLinkText("Issues")).click();
        });

        step("Проверяем, что Issue с названием " + ISSUE_NAME + " первый в списке", () -> {
            $$(".Box [aria-label=Issues]").get(0).shouldHave(Condition.text(ISSUE_NAME));
        });
    }
}
