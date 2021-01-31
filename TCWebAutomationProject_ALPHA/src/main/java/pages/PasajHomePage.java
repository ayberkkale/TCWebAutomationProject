package pages;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;



public class PasajHomePage extends BasePage {


    private static Logger log  = Logger.getLogger(PasajHomePage.class.getName()); // logger object

    public PasajHomePage(WebDriver driver){

        this.driver = driver;
        init(driver);
    }


    public PasajHomePage navigateSepet() {


        try{
            actions.clickElement(By.xpath("//a[@class='o-p-header__my-basket']"));

            log.info("Basket clicked");
            return this;
        }catch (Exception e){
            log.error(e);
            return this;
        }



    }


    public PasajHomePage scrollEndofPage() {
        try{

            actions.scrollEndofThePage();

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


            actions.clickElement(By.xpath(tempXpath));

            log.info("Desired Footer link clicked by xpath: "+tempXpath);
            return this;

        }catch( Exception e){
            log.error(e);
            return this;
        }

    }



    public PasajSepetPage getPasajSepetPage()  {


        return new PasajSepetPage(driver);
    }

    public TCsearchResultPage getTCsearchResultPage()  {


        return new TCsearchResultPage(driver);
    }


}
