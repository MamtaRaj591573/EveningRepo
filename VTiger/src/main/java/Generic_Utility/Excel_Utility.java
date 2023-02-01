package Generic_Utility;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility 
{
	public String getExcelData(String sheetname,int rownum,int cellnum) throws Throwable
	{
		FileInputStream efis=new FileInputStream("./src/test/resources/Jan5.xlsx");
		Workbook book=WorkbookFactory.create(efis);
		Sheet sh=book.getSheet(sheetname);
		Row row=sh.getRow(rownum);
		Cell cel=row.getCell(cellnum);
		String prddata=cel.getStringCellValue();
		return prddata;
		
	}

}
