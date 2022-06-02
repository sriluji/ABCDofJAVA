package Util;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class getExcelData {

			
		public static Object[][] getTestData() throws IOException {
			FileInputStream file=new FileInputStream("C:\\Users\\hr\\Desktop\\Sreelatha\\Java\\ABCD\\src\\main\\java\\Util\\TestData.xlsx");
			XSSFWorkbook book= new XSSFWorkbook(file);
			XSSFSheet sheet=book.getSheet("ABCDExcelData");
			int rowcount=sheet.getLastRowNum();
			int colcount=sheet.getRow(0).getLastCellNum();
			Object[][ ]data=new Object[rowcount][colcount];
			
			for (int i=0;i<rowcount;i++) {
				for(int j=0;j<colcount;j++) {
					data[i][j]=sheet.getRow(i+1).getCell(j).toString();
					//System.out.println(data[i][j]);
			}
			}
			return data;
		}
}
