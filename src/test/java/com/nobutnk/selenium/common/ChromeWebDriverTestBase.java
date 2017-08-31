/**
 * 
 */
package com.nobutnk.selenium.common;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author nobutnk
 *
 */
public class ChromeWebDriverTestBase {
    
    /**
     * WebDriver 管理コンテナ
     */
    protected static ChromeDriverContainer driverContainer = new ChromeDriverContainer();
    
    /**
     * WebDriver 実体
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
    public void setUp() {
        driver = driverContainer.getWebDriver();
        
        // if you need, login to the top page.
    }
    
    /**
     * [TestCleanup()]
     * テストメソッド実行後に毎回呼ばれる
     */
    @After
    public void tearDown() {
        // 毎回ブラウザ閉じたい場合
//        if (this.driver != null) {
//            driver.close();
//            driver.quit();
//        }
        System.out.println("tearDown");
        
    }
    
    /**
     * クラス内の全テスト実行後に呼ばれる
     */
    @AfterClass
    public static void after() {
        driverContainer.cleanup();
    }

}
