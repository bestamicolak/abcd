package abcd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BookingComPage extends CommonPageElements{
    @FindBy(id = "onetrust-accept-btn-handler")
    public WebElement acceptCookies;

    @FindBy(css = "[aria-label=\"Booking.com\"]")
    public WebElement mainTitle;

    @FindBy(id = "flights")
    public WebElement flightsButton;

    @FindBy(xpath = "//*[text()='Compare and book flights with ease']")
    public WebElement flightsPageTitle;

    @FindBy(css = "[class*='InputRadio-module__field']")
    public List<WebElement> flightOptionsList;

    @FindBy(css = "[data-ui-name=\"input_location_from_segment_0\"]")
    public WebElement whereFromSearchBox;

    @FindBy(css = "[data-ui-name=\"input_location_to_segment_0\"]")
    public WebElement whereToSearchBox;

    @FindBy(css = "[placeholder=\"Choose departure date\"]")
    public WebElement dateBox;

    @FindBy(xpath = "//*[text()='Search']")
    public WebElement searchButton;

    @FindBy(xpath = "//*[text()='Filters']")
    public WebElement filterTitle;

    @FindBy(css = "[data-testid=\"searchresults_card\"]")
    public List<WebElement> flightList;

    @FindBy(xpath = "//*[text()='See flight']")
    public List<WebElement> seeFlightList;

    @FindBy(xpath = "//*[text()='Your flight to Istanbul']")
    public WebElement flightDetailsTitle;

    @FindBy(xpath = "//*[text()='Next']")
    public WebElement nextButton;

    @FindBy(css = "[type=\"email\"]")
    public WebElement emailBox;

    @FindBy(css = "[name=\"number\"]")
    public WebElement phoneNumberBox;

    @FindBy(css = "[name=\"passengers.0.firstName\"]")
    public WebElement firstNameBox;

    @FindBy(css = "[name=\"passengers.0.lastName\"]")
    public WebElement lastNameBox;

    @FindBy(css = "[name=\"passengers.0.gender\"]")
    public WebElement genderBox;

    @FindBy(xpath = "//*[text()='Check and pay']")
    public WebElement paymentPageTitle;



}
