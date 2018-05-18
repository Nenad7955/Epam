package epam;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class EpamTest2 {

    private WebDriver driver;

    @Before
    public void before(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\nenad\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.driver.manage().window().maximize();
        driver.navigate().to(texts.link.value);
        work.initHP(this.driver);
        work.homePage.login(texts.ID.value, texts.password.value);
    }

    @After
    public void  after(){
        work.homePage.driver.close();
    }

    @Test
    public void checkURL(){
        Assert.assertEquals(work.homePage.driver.getCurrentUrl(), texts.link.value);
    }

    @Test
    public void userName(){
        Assert.assertEquals(work.homePage.profilePhoto.getAttribute("innerText")," " + texts.userName.value);
    }

    @Test
    public void title(){
        Assert.assertEquals(work.homePage.driver.getTitle(), texts.linkIndex.value);
    }

    @Test
    public void images(){
        Assert.assertEquals(work.homePage.images.size(),4);

        Assert.assertTrue(work.homePage.images.get(0).isDisplayed());
        Assert.assertTrue(work.homePage.images.get(1).isDisplayed());
        Assert.assertTrue(work.homePage.images.get(2).isDisplayed());
        Assert.assertTrue(work.homePage.images.get(3).isDisplayed());
    }

    @Test
    public void texts(){
        Assert.assertEquals(work.homePage.texts.size(),4);

        Assert.assertEquals(work.homePage.texts.get(0).getText(), texts.first.value);
        Assert.assertEquals(work.homePage.texts.get(1).getText(), texts.second.value);
        Assert.assertEquals(work.homePage.texts.get(2).getText(), texts.third.value);
        Assert.assertEquals(work.homePage.texts.get(3).getText(), texts.fourth.value);

        Assert.assertEquals(work.homePage.mainText.getText(), texts.weird.value);
        Assert.assertEquals(work.homePage.mainTitle.getText(), texts.framework.value);


    }

}
