package pages;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.apache.log4j.Logger;

public class TCmainPage extends BasePage{

    private static Logger log  = Logger.getLogger(TCmainPage.class.getName()); // logger object

    protected static WebDriver driver;
    private int defaultWait=30;

    public TCmainPage(WebDriver driver){ // constructor

        this.driver = driver;
        driver.manage().window().maximize();
        init(driver);
    }



       public void searchItembyText(String searchText1)  {

        try{

            clickElement(By.xpath("//*[@title='Arama']"));

            clickSendKeysAndSubmit(By.xpath("//*[@name='qx']"),searchText1);



            log.info("Search Text Submitted");
        }catch ( Exception e){

            log.fatal("No search object");
            log.error(e);
        }


    }


    public void navigatePasaj() {

        try{

            clickElement(By.xpath("//a[@title='Pasaj']"));

            log.info("Clicked pasaj button");
        }catch( Exception e){
            log.fatal("Couldn't navigated");
            log.error(e);
        }



    }




    public TCsearchResultPage getTCsearchResultPage()  {


        return new TCsearchResultPage(driver);
    }

    public PasajHomePage getPasajHomePage()  {


        return new PasajHomePage(driver);
    }


}
