package testCases;


import org.testng.Assert;
import org.testng.annotations.*;
import pages.TCmainPage;
import pages.TCsearchResultPage;


public class TestCase1 extends TestBase {




    @Test
    public void test1() throws InterruptedException {

        log.info( "Test Case 1 ");


        TCmainPage TurkcellMainpage = new TCmainPage(driver);


        String searchText= "iPhone 12 64 GB";


        TurkcellMainpage.searchItembyText(searchText);

        TCsearchResultPage TurkcellSearchResultPage = TurkcellMainpage.getTCsearchResultPage();

        TurkcellSearchResultPage.goDevicesTab();


        TurkcellSearchResultPage.issSearchItemListed(searchText);



    }




}
