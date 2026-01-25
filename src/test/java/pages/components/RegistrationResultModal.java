package pages.components;

import com.codeborne.selenide.SelenideElement;
import examples.Constants;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static examples.Constants.SUBMITTING_FORM;

public class RegistrationResultModal {


    private SelenideElement modalButton = $("#closeLargeModal");

    public void verifyModalAppears () {
        $(".modal-content").shouldBe(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text(SUBMITTING_FORM));
    }

    public void verifyModalResult(String key, String value) {
        $(By.xpath("//td[normalize-space()='" + key +"']" +
                "/following-sibling::td[normalize-space()='" + value +"']"));
    }

    public void closeModalWindow() {
        modalButton.click();
    }
}
