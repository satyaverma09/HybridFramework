package dataProvider;
import org.testng.annotations.DataProvider;

public class sampletestDDT {
	
	@DataProvider(name="LoginDetails")
	public Object[][] getData()
	{
		Object[][] arr= excelreader.getDataFromSheet("Sheet1");
		return arr;
	}

}
