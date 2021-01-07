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


public class TestCase3 {
    private static Logger log  = Logger.getLogger(TCmainPage.class.getName()); // logger object

    public static void main(String[] args) throws InterruptedException, IOException, SAXException, ParserConfigurationException {

        String driverExecutablePath = "src\\driver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverExecutablePath);
        PropertyConfigurator.configure("src\\main\\java\\resources\\log4j.properties");

        log.info( "Test Case 3" );

        WebDriver driver=new ChromeDriver();

        TCmainPage TurkcellMainpage = new TCmainPage(driver);
        PasajHomePage TCPasajHomePage = new PasajHomePage(driver);
        TCsearchResultPage TurkcellSearchResultPage = new TCsearchResultPage(driver);
        ProductDetailPage  ProductDetail= new ProductDetailPage(driver);


        TurkcellMainpage.navigatePasaj();

        TCPasajHomePage.scrollEndofPage();

        String BrandName="Macbook";

        TCPasajHomePage.navigatefooterlink(BrandName);


        String SearchItem="Apple MacBook Pro Touch Bar 13 inç";

        TurkcellSearchResultPage.navigateSearchItem(SearchItem);

        double montlyInstallment =1000;

        if(ProductDetail.isDefaultMontlyInstallmenthigherthan(montlyInstallment)){

            log.info( "Higher" );
            log.info( "Test 3 is passed_1" );
        }else{
            log.warn( "Less" );
            log.error("Test 3 is failed_1");
        }


        if(ProductDetail.checkInstallment6mhigherthan9m()){

            log.info( "6m Higher" );
            log.info( "Test 3 is passed_2" );
        }else{
            log.error( "Error 6m vs 9m comparison" );
            log.error("Test 3 is failed_2");
        }





        //Close browser instance
        ProductDetail.tearDown();

    }
}
