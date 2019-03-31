import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class TestKatalon {
    WebDriver driver;
    String nameId = "first-name";
    String lastnameId = "last-name";
    String genderxpath = "//*[@id=\"infoForm\"]/div[3]/div/div/label[2]";
    String dateofbirthId = "dob";
    String addressId = "address";
    String emailId = "email";
    String passwordId = "password";
    String companyId = "company";
    String commentId = "comment";
    String submitId = "submit";
    String roleId = "role";
    String firstNameErrorId = "first-name-error";

    @Before
    public void setUp() {

        System.setProperty("webdriver.gecko.driver",
                "src/resources/geckodriver.exe");

        driver = new FirefoxDriver();

        driver.manage().window().maximize();

        driver.get("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testValidUserRegistration() {
        //znajdź element do wpisania imienia
        WebElement nameField = driver.findElement(By.id(nameId));
        //kliknij pole, wyczyść i wpisz tekst "Karol"
        if (nameField.isDisplayed()) {
            nameField.click();
            nameField.clear();
            nameField.sendKeys("Karol");
            System.out.println("Wpisuję w pole o id: " + nameId + " wartość: Karol" );
        } else {
            Assert.fail();
        }
        WebElement lastnameField = driver.findElement(By.id(lastnameId));
        //kliknij pole, wyczyść i wpisz tekst "Karol"
        if (lastnameField.isDisplayed())
        lastnameField.click();
        lastnameField.clear();
        lastnameField.sendKeys("Kowalski");
        WebElement GenderField = driver.findElement(By.xpath(genderxpath));
        GenderField.click();
        WebElement dateodfbirthField = driver.findElement(By.id(dateofbirthId));
        //kliknij pole, wyczyść i wpisz datę urodzenia
        dateodfbirthField.click();
        dateodfbirthField.clear();
        dateodfbirthField.sendKeys("05/22/2010");
        WebElement addressField = driver.findElement(By.id(addressId));
        //kliknij pole, wyczyść i wpisz datę urodzenia
        addressField.click();
        addressField.clear();
        addressField.sendKeys("Prosta 51");
        WebElement emailField = driver.findElement(By.id(emailId));
        //kliknij pole, wyczyść i wpisz datę urodzenia
        emailField.click();
        emailField.clear();
        emailField.sendKeys("karol.kowalski@mailinator.com");
        WebElement passwordField = driver.findElement(By.id(passwordId));
        //kliknij pole, wyczyść i wpisz datę urodzenia
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys("Pass123");
        WebElement companyField = driver.findElement(By.id(companyId));
        //kliknij pole, wyczyść i wpisz datę urodzenia
        companyField.click();
        companyField.clear();
        companyField.sendKeys("Coders Lab");
        Select select = new Select(driver.findElement(By.id(roleId)));
        select.selectByVisibleText("QA");
        //wybranie opcji w selecie
        WebElement commentField = driver.findElement(By.id(commentId));
        //kliknij pole, wyczyść i wpisz datę urodzenia
        commentField.click();
        commentField.clear();
        commentField.sendKeys("To jest mój pierwszy automat testowy");
        WebElement submitButton = driver.findElement(By.id(submitId));
        //kliknij pole, wyczyść i wpisz datę urodzenia
        submitButton.submit();

    }
    @Test
    public void errorHandling(){
        //od razu klikamy na submit, żeby sprawdzić, czy pojawią się wiadomości walidacyjne
        WebElement submitButton = driver.findElement(By.id(submitId));
        //kliknij pole, wyczyść i wpisz datę urodzenia
        submitButton.click();

        WebElement firstNameErrorMessage = driver.findElement(By.id (firstNameErrorId));
        assertTrue(firstNameErrorMessage.isDisplayed());

    }


    @After
    public void tearDown() {
        //driver.quit();
    }
}
