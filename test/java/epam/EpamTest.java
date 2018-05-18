package epam;

import org.junit.*;
import org.openqa.selenium.By;




public class EpamTest {

    @Before
    public void init() {
        work.init(texts.link.value);
    }

    @Test
    public void siteOpened() {
        Assert.assertEquals(work.driver.getCurrentUrl(), texts.link.value);
    }

    @Test
    public void checkIndex() {
        Assert.assertEquals(work.driver.getTitle(), texts.linkIndex.value);
    }

    @Test
    public void userInput() {

        work.logIn(texts.ID.value, texts.password.value);//xpath
        //work.LogIn2(texts.ID.value,texts.password.value);//css

        Assert.assertTrue(work.driver.findElements(By.xpath("//li/a/div/span")).size() == 1);
        Assert.assertEquals(texts.userName.value, work.driver.findElement(By.xpath("//li/a/div/span")).getText());
    }

    @Test
    public void PageObject() {

        Assert.assertTrue(work.driver.findElements(By.xpath("//div[@class='col-sm-3']")).size() == 4);
        Assert.assertTrue(work.driver.findElements(By.xpath("//span[@class='benefit-txt']")).size() == 4);

        Assert.assertEquals(texts.first.value, work.driver.findElement(By.xpath("//span[text()='To include good practices']")).getText());
        Assert.assertEquals(texts.second.value, work.driver.findElement(By.xpath("//span[text()='To be flexible and']")).getText());
        Assert.assertEquals(texts.third.value, work.driver.findElement(By.xpath("//span[text()='To be multiplatform ']")).getText());
        Assert.assertEquals(texts.fourth.value, work.driver.findElement(By.xpath("//span[text()='Already have good base']")).getText());

      //  Assert.assertEquals(true,work.driver.findElement(By.cssSelector("To include good practices")));
    }

    @Test
    public void Header() {
        Assert.assertEquals(texts.framework.value, work.driver.findElement(By.xpath("//h3")).getText());
        Assert.assertEquals(texts.weird.value, work.driver.findElement(By.xpath("//p[@class='main-txt text-center']")).getText());
    }

    @After
    public void CloseBrowser() {
        work.driver.quit();
    }
}