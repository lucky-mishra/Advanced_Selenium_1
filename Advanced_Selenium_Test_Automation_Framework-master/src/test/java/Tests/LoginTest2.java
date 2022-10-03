package Tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.RegistrationPage;
import reusableComponents.ExcelOperations;
import testBase.DriverFactory;
import testBase.TestBase;

import java.util.HashMap;

public class LoginTest2 extends TestBase {
    LoginPage loginPage;
    RegistrationPage registrationPage;
    ExcelOperations excel = new ExcelOperations("validLogin");
    ExcelOperations excel2 = new ExcelOperations("invalidLogin");


    //Dataprovider method --> return object array
    @DataProvider(name = "validLogin")
    public Object[][] testDataSupplier1() throws Exception {
        Object[][] obj = new Object[excel.getRowCount()][1];
        for (int i = 1; i <= excel.getRowCount(); i++) {
            HashMap<String, String> testData = excel.getTestDataInMap(i);
            obj[i - 1][0] = testData;
        }
        return obj;

    }

    @DataProvider(name = "invalidLogin")
    public Object[][] testDataSupplier2() throws Exception {
        Object[][] obj = new Object[excel2.getRowCount()][1];
        for (int i = 1; i <= excel2.getRowCount(); i++) {
            HashMap<String, String> testData = excel2.getTestDataInMap(i);
            obj[i - 1][0] = testData;
        }
        return obj;

    }

    @BeforeMethod
    public void loadClass() {
        //loginPage = PageFactory.initElements(DriverFactory.getInstance().getDriver(), LoginPage.class);
        registrationPage = PageFactory.initElements(DriverFactory.getInstance().getDriver(), RegistrationPage.class);
    }

    @Test(dataProvider = "invalidLogin", description = "login with invalid password")
    public void loginTest_03(Object obj1) {
        try {
            System.out.println("in method1");

            //Map<String, String> testdata = (HashMap<String, String>) obj1;
            registrationPage.clickAccount();
            System.out.println("clicking on login link");
            registrationPage.clickRegister();
            //ISuite suite = context.getSuite();
            //String email = (String) suite.getAttr+ibute("emailId");
            //System.out.println("Email id is :"+email);
            //loginPage.enterEmail(email);
            //loginPage.enterEmail(testdata.get("email"));
            //registrationPage.enterPassword(testdata.get("password"));
            //loginPage.clickLoginButton();
            //loginPage.verifyLogin();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assert.fail("Cant do login");
        }

    }

    @Test(dataProvider = "validLogin", description = "login with valid password")
    public void loginTest_04(Object obj2) {
        try {
            System.out.println("in method2");
            //Map<String, String> testdata = (HashMap<String, String>) obj1;
            registrationPage.clickAccount();
            System.out.println("clicking on login link");
            Thread.sleep(5000);
            registrationPage.clickLoginLink();
            registrationPage.clickForgotPasswordLink();
            //ISuite suite = context.getSuite();
            //String email = (String) suite.getAttribute("emailId");
            //System.out.println("Email id is :"+email);
            //loginPage.enterEmail(email);
            //loginPage.enterEmail(testdata.get("email"));
            //registrationPage.enterPassword(testdata.get("password"));
            //loginPage.clickLoginButton();
            //loginPage.verifyLogin();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assert.fail("Cant do login");
        }

    }

}
