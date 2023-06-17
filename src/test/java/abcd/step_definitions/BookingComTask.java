package abcd.step_definitions;

import abcd.utilities.CommonSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class BookingComTask extends CommonSteps {
    @Given("user launch the browser and enter the web page {string}")
    public void user_launch_the_browser_and_enter_the_web_page(String webAddress) {
      driver.get(webAddress);
      bookingCom.acceptCookies.click();
      Assert.assertTrue(bookingCom.mainTitle.isDisplayed());
    }

    @When("the user clicks on flights option")
    public void the_user_clicks_on_flights_option() {
        bookingCom.flightsButton.click();
    }

    @Then("user verifies the page title")
    public void user_verifies_the_page_title() {
        Assert.assertTrue(bookingCom.flightsPageTitle.isDisplayed());
    }

    @Then("user chooses a one way trip for from {string} to {string} for {string} and clicks search button")
    public void user_chooses_a_one_way_trip_for_from_to_for_and_clicks_search_button(String departureLoc, String arrivalLoc, String date) {

        bookingCom.flightOptionsList.get(1).click();

        bookingCom.whereFromSearchBox.click();

        WebElement inputBox1 = driver.findElement(By.cssSelector("[placeholder=\"Airport or city\"]"));
        inputBox1.sendKeys("London");

        bookingCom.whereToSearchBox.click();

        WebElement inputBox2 = driver.findElement(By.cssSelector("[placeholder=\"Airport or city\"]"));
        inputBox2.sendKeys("Istanbul");

        List<WebElement> inputList = driver.findElements(By.cssSelector("[data-ui-name=\"locations_list_item\"]"));
        inputList.get(1).click();

        bookingCom.dateBox.click();

        WebElement selectDate = driver.findElement(By.cssSelector("[data-date='"+date+"']"));
        selectDate.click();

        bookingCom.searchButton.click();
    }


    @Then("user verifies the flights are shown")
    public void user_verifies_the_flights_are_shown() {
       waitForVisibility(bookingCom.filterTitle,7);
       Assert.assertFalse(bookingCom.flightList.isEmpty());
    }

    @Then("user clicks on See flight option")
    public void user_clicks_on_see_flight_option() {
        bookingCom.seeFlightList.get(0).click();
    }

    @Then("user verifies the flight details")
    public void user_verifies_the_flight_details() {
        Assert.assertTrue(bookingCom.flightDetailsTitle.isDisplayed());
    }

    @Then("user clicks on select button and")
    public void user_clicks_on_select_button_and() {
       clickWithJS(driver.findElement(By.xpath("//*[text()='Select']")));
    }

    @Then("user verifies the title as {string}")
    public void user_verifies_the_title_as(String routeTitle) {
        WebElement routeT = driver.findElement(By.xpath("//*[text()='" + routeTitle + "']"));
        waitForVisibility(routeT,7);
        Assert.assertTrue(routeT.isDisplayed());

        clickWithJS(bookingCom.nextButton);
    }

    @Then("user fills the {string} {string} {string} {string} {string} and date of birth and click to Next button")
    public void user_fills_the_and_date_of_birth_and_click_to_next_button(String ContactEmail, String PhoneNumber, String FirstName, String LastName, String Gender) {

        sendText(bookingCom.emailBox,ContactEmail);
        sendText(bookingCom.phoneNumberBox,PhoneNumber);

        scrollToElement(bookingCom.nextButton);

        sendText(bookingCom.firstNameBox,FirstName);
        sendText(bookingCom.lastNameBox,LastName);

        Select select=new Select(bookingCom.genderBox);
        select.selectByIndex(1);

        clickWithJS(bookingCom.nextButton);
    }

    @Then("user clicks on next button")
    public void user_clicks_on_next_button() {
        waitFor(4);
        driver.navigate().refresh();
        scrollToElement(bookingCom.nextButton);
        clickWithJS(bookingCom.nextButton);
    }


    @Then("user verifies the payment page title")
    public void user_verifies_the_payment_page_title() {
        waitForVisibility(bookingCom.paymentPageTitle,5);
        Assert.assertTrue(bookingCom.paymentPageTitle.isDisplayed());

        //I have stopped here due to payment issue...
    }

    @Then("user closes the browser")
    public void user_closes_the_browser() {
       driver.close();
    }


    //SOME API TESTS FOR Booking.com
    @Test
    public void searchFlights(){
        String url="https://flights.booking.com/api/flights/?type=ONEWAY&adults=1&cabinClass=ECONOMY&children=&from=LON.CITY&to=IST.AIRPORT&fromCountry=GB&toCountry=TR&fromLocationName=London&toLocationName=Istanbul+Airport&depart=2023-07-15&sort=BEST&travelPurpose=leisure&aid=304142&label=gen173nr-1FCAEoggI46AdIM1gEaFCIAQGYAQm4ARfIAQzYAQHoAQH4AQyIAgGoAgO4AqvbtqQGwAIB0gIkNGNkOTUxYWQtYTYyOS00NTMwLWE4OWUtYWI5NzViYzU5NzQ02AIG4AIB&enableVI=1";
        Response response = given().contentType(ContentType.JSON).get(url).prettyPeek();
        response.then().assertThat().statusCode(200);
        response.then().assertThat().body("aggregation.airlines", Matchers.notNullValue());
        response.then().assertThat().body("aggregation.airports.byCity[0].airports[2].name",Matchers.equalTo("London Heathrow Apt"));
    }

    @Test
    public void track(){
        /*
        Request Body
        {
    "requests": [
        {
            "type": "stage",
            "name": "flights_web_ddot_aa_pages_traffic",
            "value": 4
        }
               ]
      }
         */
        String url="https://flights.booking.com/track/et";
        Map<String, Object> requestMap=new HashMap<>();
        requestMap.put("type","stage");
        requestMap.put("name","flights_web_ddot_aa_pages_traffic");
        requestMap.put("value",4);

        List<Object>requestList=new ArrayList<>();
        requestList.add(requestMap);

        Map<String, Object> requestBody=new HashMap<>();
        requestBody.put("requests",requestList);

        Response response = given().contentType(ContentType.JSON).body(requestBody).log().all().post(url).prettyPeek();
        response.then().assertThat().statusCode(403);

        //Here, I tried a test without authorization. I was expecting error code of "403"

    }

}
