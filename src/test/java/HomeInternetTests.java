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

@DisplayName("Тестирование полей раздела \"Домашний интернет\"")
public class HomeInternetTests {

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
        WebElement select = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button")));
        select.click();
        WebElement selectInternet = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[2]")));
        selectInternet.click();
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
    @DisplayName("Проверка лейбла кода страны у поля \"Номер телефона\" в разделе \"Домашний интернет\"")
    public void testInternetPhoneLabel() {
        WebElement internetPhoneLabel = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='internet-phone']")));
        String expectedInternetPhoneLabel = "+375";
        assertEquals(expectedInternetPhoneLabel, internetPhoneLabel.getText(), "Текст лейбла не соответствует ожидаемому.");
    }

    @Test
    @DisplayName("Проверка плейсхолдера у поля \"Номер телефона\" в разделе \"Домашний интернет\"")
    public void testPlaceholderInternetPhone() {
        WebElement internetPhone = wait.until(ExpectedConditions.elementToBeClickable(By.id("internet-phone")));
        String expectedPlaceholderInternetPhone = "Номер абонента";
        assertEquals(expectedPlaceholderInternetPhone, internetPhone.getAttribute("placeholder"), "Атрибут 'Placeholder' не верный.");
    }

    @Test
    @DisplayName("Проверка плейсхолдера у поля \"Сумма\" в разделе \"Домашний интернет\"")
    public void testPlaceholderInternetSum() {
        WebElement internetSum = wait.until(ExpectedConditions.elementToBeClickable(By.id("internet-sum")));
        String expectedPlaceholderInternetSum = "Сумма";
        assertEquals(expectedPlaceholderInternetSum, internetSum.getAttribute("placeholder"), "Атрибут 'Placeholder' не верный.");
    }

    @Test
    @DisplayName("Проверка лейбла валюты у поля \"Сумма\" в разделе \"Домашний интернет\"")
    public void testInternetSumLabel() {
        WebElement internetSumLabel = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='internet-sum']")));
        String expectedInternetSumLabel = "Руб.";
        assertEquals(expectedInternetSumLabel, internetSumLabel.getText(), "Текст лейбла не соответствует ожидаемому.");
    }

    @Test
    @DisplayName("Проверка плейсхолдера у поля \"E-mail\" в разделе \"Домашний интернет\"")
    public void testPlaceholderInternetEmail() {
        WebElement internetEmail = wait.until(ExpectedConditions.elementToBeClickable(By.id("internet-email")));
        String expectedPlaceholderInternetEmail = "E-mail для отправки чека";
        assertEquals(expectedPlaceholderInternetEmail, internetEmail.getAttribute("placeholder"), "Атрибут 'Placeholder' не верный.");
    }
}