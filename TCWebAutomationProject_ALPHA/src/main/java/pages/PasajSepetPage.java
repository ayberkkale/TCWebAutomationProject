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

public class PasajSepetPage extends BasePage{

    protected static WebDriver driverPaSePa;
    private int defaultWait=30;
    private static Logger log  = Logger.getLogger(TCmainPage.class.getName()); // logger object

    public PasajSepetPage(WebDriver driver){

        this.driverPaSePa = driver;
        init(driver);
    }


    public void checkNoItemInBasket(){
        Assert.assertNotNull(getElement(By.xpath(" //h3[text()='Sepetinizde ürün bulunmamaktadır.']")),"Sepetinizde ürün bulunmamaktadır is not dipslayed");
        log.info("Test 2 is passed");
        log.info("Sepetinizde ürün bulunmamaktadır Is  Found");





    }


}
