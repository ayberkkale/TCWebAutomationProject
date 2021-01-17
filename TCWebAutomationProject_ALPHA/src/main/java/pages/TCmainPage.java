package pages;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.apache.log4j.Logger;

public class TCmainPage {

    private static Logger log  = Logger.getLogger(TCmainPage.class.getName()); // logger object

    protected static WebDriver driver;
    private int defaultWait=30;

    public TCmainPage(WebDriver driver){ // constructor
        PropertyConfigurator.configure("src\\main\\java\\resources\\log4j.properties");//log4j property location
        driver.get("https://www.turkcell.com.tr/");
        this.driver = driver;
    }



       public void searchItembyText(String searchText1)  {

        try{

            WebElement buttonSearch = new WebDriverWait(driver, defaultWait).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@title='Arama']")));


            buttonSearch.click();

            WebElement areaSearch = new WebDriverWait(driver, defaultWait).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@name='qx']")));

            areaSearch.click();


            areaSearch.sendKeys(searchText1);
            areaSearch.submit();
            log.info("Search Text Submitted");
        }catch ( Exception e){

            log.fatal("No search object");
            log.error(e);
        }


    }


    public void navigatePasaj() {

        try{
            WebElement buttonPasaj = new WebDriverWait(driver, defaultWait).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Pasaj']")));

            buttonPasaj.click();
            log.info("Clicked pasaj button");
        }catch( Exception e){
            log.fatal("Couldn't navigated");
            log.error(e);
        }



    }


    public void tearDown()  {

        try{
            driver.quit();
            log.trace("Driver closed");
        }catch( Exception e){

            log.fatal("Couldn't closed driver");
            log.error(e);
        }

    }
}
