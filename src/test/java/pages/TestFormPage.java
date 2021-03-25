package pages;

import com.github.javafaker.Faker;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestFormPage {

    //test data
    Faker faker = new Faker();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String userNumber = faker.number().digits(10);
    String subjectItem = "History";
    String fileName = "testImage.png";
    String address = faker.address().streetAddress();
    String state = "NCR";
    String city = "Delhi";
    String mainPageUrl = "/automation-practice-form";


    public void openPage() {
        open(mainPageUrl);
    }

    public void fillForm() {
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
    }

    public void formVerification() {
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
}
