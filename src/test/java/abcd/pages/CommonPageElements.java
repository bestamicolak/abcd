package abcd.pages;

import abcd.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public abstract class CommonPageElements extends Driver {
    public CommonPageElements() {
        PageFactory.initElements(driver,this);
    }

}
