import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1280x1024";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
    }

    @Test
    void dragAndDropTest() {
        open("/drag_and_drop");

        // Передвигаем первым способом и проверяем, что всё сработало
        actions().moveToElement($("div#column-a")).clickAndHold().moveByOffset(215, 0).release().perform(); //215 - расстояние между центрами прямоугольников
        $("div#column-a").shouldHave(text("B"));

        // Передвигаем вторым способом и снова проверяем, что всё вернулось на прежнее место
        $("div#column-b").dragAndDrop(to($("div#column-a")));
        $("div#column-a").shouldHave(text("A"));
    }
}