package stepdefinition;

import static com.selenium.nosalty.driver.Driver.getChromeDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseStepDefinition {
    ChromeDriver driver = getChromeDriver();
    protected final String BASE_URL = "https://startlogin.hu/auth/realms/StartLogin/protocol/openid-connect/auth?scope=openid&client_id=nosalty&response_type=code&redirect_uri=https%3A%2F%2Fwww.nosalty.hu%2Fcallback";
}
