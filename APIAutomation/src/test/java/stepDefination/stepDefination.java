package stepDefination;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.Apiresources;
import resources.Utils;
import resources.testData;


public class stepDefination extends Utils {
	
	RequestSpecification request;
	Response res;
	Response responseextract;
	static String place_id;
	
	@Given("^AddPlace API payload with \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void addplace_api_payload_with_something_something_something(String name, String language, String address) throws Throwable {
		

		
		request= given().spec(Utils.requestspecs()).body(testData.datapayload(name, language, address));

    }

	@When("^User calls \"([^\"]*)\" with \"([^\"]*)\" http request$")
    public void user_calls_something_with_something_http_request(String resource, String requestmethod) throws Throwable{
    	
		
		Apiresources resourceAPI=Apiresources.valueOf(resource);
	//	resourceAPI.getResource();
		
//    	res=request.when().post("/maps/api/place/add/json");
		if(requestmethod.equalsIgnoreCase("POST")) {
	    	res=request.when().post(resourceAPI.getResource());

		}
		else if(requestmethod.equalsIgnoreCase("GET")){
			
			res=request.when().get(resourceAPI.getResource());
		}
 

    }

    @Then("^API call got success with \"([^\"]*)\" status code$")
    public void api_call_got_success_with_something_status_code(int statusCode) throws Throwable {
    	
    	responseextract=res.then().spec(Utils.responsespecs()).extract().response();
    	assertEquals(responseextract.statusCode(), statusCode);

    }

    @And("^\"([^\"]*)\" in response body is \"([^\"]*)\"$")
    public void something_in_response_body_is_something(String key, String value) throws Throwable {
  	
    	assertEquals(getJsonPath(responseextract.asString(), key), value);
    }
    
    @And("^verify that \"([^\"]*)\" created maps to \"([^\"]*)\" using \"([^\"]*)\"$")
    public void verify_that_something_created_maps_to_something_using_something(String key,String name, String resource) throws Throwable {
    	
    	place_id=getJsonPath(responseextract.asString(), key);
    	Apiresources resourceAPI=Apiresources.valueOf(resource);
//    	
   	   String response2= given().spec(Utils.requestspecs()).queryParam("place_id", place_id)
   // 	user_calls_something_with_something_http_request(resource, "GET");
    	

    	.when().get(resourceAPI.getResource())
    	.then().extract().response().asString();
    	assertEquals(getJsonPath(response2, "name"), name);  	
    	
    }
    @Given("^DeletePlaceApi palyload$")
    public void deleteplaceapi_palyload() throws Throwable {
    	
    	request=given().spec(Utils.requestspecs()).body(testData.deletePlacePayload(place_id));
    	
    	
    }



}
