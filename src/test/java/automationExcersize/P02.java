package automationExcersize;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P02{

    static WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() {

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com/'
        driver.get("http://automationexercise.com/");

        //3. Verify that home page is visible successfully
        WebElement homepage = driver.findElement(By.xpath("//*[@alt='Website for automation practice']"));
        Assert.assertTrue(homepage.isEnabled());

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@class='fa fa-lock']")).click();

        //5. Verify 'Login to your account' is visible
        driver.findElement(By.xpath("//h2[.='Login to your account']")).isDisplayed();

        //6. Enter incorrect email address and password
        driver.findElement(By.xpath("(//*[@type='email'])[1]")).sendKeys("mzgnesen@hotmail.com");
        driver.findElement(By.xpath("//*[@type='password']")).sendKeys("12344");

        //7. Click 'login' button
        driver.findElement(By.xpath("(//*[@class='btn btn-default'])[1]")).click();

        //8. Verify error 'Your email or password is incorrect!' is visible
        driver.findElement(By.xpath("//*[.='Your email or password is incorrect!']")).isDisplayed();
    }
}
