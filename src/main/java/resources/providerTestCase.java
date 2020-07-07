package resources;

import org.testng.annotations.Test;

public class providerTestCase {

	
	@Test(dataProvider="InputData",dataProviderClass=Datatestcase.class)
	public void testdataresult(String s)
	{
	System.out.println(s);
		
	}
	
	
}
