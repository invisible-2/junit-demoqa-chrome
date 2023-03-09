package org.example.tests;

import org.example.pom.DemoLogin;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class DemoqaLoginTest {
    private static WebDriver webDriver;
    private static final String USER_NAME = "daniel";
    private static final String USER_PASSWORD = "D@niel2003";
    private static final String URL_LOGIN = "https://demoqa.com/login";


    @BeforeClass
    public static void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "D:\\WebDrivers\\ChromeDriver\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @Test
    public void loginTest() throws InterruptedException {
        System.out.println("Start loginTest");
        webDriver.get(URL_LOGIN);

        DemoLogin login = new DemoLogin(webDriver);

        login.setUserName(USER_NAME);
        login.setPassword(USER_PASSWORD);

        new Actions(webDriver)
                .moveToElement(login.getLoginElement())
                .click()
                .perform();

        Thread.sleep(1000);


        
        String expected = "Profile";
        String actual = login.getTitleElement().getText();

        assertEquals(expected, actual);


        System.out.println("Finished test with success");
    }

    @AfterClass
    public static void quit() {
        webDriver.quit();
    }
}
