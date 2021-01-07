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

public class TCsearchResultPage {

    protected static WebDriver driver;
    private int defaultWait=30;
    private static Logger log  = Logger.getLogger(TCmainPage.class.getName()); // logger object

    public TCsearchResultPage(WebDriver driver){
        PropertyConfigurator.configure("src\\main\\java\\resources\\log4j.properties");
        this.driver = driver;
    }

    @BeforeTest
    public void goDevicesTab(){
        try{

            WebElement devicesTab = new WebDriverWait(driver, defaultWait).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@title='Cihazlar']")));

            devicesTab.click();



        }catch (Exception e){
            log.error(e);
        }


    }
    @Test
    public boolean issSearchItemListed(String searchText){



        boolean boolTemp=false;
        try{
            Thread.sleep(6000);


            List<WebElement> allInputElements = new WebDriverWait(driver, defaultWait).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("(//span[@class='m-p-pc__title'])")));



            if(allInputElements.size() != 0)
            {
                log.trace(allInputElements.size() + " Elements found \n");


                for(WebElement inputElement : allInputElements)
                {

                    String temp=inputElement.getText();

                    if(temp.equals(searchText)) {
                        log.trace(temp+ " is found and listed");
                        boolTemp=true;
                    }
                }
            }




            return boolTemp;

        }catch (Exception e){
            log.error(e);
            return false;
        }



    }
    @BeforeTest
    public void navigateSearchItem(String searchText)throws InterruptedException{

        try{
            Thread.sleep(3000);
            boolean boolTemp=false;
            List<WebElement> allInputElements = new WebDriverWait(driver, defaultWait*4).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("(//span[@class='m-p-pc__title'])")));


            int Counter=0;

            WebElement FirstElement=null;

            if(allInputElements.size() != 0)
            {


                for(WebElement inputElement : allInputElements)
                {

                    String temp=inputElement.getText();

                    if(temp.contains(searchText) && Counter==0) {
                        log.trace("Search item "+temp+ " is found ");
                        boolTemp=true;

                        FirstElement=inputElement;
                        Counter++;
                    }
                }
            }
            if(boolTemp){


                FirstElement.click();
                log.trace("Search item is clicked");



            }else{

                log.error("no listed item");
            }




        }catch ( Exception e){
            log.error(e);
        }


    }

    @AfterTest
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
