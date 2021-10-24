package unicodeTech.Dummy;

import unicodeTech.Utility.ExcelFileReader;

public class ReadWriteXLSData {

	public static void main(String[] args) {

		ExcelFileReader data = new ExcelFileReader("./src/unicodeTech/TestData/TestData.xlsx");
		
		System.out.println(data.totalRow("ValidateUser"));
		System.out.println(data.totalColumn("ValidateUser"));
		System.out.println(data.getData("ValidateUser", 4, 1));
		data.setData("ValidateUser", 6, 0, "tanmay@unicodetechnologies.in");
		data.setData("ValidateUser", 6, 1, "tanmay11");
		
		
		int rows = data.totalRow("ValidateUser");
		int cols = data.totalColumn("ValidateUser");
		
		Object[][] myData = new Object[rows-1][cols];

		for(int row=1;row<rows;row++) {
			
			for(int col=0;col<cols;col++) {
				
				myData[row-1][col] = data.getData("ValidateUser", row, col);
			}
		}
		
		
		
		
		
	}

}
