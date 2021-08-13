package org.store;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class Ecommerce_TC_1 extends BaseClass {
    public static void main(String[] args) throws MalformedURLException {
        BaseClass b = new BaseClass();
        b.setupApp();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementById("com.androidsample.generalstore:id/spinnerCountry").click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Bangladesh\"))");
        // Another way to scroll a list
        //driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + Bangladesh + "\").instance(0))"));
        driver.findElementByXPath("//*[@text='Bangladesh']").click();
        driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Auntor");
        driver.hideKeyboard();
        driver.findElementById("com.androidsample.generalstore:id/radioMale").click();
        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
        System.out.println("TC execution Done");

    }

}
