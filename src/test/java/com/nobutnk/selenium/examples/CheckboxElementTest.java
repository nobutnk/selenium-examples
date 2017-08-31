package com.nobutnk.selenium.examples;

import static org.hamcrest.Matchers.is;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.nobutnk.selenium.common.ChromeWebDriverTestBase;
import com.nobutnk.selenium.common.WebDriverUtils;


/**
 * Unit test for simple App.
 */
public class CheckboxElementTest extends ChromeWebDriverTestBase {

    @Test
    public void test() throws InterruptedException {

        // settings
        String url = "http://html.com/input-type-checkbox/";

        driver.get(url);
        
        
        String checkbox1 = "love";
        WebElement checkbox1Element = driver.findElement(By.id(checkbox1));
        boolean checkbox1Selected = checkbox1Element.isSelected();
        Assert.assertThat(false, is(checkbox1Selected));
        WebDriverUtils.click(driver, By.id(checkbox1));
        checkbox1Selected = checkbox1Element.isSelected();
        Assert.assertThat(true, is(checkbox1Selected));
    }
}
