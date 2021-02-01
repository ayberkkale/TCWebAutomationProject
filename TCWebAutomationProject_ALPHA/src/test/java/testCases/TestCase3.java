package testCases;


import org.apache.log4j.Logger;
import org.xml.sax.SAXException;
import pages.*;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import org.testng.annotations.Test;
import testBase.TestBase;


public class TestCase3 extends TestBase {
    private static Logger log  = Logger.getLogger(TestCase3.class.getName()); // logger object

    @Test
    public void test3() throws InterruptedException{



        log.info( "Test Case 3" );



        TCmainPage TurkcellMainpage = new TCmainPage(driver);


        PasajHomePage TCPasajHomePage =   TurkcellMainpage.navigatePasaj().getPasajHomePage();




        String BrandName="Macbook";
        String BrandName2="HP Bilgisayarlar";

        TCPasajHomePage.scrollEndofPage().navigatefooterlink(BrandName2);


        String SearchItem="Apple MacBook Pro Touch Bar 13 inç";
        String SearchItem2="HP Pavilion Gaming 15-dk0005nt";



        TCsearchResultPage TurkcellSearchResultPage = TCPasajHomePage.getTCsearchResultPage().navigateSearchItem(SearchItem2);



        ProductDetailPage  ProductDetail=  TurkcellSearchResultPage.getProductDetailPage();

        double montlyInstallment =1000;


        ProductDetail.isDefaultMontlyInstallmentcompare(montlyInstallment,AttributeConstants.COMPARE_FOR_LESS_THAN);


        ProductDetail.checkInstallment6mhigherthan9m();





    }
}
