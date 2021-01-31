package pages;


import org.openqa.selenium.WebDriver;




public class BasePage {

    public Actions actions;
    public Validations validations;
    public static  WebDriver driver;



    public void init(WebDriver driver)  {

        this.driver=driver;

        actions = new Actions();
        validations = new Validations();


    }



}
