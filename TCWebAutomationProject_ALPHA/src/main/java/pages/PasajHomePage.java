package pages;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;


public class PasajHomePage extends BasePage {


    protected static WebDriver driverPaHoPa;
    private int defaultWait=30;
    private static Logger log  = Logger.getLogger(TCmainPage.class.getName()); // logger object

    public PasajHomePage(WebDriver driver){

        this.driverPaHoPa = driver;
        init(driverPaHoPa);
    }


    public PasajHomePage navigateSepet() {


        try{
            clickElement(By.xpath("//a[@class='o-p-header__my-basket']"));

            log.info("Basket clicked");
            return this;
        }catch (Exception e){
            log.error(e);
            return this;
        }



    }


    public PasajHomePage scrollEndofPage() {
        try{


            driverPaHoPa.manage().window().maximize();

            WebElement bottomElement = getElement(By.xpath("//span[@class='o-p-footer__copyright']"));


            Actions builder = new Actions(driverPaHoPa);

            builder.moveToElement(bottomElement).perform();
            log.info("Scrolled end of page");
            return this;

        }catch( Exception e){
            log.error(e);
            return this;
        }


    }

    public PasajHomePage navigatefooterlink(String BrandName){
        try{
            String tempXpath= "(//a[contains(@title,'"+BrandName+"')])[1]";


            clickElement(By.xpath(tempXpath));

            log.info("Desired Footer link clicked by xpath: "+tempXpath);
            return this;

        }catch( Exception e){
            log.error(e);
            return this;
        }

    }





    public PasajSepetPage getPasajSepetPage()  {


        return new PasajSepetPage(driverPaHoPa);
    }

    public TCsearchResultPage getTCsearchResultPage()  {


        return new TCsearchResultPage(driverPaHoPa);
    }


}
