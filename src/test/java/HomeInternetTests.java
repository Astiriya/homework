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
        driver.quit();
    }

    @Test
    public void testInternetPhoneLabel() {
        WebElement internetPhoneLabel = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='internet-phone']")));
        String expectedInternetPhoneLabel = "+375";
        assertEquals(expectedInternetPhoneLabel, internetPhoneLabel.getText(), "Текст лейбла не соответствует ожидаемому.");
    }

    @Test
    public void testPlaceholderInternetPhone() {
        WebElement internetPhone = wait.until(ExpectedConditions.elementToBeClickable(By.id("internet-phone")));
        String expectedPlaceholderInternetPhone = "Номер абонента";
        assertEquals(expectedPlaceholderInternetPhone, internetPhone.getAttribute("placeholder"), "Атрибут 'Placeholder' не верный.");
    }

    @Test
    public void testPlaceholderInternetSum() {
        WebElement internetSum = wait.until(ExpectedConditions.elementToBeClickable(By.id("internet-sum")));
        String expectedPlaceholderInternetSum = "Сумма";
        assertEquals(expectedPlaceholderInternetSum, internetSum.getAttribute("placeholder"), "Атрибут 'Placeholder' не верный.");
    }

    @Test
    public void testInternetSumLabel() {
        WebElement internetSumLabel = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='internet-sum']")));
        String expectedInternetSumLabel = "Руб.";
        assertEquals(expectedInternetSumLabel, internetSumLabel.getText(), "Текст лейбла не соответствует ожидаемому.");
    }

    @Test
    public void testPlaceholderInternetEmail() {
        WebElement internetEmail = wait.until(ExpectedConditions.elementToBeClickable(By.id("internet-email")));
        String expectedPlaceholderInternetEmail = "E-mail для отправки чека";
        assertEquals(expectedPlaceholderInternetEmail, internetEmail.getAttribute("placeholder"), "Атрибут 'Placeholder' не верный.");
    }
}