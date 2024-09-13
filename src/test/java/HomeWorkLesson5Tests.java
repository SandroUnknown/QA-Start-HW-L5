import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;

public class HomeWorkLesson5Tests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1280x1024";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void openEnterprisePageTest() {
        open("https://github.com");
        $(byTagAndText("button", "Solutions")).hover();
        $("div.HeaderMenu-dropdown [href='https://github.com/enterprise']").click();    //можно и без поиска "div.HeaderMenu-dropdown", но так я точно уверен, что ссылку ищет в нужном месте
        $("h1#hero-section-brand-heading").shouldHave(text("The AI-powered developer platform"));
    }
}