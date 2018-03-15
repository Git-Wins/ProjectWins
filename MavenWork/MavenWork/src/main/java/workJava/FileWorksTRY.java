package workJava;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileWorksTRY {


	public static String[][] getSheet(String dataSheetName) throws IOException
	{
		String[][] data = null;

		FileInputStream fis = new FileInputStream("./data/"+dataSheetName+".xlsx");
		XSSFWorkbook wBook = new XSSFWorkbook(fis);
		XSSFSheet wSheet = wBook.getSheet("Sheet1");

		int rowCount = wSheet.getLastRowNum();
		System.out.println("RowCount: " +rowCount);

		int columnCount = wSheet.getRow(0).getLastCellNum();
		System.out.println("ColumnCount: " +columnCount);

		data = new String[rowCount][columnCount];

		for(int i=1;i<rowCount+1;i++)
		{
			XSSFRow row = wSheet.getRow(i);
			for(int j=0;j<columnCount;j++)
			{
				String cellVal = "";
				cellVal = row.getCell(j).getStringCellValue();
				// cellVal = wSheet.getRow(i).getCell(j).getStringCellValue() THIS IS WHAT HAPPENS ABOVE
				data[i-1][j] = cellVal;
			}
		}
		fis.close();
		wBook.close();
		return data;

	}
}
