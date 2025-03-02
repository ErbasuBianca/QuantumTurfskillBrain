package org.quantumturf.autorization;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
public class Registration {

        @Test
        public void registerUser() throws InterruptedException {
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.quantumturf.com");
            driver.findElement(By.cssSelector(".header a[href*='signup'")).click();
            driver.findElement(By.xpath("//div[.='First Name']/following-sibling::div/input")).sendKeys("Bianca");
            driver.findElement(By.xpath("//div[.='Last Name']/following-sibling::div/input")).sendKeys("Erbasu");
            driver.findElement(By.xpath("//div[.='Email']/following-sibling::div/input")).sendKeys("georgiana.erbasu@yahoo.com");
            driver.findElement(By.xpath("//div[.='Password']/following-sibling::div/input")).sendKeys("Skillbrain34@");

            driver.findElement(By.xpath("//span[.='Privacy Policy']/preceding-sibling::span")).click();
            driver.findElement(By.xpath("//span[.='Tems and Conditions']/preceding-sibling::span")).click();
            WebElement getStarted = driver.findElement(By.cssSelector("button.btn"));
            Actions actions = new Actions(driver);
            actions.moveToElement(getStarted).click().perform();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.text-red")));

            Assert.assertTrue(alert.isDisplayed());
            Assert.assertEquals(alert.getText(), "This username already exists");
        }

        @Test
        public void registrationInvalidEmail() {
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.quantumturf.com");
            driver.findElement(By.cssSelector(".header a[href*='signup'")).click();
            driver.findElement(By.xpath("//div[.='Email']/following-sibling::div/input"))
                    .sendKeys("georgiana.erbasu@yahoo.com");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated
                    (By.xpath("//div[.='Email']/following-sibling::div[@class='text-red text-small mt-1']")));

            Assert.assertTrue(errorMessage.isDisplayed());
            Assert.assertEquals(errorMessage.getText(), "Invalid email format.");
        }
    }

