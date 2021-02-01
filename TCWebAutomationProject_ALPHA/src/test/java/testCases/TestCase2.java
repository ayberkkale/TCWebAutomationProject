package testCases;


import org.apache.log4j.Logger;
import pages.TCmainPage;
import pages.PasajHomePage;
import pages.PasajSepetPage;
import org.testng.annotations.Test;
import testBase.TestBase;

public class TestCase2 extends TestBase {

    private static Logger log  = Logger.getLogger(TestCase2.class.getName()); // logger object
    @Test
    public void test2()   {



        log.info( "Test Case 2" );


        TCmainPage TurkcellMainpage = new TCmainPage(driver);



        PasajHomePage TCPasajHomePage = TurkcellMainpage.navigatePasaj().getPasajHomePage();



        PasajSepetPage PasajSepet = TCPasajHomePage.navigateSepet().getPasajSepetPage();

        PasajSepet.checkNoItemInBasket();







    }
}
