package com.simbirsoft;


import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

@Feature("Issues")
@Owner("a.dankov")
public class SelenideIssueTest {

    @Test
    @Story("Поиск по Issue")
    @Link(name = "Главная страница", url = "https://github.com")
    @DisplayName("Проверка, что первый Issue в списке имеет название С Новым Годом (2022)")
    @Severity(SeverityLevel.NORMAL)
    public void issueShouldBeInList() {
        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys("eroshenkoam/allure-example");
        $(".header-search-input").submit();

        $(linkText("eroshenkoam/allure-example")).click();
        $(partialLinkText("Issues")).click();

        $$(".Box [aria-label=Issues]").get(0).shouldHave(Condition.text("С Новым Годом (2022)"));
    }
}
