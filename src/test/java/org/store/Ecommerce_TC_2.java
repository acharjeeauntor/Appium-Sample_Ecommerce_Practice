package org.store;

import org.testng.Assert;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class Ecommerce_TC_2 extends BaseClass {
    public static void main(String[] args) throws MalformedURLException {
        BaseClass b = new BaseClass();
        b.setupApp();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
        //name attribute for toast messages will have content
        String toastMessage = driver.findElementByXPath("//android.widget.Toast[1]").getAttribute("name");
        Assert.assertEquals("Please enter your name", toastMessage);
        System.out.println("TC execution Done");
    }
}
