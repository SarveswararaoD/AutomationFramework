package generic_Utility;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
import java.util.Properties;
/** This class consists of generic methods for property file
 * 
 * @author D.Sarveswararao
 *
 */
public class Properties_Utility {
	/**
	 * This method is used to read data from property file
	 * @param key
	 * @return
	 * @throws Exception
	 */
public String readDataFromProperties(String key) throws Exception
{
	FileInputStream fisp=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
	Properties pObj=new Properties();
	pObj.load(fisp);
	String value=pObj.getProperty(key);
	return value;
	
}
}
