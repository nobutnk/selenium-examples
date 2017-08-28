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
public class TextInputTest {

    @Test
    public void test() throws InterruptedException {
        // Optional, if not specified, WebDriver will search your path for
        // chromedriver.
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");

        // settings
        String url = "https://www.google.co.jp";

        WebDriver driver = new ChromeDriver();

        driver.get(url);
        String form1 = "lst-ib";
        WebDriverUtils.inputText(driver, "Selenium 日本語", By.id(form1));
        
        WebElement element = driver.findElement(By.id(form1));
        Assert.assertThat("Selenium 日本語", is(element.getAttribute("value")));
        
        String button = "input[name='btnK']";
        WebDriverUtils.click(driver, By.cssSelector(button));
        
        String title = driver.getTitle();
        Assert.assertThat("Selenium 日本語 - Google 検索", is(title));
        
//        driver.quit();
    }
}
