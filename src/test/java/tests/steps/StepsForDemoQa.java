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

    @Step("��������� �������� automation-practice-form")
    public void openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
    }

    @Step("������� ������� � �����")
    public void removingAds() {
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
    }

    @Step("������ ���")
    public void setFirstName() {
        firstNameInput.setValue("Pol");
    }

    @Step("������ �������")
    public void setLastName() {
        lastNameInput.setValue("Vod");
    }

    @Step("������ Email")
    public void setuserEmail() {
        $("#userEmail").setValue("PV@gm.com");
    }

    @Step("�������� ���")
    public void setGender() {
        $("#genterWrapper").$(byText("Male")).click();
    }

    @Step("�������� ���� ��������")
    public void setDateOfBirth() {
        $("#dateOfBirthInput").click();
        calenderComponent.setDate("30", "July", "1997");
    }

    @Step("������ ����� ��������")
    public void setNumber() {
        $("#userNumber").setValue("9990001122");
    }

    @Step("�������� ��������")
    public void setSubjects() {
        $("#subjectsInput").setValue("Chemistry").pressEnter();
    }

    @Step("������ �����")
    public void setAddress() {
        $("#currentAddress").setValue("Revaz 22");
    }


    @Step("�������� �����")
    public void setHobby() {
        $(byText("Music")).click();
    }


    @Step("��������� �����������")
    public void setLoad() {
        $("#uploadPicture").uploadFromClasspath("Screen1.png");
    }

    @Step("�������� ����")
    public void setState() {
        $("#react-select-3-input").setValue("Rajasthan").pressEnter();
    }

    @Step("�������� �����")
    public void setCity() {
        $("#react-select-4-input").setValue("Jaipur").pressEnter();
    }

    @Step("������� Submit")
    public void pressSub() {
        $("#submit").click();
    }

    @Step("��������� ��������� ����������")
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
