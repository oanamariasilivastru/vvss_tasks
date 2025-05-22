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
@UseTestDataFrom("src/test/resources/features/loginValidTestCase.csv")
public class TestValidLogin {
    @Steps
    EndUserSteps user;

    String username, password;

    @Managed(uniqueSession = true, driver = "chrome")
    public WebDriver webdriver;

    @Test
    public void loginWithValidCredentials() {
        System.out.println("username: " + username + ", password: " + password);
        user.isOnTheLoginPage();
        user.entersUsername(username);
        user.entersPassword(password);
        user.clicksLoginButton();
        user.shouldSeeHomePage();
    }
}