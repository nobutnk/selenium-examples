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
public class RadioTest {

    @Test
    public void test() throws InterruptedException {
        // Optional, if not specified, WebDriver will search your path for
        // chromedriver.
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");

        // settings
        String url = "https://v4-alpha.getbootstrap.com/components/forms/#textual-inputs";

        WebDriver driver = new ChromeDriver();

        driver.get(url);
        String radio1 = "optionsRadios1";
        String radio2 = "optionsRadios2";
        WebDriverUtils.click(driver, By.id(radio2));
        
        // click後、チェックが付いているか確認
        WebElement radio2Element = driver.findElement(By.id(radio2));
        boolean radio2Selected = radio2Element.isSelected();
        Assert.assertThat(true, is(radio2Selected));
        // radio2をclick後、チェック外れていることを確認
        WebElement radio1Element = driver.findElement(By.id(radio1));
        boolean radio1Selected = radio1Element.isSelected();
        Assert.assertThat(false, is(radio1Selected));
        driver.quit();
    }
}
