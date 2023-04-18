package generic_Utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class IRetryAnalyzerImplementationClass implements IRetryAnalyzer{
    int count=0,retryCount=4;
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		while(count<retryCount)
		{
			count++;
			return true;
		}
		return false;
	}
	
}
