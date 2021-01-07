package pages;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class ProductDetailPage {

    protected static WebDriver driverPrDePa;
    private int defaultWait=30;
    private static Logger log  = Logger.getLogger(TCmainPage.class.getName()); // logger object

    public ProductDetailPage(WebDriver driver){
        PropertyConfigurator.configure("src\\main\\java\\resources\\log4j.properties");
        this.driverPrDePa = driver;

    }
    @BeforeTest
    private double TurkishDecimalConverter(String str_foundMonthlyInstallment){ // Turkish number notation to general

        int dot= str_foundMonthlyInstallment.indexOf('.');
        int comma= str_foundMonthlyInstallment.indexOf(',');
        str_foundMonthlyInstallment=str_foundMonthlyInstallment.substring(0,dot)+str_foundMonthlyInstallment.substring(dot+1,comma);
        double answer= Double.parseDouble(str_foundMonthlyInstallment);
        return answer;
    }
    @Test
    public boolean isDefaultMontlyInstallmenthigherthan(double montlyInstallment){
        try{
            Thread.sleep(3000);
            WebElement installmentElement = new WebDriverWait(driverPrDePa, defaultWait*2).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='a-price-val']")));


            String str_foundMonthlyInstallment=installmentElement.getText();

            double foundMonthlyInstallment=TurkishDecimalConverter(str_foundMonthlyInstallment);

            log.trace("foundMonthlyInstallment "+foundMonthlyInstallment );
            return foundMonthlyInstallment>montlyInstallment ;

        }catch( Exception e){
            log.error(e);
            return false;
        }


    }


    private double giveMontlyInstallment(int Month){
        try{
            Thread.sleep(3000);
            String monthSTR= "title=\""+Month+" AY\" data-price=\"";
            int monthStartIndex = driverPrDePa.getPageSource().indexOf(monthSTR);
            int strlengh=monthSTR.length();
            int startofAmount=driverPrDePa.getPageSource().indexOf('"',monthStartIndex+strlengh);
            String amountSTR= driverPrDePa.getPageSource().substring(monthStartIndex+strlengh,startofAmount);
            log.trace( "Month: "+Month+", Installment: "+ TurkishDecimalConverter(amountSTR));
            return TurkishDecimalConverter(amountSTR);
        }catch( Exception e){
            log.error(e);
            return -1;
        }

    }

    @Test
    public boolean checkInstallment6mhigherthan9m()  {

        try{
             Thread.sleep(6000);

            WebDriver.Timeouts timeouts = driverPrDePa.manage().timeouts().implicitlyWait(defaultWait*2, TimeUnit.SECONDS);

            boolean answer=giveMontlyInstallment(6)>giveMontlyInstallment(9);
            log.trace("6m vs 9m "+answer);

            String filePath = "src\\Files\\pdpDOM.xml";
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(driverPrDePa.getPageSource());
            writer.close();
            log.trace("DOM file saved");

            return answer;
        }catch( Exception e){
            log.error(e);
            return false;
        }
    }


    @AfterTest
    public void tearDown()  {

        try{
            driverPrDePa.quit();
        }catch( Exception e){
            log.error(e);
        }

    }


}
