package SelenideSampleTestScripts;

import org.testng.annotations.Test;


import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
public class Commands {


    @Test
    public void commandsInSelenide() {

        open("https://www.google.com/");
                
    }

    
}
