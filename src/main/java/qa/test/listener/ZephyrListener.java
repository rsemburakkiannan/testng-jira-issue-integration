package qa.test.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import qa.test.annotation.JiraDetails;

public class ZephyrListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext testContext) {
        System.out.println("PASSED TEST CASES");
       testContext.getPassedTests().getAllResults()
                .forEach(iTestResult -> {
                    try {
                        JiraDetails jiraDetails = iTestResult.getTestClass().getRealClass().getMethod(iTestResult.getMethod().getMethodName()).getAnnotation(JiraDetails.class);
                        if (jiraDetails != null){
                            System.out.println(iTestResult.getTestClass().getName()+":"+iTestResult.getMethod().getMethodName()+"()=>"+ jiraDetails.issueId());
                        }
                    } catch (NoSuchMethodException e) { /* ignore if method not found */ }
                });

        System.out.println("FAILED TEST CASES");
        testContext.getFailedTests().getAllResults()
                .forEach(iTestResult -> {
                    try {
                        JiraDetails jiraDetails = iTestResult.getTestClass().getRealClass().getMethod(iTestResult.getMethod().getMethodName()).getAnnotation(JiraDetails.class);
                        if (jiraDetails != null){
                            System.out.println(iTestResult.getTestClass().getName()+":"+iTestResult.getMethod().getMethodName()+"()=>"+ jiraDetails.issueId());
                        }
                    } catch (NoSuchMethodException e) { /* ignore if method not found */ }
                });

        System.out.println("\nTest completed on: " + testContext.getEndDate().toString());
    }
}
