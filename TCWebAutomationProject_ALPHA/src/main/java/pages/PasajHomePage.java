package pages;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;


public class PasajHomePage {


    protected static WebDriver driverPaHoPa;
    private int defaultWait=30;
    private static Logger log  = Logger.getLogger(TCmainPage.class.getName()); // logger object

    public PasajHomePage(WebDriver driver){
        PropertyConfigurator.configure("src\\main\\java\\resources\\log4j.properties");
        this.driverPaHoPa = driver;
    }

    @BeforeTest
    public void navigateSepet() {


        try{
            WebElement basketElement = new WebDriverWait(driverPaHoPa, defaultWait).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='o-p-header__my-basket']")));
            basketElement.click();
            log.info("Basket clicked");
        }catch (Exception e){
            log.error(e);
        }



    }

    @BeforeTest
    public void scrollEndofPage() {
        try{


            driverPaHoPa.manage().window().maximize();

            WebElement bottomElement = new WebDriverWait(driverPaHoPa, defaultWait*2).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='o-p-footer__copyright']")));

            Actions builder = new Actions(driverPaHoPa);

            builder.moveToElement(bottomElement).perform();
            log.info("Scrolled end of page");

        }catch( Exception e){
            log.error(e);
        }


    }
    @BeforeTest
    public void navigatefooterlink(String BrandName){
        try{
            String tempXpath= "(//a[contains(@title,'"+BrandName+"')])[1]";
            Thread.sleep(3000);

            WebElement BrandElement = new WebDriverWait(driverPaHoPa, defaultWait*2).until(ExpectedConditions.elementToBeClickable(By.xpath(tempXpath)));

            BrandElement.click();
            log.trace("Desired Footer link clicked by xpath: "+tempXpath);

        }catch( Exception e){
            log.error(e);
        }

    }

    @AfterTest
    public void tearDown()  {

        try{
            driverPaHoPa.quit();
        }catch( Exception e){
            log.error(e);
        }

    }
}
