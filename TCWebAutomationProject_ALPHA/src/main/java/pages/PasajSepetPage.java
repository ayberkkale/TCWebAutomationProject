package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class PasajSepetPage extends BasePage{


  private static Logger log  = Logger.getLogger(PasajSepetPage.class.getName()); // logger object

    public PasajSepetPage(WebDriver driver){

        this.driver = driver;
        init(driver);

    }


    public void checkNoItemInBasket(){
        By xpath=By.xpath(" //h3[text()='Sepetinizde ürün bulunmamaktadır.']");

        validations.verifyElementExists(xpath);

        log.info("Test 2 is passed");
        log.info("Sepetinizde ürün bulunmamaktadır Is  Found");




    }


}
