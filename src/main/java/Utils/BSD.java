package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BSD {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public BSD() {
    }

    public static void waitAndClose() {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException var1) {
            throw new RuntimeException(var1);
        }

        driver.quit();
    }

    public static void wait(int s) {
        try {
            Thread.sleep((long)(s * 1000));
        } catch (InterruptedException var2) {
            throw new RuntimeException(var2);
        }
    }

    static {
        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.WARNING);
        System.setProperty("webdriver.chrome.silentOutput", "true");
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30L));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30L));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30L));
    }
}
