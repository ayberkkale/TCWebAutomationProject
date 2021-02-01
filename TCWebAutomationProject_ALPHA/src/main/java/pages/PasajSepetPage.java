package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class PasajSepetPage extends BasePage{



    public PasajSepetPage(WebDriver driver){

        this.driver = driver;
        init(driver);
        setClassNameforLogger(PasajSepetPage.class.getName());

    }


    public void checkNoItemInBasket(){
        By xpath=By.xpath(" //h3[text()='Sepetinizde ürün bulunmamaktadır.']");

        validations.verifyElementExists(xpath);

        systemLog.info("Test 2 is passed");
        systemLog.info("Sepetinizde ürün bulunmamaktadır Is  Found");




    }


}
