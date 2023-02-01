package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FirstAndSecondColData 
{

	public static void main(String[] args) throws Throwable
	{
		FileInputStream efis=new FileInputStream("./src/test/resources/Emp_Detail.xlsx");
		Workbook book=WorkbookFactory.create(efis);
		//Sheet sh=book.getSheet("emp");//using sheet name
		Sheet sh=book.getSheetAt(0);//using sheet index
	
		int rows=sh.getLastRowNum();
		int cols=sh.getRow(0).getLastCellNum();
		for(int i=0;i<=rows;i++)
		{
			Row row=sh.getRow(i);
			for(int j=0;j<cols-1;j++)
			{
				Cell cel=row.getCell(j);
				switch (cel.getCellType())
				{
				case STRING://if object is of String type
							System.out.print(cel.getStringCellValue());
							break;
				case NUMERIC: //if object is of type number
					System.out.print(cel.getNumericCellValue());
					break;
				
				}
				System.out.print(" ");
			}
			System.out.println();
		}
		

	}

}
