
import java.time.Duration;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestReto1 {

    WebDriver driver;

    @BeforeEach
    public void initConfig() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get("https://demoblaze.com/");

    }

    @Test
    public void searchProducts() throws InterruptedException {

        WebElement cellPhonesButton = driver.findElement(By.xpath("//*[@id='contcont']/div/div[1]/div/a[2]"));
        cellPhonesButton.click();
        WebElement samsungGalaxyS6 = driver.findElement(By.xpath("//*[@id='tbodyid']/div[1]/div/div/h4/a"));
        samsungGalaxyS6.click();
        WebElement priceS = driver.findElement(By.xpath("//*[@id='tbodyid']/h3"));
        assertEquals(priceS.getText().toString().replace(" *includes tax", ""), "$360");

        driver.navigate().back();

        WebElement nokialumia = driver.findElement(By.xpath("//*[@id='tbodyid']/div[2]/div/div/h4/a"));
        nokialumia.click();
        WebElement priceN = driver.findElement(By.xpath("//*[@id='tbodyid']/h3"));
        assertEquals(priceN.getText().toString().replace(" *includes tax", ""), "$820");

        driver.navigate().back();    

        WebElement laptopsButton = driver.findElement(By.xpath("//*[@id='contcont']/div/div[1]/div/a[3]"));
        laptopsButton.click();
        Thread.sleep(1000);
        WebElement laptop1 = driver.findElement(By.xpath("//*[@id='tbodyid']/div[1]/div/div/h4/a"));
        laptop1.click();
        WebElement price1 = driver.findElement(By.xpath("//*[@id='tbodyid']/h3"));
        assertEquals(price1.getText().toString().replace(" *includes tax", ""), "$790");

        driver.navigate().back();

        WebElement laptop2 = driver.findElement(By.xpath("//*[@id='tbodyid']/div[3]/div/div/h4/a"));
        laptop2.click();
        WebElement price2 = driver.findElement(By.xpath("//*[@id='tbodyid']/h3"));
        assertEquals(price2.getText().toString().replace(" *includes tax", ""), "$700");
       
        driver.navigate().back();
        

        WebElement monitorsButton = driver.findElement(By.xpath("//*[@id='contcont']/div/div[1]/div/a[4]"));
        monitorsButton.click();
        Thread.sleep(1000);        
        WebElement monitor1 = driver.findElement(By.xpath("//*[@id='tbodyid']/div[2]/div/div/h4/a"));
        monitor1.click();
        WebElement price = driver.findElement(By.xpath("//*[@id='tbodyid']/h3"));
        assertEquals(price.getText().toString().replace(" *includes tax", ""), "$230");
        
    }

    @AfterEach
    public void closeDriver() {
        driver.close();
    }
}
