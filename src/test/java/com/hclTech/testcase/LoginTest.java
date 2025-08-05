package com.hclTech.testcase;
 
import com.hclTech.elements.Login;
import com.hcltech.common.BrowserFactory;

import java.io.FileInputStream;
import java.io.IOException; 
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;
 
 
public class LoginTest extends BrowserFactory {
 
	@Test
	public void testLogin1() throws InterruptedException {
	    driver.get("https://www.saucedemo.com");
	    Login loginPage = new Login(driver);
	    loginPage.loginToApp("standard_user", "secret_sauce");
 
	    // Simple assertion: check if redirected to inventory page
	    String expectedUrl = "https://www.saucedemo.com/inventory.html";
	    Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Login failed or URL mismatch");
 
	    System.out.println("Login successful.");
	    Thread.sleep(5000);
	}
	@Test
	public void testInvalidLogin() {
	    driver.get("https://www.saucedemo.com");
	    Login loginPage = new Login(driver);
	    loginPage.loginToApp("nirmal", "nirmal@gowri");
 
	    // Assert that login failed by checking for error message or URL
	    String currentUrl = driver.getCurrentUrl();
	    Assert.assertNotEquals(currentUrl, "https://www.saucedemo.com/inventory.html", "Unexpected login success");
 
	    System.out.println("Login failed as expected.");
	}
	@Test
    public void runLoginTestsFromExcel() throws IOException {
        String excelFilePath = "C:\\Users\\raakeshravie.s\\eclipse-workspace\\SwagLabs\\Excel\\login_test_data.xlsx";
        FileInputStream fis = new FileInputStream(excelFilePath);

        try (Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheetAt(0);

            for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                Row row = sheet.getRow(rowIndex);
                if (row == null) continue;

                String username = row.getCell(0).toString();
                String password = row.getCell(1).toString();
                String expectedResult = row.getCell(2).toString();
                
                
                driver.get("https://www.saucedemo.com");
        	    Login loginPage = new Login(driver);
        	    loginPage.loginToApp(username, password);
        	    System.out.println(username+" & "+password+" is "+expectedResult);
            }
        }
    }
 
 
}