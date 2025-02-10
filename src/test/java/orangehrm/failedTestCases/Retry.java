package orangehrm.failedTestCases;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

	private int count=0;
	private int max=3;
	
	@Override
	public boolean retry(ITestResult iTestResult) {
				
		if(!iTestResult.isSuccess()) {
			if(count<max) {
				count++;
				return true;
			}
		}
		return false;
	}
}
