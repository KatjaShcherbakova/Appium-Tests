package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static helpers.DriverHelper.byTestId;
import static io.qameta.allure.Allure.step;

@Feature("Selenide-appium IOS tests")
@Story("Login tests")
@Tag("ios")
public class IOS_LoginTest extends TestBase {
    @Test
    @DisplayName("Successful login ios test")
    void successfulLogin() {

      private String login = "Katja";
      private String password = "12345";

        step("Go to login page", ()-> {
            open();
            $(byTestId("Header label")).shouldHave(text("Not authorized"));
        });

        step("Fill the authorization form", ()-> {
            $(byTestId("Authorization form")).shouldBe(visible);
            $(byTestId("Login input")).setValue(login);
            $(byTestId("Password input")).setValue(password);
            $(byTestId("Remember me checkbox")).click();
            $(byTestId("Login button")).click();
        });

        step("Verify successful authorization", ()-> {
            $(byTestId("Authorization form")).shouldNot(exist);
            $(byTestId("Header label")).shouldHave(text("Hello, " + login + "!"));
            $$(byTestId("Private content"))
                    .shouldHaveSize(2)
                    .shouldHave(texts("Here is your private content #1",
                            "and private content #2"));
        });
    }
}
