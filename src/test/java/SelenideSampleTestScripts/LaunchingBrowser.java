package SelenideSampleTestScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class LaunchingBrowser {

    @Test
    public void testLogin() {
        open("https://the-internet.herokuapp.com/login");
        $(By.name("username")).setValue("tomsmith");
        $(By.name("password")).setValue("SuperSecretPassword!"); 
        $(By.xpath("//button[@type='submit']")).click();

        // verify text
        $(By.cssSelector("#flash")).shouldHave(text("You logged into a secure area!"));
        
        // verify url contains
        String url = WebDriverRunner.url();
        Assert.assertTrue(url.contains("secure"));

        // verify title
        String title = title();
        Assert.assertEquals(title, "The Internet");


    }


    @Test
    public void googleSearch() {
        open("https://www.google.com/");
    
        $(By.cssSelector("input[title='Search']")).setValue("Selenide").sendKeys(Keys.ENTER);
        
        String title = title();
        Assert.assertEquals(title, "Selenide - Google Search");
    }

}
