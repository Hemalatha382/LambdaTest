import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SeleniumPlaygroundTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\1000061697\\Downloads\\msedgedriver.exe");
         EdgeOptions options = new EdgeOptions();
	    options.addArguments("--inprivate");

	    driver = new EdgeDriver(options);

	    driver.manage().window().maximize();

        try {
            driver.get("https://www.lambdatest.com/selenium-playground");
            WebElement simpleFormDemoLink = driver.findElement(By.linkText("Simple Form Demo"));
            simpleFormDemoLink.click();
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.urlContains("simple-form-demo"));
            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.contains("simple-form-demo")) {
                System.out.println("URL validation passed.");
            } else {
                System.out.println("URL validation failed.");
            }
            String message = "Welcome to LambdaTest";
            WebElement messageInputBox = driver.findElement(By.xpath("//input[@id='user-message']"));
            messageInputBox.sendKeys(message);
            WebElement showMessageButton = driver.findElement(By.xpath("//button[@id='showInput']"));
            showMessageButton.click();
            WebElement displayedMessage = driver.findElement(By.id("display"));
            String displayedText = displayedMessage.getText();
            if (message.equals(displayedText)) {
                System.out.println("Message validation passed.");
            } else {
                System.out.println("Message validation failed.");
            }
        } finally {
            driver.quit();
        }
    }
}
