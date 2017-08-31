/**
 * 
 */
package com.nobutnk.selenium.examples;

import static org.hamcrest.Matchers.is;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.nobutnk.selenium.common.ChromeWebDriverTestBase;
import com.nobutnk.selenium.common.WebDriverUtils;

/**
 * @author nobutnk
 *
 */
public class SequencialTest extends ChromeWebDriverTestBase {
    
    @Test
    public void testCheckbox() throws InterruptedException {

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
    
    @Test
    public void testRadiobox() throws InterruptedException {

        // settings
        String url = "https://v4-alpha.getbootstrap.com/components/forms/#textual-inputs";

        driver.navigate().to(url);
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
    }
    
    @Test
    public void testTextinput() throws InterruptedException {

        // settings
        String url = "https://www.google.co.jp";

        driver.navigate().to(url);
        String form1 = "lst-ib";
        WebDriverUtils.inputText(driver, "Selenium 日本語", By.id(form1));
        
        WebElement element = driver.findElement(By.id(form1));
        Assert.assertThat("Selenium 日本語", is(element.getAttribute("value")));
        
        String button = "input[name='btnK']";
        WebDriverUtils.click(driver, By.cssSelector(button));
        
        String title = driver.getTitle();
        Assert.assertThat("Selenium 日本語 - Google 検索", is(title));
    }

}
