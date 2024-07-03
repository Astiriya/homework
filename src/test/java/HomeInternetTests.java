import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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
        public static void tearDown()  {
            driver.quit();
        }

        @Test
        @Order(1)
        public void testInternetPhoneLabel() {
            WebElement internetPhoneLabel = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='internet-phone']")));
            String actualPlaceInternetPhoneLabel = internetPhoneLabel.getText();
            String expectedPlaceInternetPhoneLabel = "+375";
            Assertions.assertTrue(actualPlaceInternetPhoneLabel.equals(expectedPlaceInternetPhoneLabel), "Атрибут 'Text' не верный.");
        }
        @Test
        @Order(2)
        public void testInternetPhone() {
            WebElement internetPhone = driver.findElement(By.id("internet-phone"));
            String actualPlaceInternetPhone = internetPhone.getAttribute("placeholder");
            String expectedPlaceInternetPhone = "Номер абонента";
            Assertions.assertTrue(actualPlaceInternetPhone.equals(expectedPlaceInternetPhone), "Атрибут 'Placeholder' не верный.");
        }
        @Test
        @Order(3)
        public void testInternetSum() {
            WebElement internetSum = driver.findElement(By.id("internet-sum"));
            String actualPlaceInternetSum = internetSum.getAttribute("placeholder");
            String expectedPlaceInternetSum = "Сумма";
            Assertions.assertTrue(actualPlaceInternetSum.equals(expectedPlaceInternetSum), "Атрибут 'Placeholder' не верный.");
        }
        @Test
        @Order(4)
        public void testInternetSumLabel() {
            WebElement internetSumLabel = driver.findElement(By.xpath("//label[@for='internet-sum']"));
            String actualPlaceInternetSumLabel = internetSumLabel.getText();
            String expectedPlaceInternetSumLabel = "Руб.";
            Assertions.assertTrue(actualPlaceInternetSumLabel.equals(expectedPlaceInternetSumLabel), "Атрибут 'Text' не верный.");
        }
        @Test
        @Order(5)
        public void testInternetEmail() {
            WebElement internetEmail = driver.findElement(By.id("internet-email"));
            String actualPlaceInternetEmail = internetEmail.getAttribute("placeholder");
            String expectedPlaceInternetEmail = "E-mail для отправки чека";
            Assertions.assertTrue(actualPlaceInternetEmail.equals(expectedPlaceInternetEmail), "Атрибут 'Placeholder' не верный.");
        }
    }