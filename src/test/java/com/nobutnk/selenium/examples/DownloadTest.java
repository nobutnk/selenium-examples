package com.nobutnk.selenium.examples;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.HashMap;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Unit test for simple App.
 */
public class DownloadTest {

    @Test
    public void test() throws InterruptedException, AWTException {
        // Optional, if not specified, WebDriver will search your path for
        // chromedriver.
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
        
        // settings
        String mainPage = "http://www.nomadworks.co.jp/htmlsample/download.html";
        String download = "http://www.nomadworks.co.jp/htmlsample/archive/win/sec2/info01.zip";

        String downloadFilepath = "/tmp";
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("download.prompt_for_download", false);
        chromePrefs.put("download.default_directory", downloadFilepath);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        cap.setCapability(ChromeOptions.CAPABILITY, options);
        WebDriver driver = new ChromeDriver(cap);
        
        // 認証前ページにアクセス
        driver.get(mainPage);
        
        
        // ファイルダウンロード
        driver.get(download);

        Thread.sleep(5000); // Let the user actually see something!
        
        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_TAB);
//
        robot.keyRelease(KeyEvent.VK_ALT);
        robot.keyRelease(KeyEvent.VK_TAB);
        Thread.sleep(5000); // sometimes there may be a delay for the dialog box to get appeared. Can be removed if needed
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        
        System.out.println("enter");
        
        String pageSource = driver.getPageSource();
        
        //driver.quit();
    }
}
