package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import utils.ExcelUtils;

import java.time.Duration;

public class LoginTest {

    @DataProvider(name = "loginData")
    public Object[][] loginDataProvider() {
        return ExcelUtils.getData("testdata/loginData.xlsx", "Sheet1");
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\karthiha\\OneDrive\\Desktop\\se files\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://example.com/login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        // Add assertion or success verification here if needed

        driver.quit();
    }
}
