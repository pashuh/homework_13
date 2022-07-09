package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.steps.StepsForDemoQa;
import static org.junit.jupiter.api.Assertions.assertTrue;


@Tag("Notifications")
public class TestNotifications extends TestBase {

    @Test
    @Tag("tests")
    void practiceForm() {
        StepsForDemoQa steps = new StepsForDemoQa();

        steps.openPage();
        steps.setFirstName();
        steps.setLastName();
        steps.setuserEmail();
        steps.setGender();
        steps.setNumber();
        steps.setDateOfBirth();
        steps.setSubjects();
        steps.setHobby();
        steps.setLoad();
        steps.setAddress();
        steps.setState();
        steps.setCity();
        steps.pressSub();
        steps.checkResult();
    }

    @Test
    void test1() {
        assertTrue(true);
    }

    @Test
    void test2() {
        assertTrue(false);
    }

    @Test
    void test3() {
        assertTrue(true);
    }

    @Test
    void test4() {
        assertTrue(false);
    }
}

