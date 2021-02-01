package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;

public class TCmainPage extends BasePage{




    public TCmainPage(WebDriver driver){ // constructor

        this.driver = driver;

        init(driver);
        setClassNameforLogger(TCmainPage.class.getName());


    }



       public TCmainPage searchItembyText(String searchText1)  {

        try{

            actions.clickElement(By.xpath("//*[@title='Arama']"));

            actions.clickSendKeysAndSubmit(By.xpath("//*[@name='qx']"),searchText1);



            systemLog.info("Search Text Submitted");

            return this;
        }catch ( Exception e){

            systemLog.fatal("No search object");
            systemLog.error(e);
            return this;
        }


    }


    public TCmainPage navigatePasaj() {

        try{

            actions.clickElement(By.xpath("//a[@title='Pasaj']"));

            systemLog.info("Clicked pasaj button");
            return this;
        }catch( Exception e){
            systemLog.fatal("Couldn't navigated");
            systemLog.error(e);
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
