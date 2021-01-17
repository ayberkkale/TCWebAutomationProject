package testCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.TCmainPage;
import pages.TCsearchResultPage;


public class TestCase1 extends TestBase{




    @Test
    public void test1() throws InterruptedException {

        log.info( "Test Case 1 ");



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




    }




}
