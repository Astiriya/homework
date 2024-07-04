import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        driver.quit();
    }

    @Test
    public void testPlaceholderInstalmentScore() {
        WebElement instalmentScore = wait.until(ExpectedConditions.elementToBeClickable(By.id("score-instalment")));
        String expectedPlaceholderInstalmentScore = "Номер счета на 44";
        assertEquals(expectedPlaceholderInstalmentScore, instalmentScore.getAttribute("placeholder"), "Атрибут 'Placeholder' не верный.");
    }

    @Test
    public void testInstalmentSumLabel() {
        WebElement instalmentSumLabel = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='instalment-sum']")));
        String expectedInstalmentSumLabel = "Руб.";
        assertEquals(expectedInstalmentSumLabel, instalmentSumLabel.getText(), "Текст лейбла не соответствует ожидаемому.");
    }

    @Test
    public void testPlaceholderInstalmentSum() {
        WebElement instalmentSum = wait.until(ExpectedConditions.elementToBeClickable(By.id("instalment-sum")));
        String expectedPlaceholderInstalmentSum = "Сумма";
        assertEquals(expectedPlaceholderInstalmentSum, instalmentSum.getAttribute("placeholder"), "Атрибут 'Placeholder' не верный.");
    }

    @Test
    public void testPlaceholderInstalmentEmail() {
        WebElement instalmentEmail = wait.until(ExpectedConditions.elementToBeClickable(By.id("instalment-email")));
        String expectedPlaceholderInstalmentEmail = "E-mail для отправки чека";
        assertEquals(expectedPlaceholderInstalmentEmail, instalmentEmail.getAttribute("placeholder"), "Атрибут 'Placeholder' не верный.");
    }
}



