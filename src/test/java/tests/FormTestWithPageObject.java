package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pageObjects.TestFormPage;

public class FormTestWithPageObject {

    TestFormPage testFormPage = new TestFormPage();

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void fillFormTestWithPageObject() {
        testFormPage.openPage();
        testFormPage.fillForm();
        testFormPage.formVerification();

    }
}
