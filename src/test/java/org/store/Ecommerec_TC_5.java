package org.store;

import org.testng.Assert;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class Ecommerec_TC_4 extends BaseClass {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        BaseClass b = new BaseClass();
        b.setupApp();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementById("com.androidsample.generalstore:id/spinnerCountry").click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Bangladesh\"))");
        // Another way to scroll a list
        //driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + Bangladesh + "\").instance(0))"));
        driver.findElementByXPath("//*[@text='Bangladesh']").click();
        driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Auntor");
        driver.hideKeyboard();
        driver.findElementById("com.androidsample.generalstore:id/radioMale").click();
        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"PG 3\"))");
        driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
        driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
        driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
        Thread.sleep(4000);

        int count = driver.findElementsById("com.androidsample.generalstore:id/productPrice").size();
        double sumOfProduct = 0;
        for (int i = 0; i < count; i++) {
            String amount = driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(i).getText();
            double productAmount = getAmount(amount);
            sumOfProduct += productAmount;
        }

        String total = driver.findElementById("com.androidsample.generalstore:id/totalAmountLbl").getText();
        double totalAmount = getAmount(total);

        Assert.assertEquals(sumOfProduct, totalAmount);
        System.out.println("Total: " + totalAmount);
        System.out.println("Total Product Amount: " + sumOfProduct);
        System.out.println("TC Execution Done");


    }

    public static double getAmount(String value) {
        value = value.substring(1);
        double productAmount = Double.parseDouble(value);
        return productAmount;
    }


}
