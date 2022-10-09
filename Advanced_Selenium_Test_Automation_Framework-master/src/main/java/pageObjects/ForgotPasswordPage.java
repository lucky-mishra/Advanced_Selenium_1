package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import reports.ExtentFactory;

import static com.aventstack.extentreports.Status.INFO;

public class ForgotPasswordPage {

    private WebDriver driver;


    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//a[contains(text(),'Forgot Your Password?')]")
    private WebElement forgotPasswordLink;
    @FindBy(xpath = "//input[@id='email_address']")
    private WebElement emailId;

    @FindBy(xpath = "//li[@class='success-msg']")
    private WebElement successMessage;
    @FindBy(xpath = "//button[@title='Submit']")
    private WebElement submitButton;
    @FindBy(xpath = "//div[@class='validation-advice']")
    private WebElement blankEmailErrMsg;


    public void clickForgotPasswordLink() throws InterruptedException {
        //Log.info("Click on login link");
        Thread.sleep(5000);
        forgotPasswordLink.click();
        ExtentFactory.getInstance().getExtent().log(INFO, "Click on forgot password link");
    }

    public void enterEmail(String emailTeXt) {
        emailId.sendKeys(emailTeXt);
        ExtentFactory.getInstance().getExtent().log(INFO, "Enter email is :" + emailTeXt);
    }

    public void clickSubmit() {
        submitButton.click();
        ExtentFactory.getInstance().getExtent().log(INFO, "click on submit button");
    }

    public void verifySuccessMessage(String emailTeXt) {
        successMessage.isDisplayed();
        ExtentFactory.getInstance().getExtent().log(INFO, "forgot password email sent to :" + emailTeXt);
    }

    public void verifyBlankEmailMessage() {
        blankEmailErrMsg.isDisplayed();
        ExtentFactory.getInstance().getExtent().log(INFO, "Email id can not be blank");
    }


}
