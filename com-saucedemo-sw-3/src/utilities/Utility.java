package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Utility extends BaseTest {
    /**
     * This method will click on element
     */
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    /**
     * Click on checkbox with condition
     */
    public void clickOnCheckBoxAndRadioButton(By by) {
        WebElement element = driver.findElement(by);
        if (!element.isSelected()) {
            element.click();
        }
    }


    /**
     * This method will send text on element
     */
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
        /*WebElement emailfield = driver.findElement(by);
        emailfield.sendKeys(text);*/
    }

    /**
     * This method will get text from element
     */
    public String getTextFromElement(By by) {
        /*WebElement webElement = driver.findElement(by);
        String text = webElement.getText();
        return text;*/
        return driver.findElement(by).getText();
    }

    /**
     * This method will get Attribute value from element
     */
    public String getAttributeValueFromElement(By by) {
        /*WebElement webElement = driver.findElement(by);
        String text = webElement.getText();
        return text;*/
        return driver.findElement(by).getAttribute("value");
    }
    //******************************** DropDown Menu Without Select Tag ********************************************//
    public void dropDownWithList(By by, String option) {
        List<WebElement> list = driver.findElements(by);
        for (WebElement e : list) {
            if (e.getText().equalsIgnoreCase(option)) {
                e.click();
                break;
            }
        }
    }
    //*************************** Select Class Methods ***************************************//

    /**
     * Select dropdown using value
     */
    public void selectByValueFromDropDown(By by, String value) {
        WebElement dropDown = driver.findElement(by);
        //Create an object of select class
        Select select = new Select(dropDown);
        //Select by value
        select.selectByValue(value);
    }

    /**
     * Select dropdown using text
     */

    public void selectByVisibleTextFromDropDown(By by, String value) {
        WebElement dropDown = driver.findElement(by);
        //Create an object of select class
        Select select = new Select(dropDown);
        //Select by value
        select.selectByVisibleText(value);
    }

    /**
     * Select dropdown using Index
     */
    public void selectByIndexFromDropDown(By by, Integer value) {
        WebElement dropDown = driver.findElement(by);
        //Create an object of select class
        Select select = new Select(dropDown);
        //Select by value
        select.selectByIndex(value);
    }

    /**
     * Verify that list is in decending order
     */
    public boolean verifyTheListIsDescendingOrder(By by) {
        List<WebElement> list = driver.findElements(by);

        boolean isDescending = true;

        for (int i = 0; i < list.size() - 1; i++) {
             System.out.println(list.get(i).getText());
            if (list.get(i).getText().compareTo(list.get(i + 1).getText()) < 0) {
                isDescending = false;
            }
        }
        System.out.println(isDescending);
        return isDescending;
    }

    /**
     * Verify that list is in Ascending order for String text
     */
    public boolean verifyTheListIsAscendingOrder(By by) {
        List<WebElement> list = driver.findElements(by);

        boolean isAscending = true;

        for (int i = 0; i < list.size() - 1; i++) {
             System.out.println(list.get(i).getText());
            if (list.get(i).getText().compareTo(list.get(i + 1).getText()) > 0) {
                isAscending = false;
            }
        }
        System.out.println(isAscending);
        return isAscending;
    }

    public boolean verifyTheListIsAscendingOrderForIntValue(By by) {
        List<WebElement> list = driver.findElements(by);

        boolean isAscending = true;

        for (int i = 0; i < list.size() - 1; i++) {
            System.out.println(list.get(i).getText());
            if (list.get(i).getText().compareTo(list.get(i + 1).getText()) > 0) {
                isAscending = false;
            }
        }
        return isAscending;
    }

    //*************************** Action Methods ***************************************//

    /**
     * This method will use to hover mouse on element
     */
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }

    /**
     * This method will use to Verify Actual and Expected Result
     */
    public void verifyElements(String displayMessage, String expectedValue, By by) {
        String actualValue = getTextFromElement(by);
        Assert.assertEquals(displayMessage, expectedValue, actualValue);
    }

    public void verifyElements(String displayMessage, String expectedValue, String actualValue) {
        Assert.assertEquals(displayMessage, expectedValue, actualValue);
    }

    /**
     * Clear webElement
     */

    public void clearElement(By by) {
        driver.findElement(by).clear();
    }

    public void sleep(int sec) throws InterruptedException {
        Thread.sleep(sec * 1000);
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

}
