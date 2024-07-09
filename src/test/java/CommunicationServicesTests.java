import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тестирование полей раздела \"Услуги связи\"")
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
        LogEntries browserLogs = driver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> allLogRows = browserLogs.getAll();

        if (!allLogRows.isEmpty()) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("browser_logs.txt", true))) {
                for (LogEntry logEntry : allLogRows) {
                    writer.write(logEntry.toString());
                    writer.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        driver.quit();
    }

    @Test
    @DisplayName("Проверка плейсхолдера у поля \"Номер телефона\" в разделе \"Услуги связи\"")
    public void testPlaceholderConnectionPhone() {
        WebElement connectionPhone = wait.until(ExpectedConditions.elementToBeClickable(By.id("connection-phone")));
        String expectedPlaceholderConnectionPhone = "Номер телефона";
        assertEquals(expectedPlaceholderConnectionPhone, connectionPhone.getAttribute("placeholder"), "Атрибут 'Placeholder' не верный.");
    }

    @Test
    @DisplayName("Проверка плейсхолдера у поля \"Сумма\" в разделе \"Услуги связи\"")
    public void testPlaceholderConnectionSum() {
        WebElement connectionSum = wait.until(ExpectedConditions.elementToBeClickable(By.id("connection-sum")));
        String expectedPlaceholderConnectionSum = "Сумма";
        assertEquals(expectedPlaceholderConnectionSum, connectionSum.getAttribute("placeholder"), "Атрибут 'Placeholder' не верный.");
    }

    @Test
    @DisplayName("Проверка плейсхолдера у поля \"E-mail\" в разделе \"Услуги связи\"")
    public void testPlaceholderConnectionEmail() {
        WebElement connectionEmail = wait.until(ExpectedConditions.elementToBeClickable(By.id("connection-email")));
        String expectedPlaceholderConnectionEmail = "E-mail для отправки чека";
        assertEquals(expectedPlaceholderConnectionEmail, connectionEmail.getAttribute("placeholder"), "Атрибут 'Placeholder' не верный.");
    }

    @Test
    @DisplayName("Проверка лейбла кода страны у поля \"Номер телефона\" в разделе \"Услуги связи\"")
    public void testConnectionPhoneLabel() {
        WebElement connectionPhoneLabel = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='connection-phone']")));
        String expectedConnectionPhoneLabel = "+375";
        assertEquals(expectedConnectionPhoneLabel, connectionPhoneLabel.getText(), "Текст лейбла не соответствует ожидаемому.");
    }

    @Test
    @DisplayName("Проверка лейбла валюты у поля \"Сумма\" в разделе \"Услуги связи\"")
    public void testConnectionSumLabel() {
        WebElement connectionSumLabel = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='connection-sum']")));
        String expectedConnectionSumLabel = "Руб.";
        assertEquals(expectedConnectionSumLabel, connectionSumLabel.getText(), "Текст лейбла не соответствует ожидаемому.");
    }
}

