package testCases;


import org.apache.log4j.Logger;
import org.testng.annotations.*;
import pages.TCmainPage;
import pages.TCsearchResultPage;
import testBase.TestBase;


public class TestCase1 extends TestBase {

    private static Logger log  = Logger.getLogger(TestCase1.class.getName()); // logger object


    @Test
    public void test1() {

        log.info( "Test Case 1 ");


        TCmainPage TurkcellMainpage = new TCmainPage(driver);


        String searchText= "iPhone 12 64 GB";



        TCsearchResultPage TurkcellSearchResultPage =  TurkcellMainpage.searchItembyText(searchText).getTCsearchResultPage().goDevicesTab();

       


        TurkcellSearchResultPage.issSearchItemListed(searchText);



    }




}
