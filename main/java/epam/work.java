package epam;


import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


@AllArgsConstructor
public class work {

    public static ChromeDriver driver;
    public static HomePage homePage;


    public static void init(String webpage) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\nenad\\chromedriver.exe");
        driver = new ChromeDriver();
        //driver.get(webpage);
        driver.navigate().to(webpage);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    //xpath
    public static void logIn(String userName, String password) {
        WebElement form = driver.findElement(By.xpath("//i[@class=\"fa fa-user\"]"));

        Actions actionsClick = new Actions(driver);
        actionsClick.click(form).build().perform();

        driver.findElement(By.xpath(".//*[@id='Login']")).sendKeys(userName);
        driver.findElement(By.xpath(".//*[@id='Password']")).sendKeys(password);
        driver.findElement(By.xpath("//i[@class='fa fa-sign-in']")).click();
    }

    //css
    public static void logIn2(String userName, String password) {
        driver.findElementByCssSelector(".profile-photo").click();
        driver.findElementByCssSelector("#Login").sendKeys(userName);
        driver.findElementByCssSelector("#Password").sendKeys(password);
        driver.findElementByCssSelector("form .btn-login").click();
    }

    public static void initHP(WebDriver driver) {
        homePage = PageFactory.initElements(driver, HomePage.class);
    }


}
