import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    public WebDriver driver;
    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    public int timeSeconds =3;
    public static WebDriver getDriver() {
        return threadDriver.get();
    }
    @BeforeMethod
    @Parameters({"url"})
    public void launchBrowser(String url) throws MalformedURLException {
        //ChromeOptions options = new ChromeOptions();
        // options.addArguments("--remote-allow-origins=*");
        //driver = new ChromeDriver(options);
        //driver = new FirefoxDriver();
        //driver = pickBrowser(System.getProperty("browser"));
        threadDriver.set(pickBrowser(System.getProperty("browser")));

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(timeSeconds));
        //driver.manage().window().maximize();
        getDriver().manage().window().maximize();
        getDriver().get(url);
        System.out.println(getDriver());

    }


    //return driver = new RemoteWebDriver(new URL("https://" +userName + ":" +accessKey + hubURL), capabilities);
    //@AfterMethod
    //public void closeBrowser() {
    //driver.quit();
    //}
   public WebDriver lambdaTest() throws MalformedURLException  {
        String hubUrl = "@hub.lambdatest.com/wd/hub";
        String userName = "elzat.nurmanbetova";
        String accessKey = "zu16PAPnswz48MXiIBrR5MU67gfzeemhgB69XlBQyVRGA17Ux1";
        //capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", "123.0");

        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", userName);
        ltOptions.put("accessKey", accessKey);
        ltOptions.put("project", "KoelTest");
        ltOptions.put("name", "CloudTest");
        ltOptions.put("w3c", true);
        ltOptions.put("plugin", "java-java");
        capabilities.setCapability("LT:Options", ltOptions);
        return driver = new RemoteWebDriver(new URL("https://" + userName + ":" + accessKey + hubUrl), capabilities);
    }
    public void closeBrowser(){
        driver.quit();
    }

    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridUrl = "http://192.168.1.65:4444";
        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--remote-allow-origins=*");
                return new FirefoxDriver(firefoxOptions.merge(caps));
            //return driver = new FirefoxDriver();
            case "MicrosoftEdge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                return new EdgeDriver(edgeOptions.merge(caps));
            case "cloud":
                return lambdaTest();

            //grid cases
            case "grid-edge":
                caps.setCapability("browserName", "MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridUrl).toURL(), caps);
            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridUrl).toURL(), caps);
            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridUrl).toURL(), caps);

            default:
                WebDriverManager.chromedriver().setup(); // Set up the ChromeDriver executable using WebDriverManager
                ChromeOptions options = new ChromeOptions(); // Create a new ChromeOptions object
                options.addArguments("--disable-notifications", "--remote-allow-origins=*", "--incognito", "--start-maximized"); // Disable notifications, allow remote origins, launch in incognito mode, and start maximized
                options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); // Exclude the enable-automation switch
                return new ChromeDriver(options.merge(caps));    // Launch Chrome with the specified options and capabilities
        }
    }
}