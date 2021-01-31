package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class Actions extends ElementService{


    public void clickElement(By by)  {

        getElement(by).click();


    }

    public void clickSendKeysAndSubmit(By by,String searchText1)  {


        WebElement areaSearch =  getElement(by);
        areaSearch.click();
        areaSearch.sendKeys(searchText1);
        areaSearch.submit();


    }

    public String getTextofElement(By by)  {


        String text =getElement(by).getText();

        return  text;
    }

    public void  scrollEndofThePage() {



        WebElement bottomElement = getElement(By.xpath("//span[@class='o-p-footer__copyright']"));


        org.openqa.selenium.interactions.Actions builder = new org.openqa.selenium.interactions.Actions(BasePage.driver);

        builder.moveToElement(bottomElement).perform();


    }

    public String getAttributeofElement(By by, String attribute){

        return getElement(by).getAttribute(attribute);

    }
}
