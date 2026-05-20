package com.framework.utilities;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	Workbook workbook;
	Sheet sheet;

	public ExcelUtils(String path, String sheetName) {
		try {
			FileInputStream fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getRowCount() {
		return sheet.getLastRowNum();
	}

	public int getColumnCount() {
		return sheet.getRow(0).getLastCellNum();
	}

	public String getCellData(int row, int col) {
		DataFormatter formatter = new DataFormatter();
		return formatter.formatCellValue(sheet.getRow(row).getCell(col));
	}
}
