package testCases;


import org.testng.annotations.*;
import pages.TCmainPage;
import pages.TCsearchResultPage;


public class TestCase1 extends TestBase{




    @Test
    public void test1() throws InterruptedException {

        log.info( "Test Case 1 ");


        TCmainPage TurkcellMainpage = new TCmainPage(driver);


        String searchText= "iPhone 12 64 GB";


        TurkcellMainpage.searchItembyText(searchText);

        TCsearchResultPage TurkcellSearchResultPage = TurkcellMainpage.getTCsearchResultPage();

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
