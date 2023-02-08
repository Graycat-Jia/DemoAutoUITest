package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.testng.annotations.Test;

public class LoginCase extends BaseCase{

    /** 正常登录server的一条用例 */
    @Test(groups = "ui_auto", priority = 0, description = "This is a testcase description for normal login.")
    public void validLoginServerCNTest(  ){
        loginPage.toLoginPage()
                .verifyUsernameAndPassword("test_auto","123456")
                .clickLoginButton();
//                .clickNoticeConfirmBtn();     // 通知协议确定
//                .click(By.id("yc_notice_cancel"));  //协议确定按钮
    }

    /** 密码错误的登录 */
    @Test(groups = "ui_auto",priority = 1, expectedExceptions = TimeoutException.class,
        description = "This is a testcase for wrong login.")
    public void invalidLoginServerCNTest(  ){
        loginPage.toLoginPage()
                .verifyUsernameAndPassword("test_auto","12345678")
                .clickLoginButton();
    }



    /** 常见元素定位方法 */
    @Test
    public void normalElementSelector(  ){
        By.id(" ");
        By.className(" ");
        By.linkText("");
        By.name(" ");
        By.cssSelector("");
        By.tagName(" ");
        By.xpath("");
    }

}
