package com.nobutnk.selenium.common;

import java.util.HashMap;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeDriverContainer {
    
    private ChromeDriver driver;
    
    /**
     * WebDriverを取得する。なければ作成する
     * @return WebDriver
     */
    public ChromeDriver getWebDriver() {
        if (driver == null) {
            driver = createChromeDriver();
            System.out.println("driver is null -> create");
        } else if (driver.toString().contains("(null")) {
            driver = createChromeDriver();
            System.out.println("driver is closed -> create");
        }
        
        System.out.println(driver.toString());
        
        // if you need, login to the top page.
        
        return driver;
    }
    
    /**
     * create ChromeDriver
     * @return chromeDriver
     */
    private ChromeDriver createChromeDriver() {
        
        // -- chrome settings for file download
        String downloadFilepath = "/tmp";
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("download.prompt_for_download", false);
        chromePrefs.put("download.default_directory", downloadFilepath);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        cap.setCapability(ChromeOptions.CAPABILITY, options);
        // -- chrome settings for file download
        
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
        ChromeDriver driver = new ChromeDriver(cap);
        
        return driver;
    }
    
    /**
     * WebDriver終了時に呼ぶ
     */
    public void cleanup() {
        driver.close();
        driver.quit();
        driver = null;
    }

}
