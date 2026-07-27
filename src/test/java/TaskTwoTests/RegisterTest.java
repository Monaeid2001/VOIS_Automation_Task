package TaskTwoTests;

import TaskTwoPages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.JsonReader;

public class RegisterTest extends BaseTest {

    @Test
    public void registerTest(){
        homePage=
                       homePage.chooseEnglish()
                        .clickLoginRegisterBtn()
                        .clickRegisterBtn()
                        .register(testData.getJsonData("name")
                                , testData.getJsonData("phone")
                                , testData.getJsonData("email")
                                , testData.getJsonData("password")
                                , testData.getJsonData("confirmPassword"));
        Assert.assertTrue(homePage.isAccountDisplayed(), "User is not registered.");

    }
    @BeforeClass
    public void precondition() {
        testData = new JsonReader("register-data");
    }


}
