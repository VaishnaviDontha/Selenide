package SelenideSampleTestScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class LaunchingBrowser {

    @Test
    public void testLogin() {
        open("https://the-internet.herokuapp.com/login");
        $(By.name("username")).setValue("tomsmith");
        $(By.name("password")).setValue("SuperSecretPassword!"); 
        $(By.xpath("//button[@type='submit']")).click();

        $(By.cssSelector("#flash")).shouldHave(text("You logged into a secure area!"));
        

        String title = title();
        Assert.assertEquals(title, "The Internet");
    }


    @Test
    public void googleSearch() {
        open("https://www.google.com/");
    
        $(By.cssSelector("input[title='Search']")).setValue("Selenide"); 
        $(By.cssSelector("input[title='Search']")).sendKeys(Keys.ENTER);
        

        String title = title();
        Assert.assertEquals(title, "Selenide - Google Search");
    }

}
