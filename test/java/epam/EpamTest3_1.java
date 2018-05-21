package epam;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.Configuration;

public class EpamTest3_1 {

    @Before
    public void before() {
        // System.setProperty("webdriver.chrome.driver", "C:\\Users\\nenad\\chromedriver.exe");
        Configuration.browser = "chrome";
        open("https://jdi-framework.github.io/tests/");

        $(".profile-photo").click();
        $("#Login").sendKeys(texts.ID.value);
        $("#Password").sendKeys((texts.password.value));
        $(".btn-login").click();
    }

    @Test
    public void loggedIn() throws InterruptedException {
        $("div.profile-photo").shouldHave(text(texts.userName.value));
        $("li.sub-menu").click();
        //$("ul.sub").find(By.linkText("Dates")).click();
        //$("ul.sub").$(By.linkText("Dates")).click();
        $("ul.sub").$x("//*[@id='mCSB_1_container']/ul/li[3]/ul/li[2]/a/p/span").click();


        String a = "/html/body/div/div/main/div[2]/div/form/div[4]/div[2]/div/a[1]";


        //0,100
        actions().dragAndDropBy($$(By.cssSelector(".ui-slider-handle")).get(0).toWebElement(), -200, 0).perform();
        actions().dragAndDropBy($$(By.cssSelector(".ui-slider-handle")).get(1).toWebElement(), -1, 0).perform();

        $$(By.cssSelector(".ui-slider-handle")).get(0).shouldHave(text("0"));
        $$(By.cssSelector(".ui-slider-handle")).get(1).shouldHave(text("100"));

        //0,0
        actions().dragAndDropBy($$(By.cssSelector(".ui-slider-handle")).get(0).toWebElement(), -1, 0).perform();
        actions().dragAndDropBy($$(By.cssSelector(".ui-slider-handle")).get(1).toWebElement(), -276, 0).perform();


        $$(By.cssSelector(".ui-slider-handle")).get(0).shouldHave(text("0"));
        $$(By.cssSelector(".ui-slider-handle")).get(1).shouldHave(text("0"));

        //100,100
        actions().dragAndDropBy($$(By.cssSelector(".ui-slider-handle")).get(0).toWebElement(), 275, 0).perform();
        actions().dragAndDropBy($$(By.cssSelector(".ui-slider-handle")).get(0).toWebElement(), 275, 0).perform();

        $$(By.cssSelector(".ui-slider-handle")).get(0).shouldHave(text("100"));
        $$(By.cssSelector(".ui-slider-handle")).get(1).shouldHave(text("100"));

        //30,70

        actions().dragAndDropBy($$(By.cssSelector(".ui-slider-handle")).get(1).toWebElement(), -196, 0).perform();
        actions().dragAndDropBy($$(By.cssSelector(".ui-slider-handle")).get(0).toWebElement(), 0, 0).perform();
        actions().dragAndDropBy($$(By.cssSelector(".ui-slider-handle")).get(1).toWebElement(), -85, 0).perform();

        $$(By.cssSelector(".ui-slider-handle")).get(0).shouldHave(text("30"));
        $$(By.cssSelector(".ui-slider-handle")).get(1).shouldHave(text("70"));

        System.out.println($("div.info-panel-section").getText());

        System.out.println("--------------------");


    }
}
