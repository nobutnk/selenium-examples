package com.nobutnk.selenium.examples;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Unit test for simple App.
 */
public class BasicAuthTest {

    @Test
    public void test() throws InterruptedException {
        // Optional, if not specified, WebDriver will search your path for
        // chromedriver.
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
        
        // settings
        String username = "user"; // username
        String password = "passwd"; // password
        String protectedPage = "https://httpbin.org/basic-auth/user/passwd";
        String dummy = "https://httpbin.org";

        WebDriver driver = new ChromeDriver();
        
        // 認証前ページにアクセス
        try {
            driver.get(dummy);
        } catch (Exception e) {
    
        }
        
        // JavaScriptで認証
        JavascriptExecutor jexec = (JavascriptExecutor) driver;
        StringBuilder js = new StringBuilder();
        js.append("var XMLReq = new XMLHttpRequest();");
        js.append("XMLReq.open('GET', '"
                + protectedPage + "', false, '"
                + username + "', '" + 
                password + "');");
        js.append("XMLReq.send(null);");
        jexec.executeScript(js.toString());
        
        // 認証後ページにアクセス
        driver.get(protectedPage);

        Thread.sleep(5000); // Let the user actually see something!
        
        String pageSource = driver.getPageSource();
        System.out.println(pageSource);
        driver.quit();
    }
}
