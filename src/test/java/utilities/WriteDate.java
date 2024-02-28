package utilities;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class WriteDate {
	
	 static XSSFWorkbook wb = new XSSFWorkbook();
	 static XSSFSheet sh;
	 static XSSFRow row;
	 static FileOutputStream file;
	 static int count=1; //start from second row
	 
	public static void writeExcel(List<String> docs) throws IOException {
		file = new FileOutputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\excelOutput\\details.xlsx");
		sh=wb.createSheet("data");// creating sheet
		row=sh.createRow(0);//creating 1st position of row
		row.createCell(0).setCellValue("Doctor details");//setting the value for 1st cell in 1st row
		
		for(int i=0;i<docs.size();i++) {	
			row = sh.createRow(i + count);
			row.createCell(0).setCellValue(docs.get(i));			
		}
		
		wb.write(file);
	}
	
	public static void writeSurgerExcel(List<String> surgeries) throws IOException {
			file = new FileOutputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\excelOutput\\details.xlsx");
			// If the sheet doesn't exist (if writeDoctorDetails wasn't called), create it
	        if (sh == null)
	            sh = wb.createSheet("data");
	        
	        row=sh.getRow(0);//getting 1st position of row
	        row.createCell(1).setCellValue("Surgery names");//Setting the value in 2nd cell of 1st row
	        
	        // Write surgery names
	        for (int i = 0; i < surgeries.size(); i++) {
	            row = sh.getRow(i + count); // Get the existing row
	            if (row == null) {
	                row = sh.createRow(i + count); // Create a new row if it doesn't exist
	            }
	            row.createCell(1).setCellValue(surgeries.get(i));
	        }

	        //count += surgeries.size(); // Update the row count
	        wb.write(file);
	        wb.close();
	        file.close();

	}
	
}
