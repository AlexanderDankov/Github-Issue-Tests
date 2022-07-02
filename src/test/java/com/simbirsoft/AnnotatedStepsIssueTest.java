package com.simbirsoft;


import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Issues")
@Owner("a.dankov")
public class AnnotatedStepsIssueTest {

    private final static String REPOSITORY = "eroshenkoam/allure-example";
    private final static String ISSUE_NAME = "С Новым Годом (2022)";

    @Test
    @Story("Поиск по Issue")
    @Link(name = "Главная страница", url = "https://github.com")
    @DisplayName("Проверка, что первый Issue в списке имеет название С Новым Годом (2022)")
    @Severity(SeverityLevel.NORMAL)
    public void issueShouldBeInList() {
       WebSteps steps = new WebSteps();

       steps.openMainPage();
       steps.searchForRepository(REPOSITORY);
       steps.goToRepository(REPOSITORY);
       steps.openIssueTab();
       steps.issueShouldBeFirstInList(ISSUE_NAME);
    }
}
