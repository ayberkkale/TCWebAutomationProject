package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BasePage {
    private final int defaultWait = 30;
    public WebDriverWait wait;

    public void init(WebDriver driver)  {


        wait = new WebDriverWait(driver, defaultWait);


    }


    public WebElement getElement(By by)  {

        return  wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement getElementPresence(By by)  {

        return  wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }





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




}
