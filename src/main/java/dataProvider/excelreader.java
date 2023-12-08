package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelreader {
	
	static XSSFWorkbook wb;
	public static Object[][] getDataFromSheet(String sheetname)
	{
		System.out.println("********Loading data from Excel************");
		Object [][] arr=null;
		
		try {
			// load excel
			//wb = new XSSFWorkbook(new FileInputStream(new File("./testdata1/data.xlsx")));
			wb = new XSSFWorkbook(new FileInputStream(new File(System.getProperty("user.dir")+"/testingdata/data.xlsx")));
			// load sheet
			XSSFSheet sh1 = wb.getSheet("Sheet1");
			// get rows
			int row = sh1.getPhysicalNumberOfRows();
			// get columns
			int col = sh1.getRow(0).getPhysicalNumberOfCells();
			
			
			arr = new Object[row][col]; // if no header
			 //arr = new Object[row-1][col]; // if any header
			for(int i=0;i<row;i++) // if no header then 0 else 1
			{
				for(int j=0;j<col;j++)
				{
					//arr[i][j]= wb.getSheet("Sheet1").getRow(i).getCell(j).getStringCellValue();
					arr[i][j]= getData(sheetname, i, j); // if no header
					//arr[i-1][j]= getData(sheetname, i, j); // if any header
				}
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Could not find the file"+ e.getMessage());
		} catch (IOException e) {
			System.out.println("Could not load the file"+ e.getMessage());
		}
		return arr;	
	}
	
	public static String getData(String sheetname, int row, int col)
	{
		XSSFCell cell=wb.getSheet(sheetname).getRow(row).getCell(col);
		//System.out.println(cell);
		String data="";
		if(cell.getCellType()==CellType.STRING) {
			data=cell.getStringCellValue();
		}
		else if(cell.getCellType()==CellType.NUMERIC) {
			double dataindouble=cell.getNumericCellValue();
			data=String.valueOf(dataindouble);
		}
		else if(cell.getCellType()==CellType.BLANK) {
			data="";
		}
		//System.out.println(data);
		return data;
		
	}
	

}
