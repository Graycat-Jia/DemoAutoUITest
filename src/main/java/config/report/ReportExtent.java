package config.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * @Author GrayCat.
 * @date 2022/01/12 10:51
 */
public class ReportExtent {
//    public static final ExtentReports extentReports = new ExtentReports();
    public static ExtentReports extent = new ExtentReports();

    public ExtentReports getExtentReports(){
        return extent;
    }


    @BeforeSuite
    public void reportInit(){
        System.out.println("action beforesuite,init report.");
        ExtentSparkReporter report = new ExtentSparkReporter("target/Report/Report.html");
        extent.attachReporter(report);
        extent.setSystemInfo("Auto-server-cn","server-cn with jenkins test");
        extent.setSystemInfo("Author","graycat.");
    }

    @AfterSuite
    public void reportCreate(){
        System.out.println(" action aftersuite，create report. ");
        extent.flush();
    }

}
