package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.data.StudentRecord.Student;

public class ExcelUtils {
	
	private static final String NAME = "./data/Student.xlsx";

		public static void main(String[] args) {
			 ArrayList elements = new ArrayList();
			try {
				int count = 0;
			FileInputStream file = new FileInputStream(new File(NAME));
			Workbook workbook = new XSSFWorkbook(file);
			DataFormatter dataFormatter = new DataFormatter();
			Iterator<Sheet> sheets = workbook.sheetIterator();
			while(sheets.hasNext()) {
				Sheet sh = sheets.next();
				System.out.println("Sheet name is "+sh.getSheetName());
				System.out.println("---------");
				Iterator<Row> iterator = sh.iterator();
				while(iterator.hasNext()) {
					Row row = iterator.next();
					Iterator<Cell> cellIterator = row.iterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						String cellValue = dataFormatter.formatCellValue(cell);
					
						System.out.print(cellValue+"\t");
						
						if(count>=1) {
							elements.add(cellValue);	
						//	System.out.print(cellValue);
						}
						
					}
					if(count>=1) {
				String val1= String.valueOf(elements.get(0));
				Integer val2 = Integer.valueOf(String.valueOf(elements.get(1)));
				Integer val3 = Integer.valueOf(String.valueOf(elements.get(2)));
				Integer val4 = Integer.valueOf(String.valueOf(elements.get(3)));
				//System.out.println(val1 +"val1"+val2+"val1"+val3+"val1"+val4+"val1");
				
				
					Student student = new Student(val1,val2,val3,val4);
				
					}// itterating 
					elements.clear();
					count++;
					System.out.println();
				}
			}
				workbook.close();
				//Student student = new Student(null, count, count, count);
				System.out.print(Student.bestSci()+" " );
				System.out.print(Student.bestMath()+"  ");
				System.out.print(Student.bestLang());
				System.out.println(Student.percentile());

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		

	}

}