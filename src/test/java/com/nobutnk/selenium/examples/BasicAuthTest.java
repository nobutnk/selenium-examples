package com.nobutnk.selenium.examples;

import org.junit.Test;

import com.nobutnk.selenium.common.ChromeWebDriverTestBase;
import com.nobutnk.selenium.common.WebDriverUtils;

/**
 * Unit test for simple App.
 */
public class BasicAuthTest extends ChromeWebDriverTestBase {

    @Test
    public void test() throws InterruptedException {

        // settings
        String username = "user"; // username
        String password = "passwd"; // password
        String protectedUrl = "https://httpbin.org/basic-auth/user/passwd";
        String baseUrl = "http://www.yahoo.co.jp";

        WebDriverUtils.basicAuthentication(driver, baseUrl, protectedUrl,
                username, password);

        Thread.sleep(5000); // Let the user actually see something!

        String pageSource = driver.getPageSource();
        System.out.println(pageSource);
    }
}
