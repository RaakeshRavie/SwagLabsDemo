package com.hclTech.common;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;
 
public class BrowserFactory {
    protected WebDriver driver;
 
    @Parameters("browser")
    @BeforeMethod
    public void setup(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver",
         		   "C:\\Users\\raakeshravie.s\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
            driver = new ChromeDriver();
            System.out.println("Chrome driver loader");
        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver",
					"C:\\Users\\raakeshravie.s\\Downloads\\edgedriver_win64\\msedgedriver.exe");
            driver = new EdgeDriver();
            System.out.println("Edge driver loader");
        }
        driver.manage().window().maximize();
    }
 
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
 
}
 