package com.nobutnk.selenium.examples;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.nobutnk.selenium.common.WebDriverUtils;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.security.UserAndPassword;

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
        String protectedUrl = "https://httpbin.org/basic-auth/user/passwd";
        String baseUrl = "http://www.yahoo.co.jp";

        WebDriver driver = new ChromeDriver();

        WebDriverUtils.basicAuthentication(driver, baseUrl, protectedUrl,
                username, password);

        Thread.sleep(5000); // Let the user actually see something!

        String pageSource = driver.getPageSource();
        System.out.println(pageSource);
        driver.quit();
    }
}
