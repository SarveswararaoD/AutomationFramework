package vtiger_Practice;

import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class ReadDataCmdLineTest {
	
	@Test
	public void readData()
	{
		String Username=System.getProperty("username");
		//String pwd=System.getProperty("Password");
		System.out.println(Username);
		
		
	}

}
