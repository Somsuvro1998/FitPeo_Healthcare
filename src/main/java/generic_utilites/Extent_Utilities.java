package generic_utilites;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extent_Utilities implements ITestListener{
	
	public ExtentSparkReporter reporter; //is used to set the report name and UI
	public ExtentReports report; //it is used to populate common information in the report
	public ExtentTest test; //it is used to provide and update status of the tests
	
	
	public void onStart(ITestContext context) {
		
		String date = new SimpleDateFormat("yyMMddhhmmss").format(new Date());
		reporter=new ExtentSparkReporter("ExtentReports/Report"+date+".html");
		reporter.config().setReportName("Automation Report");
		reporter.config().setDocumentTitle("FitPeo_Healthcare");
		reporter.config().setTheme(Theme.DARK);
		
		report=new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("Environment", "QA");
		report.setSystemInfo("Reporter", "Somsuvro Pal");
		report.setSystemInfo("OS", "Windows 11");
		
	}

	 public void onTestStart(ITestResult result) {
		 test=report.createTest(result.getName());
	 }

		
	 public void onTestSuccess(ITestResult result) {
            test.log(Status.PASS, result.getTestClass().getName());
            test.log(Status.PASS, result.getMethod().getMethodName());
            test.log(Status.PASS, result.getThrowable());
            
		  }

		
		  public void onTestFailure(ITestResult result) {
			test.log(Status.FAIL, result.getTestClass().getName());
            test.log(Status.FAIL, result.getMethod().getMethodName());
            test.log(Status.FAIL, result.getThrowable());
            
            String screenShot=null;
            try {
				screenShot=WebDriver_Utilities.takesScreenshot(Baseclass_FitPeo_Healthcare.screenshotdriver, result.getMethod().getMethodName());
			} catch (Throwable e) {
				e.printStackTrace();
			}
            test.addScreenCaptureFromPath(screenShot);
		  }

		  
		  public void onTestSkipped(ITestResult result) {
			test.log(Status.SKIP, result.getTestClass().getName());
		    test.log(Status.SKIP, result.getMethod().getMethodName());
		    test.log(Status.SKIP, result.getThrowable());
		  }
		  public void onFinish(ITestContext context) {
			    report.flush();
			  }

	

}
