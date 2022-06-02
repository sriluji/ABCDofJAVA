//package ExtentReport;
//
//import java.awt.List;
//import java.io.File;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.Map;
//
//import org.testng.IReporter;
//import org.testng.IResultMap;
//import org.testng.ISuite;
//import org.testng.ISuiteResult;
//import org.testng.ITestContext;
//import org.testng.ITestResult;
//import org.testng.xml.XmlSuite;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//
//public class ExtentReporterNG implements IReporter {
//	private ExtentReports extent;
//	public ExtentSparkReporter spark;
//
//
//	public void generateReport(java.util.List<XmlSuite> xmlSuites, java.util.List<ISuite> suites,
//			String outputDirectory) {
//		spark = new ExtentSparkReporter("outputDirectory + File.separator\r\n" + 
//				"				+ \"Extent.html\", true");
//		extent = new ExtentReports();
//
//		for (ISuite suite : suites) {
//			Map<String, ISuiteResult> result = suite.getResults();
//
//			for (ISuiteResult r : result.values()) {
//				ITestContext context = r.getTestContext();
//
//				buildTestNodes(context.getPassedTests(), Status.PASS);
//				buildTestNodes(context.getFailedTests(), Status.FAIL);
//				buildTestNodes(context.getSkippedTests(),Status.SKIP);
//			}
//		}
//
//		extent.flush();
//
//	}
//
//	private void buildTestNodes(IResultMap tests, Status status) {
//		ExtentTest test;
//
//		if (tests.size() > 0) {
//			for (ITestResult result : tests.getAllResults()) {
//				test = extent.createTest(result.getMethod().getMethodName());
//
//				test.setStartedTime(getTime(result.getStartMillis()));
//				test.setEndedTime(getTime(result.getEndMillis()));
//
//				for (String group : result.getMethod().getGroups())
//					test.assignCategory(group);
//
//				if (result.getThrowable() != null) {
//					test.log(status, result.getThrowable());
//				} else {
//					test.log(status, "Test " + status.toString().toLowerCase()
//							+ "ed");
//				}
//
//				
//			}
//		}
//	}
//
//	private Date getTime(long millis) {
//		Calendar calendar = Calendar.getInstance();
//		calendar.setTimeInMillis(millis);
//		return calendar.getTime();
//	}
//}
