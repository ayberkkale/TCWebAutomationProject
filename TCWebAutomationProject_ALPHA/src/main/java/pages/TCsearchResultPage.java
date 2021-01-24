package pages;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class TCsearchResultPage extends BasePage {

    protected static WebDriver driver;
    private int defaultWait=30;
    private static Logger log  = Logger.getLogger(TCmainPage.class.getName()); // logger object

    public TCsearchResultPage(WebDriver driver){

        this.driver = driver;
        driver.manage().window().maximize();
        init(driver);
    }


    public void goDevicesTab(){
        try{

            clickElement(By.xpath("//*[@title='Cihazlar']"));



        }catch (Exception e){
            log.error(e);
        }


    }

    public void issSearchItemListed(String searchText)   {



        Assert.assertEquals(getElement(By.xpath(" ((//span[@class='m-p-pc__title'and contains(text(), '"+searchText+"') ]))[last()]")).getText(),searchText,"Search Item "+searchText+" Is Not Found");
        log.info("Search Item "+searchText+" Is  Found");


    }


    public void navigateSearchItem(String searchText)throws InterruptedException{

        try{

            clickElement(By.xpath("(//span[contains(text(), '"+searchText+"')])[1]"));


        }catch ( Exception e){
            log.error(e);
        }


    }





    public ProductDetailPage getProductDetailPage()  {


        return new ProductDetailPage(driver);
    }



}
