import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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
        public static void tearDown()  {
            driver.quit();
        }

        @Test
        @Order(1)
        public void testNumberField() {
            WebElement numberField = wait.until(ExpectedConditions.elementToBeClickable(By.id("connection-phone")));
            String actualPlaceNumber = numberField.getAttribute("placeholder");
            String expectedPlaceNumber = "Номер телефона";
            Assertions.assertTrue(actualPlaceNumber.equals(expectedPlaceNumber), "Атрибут 'Placeholder' не верный.");
        }
        @Test
        @Order(2)
        public void testSumField() {
            WebElement sumField = driver.findElement(By.id("connection-sum"));
            String actualPlaceSum = sumField.getAttribute("placeholder");
            String expectedPlaceSum = "Сумма";
            Assertions.assertTrue(actualPlaceSum.equals(expectedPlaceSum), "Атрибут 'Placeholder' не верный.");
        }
        @Test
        @Order(3)
        public void testEmailField() {
            WebElement emailField = driver.findElement(By.id("connection-email"));
            String actualPlaceEmail = emailField.getAttribute("placeholder");
            String expectedPlaceEmail = "E-mail для отправки чека";
            Assertions.assertTrue(actualPlaceEmail.equals(expectedPlaceEmail), "Атрибут 'Placeholder' не верный.");
        }
        @Test
        @Order(4)
        public void testNumberLabel() {
            WebElement numberLabel = driver.findElement(By.xpath("//label[@for='connection-phone']"));
            String actualPlaceNumberLabel = numberLabel.getText();
            String expectedPlaceNumberLabel = "+375";
            Assertions.assertTrue(actualPlaceNumberLabel.equals(expectedPlaceNumberLabel), "Атрибут 'Text' не верный.");
        }
        @Test
        @Order(5)
        public void testSumLabel() {
            WebElement sumLabel = driver.findElement(By.xpath("//label[@for='connection-sum']"));
            String actualPlaceSumLabel = sumLabel.getText();
            String expectedPlaceSumLabel = "Руб.";
            Assertions.assertTrue(actualPlaceSumLabel.equals(expectedPlaceSumLabel), "Атрибут 'Text' не верный.");
        }
    }

