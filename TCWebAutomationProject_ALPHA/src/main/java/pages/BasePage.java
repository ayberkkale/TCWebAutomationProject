package pages;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;




public class BasePage {

    public Actions actions;
    public Validations validations;
    public static  WebDriver driver;
    public static Logger systemLog;
    private String className;



    public void init(WebDriver driver)  {

        this.driver=driver;

        actions = new Actions();
        validations = new Validations();




    }

    public void setClassNameforLogger(String className){

        this.className=className;
        systemLog = Logger.getLogger(className); // logger object

    }





}
