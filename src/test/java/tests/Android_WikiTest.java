package tests;

import com.codeborne.selenide.CollectionCondition;
import io.appium.java_client.MobileBy;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Feature("Selenide-appium Android tests")
@Story("Search tests")
@Tag("android")
class Android_WikiTest extends TestBase {
    @Test
    @DisplayName("Successful search in wikipedia android app")
    void successfulSearch() {
        step("Open application", ()-> {
            open();
        });

        step("Type search", ()-> {
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("BrowserStack");
        });

        step("Verify content found", ()-> {
            $$(MobileBy.className("android.widget.TextView"))
                    .shouldHave(CollectionCondition.sizeGreaterThan(0));
        });
    }

////////    refactored from
//    AndroidElement searchElement = (AndroidElement) new WebDriverWait(driver, 30).until(
//            ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Search Wikipedia")));
//        searchElement.click();
//    AndroidElement insertTextElement = (AndroidElement) new WebDriverWait(driver, 30).until(
//            ExpectedConditions.elementToBeClickable(MobileBy.id("org.wikipedia.alpha:id/search_src_text")));
//        insertTextElement.sendKeys("BrowserStack");
//        Thread.sleep(5000);
//    List<AndroidElement> allProductsName = driver.findElementsByClassName("android.widget.TextView");
//        assert(allProductsName.size() > 0);

}
