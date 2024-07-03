import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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
        public static void tearDown()  {
            driver.quit();
        }

        @Test
        @Order(1)
        public void testArrearsSumLabel() {
            WebElement arrearsSumLabel = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='pay-arrears']/div[2]/label")));
            String actualPlaceArrearsSumLabel = arrearsSumLabel.getText();
            String expectedPlaceArrearsSumLabel = "Руб.";
            Assertions.assertTrue(actualPlaceArrearsSumLabel.equals(expectedPlaceArrearsSumLabel), "Атрибут 'Text' не верный.");
        }
        @Test
        @Order(2)
        public void testArrearsScore() {
            WebElement arrearsScore = driver.findElement(By.id("score-arrears"));
            String actualPlaceArrearsScore = arrearsScore.getAttribute("placeholder");
            String expectedPlaceArrearsScore = "Номер счета на 2073";
            Assertions.assertTrue(actualPlaceArrearsScore.equals(expectedPlaceArrearsScore), "Атрибут 'Placeholder' не верный.");
        }
        @Test
        @Order(3)
        public void testArrearsSum() {
            WebElement arrearsSum = driver.findElement(By.id("arrears-sum"));
            String actualPlaceArrearsSum = arrearsSum.getAttribute("placeholder");
            String expectedPlaceArrearsSum = "Сумма";
            Assertions.assertTrue(actualPlaceArrearsSum.equals(expectedPlaceArrearsSum), "Атрибут 'Placeholder' не верный.");
        }
        @Test
        @Order(4)
        public void testArrearsEmail() {
            WebElement arrearsEmail = driver.findElement(By.id("arrears-email"));
            String actualPlaceArrearsEmail = arrearsEmail.getAttribute("placeholder");
            String expectedPlaceArrearsEmail = "E-mail для отправки чека";
            Assertions.assertTrue(actualPlaceArrearsEmail.equals(expectedPlaceArrearsEmail), "Атрибут 'Placeholder' не верный.");
        }
    }


