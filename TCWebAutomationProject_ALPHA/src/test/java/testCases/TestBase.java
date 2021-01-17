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


    @BeforeTest
    public void BeforeTest(){

        log.info("BeforeTest");

    }
    @BeforeClass
    public void BeforeClass(){

        log.info("BeforeClass");
    }
    @BeforeMethod
    public void BeforeMethod(){

        log.info("BeforeMethod");

        driver=new ChromeDriver();
    }

    @AfterMethod
    public void AfterMethod(){

        log.info("AfterMethod");

    }

    @AfterClass
    public void AfterClass(){

        log.info("AfterClass");
        driver.quit();
    }

    @AfterTest
    public void AfterTest(){

        log.info("AfterTest");
    }


    @AfterSuite
    public void AfterSuite(){

        log.info("AfterSuite");
    }



}