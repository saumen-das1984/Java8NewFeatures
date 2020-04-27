package test.app;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class DataCompare {
	public void listFilesForFolder(String reqFilePath, String resFilePath) {
		HashMap<String, String> resDataMap = new HashMap<String, String>();
		HashMap<String, String> resRoomDataMap = new HashMap<String, String>();
		try (Stream<Path> walk = Files.walk(Paths.get(reqFilePath))) {

			List<Path> result = walk.filter(Files::isRegularFile).filter(x -> x.toString().endsWith(".xml"))
					.map(Path::getFileName).collect(Collectors.toList());

			Workbook book = new HSSFWorkbook();
			Sheet sheet = book.createSheet("BookingsData");

			// first row start with zero
			Row rowHeader = sheet.createRow(0);

			// we will write name and birthdates in two columns
			// name will be String and birthday would be Date
			// formatted as dd.mm.yyyy
			Cell testCaseID = rowHeader.createCell(0);
			testCaseID.setCellValue("TestCase No");

			Cell resID = rowHeader.createCell(1);
			resID.setCellValue("ReservationID");

			Cell roomID = rowHeader.createCell(2);
			roomID.setCellValue("RoomTypeID");

			Cell roomGuestCnt = rowHeader.createCell(3);
			roomGuestCnt.setCellValue("RoomTypeGuestCount");

			Cell totalAdultCnt = rowHeader.createCell(4);
			totalAdultCnt.setCellValue("TotalAdultCount");

			Cell totalChildCnt = rowHeader.createCell(5);
			totalChildCnt.setCellValue("TotalChildCount");

			Cell scrapperResId = rowHeader.createCell(7);
			scrapperResId.setCellValue("ScrapperResID");

			Cell scrapperRoomTypeId = rowHeader.createCell(8);
			scrapperRoomTypeId.setCellValue("ScrapperRoomTypeID");

			Cell scrapperRoomAdultCountId = rowHeader.createCell(9);
			scrapperRoomAdultCountId.setCellValue("ScrapperRoomAdultCount");

			Cell scrapperRoomChildCountId = rowHeader.createCell(10);
			scrapperRoomChildCountId.setCellValue("ScrapperRoomChildCount");

			Cell scrspperTotalAdultCnt = rowHeader.createCell(11);
			scrspperTotalAdultCnt.setCellValue("ScrapperTotalAdultCount");

			Cell scrspperTotalChildCnt = rowHeader.createCell(12);
			scrspperTotalChildCnt.setCellValue("ScrapperTotalChildCount");

			Cell testCaseStatus = rowHeader.createCell(14);
			testCaseStatus.setCellValue("Test Result");

			CellStyle style = book.createCellStyle();// Create style
			style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
			//style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
//			style.setBorderBottom(BorderStyle.THIN);
//			style.setBorderTop(BorderStyle.THIN);
//			style.setBorderRight(BorderStyle.THIN);
//			style.setBorderLeft(BorderStyle.THIN);

			Font font = book.createFont();// Create font
			font.setBold(true);// Make font bold
			style.setFont(font);// set it to bold

			CellStyle fontStyle = book.createCellStyle();// Create style
			font.setBold(true);// Make font bold
			fontStyle.setFont(font);// set it to bold

//			Font fontBold = book.createFont();// Create font
//			fontBold.setBold(true);// Make font bold
//			style.setFont(font);// set it to bold

			CellStyle borderStyle = book.createCellStyle();// Create style
			borderStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
//			borderStyle.setBorderBottom(BorderStyle.THIN);
//			borderStyle.setBorderTop(BorderStyle.THIN);
//			borderStyle.setBorderRight(BorderStyle.THIN);
//			borderStyle.setBorderLeft(BorderStyle.THIN);

			for (int cellCnt = 0; cellCnt < rowHeader.getLastCellNum(); cellCnt++) {// For each cell in the row

				try {
					rowHeader.getCell(cellCnt).setCellStyle(style);// Set the style
				} catch (Exception e) {
					System.out.println("CellCnt : " + cellCnt);
				}
			}

			boolean resCheckFlag = false;
			boolean resRoomCheckFlag = false;
			//boolean resStatusFlag = false;

			String xlsFilePath = "D:\\TestCode\\TCResult.xls";

			int rowCount = 1;
			int scrapperRowCunt = 1;
			int statusRowCnt = 1;
//
			for (Path fileName : result) {
				System.out.println("--------------- " + fileName + " ---------------");
				System.out.println("File Name : " + fileName);
				String testCaseNo = String.valueOf(fileName).split("\\.")[0];
				System.out.println("TestCase No : " + testCaseNo);
				String fileAbsPath = reqFilePath + fileName;
//				String xlsFilePath = fileAbsPath.replaceAll(".xml", ".xls");
				String content = new String(Files.readAllBytes(Paths.get(fileAbsPath)));
//				System.out.println("File Content : " + content);
				content = content.replaceAll("xmlns=\"[^\"]*\"", "");
//
//				File inputFile = new File(fileAbsPath);
				SAXReader reader = new SAXReader();
				Document document = reader.read(new ByteArrayInputStream(content.getBytes("UTF-8")));
//
//				System.out.println("Root element :" + document.getRootElement().getName());
				Element classElement = document.getRootElement();
				Node bookingRefNode = null;
				String bookingRefNumber = "";
				List<Node> roomNodes = document
						.selectNodes("/OTA_HotelResNotifRQ/HotelReservations/HotelReservation/RoomStays/RoomStay");

				if (roomNodes.size() == 0) {
					roomNodes = document.selectNodes(
							"/OTA_HotelResModifyNotifRQ/HotelResModifies/HotelResModify/RoomStays/RoomStay");
					bookingRefNode = document.selectSingleNode(
							"/OTA_HotelResModifyNotifRQ/HotelResModifies/HotelResModify/ResGlobalInfo/HotelReservationIDs/HotelReservationID");
					bookingRefNumber = bookingRefNode.valueOf("@ResID_Value");
				} else {
					bookingRefNode = document.selectSingleNode(
							"/OTA_HotelResNotifRQ/HotelReservations/HotelReservation/ResGlobalInfo/HotelReservationIDs/HotelReservationID");
					bookingRefNumber = bookingRefNode.valueOf("@ResID_Value");
				}

				String inpTotalAdultRefKey = "Input_" + bookingRefNumber + "_Total_Adult";
				String inpTotalChildRefKey = "Input_" + bookingRefNumber + "_Total_Child";
//				String scrapperTotalAdultRefKey = "Scrapper_" + bookingRefNumber + "_Total_Adult";
//				String scrapperTotalChildRefKey = "Scrapper_" + bookingRefNumber + "_Total_Child";
				System.out.println("Booking Reference Number : " + bookingRefNumber);
//				System.out.println("RoomNodes List : " + roomNodes.size());
//				Row rowData = null;
				int roomCnt = 1;
				for (Node roomNode : roomNodes) {
					Row rowData = sheet.createRow(rowCount);
					resID = rowData.createCell(1);
					testCaseID = rowData.createCell(0);

					if (roomCnt == 1) {
						testCaseID.setCellValue(testCaseNo);
//						rowData.getCell(0).setCellStyle(style);
						testCaseID.setCellStyle(fontStyle);
						resID.setCellValue(bookingRefNumber);
					}

					Element roomElem = (Element) roomNode;
//					System.out.println("Current Element :" + roomNode.getName());
					List<Node> guestNodes = roomElem.selectNodes("GuestCounts/GuestCount");
					List<Node> roomTypeNodes = roomElem.selectNodes("RoomTypes/RoomType");
					List<Node> roomRatesNodes = roomElem.selectNodes("RoomRates/RoomRate");
//					System.out.println("roomRatesNodes Size : " + roomRatesNodes.size());
					String ratePlanCode = roomRatesNodes.get(0).valueOf("@RatePlanCode");

					String roomTypeCode = roomTypeNodes.get(0).valueOf("@RoomTypeCode");
//					System.out.println("RoomType Code :" + roomTypeCode);
//					System.out.println("RatePlan Code :" + ratePlanCode);
					String roomCode = ratePlanCode + "|" + roomTypeCode;
					System.out.println("Room Code :" + roomCode);
					System.out.println("rowCunt : " + rowCount);
					String rmGuestKey = roomCode + "|" + roomCnt;

					roomID = rowData.createCell(2);
					roomID.setCellValue(roomCode);
					for (Node guestNode : guestNodes) {
						String roomTypeGuestCnt = guestNode.valueOf("@Count");
						System.out.println("Guest Count :" + roomTypeGuestCnt);
						roomGuestCnt = rowData.createCell(3);
						roomGuestCnt.setCellValue(roomTypeGuestCnt);
						resRoomDataMap.put(rmGuestKey, roomTypeGuestCnt);
					}
////					for (Iterator<Element> it = roomElem.elementIterator("Guest"); it.hasNext();) {
////						Element guestElem = it.next();
////						Node guestNode = guestElem.node(0);
////						System.out.println("\nGuest Count :" + guestNode.valueOf("@Count"));
////					}
					totalAdultCnt = rowData.createCell(4);
					totalChildCnt = rowData.createCell(5);
//
					if (roomCnt == 1) {
						int totalAdultCount = 0;
						int totalChildCount = 0;
//
						List<Node> resGuestNodes = document.selectNodes(
								"/OTA_HotelResModifyNotifRQ/HotelResModifies/HotelResModify/ResGlobalInfo/GuestCounts/GuestCount");

						if (resGuestNodes.size() == 0) {
							resGuestNodes = document.selectNodes(
									"/OTA_HotelResNotifRQ/HotelReservations/HotelReservation/ResGlobalInfo/GuestCounts/GuestCount");
						}
////						System.out.println("ResGuestNodes Size : " + resGuestNodes.size());
//
						for (Node resGuestNode : resGuestNodes) {
							String ageQualifyingCode = resGuestNode.valueOf("@AgeQualifyingCode");
							String resGuestCount = resGuestNode.valueOf("@Count");
							if ("10".equalsIgnoreCase(ageQualifyingCode)) {
								totalAdultCount = totalAdultCount + Integer.valueOf(resGuestCount);
							} else if ("8".equalsIgnoreCase(ageQualifyingCode)) {
								totalChildCount = totalChildCount + Integer.valueOf(resGuestCount);
							}
						}
//
						System.out.println("Total Adult Count : " + totalAdultCount);
						totalAdultCnt.setCellValue(String.valueOf(totalAdultCount));
						System.out.println("Total Child Count : " + totalChildCount);
						totalChildCnt.setCellValue(String.valueOf(totalChildCount));

						resDataMap.put(inpTotalAdultRefKey, String.valueOf(totalAdultCount));
						resDataMap.put(inpTotalChildRefKey, String.valueOf(totalChildCount));
					}
					
//					
					for (int cellCnt = 0; cellCnt < rowData.getLastCellNum(); cellCnt++) {// For each cell in the row
//						rowHeader.getCell(cellCnt).setCellStyle(style);// Set the style
//						if (cellCnt==0)
//						{
//							borderStyle.setFont(font);
//						}
//						else
//						{
//							font.setBold(false);
//							borderStyle.setFont(font);
//						}
						rowData.getCell(cellCnt).setCellStyle(borderStyle);// Set the style
					}
					roomCnt = roomCnt + 1;
					rowCount = rowCount + 1;
				}
//
//				// auto-resizing columns
				sheet.autoSizeColumn(1);

				String fileResPath = resFilePath + "Scrapper_" + fileName;

				String resContent = new String(Files.readAllBytes(Paths.get(fileResPath)));
//				System.out.println("File Content : " + resContent);
				resContent = resContent.replaceAll("xmlns=\"[^\"]*\"", "");

//				File outputFile = new File(fileResPath);
				reader = new SAXReader();
				document = reader.read(new ByteArrayInputStream(resContent.getBytes("UTF-8")));

//				System.out.println("Root element :" + document.getRootElement().getName());

//				Node bookingRefNode = null;
//				String bookingRefNumber = "";
				roomNodes = document
						.selectNodes("/OTA_HotelResNotifRQ/HotelReservations/HotelReservation/RoomStays/RoomStay");

				if (roomNodes.size() == 0) {
					roomNodes = document.selectNodes(
							"/OTA_HotelResModifyNotifRQ/HotelResModifies/HotelResModify/RoomStays/RoomStay");
					bookingRefNode = document.selectSingleNode(
							"/OTA_HotelResModifyNotifRQ/HotelResModifies/HotelResModify/ResGlobalInfo/HotelReservationIDs/HotelReservationID");
					bookingRefNumber = bookingRefNode.valueOf("@ResID_Value");
				} else {
					bookingRefNode = document.selectSingleNode(
							"/OTA_HotelResNotifRQ/HotelReservations/HotelReservation/ResGlobalInfo/HotelReservationIDs/HotelReservationId");
					bookingRefNumber = bookingRefNode.valueOf("@ResID_Value");
				}
				System.out.println("Booking Reference Number : " + bookingRefNumber);
				System.out.println("RoomNodes List : " + roomNodes.size());
				
				int totalAdultCount = 0;
				int totalChildCount = 0;
				roomCnt = 1;
//				Iterator<Row> rowIterator = sheet.iterator(); 
				for (Node roomNode : roomNodes) {
					System.out.println("scrapperRowCunt : " + scrapperRowCunt);
					Row rowData = sheet.getRow(scrapperRowCunt);
					try {
						

						resID = rowData.createCell(7);
						if (roomCnt == 1) {
							totalAdultCnt = rowData.createCell(11);
							totalChildCnt = rowData.createCell(12);
							resID.setCellValue(bookingRefNumber);
						} else {
							rowData.createCell(11);
							rowData.createCell(12);
						}
						Element roomElem = (Element) roomNode;
//						System.out.println("Current Element :" + roomNode.getName());
						List<Node> guestNodes = roomElem.selectNodes("GuestCounts/GuestCount");
						List<Node> roomTypeNodes = roomElem.selectNodes("RoomRates/RoomRate");
//						System.out.println("roomTypeNodes Size : " + roomTypeNodes.size());
						String roomTypeCode = roomTypeNodes.get(0).valueOf("@RoomTypeCode");
						System.out.println("RoomType Code :" + roomTypeCode);
						
						roomID = rowData.createCell(8);
						roomID.setCellValue(roomTypeCode);
						String roomTypeGuestCnt = "0";
						for (Node guestNode : guestNodes) {

							String ageQualifyingCode = guestNode.valueOf("@AgeQualifyingCode");
							String resGuestCount = guestNode.valueOf("@Count");

							if ("10".equalsIgnoreCase(ageQualifyingCode)) {
								roomGuestCnt = rowData.createCell(9);
								roomGuestCnt.setCellValue(resGuestCount);
								totalAdultCount = totalAdultCount + Integer.valueOf(resGuestCount);
								roomTypeGuestCnt = String
										.valueOf(Integer.valueOf(roomTypeGuestCnt) + Integer.valueOf(resGuestCount));
							} else if ("8".equalsIgnoreCase(ageQualifyingCode)) {
								totalChildCount = totalChildCount + Integer.valueOf(resGuestCount);
								roomGuestCnt = rowData.createCell(10);
								roomGuestCnt.setCellValue(resGuestCount);
								roomTypeGuestCnt = String
										.valueOf(Integer.valueOf(roomTypeGuestCnt) + Integer.valueOf(resGuestCount));
							}
//							String roomTypeGuestCnt = guestNode.valueOf("@Count");
//							System.out.println("Guest Count :" + roomTypeGuestCnt);

						}
						System.out.println("Room Guest Count :" + roomTypeGuestCnt);
						String chkRoomKey = roomTypeCode + "|" + roomCnt;
						if (resRoomDataMap.get(chkRoomKey).equalsIgnoreCase(roomTypeGuestCnt)) {
							resRoomCheckFlag = true;
						} else {
							resRoomCheckFlag = false;
						}
//						for (Iterator<Element> it = roomElem.elementIterator("Guest"); it.hasNext();) {
//							Element guestElem = it.next();
//							Node guestNode = guestElem.node(0);
//							System.out.println("\nGuest Count :" + guestNode.valueOf("@Count"));
//						}

						if (scrapperRowCunt == 1) {
							List<Node> resGuestNodes = document.selectNodes(
									"/OTA_HotelResModifyNotifRQ/HotelResModifies/HotelResModify/ResGlobalInfo/GuestCounts/GuestCount");

							if (resGuestNodes.size() == 0) {
								resGuestNodes = document.selectNodes(
										"/OTA_HotelResNotifRQ/HotelReservations/HotelReservation/ResGlobalInfo/GuestCounts/GuestCount");
							}
//							System.out.println("ResGuestNodes Size : " + resGuestNodes.size());

							for (Node resGuestNode : resGuestNodes) {
								String ageQualifyingCode = resGuestNode.valueOf("@AgeQualifyingCode");
								String resGuestCount = resGuestNode.valueOf("@Count");
								if ("10".equalsIgnoreCase(ageQualifyingCode)) {
									totalAdultCount = totalAdultCount + Integer.valueOf(resGuestCount);
								} else if ("8".equalsIgnoreCase(ageQualifyingCode)) {
									totalChildCount = totalChildCount + Integer.valueOf(resGuestCount);
								}
							}

						}

						for (int cellCnt = 0; cellCnt < rowData.getLastCellNum(); cellCnt++) {// For each cell in the
																								// row
//							rowHeader.getCell(cellCnt).setCellStyle(style);// Set the style
							try {
								rowData.getCell(cellCnt).setCellStyle(borderStyle);// Set the style
							} catch (Exception e) {
								// TODO: handle exception
							}

						}
						
					} catch (Exception e) {
						//scrapperRowCunt = scrapperRowCunt + 1;
						System.out.println("scrapperRowCunt Exception : " + scrapperRowCunt);
					}

					//if (roomCnt == 1) {
						totalAdultCnt.setCellValue(String.valueOf(totalAdultCount));
						totalChildCnt.setCellValue(String.valueOf(totalChildCount));
						System.out.println("Total Adult Count : " + totalAdultCount);
						System.out.println("Total Child Count : " + totalChildCount);
					//}
					roomCnt = roomCnt + 1;
					scrapperRowCunt = scrapperRowCunt + 1;
				}

				if (resDataMap.get(inpTotalAdultRefKey).equalsIgnoreCase(String.valueOf(totalAdultCount))
						&& resDataMap.get(inpTotalChildRefKey).equalsIgnoreCase(String.valueOf(totalChildCount))) {
					resCheckFlag = true;
				} else {
					resCheckFlag = false;
				}

				if (resCheckFlag && resRoomCheckFlag) {
					Row rowData = sheet.getRow(statusRowCnt);
					testCaseStatus = rowData.createCell(14);
					testCaseStatus.setCellValue("Pass");
//					testCaseStatus.setCellStyle(fontStyle);
					CellStyle backStyle = book.createCellStyle();// Create style
					backStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
					//backStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
					backStyle.setFont(font);
					testCaseStatus.setCellStyle(backStyle);
				} else {
					Row rowData = sheet.getRow(statusRowCnt);
					testCaseStatus = rowData.createCell(14);
					testCaseStatus.setCellValue("Fail");
					CellStyle backStyle = book.createCellStyle();// Create style
					backStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
					//backStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
					backStyle.setFont(font);
					testCaseStatus.setCellStyle(backStyle);
				}

//				System.out.println("resDataMap : " + resDataMap.get(inpTotalAdultRefKey));
//				System.out.println("resDataMap : " + resDataMap.get(inpTotalAdultRefKey));
				System.out.println("Total Guest Flag : " + resCheckFlag);
				System.out.println("Total Room Guest Flag : " + resRoomCheckFlag);

				scrapperRowCunt = scrapperRowCunt + 1;
				rowCount = rowCount + 1;
				statusRowCnt = rowCount;

				System.out.println("------------------------------");
			}

			// Now, its time to write content of Excel into File
			System.out.println("OutPut .xls File Path : " + xlsFilePath);
			book.write(new FileOutputStream(xlsFilePath));
			book.close();

		} catch (IOException e) {
			System.out.println("-------------IOException---------------");
			e.printStackTrace();
		} catch (DocumentException e) {
			System.out.println("-------------DocumentException---------------");
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		DataCompare dataCompare = new DataCompare();
		String inpFilePath = "D:\\TestCode\\";
		String scrapperFilePath = "D:\\ResultCode\\";
		dataCompare.listFilesForFolder(inpFilePath, scrapperFilePath);

	}
}
