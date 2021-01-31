package pages;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;




public class ProductDetailPage extends BasePage{


    private static Logger log  = Logger.getLogger(ProductDetailPage.class.getName()); // logger object

    public ProductDetailPage(WebDriver driver){

        this.driver = driver;
        init(driver);

    }
    private double TurkishDecimalConverter(String str_foundMonthlyInstallment){ // Turkish number notation to general US

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


    public void isDefaultMontlyInstallmentcompare(double montlyInstallment,int higher1_lower0)  {

        String str_foundMonthlyInstallment=actions.getTextofElement(By.xpath("(//span[@class='a-price-val'])[1]"));

        double foundMonthlyInstallment=TurkishDecimalConverter(str_foundMonthlyInstallment);


        log.info("founddefaultMonthlyInstallment is: "+foundMonthlyInstallment );



        if(higher1_lower0==1){

            validations.verifyIsTrue(foundMonthlyInstallment>montlyInstallment);

            log.info( "Higher" );
            log.info( "Test 3 is part_1 is passed" );
        }else{

            validations.verifyIsTrue(foundMonthlyInstallment<montlyInstallment);

            log.info( "Less" );
            log.info("Test 3 part_1 is passed  condition2-less");
        }



    }




    private double giveMontlyInstallment(int Month){
        try{
            By xpath =By.xpath("//*[(@title='"+Month+" AY')]");
            String dataAttribute="data-price";


            String amountSTR = actions.getAttributeofElement(xpath,dataAttribute);
            double dAmount=TurkishDecimalConverter(amountSTR);


            log.info( "Month: "+Month+", Installment: "+ dAmount);
            return dAmount;
        }catch( Exception e){
            log.error(e);
            return -1;
        }

    }


    public void checkInstallment6mhigherthan9m()  {



        boolean comparison=giveMontlyInstallment(6)>giveMontlyInstallment(9);

        Assert.assertTrue(comparison,"Error in comparison Test 3 part 2 is failed");
        log.info("6m vs 9m "+comparison);

        log.info( "6m Higher" );
        log.info( "Test 3 part 2 is passed" );



    }




}
