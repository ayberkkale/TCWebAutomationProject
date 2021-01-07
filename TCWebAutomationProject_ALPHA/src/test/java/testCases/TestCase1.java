package testCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.TCmainPage;
import pages.TCsearchResultPage;

public class TestCase1 {

    private static Logger log  = Logger.getLogger(TCmainPage.class.getName()); // logger object

    public static void main(String[] args) throws InterruptedException {

        String driverExecutablePath = "src\\driver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverExecutablePath);

        PropertyConfigurator.configure("src\\main\\java\\resources\\log4j.properties");
        log.info( "Test Case 1 ");

        WebDriver driver=new ChromeDriver();

        TCmainPage TurkcellMainpage = new TCmainPage(driver);
        TCsearchResultPage TurkcellSearchResultPage = new TCsearchResultPage(driver);

        String searchText= "iPhone 12 64 GB";




        TurkcellMainpage.searchItembyText(searchText);
        TurkcellSearchResultPage.goDevicesTab();



        if(TurkcellSearchResultPage.issSearchItemListed(searchText)){
            log.info("Search Item "+searchText+" Is Found");
            log.info( "Test 1 is passed" );
        }else{
            log.warn("Not Found");
            log.error("Test 1 is failed");
        }



        //Close browser instance
        TurkcellSearchResultPage.tearDown();

    }




}
