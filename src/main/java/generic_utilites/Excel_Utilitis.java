package generic_utilites;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utilitis {
	
	public String getDataFormatterData(String sheetname, int rowNum, int cellNum) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/Test_Data.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetname);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		
		DataFormatter format=new DataFormatter();
		String excelData = format.formatCellValue(cell);
		return excelData;
	}

}
