package automationExcersize;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class P01 {

    static WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void accountCreate() {

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement homepage = driver.findElement(By.xpath("//*[@alt='Website for automation practice']"));
        Assert.assertTrue(homepage.isEnabled());

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@class='fa fa-lock']")).click();

        //5. Verify 'New User Signup!' is visible
        WebElement newUserSignup = driver.findElement(By.xpath("//*[text()='New User Signup!']"));
        Assert.assertTrue(newUserSignup.isDisplayed());

        //6. Enter name and email address
        driver.findElement(By.xpath("//*[@placeholder='Name']")).sendKeys("Mizgin");
        driver.findElement(By.xpath("(//*[@placeholder='Email Address'])[2]")).sendKeys("mzgn_esen@hotmail.com");

        //7. Click 'Signup' button
        driver.findElement(By.xpath("(//*[@class='btn btn-default'])[2]")).click();

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement enterAccountInformation = driver.findElement(By.xpath("//*[@class='title text-center']"));
        Assert.assertTrue(enterAccountInformation.isDisplayed());

        //9. Fill details: Title, Name, Email, Password, Date of birth
        //10. Select checkbox 'Sign up for our newsletter!'
        //11. Select checkbox 'Receive special offers from our partners!'
        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        //13. Click 'Create Account button'
        driver.findElement(By.xpath("//*[@id='id_gender2']")).click();

        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("12345");

        WebElement day = driver.findElement(By.xpath("//select[@id='days']"));
        Select select1 = new Select(day);
        select1.selectByVisibleText("16");

        WebElement month = driver.findElement(By.xpath("//select[@id='months']"));
        Select select2 = new Select(month);
        select2.selectByVisibleText("November");

        WebElement year = driver.findElement(By.xpath("//select[@id='years']"));
        Select select3 = new Select(year);
        select3.selectByVisibleText("1997");

        driver.findElement(By.xpath("//select[@id='years']")).sendKeys(Keys.TAB, Keys.SPACE, Keys.TAB, Keys.SPACE,
                Keys.TAB, "Mizgin", Keys.TAB, "Esen", Keys.TAB, "Techpro", Keys.TAB, "Mecidiyeköy", Keys.TAB, "Şişli");

        WebElement country = driver.findElement(By.xpath("//select[@id='country']"));
        Select select4 = new Select(country);
        select4.selectByVisibleText("United States");

        driver.findElement(By.xpath("//*[@id='state']")).sendKeys("Türkiye",
                Keys.TAB, "İstanbul", Keys.TAB, "34000", Keys.TAB, "5415726246", Keys.TAB, Keys.ENTER);

        //14. Verify that 'ACCOUNT CREATED!' is visible
        driver.findElement(By.xpath("//*[@class='title text-center']")).isDisplayed();

        //15. Click 'Continue' button
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
        driver.navigate().back();
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();

        //16. Verify that 'Logged in as username' is visible
        driver.findElement(By.xpath("//*[@class='fa fa-user']")).isDisplayed();

    }

    @Test
    public void accountDelete() {

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement homepage = driver.findElement(By.xpath("//*[@alt='Website for automation practice']"));
        Assert.assertTrue(homepage.isEnabled());

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@class='fa fa-lock']")).click();

        //5. Verify 'Login to your account' is visible
        driver.findElement(By.xpath("//h2[.='Login to your account']")).isDisplayed();

        //6. Enter correct email address and password
        driver.findElement(By.xpath("(//*[@type='email'])[1]")).sendKeys("mzgn_esen@hotmail.com");
        driver.findElement(By.xpath("//*[@type='password']")).sendKeys("12345");

        //7. Click 'login' button
        driver.findElement(By.xpath("(//*[@class='btn btn-default'])[1]")).click();

        //8. Verify that 'Logged in as username' is visible
        driver.findElement(By.xpath("//*[@class='fa fa-user']")).isDisplayed();

        //9. Click 'Delete Account' button
        driver.findElement(By.xpath("//*[@class='fa fa-trash-o']")).click();

        //10. Verify that 'ACCOUNT DELETED!' is visible
        driver.findElement(By.xpath("//*[@class='title text-center']")).isDisplayed();
    }
}


