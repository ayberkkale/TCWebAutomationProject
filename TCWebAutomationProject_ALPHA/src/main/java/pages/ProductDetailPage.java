package pages;


import org.apache.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;



public class ProductDetailPage extends BasePage{

    protected static WebDriver driverPrDePa;
    private int defaultWait=30;
    private static Logger log  = Logger.getLogger(TCmainPage.class.getName()); // logger object

    public ProductDetailPage(WebDriver driver){

        this.driverPrDePa = driver;
        init(driverPrDePa);

    }
    private double TurkishDecimalConverter(String str_foundMonthlyInstallment){ // Turkish number notation to general

        int dot_temp= str_foundMonthlyInstallment.indexOf('.');
        int dot=1;
        int dot2=0;
        if(dot_temp>0){
            dot=dot_temp;
            dot2=dot_temp;
        }
        int comma= str_foundMonthlyInstallment.indexOf(',');
        str_foundMonthlyInstallment=str_foundMonthlyInstallment.substring(0,dot)+str_foundMonthlyInstallment.substring(dot2+1,comma);
        double answer= Double.parseDouble(str_foundMonthlyInstallment);
        return answer;
    }


    public void isDefaultMontlyInstallmentcompare(double montlyInstallment,int higher1_lower0) throws InterruptedException {

        String str_foundMonthlyInstallment=getTextofElement(By.xpath("//span[@class='a-price-val']"));

        double foundMonthlyInstallment=TurkishDecimalConverter(str_foundMonthlyInstallment);


        log.info("founddefaultMonthlyInstallment is: "+foundMonthlyInstallment );



        if(higher1_lower0==1){
            Assert.assertTrue(foundMonthlyInstallment>montlyInstallment ,"Test 3  is failed Expected Higher But Less");
            log.info( "Higher" );
            log.info( "Test 3 is part_1 is passed" );
        }else{
            Assert.assertTrue(foundMonthlyInstallment<montlyInstallment ,"Test 3  is failed Expected Lower But Higher");
            log.warn( "Less" );
            log.error("Test 3 part_1 is passed  condition2-less");
        }



    }






    private double giveMontlyInstallment(int Month){
        try{


            getElementPresence(By.xpath("(//span[@class='a-price-val'])[1]"));


            String monthSTR= "title=\""+Month+" AY\" data-price=\"";
            int monthStartIndex = driverPrDePa.getPageSource().indexOf(monthSTR);
            int strlengh=monthSTR.length();
            int startofAmount=driverPrDePa.getPageSource().indexOf('"',monthStartIndex+strlengh);
            String amountSTR= driverPrDePa.getPageSource().substring(monthStartIndex+strlengh,startofAmount);
            log.info( "Month: "+Month+", Installment: "+ TurkishDecimalConverter(amountSTR));
            return TurkishDecimalConverter(amountSTR);
        }catch( Exception e){
            log.error(e);
            return -1;
        }

    }


    public void checkInstallment6mhigherthan9m() throws InterruptedException, IOException {



        getElement(By.xpath("(//span[@class='a-price-val'])[last()]"));



        boolean answer=giveMontlyInstallment(6)>giveMontlyInstallment(9);

        Assert.assertTrue(answer,"Error in comparison Test 3 part 2 is failed");
        log.info("6m vs 9m "+answer);

        log.info( "6m Higher" );
        log.info( "Test 3 part 2 is passed" );
//
//            String filePath = "src\\Files\\pdpDOM.xml";
//            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
//            writer.write(driverPrDePa.getPageSource());
//            writer.close();
//            log.trace("DOM file saved");


    }





}
