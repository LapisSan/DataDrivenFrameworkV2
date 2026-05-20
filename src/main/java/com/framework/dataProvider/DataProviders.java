package com.framework.dataProvider;
import org.testng.annotations.DataProvider;
import com.framework.utilities.ExcelUtils;
public class DataProviders {
	@DataProvider(name = "loginData")
	public Object[][] getLoginData() {
		String path = System.getProperty("user.dir")+"src/test/resources/testData/TestData.xlsx";
		
		ExcelUtils excel = new ExcelUtils(path, "Login");
		
		int rows = excel.getRowCount();
		int cols = excel.getColumnCount();
		
		Object[][] data = new Object[rows][cols];
		
		for(int i=1;i<=rows;i++) {
			for(int j=0;j<cols;j++) {
				data[i-j][j] = excel.getCellData(i, j);
			}
		}
		return data;
	}

}
