import org.junit.jupiter.api.*;
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
@DisplayName("Тестирование полей раздела \"Рассрочка\"")
public class InstallmentTests {

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
        WebElement select2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button")));
        select2.click();
        WebElement selectInstalment = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[3]")));
        selectInstalment.click();
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
    @DisplayName("Проверка плейсхолдера у поля \"Номер счета\" в разделе \"Рассрочка\"")
    public void testPlaceholderInstalmentScore() {
        WebElement instalmentScore = wait.until(ExpectedConditions.elementToBeClickable(By.id("score-instalment")));
        String expectedPlaceholderInstalmentScore = "Номер счета на 44";
        assertEquals(expectedPlaceholderInstalmentScore, instalmentScore.getAttribute("placeholder"), "Атрибут 'Placeholder' не верный.");
    }

    @Test
    @DisplayName("Проверка лейбла валюты у поля \"Сумма\" в разделе \"Рассрочка\"")
    public void testInstalmentSumLabel() {
        WebElement instalmentSumLabel = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='instalment-sum']")));
        String expectedInstalmentSumLabel = "Руб.";
        assertEquals(expectedInstalmentSumLabel, instalmentSumLabel.getText(), "Текст лейбла не соответствует ожидаемому.");
    }

    @Test
    @DisplayName("Проверка плейсхолдера у поля \"Сумма\" в разделе \"Рассрочка\"")
    public void testPlaceholderInstalmentSum() {
        WebElement instalmentSum = wait.until(ExpectedConditions.elementToBeClickable(By.id("instalment-sum")));
        String expectedPlaceholderInstalmentSum = "Сумма";
        assertEquals(expectedPlaceholderInstalmentSum, instalmentSum.getAttribute("placeholder"), "Атрибут 'Placeholder' не верный.");
    }

    @Test
    @DisplayName("Проверка плейсхолдера у поля \"E-mail\" в разделе \"Рассрочка\"")
    public void testPlaceholderInstalmentEmail() {
        WebElement instalmentEmail = wait.until(ExpectedConditions.elementToBeClickable(By.id("instalment-email")));
        String expectedPlaceholderInstalmentEmail = "E-mail для отправки чека";
        assertEquals(expectedPlaceholderInstalmentEmail, instalmentEmail.getAttribute("placeholder"), "Атрибут 'Placeholder' не верный.");
    }
}



