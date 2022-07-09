package tests.steps;

import com.codeborne.selenide.SelenideElement;
import components.CalenderComponent;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Tag;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@Tag("notrun")
public class StepsForDemoQa {
    CalenderComponent calenderComponent = new CalenderComponent();

    SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName");

    @Step("Открываем страницу automation-practice-form")
    public void openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
    }

    @Step("Удаляем рекламу и футер")
    public void removingAds() {
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
    }

    @Step("Вводим имя")
    public void setFirstName() {
        firstNameInput.setValue("Pol");
    }

    @Step("Вводим фамилию")
    public void setLastName() {
        lastNameInput.setValue("Vod");
    }

    @Step("Вводим Email")
    public void setuserEmail() {
        $("#userEmail").setValue("PV@gm.com");
    }

    @Step("Выбираем пол")
    public void setGender() {
        $("#genterWrapper").$(byText("Male")).click();
    }

    @Step("Выбираем дату рождения")
    public void setDateOfBirth() {
        $("#dateOfBirthInput").click();
        calenderComponent.setDate("30", "July", "1997");
    }

    @Step("Вводим номер телефона")
    public void setNumber() {
        $("#userNumber").setValue("9990001122");
    }

    @Step("Выбираем предметы")
    public void setSubjects() {
        $("#subjectsInput").setValue("Chemistry").pressEnter();
    }

    @Step("Вводим адрес")
    public void setAddress() {
        $("#currentAddress").setValue("Revaz 22");
    }


    @Step("Выбираем хобби")
    public void setHobby() {
        $(byText("Music")).click();
    }


    @Step("Загружаем изображение")
    public void setLoad() {
        $("#uploadPicture").uploadFromClasspath("Screen1.png");
    }

    @Step("Выбираем штат")
    public void setState() {
        $("#react-select-3-input").setValue("Rajasthan").pressEnter();
    }

    @Step("Выбираем город")
    public void setCity() {
        $("#react-select-4-input").setValue("Jaipur").pressEnter();
    }

    @Step("Кликаем Submit")
    public void pressSub() {
        $("#submit").click();
    }

    @Step("Проверяем введенную информацию")
    public void checkResult() {
        $(".modal-content").shouldHave(
                text("Pol"),
                text("Vod"),
                text("PV@gm.com"),
                text("Male"),
                text("9990001122"),
                text("30 July,1997"),
                text("Chemistry"),
                text("Screen1.png"),
                text("Revaz 22"),
                text("Rajasthan"),
                text("Jaipur"));
    }
}
