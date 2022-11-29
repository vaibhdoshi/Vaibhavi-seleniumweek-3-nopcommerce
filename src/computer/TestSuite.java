package computer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class TestSuite extends Utility {

    String baseUrl = "https://demo.nopcommerce.com";

    @Before

    public void setUp() {

        openBrowser(baseUrl);
    }

    @Test

    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {
        //Click on Computer Menu
        clickOnElement(By.partialLinkText("Computers"));
        //Click on Desktop
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/h2[1]/a[1]"));
        //Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: Z to A");
        Thread.sleep(2000);
        //Verify the Product will arrange in Descending order.
        verifyElements("Name: Z to A", By.xpath("//option[contains(text(),'Name: Z to A')]"), "Name:A to A is not in descending order");

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessfully() throws InterruptedException {
        //Click on Computer Menu using utility method click on Element
        clickOnElement(By.partialLinkText("Computers"));
        //Click on Desktop using utility method click on Element
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/h2[1]/a[1]"));
        //Select Sort By position "Name: A to Z"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: A to Z");
        Thread.sleep(2000);
        //Click on "Add to Cart"
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]"));
        //Verify the Text "Build your own computer"
        verifyElements("Build your own computer", By.cssSelector("div[class='product-name'] h1"), "build it");
        Thread.sleep(2000);
        //Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='product_attribute_1']"), "2.2 GHz Intel Pentium Dual-Core E2200");
        Thread.sleep(2000);
        //Select "8GB [+$60.00]" using Select class.
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='product_attribute_2']"), "8GB [+$60.00]");
        //Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.xpath("//input[@id='product_attribute_3_7']"));
        Thread.sleep(2000);
        //Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.xpath("//input[@id='product_attribute_4_9']"));
        //Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander
        //[+$5.00]"
        clickOnElement(By.xpath("//input[@id='product_attribute_5_10']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//input[@id='product_attribute_5_10']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//input[@id='product_attribute_5_12']"));
        Thread.sleep(2000);
        //Verify the price "$1,475.00"
        verifyElements("$1,475.00", By.xpath("//span[@id='price-value-1']"), "correct price");
        //Click on "ADD TO CARD" Button
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));
        //Verify the Message "The product has been added to your shopping cart" on Top green bar
        verifyElements("The product has been added to your shopping cart", By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"), "correct message");
        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));
        // Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverToElementAndClick(By.xpath("//a[contains(text(),'shopping cart')]"));
        Thread.sleep(2000);
        // Verify the message "Shopping cart"
        verifyElements("Shopping cart", By.xpath("//h1[contains(text(),'Shopping cart')]"), "correct message");
        Thread.sleep(2000);
        // Change the Qty to "2" and Click on "Update shopping cart"
        Thread.sleep(3000);
        WebElement qty = driver.findElement(By.xpath("//input[@class='qty-input' and @value='1']"));
        qty.clear();
        sendTextToElement(By.xpath("//input[@class='qty-input']"), "2");
        //click on update shopping cart
        clickOnElement(By.xpath("//button[@class='button-2 update-cart-button']"));
        // Verify the Total"$2,950.00"
        verifyElements("$2,950.00", By.xpath("//span[@class='value-summary']"), "correct price");
        //2.18 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));

        //2.19 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));

        //2.20 Verify the Text “Welcome, Please Sign In!”
        verifyElements("Welcome, Please Sign In!", By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"), "User is not on the Sign in Page");

        //2.21 Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));

        //2.22 Fill the all mandatory field
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"), "Vaibh");//firstname
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"), "Dhami");//lastname
        sendTextToElement(By.id("BillingNewAddress_Email"), "vi123@gmail.com");//email
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "United Kingdom");//country
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "London");//city
        sendTextToElement(By.cssSelector("#BillingNewAddress_Address1"), "125 cameroseavenue");//Address1
        sendTextToElement(By.cssSelector("#BillingNewAddress_ZipPostalCode"), "HA8 1AF");//Zip/Postal code
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "07598555550");//Phone number

        //Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));

        //2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.id("shippingoption_1"));

        //2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));

        //   2.26 Select Radio Button “Credit Card”
        clickOnElement(By.id("paymentmethod_1"));
        clickOnElement(By.xpath("//button[@name='save' and @class='button-1 payment-method-next-step-button']"));


        //Select “Master card” From Select credit card dropdown and fill all details and click on continue
        selectByindexFromDropDown(By.xpath("//select[@id='CreditCardType']"), 1);
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "Vaibhvi");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "5555 5555 5555 4444");
        sendTextToElement(By.xpath("//select[@id='ExpireMonth']"), "12");
        sendTextToElement(By.xpath("//select[@id='ExpireYear']"), "2022");
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "234");
        // 2.34 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        Thread.sleep(2000);
        //Verify “Payment Method” is “Credit Card”
        verifyElements("Credit Card", By.xpath("//span[contains(text(),'Credit Card')]"), "Payment method is displayed incorrectly");
        //Verify “Shipping Method” is “2nd Day Air”
        Thread.sleep(2000);
        verifyElements("Next Day Air", By.xpath("//div[@class='shipping-method-info']//ul[1]//li[1]//span[@class='value' and contains(text(),'Next')]"), "Shipping Method is displayed incorrectly");
        //Verify Total is “$698.00”
        verifyElements("$2,950.00", By.xpath("//span[contains(text(),'$2,950.00')]"), "Total Amount is displayed incorrectly");

        //Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
        //Verify the Text “Thank You”
        verifyElements("Thank you", By.xpath("//h1[contains(text(),'Thank you')]"), "Thank You Message is incorrectly displayed");

        //Verify the message “Your order has been successfully processed!”
        verifyElements("Your order has been successfully processed!", By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"), "Order has not been processed successfully");

        //Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));

        //Verify the text “Welcome to our store”
        verifyElements("Welcome to our store", By.xpath("//h2[contains(text(),'Welcome to our store')]"), "Welcome to our store has been incorrectly displayed");


    }

    @After
    public void tearDown() {

        closeBrowser();
    }

}
