package resources;

import org.testng.annotations.DataProvider;

public class Datatestcase {
	
	@DataProvider(name="InputData")
	public Object[] test()
	{
		Object[]name= new Object[2];
			name[0]="ajay";
		name[1]="vijay";
		
		return name;
		
	}
	

}
