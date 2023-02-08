package testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import page.BasePage;
import page.ServerLoginPage;

public class BaseCase {

    public WebDriver chromDriver;

    public BasePage basePage;

    public ServerLoginPage loginPage;

    /** 初始化配置，设置google浏览器的驱动程序  */
    @BeforeClass(groups = "ui_auto")
    public void initSource(){

        System.setProperty("webdriver.gecko.driver","C:\\Users\\grt-linweijia\\Desktop\\geckodriver.exe");

//        System.setProperty("webdriver.chrome.driver","C:\\Users\\grt-linweijia\\Desktop\\chromedriver104.exe");
        this.chromDriver = new FirefoxDriver();
    }

    @BeforeMethod(groups = "ui_auto")
    public void initPage(){
        loginPage = new ServerLoginPage(chromDriver);

    }

    @AfterClass(groups = "ui_auto")
    public void shutdownSource() throws InterruptedException {
        Thread.sleep(2000);
        chromDriver.quit();
    }

}
