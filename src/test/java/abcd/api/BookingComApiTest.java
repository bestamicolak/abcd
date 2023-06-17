package abcd.api;

import abcd.utilities.CommonSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BookingComApiTest extends CommonSteps {
    @Given("user send request to search flights url")
    public void user_send_request_to_search_flights_url() {
       String url="https://flights.booking.com/api/flights/?type=ONEWAY&adults=1&cabinClass=ECONOMY&children=&from=LON.CITY&to=IST.AIRPORT&fromCountry=GB&toCountry=TR&fromLocationName=London&toLocationName=Istanbul+Airport&depart=2023-07-15&sort=BEST&travelPurpose=leisure&aid=304142&label=gen173nr-1FCAEoggI46AdIM1gEaFCIAQGYAQm4ARfIAQzYAQHoAQH4AQyIAgGoAgO4AqvbtqQGwAIB0gIkNGNkOTUxYWQtYTYyOS00NTMwLWE4OWUtYWI5NzViYzU5NzQ02AIG4AIB&enableVI=1";

    }
    @When("the user gets the response")
    public void the_user_gets_the_response() {

    }
    @Then("user verifies the results")
    public void user_verifies_the_results() {

    }

}
