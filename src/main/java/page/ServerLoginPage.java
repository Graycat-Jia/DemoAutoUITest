package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page.BasePage;

public class ServerLoginPage extends BasePage {

    /** web element */
    private By userName = By.id("val_loginAccount");
    private By password = By.id("val_loginPwd");
    private By loginButton = By.className("hasColorBtn");
    private By noticeButtonConfirm = By.id("yc_notice_cancel");
//    private By loginValidCodeInput = By.id("val_loginValidCode");
//    private By loginValidCode = By.id("");

    public ServerLoginPage(WebDriver driver){
        super(driver);
    }


    public ServerLoginPage toLoginPage(){
        webDriver.get(baseURL);
        return this;
    }

    public MainPage loginToMainPage(){
        return new MainPage(this.webDriver);
    }

    public ServerLoginPage verifyUsernameAndPassword(String username, String password){
        writeText(userName,username);
        writeText(this.password,password);
        return this;
    }

    public ServerLoginPage clickLoginButton(){
        click(loginButton);
        try {
            Thread.sleep(1000);
//            System.out.println(webDriver.getCurrentUrl());
//            assert ( !webDriver.getCurrentUrl().equals("https://server-cn.growatt.com/login") );
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public ServerLoginPage clickNoticeConfirmBtn(){
        click(noticeButtonConfirm);
        return this;
    }

}
