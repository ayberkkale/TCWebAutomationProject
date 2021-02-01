package pages;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;



public class PasajHomePage extends BasePage {


    public PasajHomePage(WebDriver driver){

        this.driver = driver;
        init(driver);
        setClassNameforLogger(PasajHomePage.class.getName());
    }


    public PasajHomePage navigateSepet() {


        try{
            actions.clickElement(By.xpath("//a[@class='o-p-header__my-basket']"));

            systemLog.info("Basket clicked");
            return this;
        }catch (Exception e){
            systemLog.error(e);
            return this;
        }



    }


    public PasajHomePage scrollEndofPage() {
        try{

            actions.scrollEndofThePage();

            systemLog.info("Scrolled end of page");
            return this;

        }catch( Exception e){
            systemLog.error(e);
            return this;
        }


    }

    public PasajHomePage navigatefooterlink(String BrandName){
        try{
            String tempXpath= "(//a[contains(@title,'"+BrandName+"')])[1]";


            actions.clickElement(By.xpath(tempXpath));

            systemLog.info("Desired Footer link clicked by xpath: "+tempXpath);
            return this;

        }catch( Exception e){
            systemLog.error(e);
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
