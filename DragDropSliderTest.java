import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragDropSliderTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\1000061697\\Downloads\\msedgedriver.exe");
        EdgeOptions options = new EdgeOptions();
	 options.addArguments("--inprivate");

	 driver = new EdgeDriver(options);

	  driver.manage().window().maximize();

        try {
            driver.get("https://www.lambdatest.com/selenium-playground");
            WebElement dragDropSlidersLink = driver.findElement(By.linkText("Drag & Drop Sliders"));
            dragDropSlidersLink.click();
            WebElement slider = driver.findElement(By.xpath("//input[@type='range' and @value='15']"));
            WebElement rangeOutput = driver.findElement(By.id("rangeSuccess"));
            Actions actions = new Actions(driver);
            int targetValue = 95;
            int currentValue = Integer.parseInt(slider.getAttribute("value"));
            int offset = targetValue - currentValue;
            actions.clickAndHold(slider).moveByOffset(offset * 2, 0).release().perform();
            String displayedValue = rangeOutput.getText();
            if (displayedValue.equals(String.valueOf(targetValue))) {
                System.out.println("Slider value validation passed. Value: " + displayedValue);
            } else {
                System.out.println("Slider value validation failed. Expected: 95, Found: " + displayedValue);
            }
        } finally {
            driver.quit();
        }
    }
}
