package web.service;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTestCases {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/deepak/Downloads/chromedriver-mac-arm64 3/chromedriver");
        driver = new ChromeDriver();
        System.out.println("Driver info: " + driver);
        driver.manage().window().maximize();
    }

    @Test
    public void testLoginAndAnswerQuestions() {
        driver.get("http://127.0.0.1:8080/login");

        login("ahsan", "ahsan_pass", "05-01-1998");

        answerQuestion("5", "3", "8");

        answerQuestion("5", "3", "2");

        answerQuestion("5", "3", "15");

        Assert.assertEquals("http://127.0.0.1:8080/success", driver.getCurrentUrl());
    }
    
    @Test
    public void testIncorrectLoginCredentials() {
        driver.get("http://127.0.0.1:8080/login");

        login("incorrect_username", "incorrect_password", "05-01-1998");

        WebElement errorMessage = driver.findElement(By.xpath("//div[@class='error-message']"));
        Assert.assertTrue(errorMessage.isDisplayed());
    }

    @Test
    public void testEmptyValuesForLogin() {
        driver.get("http://127.0.0.1:8080/login");

        login("", "", "");

        WebElement errorMessage = driver.findElement(By.xpath("//div[@class='error-message']"));
        Assert.assertTrue(errorMessage.isDisplayed());
    }

    @Test
    public void testIncorrectValuesForQ1() {
        driver.get("http://127.0.0.1:8080/login");

        login("ahsan", "ahsan_pass", "05-01-1998");

        answerQuestion("abc", "3", "8");

        WebElement errorMessage = driver.findElement(By.xpath("//div[@class='error-message']"));
        Assert.assertTrue(errorMessage.isDisplayed());
    }

    @Test
    public void testIncorrectValuesForQ2() {
        driver.get("http://127.0.0.1:8080/login");

        login("ahsan", "ahsan_pass", "05-01-1998");

        answerQuestion("5", "xyz", "8");

        WebElement errorMessage = driver.findElement(By.xpath("//div[@class='error-message']"));
        Assert.assertTrue(errorMessage.isDisplayed());
    }

    @Test
    public void testIncorrectValuesForQ3() {
        driver.get("http://127.0.0.1:8080/login");

        login("ahsan", "ahsan_pass", "05-01-1998");

        answerQuestion("5", "3", "abcd");

        WebElement errorMessage = driver.findElement(By.xpath("//div[@class='error-message']"));
        Assert.assertTrue(errorMessage.isDisplayed());
    }

    private void login(String username, String password, String dob) {
        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("passwd"));
        WebElement dobInput = driver.findElement(By.id("dob"));
        WebElement submitButton = driver.findElement(By.xpath("/html/body/form/input[4]"));

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        dobInput.sendKeys(dob);

        submitButton.click();

        waitForPageLoad();
    }

    private void answerQuestion(String number1, String number2, String expectedResult) {
        WebElement number1Input = driver.findElement(By.name("number1"));
        WebElement number2Input = driver.findElement(By.name("number2"));
        WebElement resultInput = driver.findElement(By.name("result"));
        WebElement submitButton = driver.findElement(By.xpath("/html/body/form/input[4]"));

        number1Input.sendKeys(number1);
        number2Input.sendKeys(number2);
        resultInput.sendKeys(expectedResult);

        submitButton.click();

        waitForPageLoad();
    }

    private void waitForPageLoad() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
