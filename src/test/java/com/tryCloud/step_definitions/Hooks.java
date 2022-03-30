package com.tryCloud.step_definitions;

import com.tryCloud.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    //important io. cucumber.java not from junit
    @Before(order=1)
    public void setupScenario() {
        System.out.println("====Setting up browser using cucumber @Before");
    }

    @Before(value = "@login",order = 2)
    public void setupScenarioForLogin(){
        System.out.println("=============this will only apply to scenario with @login tag");

    }
    @Before(value = "@db",order = 0)
    public void setupSForDataBaseScenario(){
        System.out.println("=============this will only apply to scenario with @db tag");

    }
    @After
    public void tearDownScenario(Scenario scenario){
        //scenario.isFailed()-----> is scenario fails this method will return TRUE boolean value

        if (scenario.isFailed()){
            byte[] screenshot =((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot,"image/png", scenario.getName());

        }


        Driver.closeDriver();
        //  System.out.println("====Closing browser using cucumber @After");

        //System.out.println("====Scenario ended/ Take screenshot if failed!");

    }
}
