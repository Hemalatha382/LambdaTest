import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class InputFormDemoTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\1000061697\\Downloads\\msedgedriver.exe");
       EdgeOptions options = new EdgeOptions();

	options.addArguments("--inprivate");

	driver = new EdgeDriver(options);

	 driver.manage().window().maximize();

        try {
            driver.get("https://www.lambdatest.com/selenium-playground");
            WebElement inputFormDemoLink = driver.findElement(By.linkText("Input Form Demo"));
            inputFormDemoLink.click();
            WebElement submitButton = driver.findElement(By.xpath("//button[text()='Submit']"));
            submitButton.click();
            WebElement errorMessage = driver.findElement(By.xpath("//*[contains(text(), 'Please fill in the fields')]"));
            if (errorMessage.isDisplayed()) {
                System.out.println("Error message validation passed.");
            } else {
                System.out.println("Error message validation failed.");
            }
            driver.findElement(By.id("name")).sendKeys("John Doe");
            driver.findElement(By.id("inputEmail4")).sendKeys("john.doe@example.com");
            driver.findElement(By.id("company")).sendKeys("LambdaTest");
            driver.findElement(By.id("websitename")).sendKeys("www.lambdatest.com");
            driver.findElement(By.id("inputCity")).sendKeys("San Francisco");
            driver.findElement(By.id("inputAddress1")).sendKeys("123 Main St");
            driver.findElement(By.id("inputAddress2")).sendKeys("Suite 500");
            WebElement countryDropdown = driver.findElement(By.xpath("//select[@name='country']"));
            Select selectCountry = new Select(countryDropdown);
            selectCountry.selectByVisibleText("United States");
            submitButton.click();
            WebElement successMessage = driver.findElement(By.xpath("//*[contains(text(), 'Thanks for contacting us, we will get back to you shortly.')]"));
            if (successMessage.isDisplayed()) {
                System.out.println("Success message validation passed.");
            } else {
                System.out.println("Success message validation failed.");
            }
        } finally {
            driver.quit();
        }
    }
}
