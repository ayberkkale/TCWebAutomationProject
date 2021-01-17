package testCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.xml.sax.SAXException;
import pages.TCmainPage;
import pages.PasajHomePage;
import pages.TCsearchResultPage;
import pages.ProductDetailPage;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import org.testng.annotations.Test;


public class TestCase3 extends TestBase{


    @Test
    public void test3() throws InterruptedException, IOException, SAXException, ParserConfigurationException {



        log.info( "Test Case 3" );



        TCmainPage TurkcellMainpage = new TCmainPage(driver);
        PasajHomePage TCPasajHomePage = new PasajHomePage(driver);
        TCsearchResultPage TurkcellSearchResultPage = new TCsearchResultPage(driver);
        ProductDetailPage  ProductDetail= new ProductDetailPage(driver);


        TurkcellMainpage.navigatePasaj();

        TCPasajHomePage.scrollEndofPage();

        String BrandName="Macbook";
        String BrandName2="HP Bilgisayarlar";

        TCPasajHomePage.navigatefooterlink(BrandName);


        String SearchItem="Apple MacBook Pro Touch Bar 13 inç";
        String SearchItem2="HP Pavilion Gaming 15-dk0005nt";


        TurkcellSearchResultPage.navigateSearchItem(SearchItem);

        double montlyInstallment =1000;

        if(ProductDetail.isDefaultMontlyInstallmenthigherthan(montlyInstallment)){

            log.info( "Higher" );
            log.info( "Test 3 is passed_1" );
        }else{
            log.warn( "Less" );
            log.error("Test 3 is condition2-less");
        }


        if(ProductDetail.checkInstallment6mhigherthan9m()){

            log.info( "6m Higher" );
            log.info( "Test 3 is passed_2" );
        }else{
            log.error( "Error 6m vs 9m comparison" );
            log.error("Test 3 is failed_2");


        }




    }
}
