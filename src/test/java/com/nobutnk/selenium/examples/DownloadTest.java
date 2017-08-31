package com.nobutnk.selenium.examples;

import java.awt.AWTException;

import org.junit.Test;

import com.nobutnk.selenium.common.ChromeWebDriverTestBase;

/**
 * Unit test for simple App.
 */
public class DownloadTest extends ChromeWebDriverTestBase {

    @Test
    public void test() throws InterruptedException, AWTException {
        // Optional, if not specified, WebDriver will search your path for
        // chromedriver.
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
        
        // settings
        String mainPage = "http://www.nomadworks.co.jp/htmlsample/download.html";
        String download = "http://www.nomadworks.co.jp/htmlsample/archive/win/sec2/info01.zip";
        
        // 認証前ページにアクセス
        
        driver.get(mainPage);
        
        
        // ファイルダウンロード
        driver.get(download);

        Thread.sleep(5000); // Let the user actually see something!
    }
}
