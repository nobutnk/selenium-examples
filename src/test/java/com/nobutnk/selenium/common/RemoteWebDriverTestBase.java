/**
 * 
 */
package com.nobutnk.selenium.common;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * @author nobutnk
 *
 */
public class RemoteWebDriverTestBase {
    
    /**
     * WebDriver
     */
    private RemoteWebDriver driver;
    
    /**
     * get WebDriver<br>
     * if driver is null, create XxxDriver and return,
     * if driver.toString() contains "null", quit() is called, so create XxxDriver again and return
     * @return WebDriver
     * @throws MalformedURLException 
     */
    @Before
    public void setUp() throws MalformedURLException {
        if (driver == null) {
            driver = createRemoteWebDriver();
        } else if (driver.toString().contains("null")) {
            driver = createRemoteWebDriver();
        }
    }
    
    private RemoteWebDriver createRemoteWebDriver() throws MalformedURLException {
        DesiredCapabilities firefox = DesiredCapabilities.firefox();
        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://x.x.x.x:4444/wd/hub"), firefox);
        
        return driver;
    }
    
    @After
    public void tearDown() {
        if (this.driver != null) {
            driver.close();
            driver.quit();
        }
    }

}
