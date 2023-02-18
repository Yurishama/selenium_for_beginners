import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenPage {

    @Test
    public void test1(){
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");

        driver.quit();
    }

}
