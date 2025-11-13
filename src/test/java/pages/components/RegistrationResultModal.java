package pages.components;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultModal {


    private SelenideElement modalButton = $("#closeLargeModal");

    public void verifyModalAppears () {
        $(".modal-content").shouldBe(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    }

    public void verifyModalResult(String key, String value) {
        $(By.xpath("//td[normalize-space()='" + key +"']" +
                "/following-sibling::td[normalize-space()='" + value +"']"));
    }

    public void closeModalWindow() {
        modalButton.click();
    }
}
