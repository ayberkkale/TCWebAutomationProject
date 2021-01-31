package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class TCsearchResultPage extends BasePage {


    private static Logger log  = Logger.getLogger(TCsearchResultPage.class.getName()); // logger object

    public TCsearchResultPage(WebDriver driver){

        this.driver = driver;
        driver.manage().window().maximize();
        init(driver);
    }


    public TCsearchResultPage goDevicesTab(){
        try{

            actions.clickElement(By.xpath("//*[@title='Cihazlar']"));
            log.info("DevicesTab");
            return this;

        }catch (Exception e){
            log.error(e);
            return this;
        }


    }

    public void issSearchItemListed(String searchText)   {

        By xpath=By.xpath(" ((//span[@class='m-p-pc__title'and contains(text(), '"+searchText+"') ]))[last()]");
        validations.verifyElementTextEqualsText(xpath,searchText);

        log.info("Search Item "+searchText+" Is  Found");
        log.info( "Test 1 is passed" );


    }


    public TCsearchResultPage navigateSearchItem(String searchText)throws InterruptedException{

        try{

            actions.clickElement(By.xpath("(//span[contains(text(), '"+searchText+"')])[1]"));
            log.info("clicked "+searchText);
            return this;
        }catch ( Exception e){
            log.error(e);
            return this;
        }


    }





    public ProductDetailPage getProductDetailPage()  {


        return new ProductDetailPage(driver);
    }



}
