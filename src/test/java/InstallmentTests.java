import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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
        public static void tearDown()  {
            driver.quit();
        }

        @Test
        @Order(1)
        public void testInstalmentScore() {
            WebElement instalmentScore = wait.until(ExpectedConditions.elementToBeClickable(By.id("score-instalment")));
            String actualPlaceInstalmentScore = instalmentScore.getAttribute("placeholder");
            String expectedPlaceInstalmentScore = "Номер счета на 44";
            Assertions.assertTrue(actualPlaceInstalmentScore.equals(expectedPlaceInstalmentScore), "Атрибут 'Placeholder' не верный.");
        }
        @Test
        @Order(2)
        public void testInstalmentSumLabel() {
            WebElement instalmentSumLabel = driver.findElement(By.xpath("//label[@for='instalment-sum']"));
            String actualPlaceInstalmentSumLabel = instalmentSumLabel.getText();
            String expectedPlaceInstalmentSumLabel = "Руб.";
            Assertions.assertTrue(actualPlaceInstalmentSumLabel.equals(expectedPlaceInstalmentSumLabel), "Атрибут 'Text' не верный.");
        }
        @Test
        @Order(3)
        public void testInstalmentSum() {
            WebElement instalmentSum = driver.findElement(By.id("instalment-sum"));
            String actualPlaceInstalmentSum = instalmentSum.getAttribute("placeholder");
            String expectedPlaceInstalmentSum = "Сумма";
            Assertions.assertTrue(actualPlaceInstalmentSum.equals(expectedPlaceInstalmentSum), "Атрибут 'Placeholder' не верный.");
        }
        @Test
        @Order(4)
        public void testInstalmentEmail() {
            WebElement instalmentEmail = driver.findElement(By.id("instalment-email"));
            String actualPlaceInstalmentEmail = instalmentEmail.getAttribute("placeholder");
            String expectedPlaceInstalmentEmail = "E-mail для отправки чека";
            Assertions.assertTrue(actualPlaceInstalmentEmail.equals(expectedPlaceInstalmentEmail), "Атрибут 'Placeholder' не верный.");
        }
    }



