import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class googleSearchTest {
    private WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
    }
    @Test
    public void searchTest(){
        WebElement searchbox = driver.findElement(By.name("q"));

        searchbox.clear();
        searchbox.sendKeys("Brightcove");
        searchbox.submit();
        assertEquals("Brightcove - Buscar con Google",driver.getTitle());


    }
    @After
    public void exit(){
        driver.quit();
    }
}
