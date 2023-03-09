package org.example.pagefactory;

import lombok.Getter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DemoLogin {

    private final WebDriver webDriver;
    private final JavascriptExecutor javascriptExecutor;

    @FindBy(id = "userName")
    private WebElement userNameElement;

    @FindBy(id = "password")
    private WebElement passwordElement;

    @Getter
    @FindBy(id = "login")
    private WebElement loginElement;

    @Getter
    @FindBy(xpath = "//*[@class='main-header']")
    private WebElement titleElement;

    @Getter
    @FindBy(xpath = "//*[@class='rt-tbody']//*[@class='rt-tr-group']")
    private List<WebElement> bookElements;

    public DemoLogin(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.javascriptExecutor = (JavascriptExecutor) webDriver;
        PageFactory.initElements(webDriver, this);
    }


    public void setUserName(String userName) {
        userNameElement.clear();

        if (userName != null || userName.equalsIgnoreCase("")) {
            userNameElement.sendKeys(userName);
        }
    }

    public void setPassword(String password) {
        passwordElement.clear();

        if (password != null || password.equalsIgnoreCase("")) {
            passwordElement.sendKeys(password);
        }
    }



}
