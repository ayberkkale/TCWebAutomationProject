package pages;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class PasajSepetPage {

    protected static WebDriver driverPaSePa;
    private int defaultWait=30;
    private static Logger log  = Logger.getLogger(TCmainPage.class.getName()); // logger object

    public PasajSepetPage(WebDriver driver){
        PropertyConfigurator.configure("src\\main\\java\\resources\\log4j.properties");
        this.driverPaSePa = driver;
    }

    @Test
    public boolean checkNoItemInBasket(){
        boolean tempNoItem=false;
        try{
            String searchText="Sepetinizde ürün bulunmamaktadır.";

            List<WebElement> allInputElements = new WebDriverWait(driverPaSePa, defaultWait).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("h3")));


            if(allInputElements.size() != 0)
            {


                for(WebElement inputElement : allInputElements)
                {

                    String temp=inputElement.getText();

                    if(temp.equals(searchText)) {
                        log.trace(searchText+" is displayed");
                        tempNoItem=true;
                    }
                }
            }


            return tempNoItem;
        }catch (Exception e){

            log.error(e);
            return false;
        }




    }

    @AfterTest
    public void tearDown()  {

        try{
            driverPaSePa.quit();
        }catch( Exception e){
            log.error(e);
        }

    }
}
