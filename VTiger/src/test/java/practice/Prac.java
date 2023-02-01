package practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Prac {

	public static void main(String[] args) throws Throwable
	{
		// TODO Auto-generated method stub
			FileInputStream efis=new FileInputStream("./src/test/resources/Emp_Detail.xlsx");
			Workbook book=WorkbookFactory.create(efis);
			Sheet sh=book.getSheet("emp");
			int rows=sh.getLastRowNum();
			int cels=sh.getRow(0).getLastCellNum();
			//System.out.println(cel);
			for(int i=0;i<rows;i++)
			{
				Row row=sh.getRow(i);
				for(int j=0;j<cels;j++)
				{
				
					Cell cel=row.getCell(j);
							switch(cel.getCellType())
							{
							case STRING:
								System.out.print(cel.getStringCellValue());
								break;
							case NUMERIC:
								System.out.print(cel.getNumericCellValue());
								break;
							}
					System.out.print(" ");
				}
				System.out.println();
			}
			
	}

}
