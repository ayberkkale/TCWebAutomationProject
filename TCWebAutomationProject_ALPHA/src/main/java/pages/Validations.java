package pages;

import org.openqa.selenium.By;
import org.testng.Assert;

public class Validations extends ElementService{

    public void verifyElementTextEqualsText(By by,String searchText){

        Assert.assertEquals(getElement(by).getText(),searchText,"Search Item "+searchText+AttributeConstants.NOT_FOUND_MESSAGE);

    }

    public void verifyElementExists(By by){

        Assert.assertNotNull(getElement(by),by.toString()+AttributeConstants.NOT_FOUND_MESSAGE);

    }

    public void verifyIsTrue(Boolean condition){


        Assert.assertTrue(condition ,"Condition is false");



    }

}
