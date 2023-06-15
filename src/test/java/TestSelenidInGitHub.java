import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TestSelenidInGitHub {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://github.com/";
//        Configuration.browserSize = "1920x1080";
//        Configuration.holdBrowserOpen = true;
    }

    @Test
    void successTest() {
        open("selenide/selenide");
        //Open WIKI tab
        $("#wiki-tab").click();
        $("#wiki-pages-filter").click();

        //Fill the search filter
        $("#wiki-pages-filter").setValue("SoftAssertions").pressEnter();
        //Click the search result
        $("a[href='/selenide/selenide/wiki/SoftAssertions']").click();

        //Check page is opened
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class:"));
        //Check JUnit5 code example exist
        $(".markdown-body").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" + "class Tests {\n" + "  @Test\n" + "  void test() {\n" + "    Configuration.assertionMode = SOFT;\n" + "    open(\"page.html\");\n" + "\n" + "    $(\"#first\").should(visible).click();\n" + "    $(\"#second\").should(visible).click();\n" + "  }\n" + "}"));

    }

}


