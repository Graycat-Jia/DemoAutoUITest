package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public String baseURL = "https://server-cn.growatt.com/login";

    public WebDriver webDriver;

    public WebDriverWait webDriverWait;

    BasePage( WebDriver driver ){
        webDriver = driver;
        this.webDriverWait = new WebDriverWait(driver,10);
    }

    public void click(By by) {
        waitVisibility(by).click();
    }

    //Write Text
    public void writeText(By by, String text) {
        waitVisibility(by).sendKeys(text);
    }

    //Read Text
    public String readText(By by) {
        return waitVisibility(by).getText();
    }

    // Wait
    // 显示等待情况下，只有特定条件触发后，WebDriver才会继续执行后续操作。
    // 隐式等待情况下，WebDriver 等待一定时间，该时间段内，如果特定元素没加载成功，则抛出异常。
    public WebElement waitVisibility(By by) {
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public ServerLoginPage toServerLoginPage(){
        return new ServerLoginPage(this.webDriver);
    }

}
