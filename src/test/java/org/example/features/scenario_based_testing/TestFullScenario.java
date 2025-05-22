package org.example.features.scenario_based_testing;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.example.steps.serenity.EndUserSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/resources/features/fullScenarioTestCases.csv")
public class TestFullScenario {
    @Steps
    EndUserSteps user;

    String username, password, accountType, existingAccount;

    @Managed(uniqueSession = true, driver = "chrome")
    public WebDriver webdriver;

    public void loginWithValidCredentials() {
        user.isOnTheLoginPage();
        user.entersUsername(username);
        user.entersPassword(password);
        user.clicksLoginButton();
        user.shouldSeeHomePage();
    }

    public void openNewAccount() {
        user.openNewAccountPage();
        user.selectsAccountType(accountType);
        user.selectsExistingAccount(existingAccount);

        user.clicksOpenNewAccountButton();
        user.shouldSeeAccountOpened();
    }

    public void checkOverviewTable() {
        user.clickOverviewButton();
        user.shouldOverviewTableHavePositiveNumberOfRows();
    }

    public void logout() {
        user.logsOut();
        user.shouldSeeLoginPage();
    }

    @Test
    public void openNewAccountAfterLogin() {
        loginWithValidCredentials();
        openNewAccount();
        checkOverviewTable();
        logout();
    }
}
