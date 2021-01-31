package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;

public class TCmainPage extends BasePage{

   // private static Logger log  = Logger.getLogger(TCmainPage.class.getName()); // logger object




    public TCmainPage(WebDriver driver){ // constructor

        this.driver = driver;

        init(driver);
        Logs.initLogger(TCmainPage.class.getName());
    }



       public TCmainPage searchItembyText(String searchText1)  {

        try{

            actions.clickElement(By.xpath("//*[@title='Arama']"));

            actions.clickSendKeysAndSubmit(By.xpath("//*[@name='qx']"),searchText1);



            Logs.info("Search Text Submitted");

            return this;
        }catch ( Exception e){

           // Logs.fatal("No search object");
           // log.error(e);
            return this;
        }


    }


    public TCmainPage navigatePasaj() {

        try{

            actions.clickElement(By.xpath("//a[@title='Pasaj']"));

            Logs.info("Clicked pasaj button");
            return this;
        }catch( Exception e){
            //log.fatal("Couldn't navigated");
            //log.error(e);
            return this;
        }



    }




    public TCsearchResultPage getTCsearchResultPage()  {


        return new TCsearchResultPage(driver);
    }

    public PasajHomePage getPasajHomePage()  {


        return new PasajHomePage(driver);
    }


}
