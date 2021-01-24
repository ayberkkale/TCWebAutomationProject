package testCases;


import pages.TCmainPage;
import pages.PasajHomePage;
import pages.PasajSepetPage;
import org.testng.annotations.Test;

public class TestCase2 extends TestBase {


    @Test
    public void test2()  throws InterruptedException {



        log.info( "Test Case 2" );


        TCmainPage TurkcellMainpage = new TCmainPage(driver);



        TurkcellMainpage.navigatePasaj();

        PasajHomePage TCPasajHomePage = TurkcellMainpage.getPasajHomePage();



        TCPasajHomePage.navigateSepet();

        PasajSepetPage PasajSepet = TCPasajHomePage.getPasajSepetPage();

        if(PasajSepet.checkNoItemInBasket()){
            log.info( "Sepette urun yok" );
            log.info( "Test 2 is passed" );
        }else{
            log.warn( "Item Available" );
            log.error("Test 2 is failed");
        }






    }
}
