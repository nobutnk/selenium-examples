# selenium-examples
Selenium code Examples

## Basic認証
* Basic認証がかかっているページの対処方法
* 通常は、以下の通りでよいはず

```
WebDriverWait wait = new WebDriverWait(driver, 10);
Alert alert = wait.until(ExpectedConditions.alertIsPresent()); 
alert.authenticateUsing(new UserAndPassword(username, password));
```

* しかし、現状(2017/08/02)はInternetExplorerDriver、かつSelenium-3.4でしか動作していない。
* そのため、以下のような対処方法となる。 [BasicAuthTest.java](https://github.com/nobutnk/selenium-examples/blob/master/src/test/java/com/nobutnk/selenium/examples/BasicAuthTest.java)

    1. 認証が必要なページと同一ドメインで、認証がかかっていないページに遷移する。※前提条件となる。
    
    2. JavaScriptのXMLHttpRequestを使い、Basic認証を行う
    
    3. 認証がかかっているページに遷移する。

* ※前提条件：ドメイン内のすべてのページでBasic認証がかかっている場合、この方法は使えない。
* JavaScriptでリクエストを投げる場合、同一ドメインから投げる必要があるため。ドメイン内のページに遷移後、JavaScriptからリクエストを発行するとう仕組みを使っている。
