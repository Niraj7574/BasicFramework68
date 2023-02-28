package data;

import utilities.Xls_Reader;

public class DataFile {
Xls_Reader reader= new Xls_Reader("C:\\QA\\Testing\\wetransfer_build-xml_2022-12-03_2020\\NikulTest.xlsx");
	
	//Login Test
	public String emailWithSpecialChar = reader.getCellData("Data1", "UserName", 4);
	public String wrongEmail = reader.getCellData("Data1", "UserName", 3);
	public String wrongPassword = reader.getCellData("Data1", "Password", 2);
	public String specialCharErr = reader.getCellData("Data1", "Email Error", 5);
	public String emailErr = reader.getCellData("Data1", "Email Error", 4);
	public String passwordErr = reader.getCellData("Data1", "Password Error", 3);
	public String globalErr = reader.getCellData("Data1", "Global Error", 2);
	
	//Footer Test
	
	//Search Test
	
	//AddToCartTest
	
	//UserProfile
}
