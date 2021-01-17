package testCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.TCmainPage;
import pages.PasajHomePage;
import pages.PasajSepetPage;
import org.testng.annotations.Test;

public class TestCase2 extends TestBase {


    @Test
    public void test2()  throws InterruptedException {



        log.info( "Test Case 2" );


        TCmainPage TurkcellMainpage = new TCmainPage(driver);
        PasajHomePage TCPasajHomePage = new PasajHomePage(driver);
        PasajSepetPage PasajSepet = new PasajSepetPage(driver);


        TurkcellMainpage.navigatePasaj();
        TCPasajHomePage.navigateSepet();

        if(PasajSepet.checkNoItemInBasket()){
            log.info( "Sepette urun yok" );
            log.info( "Test 2 is passed" );
        }else{
            log.warn( "Item Available" );
            log.error("Test 2 is failed");
        }






    }
}
