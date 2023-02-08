package testcase;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import javax.xml.crypto.Data;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DebugCase {


    /** 软断言 */
    @Test(groups = "debug")
    public void testSoftAssert(){
        System.out.println("action begin.");
        //软断言使用前需实例化SoftAssert
        SoftAssert assertion = new SoftAssert();
        assertion.assertEquals(5, 6,"same or not ?");
        System.out.println("action finish");
        System.out.println("test");
        //这个必须放到最后，执行上面所有断言
        assertion.assertAll();
        System.out.println("test  1");
    }

    /** 硬断言 */
    @Test(groups = "debug")
    public void testAssert() throws Exception {

        System.out.println("当前时间戳："+ System.currentTimeMillis());
    }

    /** 测试魔方云接口用 */
    @Test(groups = "debug")
    public void test() throws Exception {
        // 修改postman:  1.sign  2. requestBody
        // 获取订单结果请求参数
        String requestBody = "{\"customerOrderNumber\":\"4548904386747\",\"sysOrderId\":\"\"}";
        // 出库产品序列号请求参数
//        String requestBody = "{}";
        String appSecret = "r8VERn7DJByqY1gyNW1jxd9Kcpp01WSYOHGp6SLc"; //填入相应的密钥
        String requestDateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        System.out.println(requestDateStr);
        StringBuilder sb = new StringBuilder();
        sb.append(requestBody).append(appSecret).append("2022-09-26 10:30:05");
        String content = sb.toString();
        System.out.println(MD5(content));
    }
    public final static String MD5(String content) {
        String newContent = null;
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            byte[] btInput = content.getBytes();
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(btInput);
            byte[] md = mdInst.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            newContent = new String(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newContent.toLowerCase();
    }





}
