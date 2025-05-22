package org.example.features.function_testing;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.example.steps.serenity.EndUserSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/resources/features/loginInvalidTestCase.csv")
public class TestInvalidLogin {
    @Steps
    EndUserSteps user;
    String username, password;

    @Managed(uniqueSession = true, driver = "chrome")
    public WebDriver webdriver;

    @Test
    public void loginWithInvalidCredentials() {
        user.isOnTheLoginPage();
        user.entersUsername(username);
        user.entersPassword(password);
        user.clicksLoginButton();
        user.shouldSeeErrorPage();
    }
}
