package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class Components {

    public void setDate (String dayOfBirth, String month, String year) {

        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0" + dayOfBirth +
                ":not(.react-datepicker__day--outside-month)").click();
    }
}
