package epam;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class EpamTest3 {

    private WebDriver driver;

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\nenad\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.driver.manage().window().maximize();
        driver.navigate().to(texts.link.value);
        work.initHP(this.driver);
        work.homePage.login(texts.ID.value, texts.password.value);
    }

    @After
    public void after() {
        work.homePage.driver.close();
    }

    @Test
    public void checkURL() {
        Assert.assertEquals(work.homePage.driver.getCurrentUrl(), texts.link.value);
    }

    @Test
    public void headerServicesContainTexts() {
        work.homePage.hdrServices.click();
        Assert.assertTrue(work.homePage.hdrServices.findElement(By.cssSelector("ul.dropdown-menu")).getText().contains("SUPPORT"));
        // Assert.assertTrue(work.homePage.hdrServices2.getText().contains("SUPPORT"));
        Assert.assertTrue(work.homePage.hdrServices.findElement(By.cssSelector("ul.dropdown-menu")).getText().contains("DATES"));
        Assert.assertTrue(work.homePage.hdrServices.findElement(By.cssSelector("ul.dropdown-menu")).getText().contains("COMPLEX TABLE"));
        Assert.assertTrue(work.homePage.hdrServices.findElement(By.cssSelector("ul.dropdown-menu")).getText().contains("SIMPLE TABLE"));
        Assert.assertTrue(work.homePage.hdrServices.findElement(By.cssSelector("ul.dropdown-menu")).getText().contains("TABLE WITH PAGES"));
        Assert.assertTrue(work.homePage.hdrServices.findElement(By.cssSelector("ul.dropdown-menu")).getText().contains("DIFFERENT ELEMENTS"));
    }

    @Test
    public void menuServicesContainTexts() {
        work.homePage.subServices.click();
        Assert.assertTrue(work.homePage.subServices.findElement(By.cssSelector("ul.sub")).getText().contains("Support"));
        Assert.assertTrue(work.homePage.subServices.findElement(By.cssSelector("ul.sub")).getText().contains("Dates"));
        Assert.assertTrue(work.homePage.subServices.findElement(By.cssSelector("ul.sub")).getText().contains("Complex Table"));
        Assert.assertTrue(work.homePage.subServices.findElement(By.cssSelector("ul.sub")).getText().contains("Simple Table"));
        Assert.assertTrue(work.homePage.subServices.findElement(By.cssSelector("ul.sub")).getText().contains("Table with pages"));
        Assert.assertTrue(work.homePage.subServices.findElement(By.cssSelector("ul.sub")).getText().contains("Different elements"));
    }

    @Test
    public void DEP() {
        work.homePage.subServices.click();
        work.homePage.subServices.findElement(By.cssSelector("ul.sub")).findElement(By.linkText("Different elements")).click();
        Assert.assertEquals(work.homePage.driver.getTitle(), "Different Element");


        Assert.assertEquals(work.homePage.driver.findElement(By.cssSelector("div.main-content-hg")).findElements(By.cssSelector("label.label-checkbox")).size(), 4);
        Assert.assertEquals(work.homePage.driver.findElement(By.cssSelector("div.main-content-hg")).findElements(By.cssSelector("label.label-radio")).size(), 4);
        Assert.assertTrue(work.homePage.driver.findElement(By.cssSelector("div.main-content-hg")).findElements(By.cssSelector("div.colors")).get(0).isDisplayed()); //dropdown
        Assert.assertEquals(work.homePage.driver.findElement(By.cssSelector("div.main-content-hg")).findElements(By.cssSelector("button")).get(0).isDisplayed(), true);
        Assert.assertEquals(work.homePage.driver.findElement(By.cssSelector("div.main-content-hg")).findElements(By.cssSelector("input")).get(0).isDisplayed(), true);


        //System.out.println(work.homePage.driver.findElement(By.cssSelector("div.main-content-hg")).findElements(By.cssSelector("info-panel-header")));
        work.homePage.driver.findElement(By.cssSelector("div.main-content-hg")).findElements(By.cssSelector("label.label-checkbox")).get(0).click();
        work.homePage.driver.findElement(By.cssSelector("div.main-content-hg")).findElements(By.cssSelector("label.label-checkbox")).get(2).click();

        Assert.assertTrue(work.homePage.driver.findElement(By.cssSelector("div.main-content-hg")).findElements(By.cssSelector("input")).get(0).isSelected());
        Assert.assertTrue(work.homePage.driver.findElement(By.cssSelector("div.main-content-hg")).findElements(By.cssSelector("input")).get(2).isSelected());

        work.homePage.driver.findElement(By.cssSelector("div.main-content-hg")).findElements(By.cssSelector("label.label-radio")).get(3).click();
        Assert.assertTrue(work.homePage.driver.findElement(By.cssSelector("div.main-content-hg")).findElements(By.cssSelector("input")).get(7).isSelected());

        //work.homePage.driver.findElement(By.cssSelector("div.main-content-hg")).findElements(By.cssSelector("div.colors")).get(0).click();
        //work.homePage.driver.findElement(By.cssSelector("div.main-content-hg")).findElements(By.cssSelector("div.colors")).va
        Select color = new Select(work.homePage.driver.findElement(By.cssSelector("select.uui-form-element")));
        color.selectByIndex(3);
        Assert.assertEquals(color.getAllSelectedOptions().get(0).getText(), "Yellow");

        Assert.assertTrue(work.homePage.driver.findElement(By.cssSelector("ul.panel-body-list.logs")).getText().contains(change.waterChecked.value));
        Assert.assertTrue(work.homePage.driver.findElement(By.cssSelector("ul.panel-body-list.logs")).getText().contains(change.windChecked.value));
        Assert.assertTrue(work.homePage.driver.findElement(By.cssSelector("ul.panel-body-list.logs")).getText().contains(change.yellowChecked.value));
        Assert.assertTrue(work.homePage.driver.findElement(By.cssSelector("ul.panel-body-list.logs")).getText().contains(change.selenChecked.value));

        //uncheck water and wind
        work.homePage.driver.findElement(By.cssSelector("div.main-content-hg")).findElements(By.cssSelector("label.label-checkbox")).get(0).click();
        work.homePage.driver.findElement(By.cssSelector("div.main-content-hg")).findElements(By.cssSelector("label.label-checkbox")).get(2).click();

        Assert.assertFalse(work.homePage.driver.findElement(By.cssSelector("div.main-content-hg")).findElements(By.cssSelector("input")).get(0).isSelected());
        Assert.assertFalse(work.homePage.driver.findElement(By.cssSelector("div.main-content-hg")).findElements(By.cssSelector("input")).get(2).isSelected());

        Assert.assertTrue(work.homePage.driver.findElement(By.cssSelector("ul.panel-body-list.logs")).getText().contains(change.waterUnchecked.value));
        Assert.assertTrue(work.homePage.driver.findElement(By.cssSelector("ul.panel-body-list.logs")).getText().contains(change.windUnchecked.value));
    }
}
