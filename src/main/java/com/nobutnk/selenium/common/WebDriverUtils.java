/**
 * 
 */
package com.nobutnk.selenium.common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author nobutnk
 *
 */
public class WebDriverUtils {
    
    /**
     * Basic認証付きページにアクセスする
     * @param driver webdriver
     * @param baseUrl 認証ありページと同一ドメインの認証なしページ
     * @param protectedUrl 認証ありページ
     * @param username username
     * @param password password
     */
    public static void basicAuthentication(
            WebDriver driver, String baseUrl, String protectedUrl, String username, String password) {
       // 認証前ページにアクセス
       driver.get(baseUrl);
        
        // JavaScriptで認証
        JavascriptExecutor jexec = (JavascriptExecutor) driver;
        StringBuilder js = new StringBuilder();
        js.append("var XMLReq = new XMLHttpRequest();");
        js.append("XMLReq.open('GET', '"
                + protectedUrl + "', false, '"
                + username + "', '" + 
                password + "');");
        js.append("XMLReq.send(null);");
        jexec.executeScript(js.toString());
        
        // 認証後ページにアクセス
        driver.get(protectedUrl);
    }
    
    /**
     * テキスト入力する
     * @param driver webdriver
     * @param text 入力したい文字列
     * @param by By
     */
    public static void inputText(WebDriver driver, String text, By by) {
        WebElement element = driver.findElement(by);
        inputText(driver, text, element);
    }
    
    /**
     * テキスト入力する
     * @param driver webdriver
     * @param text 入力したい文字列
     * @param element WebElement
     */
    public static void inputText(WebDriver driver, String text, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].value=arguments[1]", element, text);
    }
    
    /**
     * 要素をclickする
     * @param driver webdriver
     * @param by by
     */
    public static void click(WebDriver driver, By by) {
        click(driver, driver.findElement(by));
    }
    
    /**
     * 要素をclickする
     * @param driver webdriver
     * @param element WebElement
     */
    public static void click(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", element);
    }

}
