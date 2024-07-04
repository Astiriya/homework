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
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PaymentWindowsTests {

    private static WebDriver driver;
    private static WebDriverWait wait;

    private static final String phoneNumber = "297777777";
    private static final String sum = "100";
    String formattedSum = String.format(Locale.US, "%.2f", Double.parseDouble(sum));
    private static final String email = "ukuondzi@yandex.ru";

    private static void fillFormAndSubmit() {
        WebElement phoneInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("connection-phone")));
        phoneInput.sendKeys(phoneNumber);

        WebElement sumInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("connection-sum")));
        sumInput.sendKeys(sum);

        WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("connection-email")));
        emailInput.sendKeys(email);

        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='pay-connection']/button")));
        continueButton.click();
        WebElement contentWrapper = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bepaid-iframe")));
        assertTrue(contentWrapper.isDisplayed(), "Окно с классом bepaid-iframe не появилось");
        driver.switchTo().frame(contentWrapper);
    }

    @BeforeAll
    static public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        driver.get("http://mts.by/");
        WebElement cookieAcceptButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[6]/main/div/div[2]/div/div[2]/button[3]")));
        cookieAcceptButton.click();
        fillFormAndSubmit();
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void testPayDescriptionCostText() {
        WebElement payDescriptionCostText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pay-description__cost")));
        String expectedPayDescriptionCostText = formattedSum + " BYN";
        assertEquals(expectedPayDescriptionCostText, payDescriptionCostText.getText(), "Текст не соответствует ожидаемому.");
    }

    @Test
    public void testPaymentButtonText() {
        WebElement paymentButtonText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/button")));
        String expectedPaymentButtonText = "Оплатить " + formattedSum + " BYN";
        assertEquals(expectedPaymentButtonText, paymentButtonText.getText(), "Текст в кнопке оплаты не соответствует ожидаемому.");
    }

    @Test
    public void testPayDescriptionText() {
        WebElement payDescriptionText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pay-description__text")));
        String expectedPayDescriptionText = "Оплата: Услуги связи Номер:375" + phoneNumber;
        assertEquals(expectedPayDescriptionText, payDescriptionText.getText(), "Текст не соответствует ожидаемому.");
    }


    @Test
    public void testCardholderNameLabel() {
        WebElement cardholderNameLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[3]/app-input/div/div/div[1]/label")));
        String expectedCardholderNameLabel = "Имя держателя (как на карте)";
        assertEquals(expectedCardholderNameLabel, cardholderNameLabel.getText(), "Текст лейбла не соответствует ожидаемому.");
    }

    @Test
    public void testCardNumberLabel() {
        WebElement cardNumberLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[1]/label")));
        String expectedCardNumberLabel = "Номер карты";
        assertEquals(expectedCardNumberLabel, cardNumberLabel.getText(), "Текст лейбла не соответствует ожидаемому.");
    }

    @Test
    public void testCardValidityPeriodLabel() {
        WebElement cardValidityPeriodLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[1]/app-input/div/div/div[1]/label")));
        String expectedCardValidityPeriodLabel = "Срок действия";
        assertEquals(expectedCardValidityPeriodLabel, cardValidityPeriodLabel.getText(), "Текст лейбла не соответствует ожидаемому.");
    }

    @Test
    public void testCvcLabel() {
        WebElement cvcLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[3]/app-input/div/div/div[1]/label")));
        String expectedPlaceNumberLabel = "CVC";
        assertEquals(expectedPlaceNumberLabel, cvcLabel.getText(), "Текст лейбла не соответствует ожидаемому.");
    }

    @Test
    public void testMastercardLogo() {
        WebElement MastercardLogo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/img[1]")));
        WebElement MastercardLogoOrig = driver.findElement(By.xpath("//img[@src='assets/images/payment-icons/card-types/mastercard-system.svg']"));
        assertEquals(MastercardLogo, MastercardLogoOrig, "Логотип 'Mastercard' отсутствует на требуемом месте.");
    }

    @Test
    public void testVisaLogo() {
        WebElement VisaLogo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/img[2]")));
        WebElement VisaLogoOrig = driver.findElement(By.xpath("//img[@src='assets/images/payment-icons/card-types/visa-system.svg']"));
        assertEquals(VisaLogo, VisaLogoOrig, "Логотип 'Visa' отсутствует на требуемом месте.");
    }

    @Test
    public void testBelkartLogo() {
        WebElement BelkartLogo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/img[3]")));
        WebElement BelkartLogoOrig = driver.findElement(By.xpath("//img[@src='assets/images/payment-icons/card-types/belkart-system.svg']"));
        assertEquals(BelkartLogo, BelkartLogoOrig, "Логотип 'Belkart' отсутствует на требуемом месте.");
    }

    @Test
    public void testMirLogo() {
        WebElement MirLogo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/div/img[1]")));
        WebElement MirLogoOrig = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='assets/images/payment-icons/card-types/mir-system-ru.svg']")));
        assertEquals(MirLogo, MirLogoOrig, "Логотип 'Mir' отсутствует на требуемом месте.");
    }

    @Test
    public void testMaestroLogo() {
        WebElement MaestroLogo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/div/img[2]")));
        WebElement MaestroLogoOrig = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='assets/images/payment-icons/card-types/maestro-system.svg']")));
        assertEquals(MaestroLogo, MaestroLogoOrig, "Логотип 'Maestro' отсутствует на требуемом месте.");
    }


}


