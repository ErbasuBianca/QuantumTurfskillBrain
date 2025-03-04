package org.quantumturf.autorization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestAiSection {
    @Test
    public void testAiSection() {
        // Inițializează WebDriver pentru Chrome în cadrul fiecărui test
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.quantumturf.com");

        // Așteaptă câteva secunde pentru a te asigura că pagina s-a încărcat complet (opțional)
        try {
            Thread.sleep(3000);  // Așteaptă 3 secunde
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Localizează secțiunea "AI Powered Lawn Care" pe pagina principală
        WebElement aiSection = driver.findElement(By.xpath("//h2[contains(text(), 'AI Powered Lawn Care')]"));

        // Verifică dacă secțiunea există pe pagină
        assertTrue(aiSection.isDisplayed(), "Secțiunea 'AI Powered Lawn Care' nu este vizibilă!");

        // Verifică dacă secțiunea conține textul așteptat (opțional, în funcție de conținut)
        String sectionText = aiSection.getText();
        assertTrue(sectionText.contains("AI"), "Secțiunea nu conține textul așteptat.");

        // Închide browser-ul după test
        driver.quit();
    }
}
