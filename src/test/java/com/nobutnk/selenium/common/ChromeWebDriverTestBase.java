/**
 * 
 */
package com.nobutnk.selenium.common;

import java.net.MalformedURLException;
import java.util.HashMap;

import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @author nobutnk
 *
 */
public class ChromeWebDriverTestBase {
    
    /**
     * WebDriver
     */
    protected ChromeDriver driver;
    
    /**
     * [TestInitialize] 
     * get WebDriver<br>
     * if driver is null, create XxxDriver and return,
     * if driver.toString() contains "null", quit() is called, so create XxxDriver again and return
     * @return WebDriver
     * @throws MalformedURLException 
     */
    @Before
    public void getWebDriver() {
        if (driver == null) {
            driver = createChromeDriver();
        }
        
        System.out.println(driver.toString());
    }
    
    /**
     * create ChromeDriver
     * @return chromeDriver
     */
    private ChromeDriver createChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
        
        String downloadFilepath = "/tmp";
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("download.prompt_for_download", false);
        chromePrefs.put("download.default_directory", downloadFilepath);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        cap.setCapability(ChromeOptions.CAPABILITY, options);
        ChromeDriver driver = new ChromeDriver(cap);
        
        return driver;
    }

}
