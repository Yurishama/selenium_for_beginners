import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;


public class loginTest {

    private WebDriver driver;
    @Before
    public void setup(){

        System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://segundamano.mx");
        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);

    }

    @Test
    public void login_test() throws InterruptedException {

        WebElement login = driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div[3]/div/div/div[2]"));
        login.click();

        WebElement user = driver.findElement(By.name("login-email"));
        user.sendKeys("missqa.smmx@gmail.com");

        WebElement pass= driver.findElement(By.name("login-password"));
        pass.sendKeys("54321");

        //WebElement submitButton = driver.findElement(By.xpath("#login-button-submit>div>button"));
        WebElement button = driver.findElement(By.xpath("//*[@id=\"login-button-submit\"]/div/button"));

        //button.submit();
        button.submit();
        //button.click();
        Thread.sleep(500);

        assertEquals("Segundamano.mx - Compra y venta, anuncios clasificados de segundamano gratis",driver.getTitle());
        assertEquals("https://www.segundamano.mx/",driver.getCurrentUrl());


    }

    @After
    public void threadDown(){
        driver.quit();
    }
}
