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
    public void testVisaLogo() {
        WebElement visaLogo = driver.findElement(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[2]/ul/li[1]/img"));
        WebElement VisaLogoOrig = driver.findElement(By.xpath("//img[@alt='Visa']"));
        Assertions.assertTrue(visaLogo.equals(VisaLogoOrig), "Логотип 'Visa' отсутствует на требуемом месте.");
    }

    @Test
    public void testVisaVerifiedByVisaLogo() {
        WebElement verifiedByVisaLogo = driver.findElement(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[2]/ul/li[2]/img"));
        WebElement verifiedByVisaLogoOrig = driver.findElement(By.xpath("//img[@alt='Verified By Visa']"));
        Assertions.assertTrue(verifiedByVisaLogo.equals(verifiedByVisaLogoOrig), "Логотип 'Verified By Visa' отсутствует на требуемом месте.");
    }

    @Test
    public void testMasterCardLogo() {
        WebElement masterCardLogo = driver.findElement(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[2]/ul/li[3]/img"));
        WebElement masterCardLogoOrig = driver.findElement(By.xpath("//img[@alt='MasterCard']"));
        Assertions.assertTrue(masterCardLogo.equals(masterCardLogoOrig), "Логотип 'MasterCard' отсутствует на требуемом месте.");
    }

    @Test
    public void testMasterCardSecureCodeLogo() {
        WebElement masterCardSecureCodeLogo = driver.findElement(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[2]/ul/li[4]/img"));
        WebElement masterCardSecureCodeLogoOrig = driver.findElement(By.xpath("//img[@alt='MasterCard Secure Code']"));
        Assertions.assertTrue(masterCardSecureCodeLogo.equals(masterCardSecureCodeLogoOrig), "Логотип 'MasterCardSecureCode' отсутствует на требуемом месте.");
    }

    @Test
    public void testBelcardLogo() {
        WebElement belcardLogo = driver.findElement(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[2]/ul/li[5]/img"));
        WebElement verifiedByVisaLogoOrig = driver.findElement(By.xpath("//img[@alt='Белкарт']"));
        Assertions.assertTrue(belcardLogo.equals(verifiedByVisaLogoOrig), "Логотип 'Belcard' отсутствует на требуемом месте.");

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
    public void testOnlinePaymentWithoutCommission() {
        WebElement phoneInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("connection-phone")));
        phoneInput.sendKeys("297777777");

        WebElement sumInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("connection-sum")));
        sumInput.sendKeys("100");

        WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("connection-email")));
        emailInput.sendKeys("ukuondzi@yandex.ru");

        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='pay-connection']/button")));
        continueButton.click();
        WebElement contentWrapper = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bepaid-iframe")));
        assertTrue(contentWrapper.isDisplayed(), "Окно с классом bepaid-iframe не появилось");
    }
}