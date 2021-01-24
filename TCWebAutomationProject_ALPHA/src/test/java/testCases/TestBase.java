package testCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.TCmainPage;
import pages.TCsearchResultPage;

public class TestBase {

    protected static Logger log  = Logger.getLogger(TCmainPage.class.getName()); // logger object
    protected static  WebDriver driver;

    @BeforeSuite
    public void BeforeSuite(){

        String driverExecutablePath = "src\\driver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverExecutablePath);
        PropertyConfigurator.configure("src\\main\\java\\resources\\log4j.properties");


        log.info("BeforeSuite");
    }



    @BeforeMethod
    public void BeforeMethod(){

        log.info("BeforeMethod");

        driver=new ChromeDriver();
        driver.get("https://www.turkcell.com.tr/");
    }



    @AfterClass
    public void AfterClass(){

        log.info("AfterClass");
        driver.quit();
    }



}
