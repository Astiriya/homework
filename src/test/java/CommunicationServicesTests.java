import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommunicationServicesTests {
    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeAll
    static public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        driver.get("http://mts.by");
        WebElement cookieAcceptButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[6]/main/div/div[2]/div/div[2]/button[3]")));
        cookieAcceptButton.click();
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void testPlaceholderConnectionPhone() {
        WebElement connectionPhone = wait.until(ExpectedConditions.elementToBeClickable(By.id("connection-phone")));
        String expectedPlaceholderConnectionPhone = "Номер телефона";
        assertEquals(expectedPlaceholderConnectionPhone, connectionPhone.getAttribute("placeholder"), "Атрибут 'Placeholder' не верный.");
    }

    @Test
    public void testPlaceholderConnectionSum() {
        WebElement connectionSum = wait.until(ExpectedConditions.elementToBeClickable(By.id("connection-sum")));
        String expectedPlaceholderConnectionSum = "Сумма";
        assertEquals(expectedPlaceholderConnectionSum, connectionSum.getAttribute("placeholder"), "Атрибут 'Placeholder' не верный.");
    }

    @Test
    public void testPlaceholderConnectionEmail() {
        WebElement connectionEmail = wait.until(ExpectedConditions.elementToBeClickable(By.id("connection-email")));
        String expectedPlaceholderConnectionEmail = "E-mail для отправки чека";
        assertEquals(expectedPlaceholderConnectionEmail, connectionEmail.getAttribute("placeholder"), "Атрибут 'Placeholder' не верный.");
    }

    @Test
    public void testConnectionPhoneLabel() {
        WebElement connectionPhoneLabel = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='connection-phone']")));
        String expectedConnectionPhoneLabel = "+375";
        assertEquals(expectedConnectionPhoneLabel, connectionPhoneLabel.getText(), "Текст лейбла не соответствует ожидаемому.");
    }

    @Test
    public void testConnectionSumLabel() {
        WebElement connectionSumLabel = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='connection-sum']")));
        String expectedConnectionSumLabel = "Руб.";
        assertEquals(expectedConnectionSumLabel, connectionSumLabel.getText(), "Текст лейбла не соответствует ожидаемому.");
    }
}

