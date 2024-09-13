import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;

public class HomeWorkLesson5 {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1280x1024";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void openEnterprisePageTest() {
        open("https://github.com");
        $(byTagAndText("button", "Solutions")).hover();
        $("[href='https://github.com/enterprise']").click();
        $("h1#hero-section-brand-heading").shouldHave(text("The AI-powered developer platform"));
    }
}
