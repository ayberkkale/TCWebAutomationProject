package testCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.TCmainPage;
import pages.PasajHomePage;
import pages.PasajSepetPage;

public class TestCase2 {
    private static Logger log  = Logger.getLogger(TCmainPage.class.getName()); // logger object

    public static void main(String[] args) throws InterruptedException {

        String driverExecutablePath = "src\\driver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverExecutablePath);
        PropertyConfigurator.configure("src\\main\\java\\resources\\log4j.properties");

        log.info( "Test Case 2" );

        WebDriver driver=new ChromeDriver();

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





        //Close browser instance
        PasajSepet.tearDown();

    }
}
