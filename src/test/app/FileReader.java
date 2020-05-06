package test.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileReader {

	public void listFilesForFolder(String filePath) {
		try (Stream<Path> walk = Files.walk(Paths.get(filePath))) {

			List<Path> result = walk.filter(Files::isRegularFile).filter(x -> x.toString().endsWith(".xlsx"))
					.map(Path::getFileName).collect(Collectors.toList());

			for (Path fileName : result) {
				System.out.println("File Name : " + fileName);
				String excelFilePath = filePath + fileName;

				FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
				XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
				XSSFSheet firstSheet = workbook.getSheetAt(0);
				Iterator<Row> iterator = firstSheet.iterator();

				while (iterator.hasNext()) {
					Row nextRow = iterator.next();
					Iterator<Cell> cellIterator = nextRow.cellIterator();

					while (cellIterator.hasNext()) {
						Cell nextCell = cellIterator.next();
						int columnIndex = nextCell.getColumnIndex();
//						System.out.println("columnIndex : " + columnIndex);
						switch (columnIndex) {
						case 1:
							break;
						case 2:
							break;
						case 3:
							break;
						case 4:
							
							String cellValue = nextCell.getStringCellValue();
							
							try {
								String response = ExtractbyteXML.extractBytes(cellValue);
								if (response.contains("63869278"))
								{
									System.out.println("Cell Value : " + cellValue);
									System.out.println("Response : " + response);
								}
								
							} catch (Exception e) {
								// TODO: handle exception
							}
							
							break;
						case 5:
//							System.out.println("Cell Value : " + nextCell.getStringCellValue());
							break;
						}
					}
				}
				workbook.close();
				inputStream.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		FileReader fileReader = new FileReader();
		String filePath = "D:\\TestCode\\";
		fileReader.listFilesForFolder(filePath);
	}
}
