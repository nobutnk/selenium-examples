package com.nobutnk.selenium.examples;

import static org.hamcrest.Matchers.*;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.nobutnk.selenium.common.WebDriverUtils;


/**
 * Unit test for simple App.
 */
public class CheckboxElementTest {

    @Test
    public void test() throws InterruptedException {
        // Optional, if not specified, WebDriver will search your path for
        // chromedriver.
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");

        // settings
        String url = "http://html.com/input-type-checkbox/";

        WebDriver driver = new ChromeDriver();

        driver.get(url);
        
        
        String checkbox1 = "love";
        WebElement checkbox1Element = driver.findElement(By.id(checkbox1));
        boolean checkbox1Selected = checkbox1Element.isSelected();
        Assert.assertThat(false, is(checkbox1Selected));
        WebDriverUtils.click(driver, By.id(checkbox1));
        checkbox1Selected = checkbox1Element.isSelected();
        Assert.assertThat(true, is(checkbox1Selected));
        driver.quit();
    }
}
