package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormTests {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void successFullFillTest() {
        // test data
        String firstName = "testFirstName";
        String lastName = "testLastName";
        String userEmail = "testemail@test.com";
        String userNumber = "1234567890";
        String subjectItem = "History";
        String fileName = "testImage.png";
        String address = "testCurrentAddress";
        String state = "NCR";
        String city = "Delhi";

        //open page
        open("https://demoqa.com/automation-practice-form");

        // fill fields on page
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("[for='gender-radio-1']").click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("2019");
        $("[aria-label='Choose Tuesday, May 7th, 2019']").click();
        $("#subjectsInput").setValue(subjectItem).pressEnter();
        $("[for='hobbies-checkbox-1']").click();
        $("#uploadPicture").uploadFromClasspath(fileName);
        $("#currentAddress").setValue(address);
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();
        $("#submit").click();

        //check modal
        $(".modal-body").shouldHave(text(firstName),
                text(lastName),
                text(userEmail),
                text("Male"),
                text(userNumber),
                text("7 May,2019"),
                text(subjectItem),
                text("Sports"),
                text(fileName),
                text(address),
                text(state),
                text(city));


    }

    @Test
    void testUpBoard() {
        //test data
        Configuration.timeout = 15000;
        String mainPage = "https://lxupboarddev.upboard.io";
        String email = "stolyarps@gmail.com";
        String pass = "Test12345";
        String boardURL = "https://lxupboarddev.upboard.io/board/c25ad318-f85e-461f-9ade-c0b2509af63d/4883000160944128";

        //test
        open(mainPage);
        sleep(5000);
        $("#email").setValue(email);
        $("#password").setValue(pass).pressEnter();
        $(byText("testorg30")).click();
        open(boardURL);
        //copy card
        $(".up-font-ic-dots").click();


        System.out.println("test");

    }
}
