import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
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
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Tests {

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
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testBlockTitle() {
        WebElement blockTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/h2")));
        String expectedText = "Онлайн пополнение\nбез комиссии";
        assertEquals(expectedText, blockTitle.getText());
    }

    @Test
    public void testOnlineRechargeLink() {
        WebElement moreDetailsLink = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/a"));
        assertTrue(moreDetailsLink.isDisplayed(), "Ссылка 'Подробнее о сервисе' не отображается на странице");
        String href = moreDetailsLink.getAttribute("href");
        assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", href,
                "Ссылка 'Подробнее о сервисе' ведет на неправильный URL");
    }

    @Test
    public void testVisaLogo() {
        WebElement visaLogo = driver.findElement(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[2]/ul/li[1]/img"));
        Assertions.assertNotNull(visaLogo, "Visa logo is not present on the page");
    }

    @Test
    public void testVisaVerifiedByVisaLogo() {
        WebElement verifiedByVisaLogo = driver.findElement(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[2]/ul/li[2]/img"));
        Assertions.assertNotNull(verifiedByVisaLogo, "Visa Verified By Visa logo is not present on the page");
    }

    @Test
    public void testMasterCardLogo() {
        WebElement masterCardLogo = driver.findElement(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[2]/ul/li[3]/img"));
        Assertions.assertNotNull(masterCardLogo, "MasterCard logo is not present on the page");
    }

    @Test
    public void testMasterCardSecureCodeLogo() {
        WebElement masterCardSecureCodeLogo = driver.findElement(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[2]/ul/li[4]/img"));
        Assertions.assertNotNull(masterCardSecureCodeLogo, "MasterCard Secure Code logo is not present on the page");
    }

    @Test
    public void testBelcardLogo() {
        WebElement belcardLogo = driver.findElement(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[2]/ul/li[5]/img"));
        Assertions.assertNotNull(belcardLogo, "Belcard logo is not present on the page");
    }

    @Test
    public void testOnlinePaymentWithoutCommission() {
        WebElement phoneInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("connection-phone")));
        phoneInput.sendKeys("297777777");

        WebElement sumInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("connection-sum")));
        sumInput.sendKeys("100");

        WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("connection-email")));
        emailInput.sendKeys("ukuondzi@yandex.ru");

        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='pay-connection']/button")));
        continueButton.click();

        WebElement modalWindow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("app-wrapper")));
        assertTrue(modalWindow.isDisplayed(), "Модальное окно не открылось после нажатия кнопки 'Продолжить'");
    }
}