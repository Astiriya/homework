import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DebtTests {

    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeAll
    static public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("http://mts.by");
        WebElement cookieAcceptButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[6]/main/div/div[2]/div/div[2]/button[3]")));
        cookieAcceptButton.click();
        WebElement select3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button")));
        select3.click();
        WebElement selectArrears = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[4]")));
        selectArrears.click();
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void testArrearsSumLabel() {
        WebElement arrearsSumLabel = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='pay-arrears']/div[2]/label")));
        String expectedArrearsSumLabel = "Руб.";
        assertEquals(expectedArrearsSumLabel, arrearsSumLabel.getText(), "Текст лейбла не соответствует ожидаемому.");
    }

    @Test
    public void testPlaceholderArrearsScore() {
        WebElement arrearsScore = wait.until(ExpectedConditions.elementToBeClickable(By.id("score-arrears")));
        String expectedPlaceholderArrearsScore = "Номер счета на 2073";
        assertEquals(expectedPlaceholderArrearsScore, arrearsScore.getAttribute("placeholder"), "Атрибут 'Placeholder' не верный.");
    }

    @Test
    public void testPlaceholderArrearsSum() {
        WebElement arrearsSum = wait.until(ExpectedConditions.elementToBeClickable(By.id("arrears-sum")));
        String expectedPlaceholderArrearsSum = "Сумма";
        assertEquals(expectedPlaceholderArrearsSum, arrearsSum.getAttribute("placeholder"), "Атрибут 'Placeholder' не верный.");
    }

    @Test
    public void testPlaceholderArrearsEmail() {
        WebElement arrearsEmail = wait.until(ExpectedConditions.elementToBeClickable(By.id("arrears-email")));
        String expectedPlaceholderArrearsEmail = "E-mail для отправки чека";
        assertEquals(expectedPlaceholderArrearsEmail, arrearsEmail.getAttribute("placeholder"), "Атрибут 'Placeholder' не верный.");
    }
}


