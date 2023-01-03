package automationExcersize;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P03 {

   static WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void test02() {

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com/'
        driver.get("http://automationexercise.com/");

        //3. Verify that home page is visible successfully
        WebElement homepage = driver.findElement(By.xpath("//*[@alt='Website for automation practice']"));
        Assert.assertTrue(homepage.isEnabled());

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@class='fa fa-lock']")).click();

        //5. Verify 'Login to your account' is visible
        WebElement loginToYourAccount = driver.findElement(By.xpath("//h2[1]"));
        Assert.assertTrue(loginToYourAccount.isDisplayed());

        //6. Enter correct email address and password
        driver.findElement(By.xpath("//*[@type='email']")).sendKeys("mzgn_esen@hotmail.com");
        driver.findElement(By.xpath("//*[@type='password']")).sendKeys("12345");

        //7. Click 'login' button
        driver.findElement(By.xpath("//*[@type='submit']")).click();

        //8. Verify that 'Logged in as username' is visible
        WebElement logged = driver.findElement(By.xpath("//*[@class='fa fa-user']"));
        Assert.assertTrue(logged.isDisplayed());

        //9. Click 'Logout' button
        driver.findElement(By.xpath("//*[@class='fa fa-lock']")).click();

        //10. Verify that user is navigated to login page
        WebElement loginPage = driver.findElement(By.id("google_esf"));
        Assert.assertTrue(loginPage.isEnabled());

    }

}
