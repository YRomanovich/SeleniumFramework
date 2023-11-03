package io.co.mercuryTravel.tests;

import io.co.mercuryTravel.utils.TestDataProvider;
import org.testng.annotations.Test;

public class LogInTests extends BaseTest{

    @Test(dataProvider="getUserData", dataProviderClass = TestDataProvider.class)
    public void verifyUserLogIn(String userName, String password, String expectedWelcomeText){

    }
}
