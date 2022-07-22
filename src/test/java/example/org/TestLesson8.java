package example.org;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestLesson8 {
    @Test
    void findJUnit5inSoftAssertions(){
        open("https://github.com/");
        $("[data-test-selector=nav-search-input]").setValue("Selenide").pressEnter();
        $("div.col-12 nav.menu.border").$(byText("Wikis")).click();
        $("#wiki_search_results").shouldHave(text("SoftAssertions"));
        $("#wiki_search_results").$(byText("SoftAssertions")).click();
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class"));
    }

    @Test
    void moveElement(){
        open("https://demoqa.com/sortable");
        $("#demo-tab-grid").click();
        $(".create-grid").$("div").shouldHave(text("One"));
        WebElement elementOne = $(".create-grid").$(byText("One"));
        WebElement elementTwo = $(".create-grid").$(byText("Two"));
        actions().dragAndDrop(elementOne, elementTwo).build().perform();
        $(".create-grid").$("div").shouldHave(text("Two"));
    }
}
