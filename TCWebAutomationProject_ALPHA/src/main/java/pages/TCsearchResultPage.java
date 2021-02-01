package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class TCsearchResultPage extends BasePage {




    public TCsearchResultPage(WebDriver driver){

        this.driver = driver;
        init(driver);
        setClassNameforLogger(TCsearchResultPage.class.getName());
    }


    public TCsearchResultPage goDevicesTab(){
        try{

            actions.clickElement(By.xpath("//*[@title='Cihazlar']"));
            systemLog.info("DevicesTab");
            return this;

        }catch (Exception e){
            systemLog.error(e);
            return this;
        }


    }

    public void issSearchItemListed(String searchText)   {

        By xpath=By.xpath(" ((//span[@class='m-p-pc__title'and contains(text(), '"+searchText+"') ]))[last()]");
        validations.verifyElementTextEqualsText(xpath,searchText);

        systemLog.info("Search Item "+searchText+" Is  Found");
        systemLog.info( "Test 1 is passed" );


    }


    public TCsearchResultPage navigateSearchItem(String searchText)throws InterruptedException{

        try{

            actions.clickElement(By.xpath("(//span[contains(text(), '"+searchText+"')])[1]"));
            systemLog.info("clicked "+searchText);
            return this;
        }catch ( Exception e){
            systemLog.error(e);
            return this;
        }


    }





    public ProductDetailPage getProductDetailPage()  {


        return new ProductDetailPage(driver);
    }



}
