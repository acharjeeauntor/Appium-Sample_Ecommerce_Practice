package org.store;

import org.openqa.selenium.By;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class Ecommerce_TC_3 extends BaseClass {

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
        // Select Product
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()" + ".resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(" + "new UiSelector().text(\"PG 3\"));");
        int productCount = driver.findElementsById("com.androidsample.generalstore:id/productName").size();
        for (int i = 0; i < productCount; i++) {
            String productName = driver.findElementsById("com.androidsample.generalstore:id/productName").get(i).getText();
            if (productName.equals("PG 3")) {
                driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(i).click();
                break;
            }
        }
        driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
        Thread.sleep(5000);
        String expectedProductName = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
        Assert.assertEquals("PG 3",expectedProductName);
        System.out.println("TC execution Done");
    }
}
