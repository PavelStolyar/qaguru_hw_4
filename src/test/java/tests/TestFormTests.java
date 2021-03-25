package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.TestFormPage;

public class TestFormTests {

    TestFormPage testFormPage = new TestFormPage();

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
        Configuration.baseUrl="https://demoqa.com";
    }

    @Test
    void fillFormTestWithPageObject() {
        testFormPage.openPage();
        testFormPage.fillForm();
        testFormPage.formVerification();

    }
}
