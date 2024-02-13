package id.ac.ui.cs.advprog.eshop.functional;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import java.util.List;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ExtendWith(SeleniumJupiter.class)
class CreateProductFunctionalTest {
    @LocalServerPort
    private int serverPort;

    @Value("${app.baseUrl:http://localhost}")
    private String testBaseUrl;

    private String baseUrl;

    @BeforeEach
    void setupTest(){
        baseUrl = String.format("%s:%d", testBaseUrl, serverPort);
    }

    @Test
    void homePage_isCorrect(ChromeDriver driver) throws Exception {
        // Exercise
        driver.get(baseUrl);
        String pageTitle = driver.getTitle();
        String welcomeMessage = driver.findElement(By.tagName("h3")).getText();

        // Verify
        assertEquals("ADV Shop", pageTitle);
        assertEquals("Welcome", welcomeMessage);
    }

    @Test
    void productListPage_isCorrect(ChromeDriver driver) throws Exception {
        driver.get(baseUrl);
        WebElement checkInput = driver.findElement(By.className("btn"));
        checkInput.click();

        String titleProductList = driver.getTitle();
        assertEquals("Product List", titleProductList);
    }
    
    @Test
    void createProductPage_isCorrect(ChromeDriver driver) throws Exception {
        driver.get(baseUrl);
        WebElement checkInput = driver.findElement(By.className("btn"));
        checkInput.click();

        checkInput = driver.findElement(By.id("create-product"));
        checkInput.click();

        String titleCreateProduct = driver.getTitle();
        assertEquals("Create New Product", titleCreateProduct);
    }

    @Test
    void createProductSubmit_isCorrect(ChromeDriver driver) throws Exception {
        driver.get(baseUrl);
        WebElement checkInput = driver.findElement(By.className("btn"));
        checkInput.click();

        checkInput = driver.findElement(By.id("create-product"));
        checkInput.click();

        WebElement nameInput = driver.findElement(By.id("nameInput"));
        WebElement quantityInput = driver.findElement(By.id("quantityInput"));

        nameInput.clear(); quantityInput.clear();

        String nama = "Apple";
        int kuantitas = 10;
        
        nameInput.sendKeys(nama);
        quantityInput.sendKeys(String.valueOf(kuantitas));

        checkInput = driver.findElement(By.className("btn"));
        checkInput.click();

        assertEquals("Product List", driver.getTitle());

        List<WebElement> tabelProduct =  driver.findElements(By.tagName("td"));

        assertEquals(nama, tabelProduct.get(0).getText());
        assertEquals(kuantitas, Integer.parseInt(tabelProduct.get(1).getText()));
    }
    
}
